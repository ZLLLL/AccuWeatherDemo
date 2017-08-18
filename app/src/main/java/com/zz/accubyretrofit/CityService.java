package com.zz.accubyretrofit;

import com.zz.accubyretrofit.bean.city.CityBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by user on 2017/8/11.
 */

public interface CityService {
    @GET("locations/v1/cities/geoposition/search")
    Call<CityBean> getCityString(@QueryMap Map<String, String> map);
}
