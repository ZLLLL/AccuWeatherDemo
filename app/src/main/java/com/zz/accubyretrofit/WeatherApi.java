package com.zz.accubyretrofit;

import com.zz.accubyretrofit.bean.weather.WeatherBean;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by zhonglei on 2017/8/16.
 */

public interface WeatherApi {
    @GET("currentconditions/v1/{locationKey}")
    Observable<List<WeatherBean>> currentWeather(@Path("locationKey") String locationKey,
                                                 @QueryMap() Map<String, String> map);
}
