package com.zz.accubyretrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by zhonglei on 2017/8/11.
 */

public interface CityService {
    @Headers("Accept-Encoding: application/json")
    @GET("locations/v1/cities/geoposition/search")
    Call<String> getCityString(@Query("apikey") String apiKey, @Query("q") String geolocation);

    @Headers("Accept-Encoding: application/json")
    @GET("locations/v1/cities/geoposition/search")
    Call<String> getCityString(@Query("apikey") String apiKey, @Query("q") String geolocation, @Query("language") String language);

//    @Headers("Accept-Encoding: application/json")
    @GET("locations/v1/cities/geoposition/search")
    Call<String> getCityString(@QueryMap Map<String, String> map);
}
