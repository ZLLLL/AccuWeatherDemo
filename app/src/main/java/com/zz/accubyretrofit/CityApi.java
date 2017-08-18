package com.zz.accubyretrofit;

import com.zz.accubyretrofit.bean.city.CityBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by user on 2017/8/16.
 */

public interface CityApi {
    @GET("locations/v1/cities/geoposition/search")
    Observable<CityBean> getCityString(@QueryMap Map<String, String> map);
}
