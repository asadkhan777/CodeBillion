package com.asadkhan.network.interactors;


import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import retrofit2.Response;

public interface NetworkService {

    <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path
    );

    <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap
    );

    <RESPONSE> Observable<Response<RESPONSE>> getWithQueries(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> queryMap
    );

    <RESPONSE> Observable<Response<RESPONSE>> getWithQueries(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> queryMap,
            @NonNull Map<String, String> headerMap
    );

    <RESPONSE> Observable<Response<RESPONSE>> getFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url
    );

    <RESPONSE> Observable<Response<RESPONSE>> getFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap
    );

    <RESPONSE> Observable<Response<RESPONSE>> getWithQueriesFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> queryMap,
            @NonNull Map<String, String> headerMap
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> post(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> post(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull Map<String, String> params,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> put(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> put(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> putAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> putAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> patch(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> patch(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> patchAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> patchAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );


    Observable<Response<Void>> delete(
            @NonNull String path);

    Observable<Response<Void>> deleteAt(
            @NonNull String url);


    HashMap<String, String> getFieldsMap();
}
