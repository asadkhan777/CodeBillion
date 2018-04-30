package com.asadkhan.network.interactors.retrofit;


import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

interface RestService {

    @GET("{path}")
    Observable<Response<ResponseBody>> get(
            @NonNull @Path(value = "path", encoded = true) String path);

    @GET("{path}")
    Observable<Response<ResponseBody>> get(
            @NonNull @Path("path") String path,
            @NonNull @HeaderMap Map<String, String> headerMap
    );

    @GET("{path}")
    Observable<Response<ResponseBody>> getWithQueries(
            @NonNull @Path("path") String path,
            @NonNull @QueryMap Map<String, String> queryMap
    );

    @GET("{path}")
    Observable<Response<ResponseBody>> getWithQueries(
            @NonNull @Path("path") String path,
            @NonNull @QueryMap Map<String, String> queryMap,
            @NonNull @HeaderMap Map<String, String> headerMap
    );

    @GET
    Observable<Response<ResponseBody>> getFrom(
            @NonNull @Url String url);

    @GET
    Observable<Response<ResponseBody>> getFrom(
            @NonNull @Url String url,
            @NonNull @HeaderMap Map<String, String> headerMap
    );

    @GET
    Observable<Response<ResponseBody>> getWithQueriesFrom(
            @NonNull @Url String url,
            @NonNull @QueryMap Map<String, String> queryMap,
            @NonNull @HeaderMap Map<String, String> headerMap
    );

    @POST("{path}")
    Observable<Response<ResponseBody>> post(
            @NonNull @Path("path") String path,
            @NonNull @Body RequestBody body);

    @POST("{path}")
    Observable<Response<ResponseBody>> post(
            @NonNull @Path("path") String path,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @Body RequestBody body
    );

    @POST
    Observable<Response<ResponseBody>> postAt(
            @NonNull @Url String url,
            @NonNull @Body RequestBody body
    );

    @POST
    Observable<Response<ResponseBody>> postAt(
            @NonNull @Url String url,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @Body RequestBody body
    );

    @POST
    Observable<Response<ResponseBody>> postAt(
            @NonNull @Url String url,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @QueryMap Map<String, String> params,
            @NonNull @Body RequestBody requestBody);


    @PUT("{path}")
    Observable<Response<ResponseBody>> put(
            @NonNull @Path("path") String path,
            @NonNull @Body RequestBody body
    );

    @PUT("{path}")
    Observable<Response<ResponseBody>> put(
            @NonNull @Path("path") String path,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @Body RequestBody body
    );

    @PUT
    Observable<Response<ResponseBody>> putAt(
            @NonNull @Url String url,
            @NonNull @Body RequestBody body
    );

    @PUT
    Observable<Response<ResponseBody>> putAt(
            @NonNull @Url String url,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @Body RequestBody body
    );


    @PATCH("{path}")
    Observable<Response<ResponseBody>> patch(
            @NonNull @Path("path") String path,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @Body RequestBody body
    );

    @PATCH("{path}")
    Observable<Response<ResponseBody>> patch(
            @NonNull @Path("path") String path,
            @NonNull @Body RequestBody body
    );

    @PATCH
    Observable<Response<ResponseBody>> patchAt(
            @NonNull @Url String url,
            @NonNull @Body RequestBody body
    );

    @PATCH
    Observable<Response<ResponseBody>> patchAt(
            @NonNull @Url String url,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @Body RequestBody body
    );


    @DELETE("{path}")
    Observable<Response<Void>> delete(
            @NonNull @Path("path") String path);

    @DELETE
    Observable<Response<Void>> deleteAt(
            @NonNull @Url String url);

    @Multipart
    @POST("{path}")
    Observable<Response<ResponseBody>> postFile(
            @NonNull @Path("path") String path,
            @NonNull @Part MultipartBody.Part file
    );

    @Multipart
    @POST("{path}")
    Observable<Response<ResponseBody>> postFile(
            @NonNull @Path("path") String path,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @Part MultipartBody.Part file
    );

    @Multipart
    @POST
    Observable<Response<ResponseBody>> postFileAt(
            @NonNull @Url String url,
            @NonNull @Part MultipartBody.Part file
    );

    @Multipart
    @POST
    Observable<Response<ResponseBody>> postFileAt(
            @NonNull @Url String url,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @Part MultipartBody.Part file
    );

    @Multipart
    @PUT("{path}")
    Observable<Response<ResponseBody>> putFile(
            @NonNull @Path("path") String path,
            @NonNull @Part MultipartBody.Part file
    );

    @Multipart
    @PUT("{path}")
    Observable<Response<ResponseBody>> putFile(
            @NonNull @Path("path") String path,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @Part MultipartBody.Part file
    );

    @Multipart
    @PUT
    Observable<Response<ResponseBody>> putFileAt(
            @NonNull @Url String url,
            @NonNull @Part MultipartBody.Part file
    );

    @Multipart
    @PUT
    Observable<Response<ResponseBody>> putFileAt(
            @NonNull @Url String url,
            @NonNull @HeaderMap Map<String, String> headerMap,
            @NonNull @Part MultipartBody.Part file
    );


    Observable<Response<ResponseBody>> putFileReactiveX(String path, MultipartBody.Part body);
}
