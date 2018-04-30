package com.asadkhan.network.di;


import com.asadkhan.network.BuildConfig;
import com.asadkhan.network.interactors.NetworkManager;
import com.asadkhan.network.interactors.NetworkService;
import com.asadkhan.network.interactors.retrofit.RetrofitManager;
import com.asadkhan.network.interactors.retrofit.RetrofitService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


@Module
public class NetworkModule {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    private static final String PROD_BASE_URL = "https://api.judge0.com";

    private static final String DEBUG_BASE_URL = "http://192.1681.11:3000";

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat(DEFAULT_DATE_FORMAT)
                .create();
    }

    // Network Section

    @Provides
    @Singleton
    public Interceptor provideInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Interceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(70, TimeUnit.SECONDS)
                .readTimeout(70, TimeUnit.SECONDS)
                .writeTimeout(70, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        String baseUrl;
        if (BuildConfig.DEBUG) {
            baseUrl = DEBUG_BASE_URL;
        } else {
            baseUrl = PROD_BASE_URL;
        }
        Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient);
        return builder.build();
    }

    @Singleton
    @Provides
    public RetrofitService provideRetrofitService(RetrofitManager manager) {
        // Requires Retrofit & Gson
        return manager;
    }

    @Provides
    @Singleton
    public NetworkService provideNetworkService(NetworkManager manager) {
        // Requires RetrofitService
        return manager;
    }


}
