package com.asadkhan.network.interactors.retrofit;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import retrofit2.Response;

public interface RetrofitService {

    /**
     *    GET Request Methods
     * */

    // Simple GET request
    <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path
    );

    // Simple GET request with headers
    <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap
    );

    // GET request with URL query parameters
    <RESPONSE> Observable<Response<RESPONSE>> getWithQueries(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> queryMap
    );

    // GET request with headers and URL query parameters
    <RESPONSE> Observable<Response<RESPONSE>> getWithQueries(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> queryMap,
            @NonNull Map<String, String> headerMap
    );

    // Simple GET request from arbitrary URL
    <RESPONSE> Observable<Response<RESPONSE>> getFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url
    );

    // GET request w/ headers from arbitrary URL
    <RESPONSE> Observable<Response<RESPONSE>> getFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap
    );

    // GET request w/ headers and URL query parameters from arbitrary URL
    <RESPONSE> Observable<Response<RESPONSE>> getWithQueriesFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> queryMap,
            @NonNull Map<String, String> headerMap);

    /**
     *    POST Request Methods
     * */

    // Simple POST request
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> post(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body
    );

    // POST request w/ headers
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> post(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    // Simple POST request to arbitrary URL
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body
    );

    // POST request w/ headers to arbitrary URL
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    // POST request w/ headers to arbitrary URL
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> postAt(
            Class<RESPONSE> clazz,
            String url,
            Map<String, String> headerMap,
            Map<String, String> params,
            REQUEST body);

    /**
     *    PUT Request Methods
     * */

    // Simple PUT request
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> put(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body
    );

    // PUT request w/ headers
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> put(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    // PUT request to arbitrary URL
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> putAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body
    );

    // PUT request w/ headers to arbitrary URL
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> putAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    /**
     *    PATCH Request Methods
     * */

    // Simple PATCH request
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patch(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body
    );

    // PATCH request w/ headers
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patch(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    // PATCH request to arbitrary URL
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patchAt(
            @NonNull Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body
    );

    // PATCH request w/ headers to arbitrary URL
    <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patchAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    /**
     *    DELETE Request Methods
     * */

    Observable<Response<Void>> delete(@NonNull String path);

    Observable<Response<Void>> deleteAt(@NonNull String url);

    void reset();
}
