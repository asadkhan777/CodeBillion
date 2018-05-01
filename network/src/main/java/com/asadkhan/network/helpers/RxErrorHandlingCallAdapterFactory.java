package com.asadkhan.network.helpers;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import static com.asadkhan.network.helpers.NetworkException.*;


public class RxErrorHandlingCallAdapterFactory<P> extends CallAdapter.Factory {

    private final RxJava2CallAdapterFactory originalRxJava2Factory;

    private RxErrorHandlingCallAdapterFactory() {
        originalRxJava2Factory = RxJava2CallAdapterFactory.create();
    }

    public static CallAdapter.Factory create() {
        return new RxErrorHandlingCallAdapterFactory();
    }

    @SuppressWarnings("unchecked")
    @Override
    public CallAdapter<?, Observable<Response<ResponseBody>>> get(
            @NonNull Type returnType,
            @NonNull Annotation[] annotations,
            @NonNull Retrofit retrofit) {

        CallAdapter<?, ?> callAdapter;
        callAdapter = originalRxJava2Factory.get( returnType, annotations, retrofit );

        CallAdapter<? , Observable<Response<ResponseBody>>> observableCallAdapter;
        // We are assuming we only will ever use observables, not single or completable
         observableCallAdapter = (CallAdapter<?, Observable<Response<ResponseBody>>>) callAdapter;

        return new RxCallAdapterWrapper( retrofit, observableCallAdapter );

    }

    private class RxCallAdapterWrapper implements CallAdapter<P, Observable<Response<ResponseBody>>> {

        private final Retrofit retrofit;

        private final CallAdapter<?, Observable<Response<ResponseBody>>> wrapped;

        public RxCallAdapterWrapper(Retrofit retrofit, CallAdapter<?, Observable<Response<ResponseBody>>> observableAdapter) {
            this.retrofit = retrofit;
            this.wrapped = observableAdapter;
        }

        @Override
        public Type responseType() {
            // Response type : class okhttp3.ResponseBody
            Type type = wrapped.responseType();
            System.err.println("Response type : " + type);
            return type;
        }

        @Override
        public Observable<Response<ResponseBody>> adapt(Call call) {
            Observable<Response<ResponseBody>> responseObservable = wrapped.adapt(call);
            return responseObservable
                    .onErrorResumeNext(
                            throwable -> { return Observable.error(asRetrofitException(throwable)); })
                    .doOnNext(
                            this::logData);
        }

        private RetrofitException asRetrofitException(Throwable throwable) {
            // We had non-200 http error
            if (throwable instanceof HttpException) {
                HttpException httpException = (HttpException) throwable;
                Response response = httpException.response();
                return RetrofitException
                        .httpError(
                            response.raw().request().url().toString(),
                            response,
                            retrofit);
            }
            // A network error happened
            if (throwable instanceof IOException) {
                return RetrofitException.networkError((IOException) throwable);
            }

            // We don't know what happened. We need to simply convert to an unknown error
            return RetrofitException.unexpectedError(throwable);
        }

        Observable<Throwable> handleError(Object obj) {
            if (obj instanceof Throwable) {
                return Observable.error(asRetrofitException((Throwable) obj));
            }
            return Observable.error(createInstance("On Error Resume Next sent us an object! WTF."));
        }

        private void logData(Response<? extends ResponseBody> response) {
            System.err.println("\n");
            System.err.println("Response code : " + response.code());
            // System.err.println("Response request data : " + response.raw().request().url().toString());
        }

    }
}
