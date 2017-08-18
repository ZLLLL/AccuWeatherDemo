package com.zz.accubyretrofit;

import com.zz.accubyretrofit.bean.weather.WeatherBean;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by user on 2017/8/12.
 */

public interface WeatherService {
    @Headers("Accept-Encoding: application/json")
    @GET("currentconditions/v1/{locationKey}")
    Call<List<WeatherBean>> currentWeather(@Path("locationKey") String locationKey, @QueryMap() Map<String, String> map);
}
