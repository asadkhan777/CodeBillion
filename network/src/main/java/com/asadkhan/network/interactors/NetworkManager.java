package com.asadkhan.network.interactors;

import com.asadkhan.network.interactors.retrofit.RetrofitService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import retrofit2.Response;

@Singleton
public class NetworkManager implements NetworkService {

    private final RetrofitService service;

    @Inject
    public NetworkManager(RetrofitService service) {
        this.service = service;
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path) {
        return this.service.get(clazz, path);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap) {
        return this.service.get(clazz, path, headerMap);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> getWithQueries(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> queryMap) {
        return this.service.getWithQueries(clazz, path, queryMap);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> getWithQueries(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> queryMap,
            @NonNull Map<String, String> headerMap) {
        return this.service.getWithQueries(clazz, path, queryMap, headerMap);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> getFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url) {
        return this.service.getFrom(clazz, url);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> getFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap) {
        return this.service.getFrom(clazz, url, headerMap);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> getWithQueriesFrom(
            @NonNull Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> queryMap,
            @NonNull Map<String, String> headerMap) {
        return this.service.getWithQueriesFrom(clazz, url, queryMap, headerMap);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> post(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body) {
        return this.service.post(clazz, path, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> post(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body) {
        return this.service.post(clazz, path, headerMap, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body) {
        return this.service.postAt(clazz, url, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body) {
        return this.service.postAt(clazz, url, headerMap, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull Map<String, String> params,
            @NonNull REQUEST body) {
        return this.service.postAt(clazz, url, headerMap, params, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> put(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body) {
        return this.service.put(clazz, path, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> put(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body) {
        return this.service.put(clazz, path, headerMap);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> putAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body) {
        return this.service.putAt(clazz, url, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> putAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body) {
        return this.service.putAt(clazz, url, headerMap, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patch(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body) {
        return this.service.patch(clazz, path, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patch(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body) {
        return this.service.patch(clazz, path, headerMap, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patchAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body) {
        return this.service.patchAt(clazz, url, body);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patchAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body) {
        return this.service.patchAt(clazz, url, headerMap, body);
    }

    @Override
    public Observable<Response<Void>> delete(@NonNull String path) {
        return this.service.delete(path);
    }

    @Override
    public Observable<Response<Void>> deleteAt(@NonNull String url) {
        return this.service.deleteAt(url);
    }


}
