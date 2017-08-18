package com.zz.accubyretrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhonglei on 2017/8/16.
 */

public class NetWork {
    private static final String ACCU_URL = "http://dataservice.accuweather.com/";
    private static final int CONNECT_TIME_OUT = 20;
    private static final int READ_TIME_OUT = 20;
    private static final int WRITE_TIME_OUT = 20;

    private static CityApi sCityApi;
    private static WeatherApi sWeatherApi;
    private static OkHttpClient sOkHttpClient;
    private static GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    private static RxJavaCallAdapterFactory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    private static NetWork sInstance;

    private NetWork() {
        sOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    public static NetWork getInstance() {
        if (sInstance == null) {
            synchronized (NetWork.class) {
                if (sInstance == null) {
                    sInstance = new NetWork();
                }
            }
        }
        return sInstance;
    }

    public WeatherApi getWeatherApi() {
        if (sWeatherApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ACCU_URL)
                    .client(sOkHttpClient)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            sWeatherApi = retrofit.create(WeatherApi.class);
        }
        return sWeatherApi;
    }

    public CityApi getCityApi() {
        if (sCityApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ACCU_URL)
                    .client(sOkHttpClient)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            sCityApi = retrofit.create(CityApi.class);
        }
        return sCityApi;
    }

}
