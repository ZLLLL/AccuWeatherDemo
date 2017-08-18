package com.zz.accubyretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zz.accubyretrofit.bean.city.CityBean;
import com.zz.accubyretrofit.bean.weather.WeatherBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String APIKEY = ""; //在ACCU网站申请的Key
    private static final String GEOLOCATION = ""; //获取的定位的经纬度 格式是："经度,纬度"
    private static final String TAG = "ZLL";
    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        findCityByOkHttp();
//        findCityByRetrofit();
    }

    private void findCityByRetrofit() {
        Map<String, String> map = new HashMap<>();
        map.put("apikey", APIKEY);
        map.put("q", GEOLOCATION);
        map.put("language", "en");
        NetWork.getInstance()
                .getCityApi()
                .getCityString(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CityBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "findCityByRetrofit onError: " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(CityBean cityBean) {
                        if (cityBean != null) {
                            String key = cityBean.getKey();
                            //to update weather
                            Log.d(TAG, "onNext: " + cityBean.toString());
                            currentWeatherByRetrofit(cityBean);
                        }
                    }
                });
    }

    private void currentWeatherByRetrofit(CityBean cityBean) {
        String language = "en";
        Map<String, String> map = new HashMap<>();
        map.put("apikey", APIKEY);
        map.put("language", language);
        map.put("details", "false");

        NetWork.getInstance()
                .getWeatherApi()
                .currentWeather(cityBean.getKey(), map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<WeatherBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "currentWeatherByRetrofit onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(List<WeatherBean> lists) {
                        int size = lists.size();
                        WeatherBean bean = lists.get(0);
                        Log.d(TAG, "onNext: " + "size: " + size + "" + bean.toString());
                    }
                });
    }

    private void currentWeatherByOkHttp(int locationKey) {
        StringBuilder sb = new StringBuilder();
        sb.append("http://dataservice.accuweather.com/currentconditions/v1/")
                .append(locationKey)
                .append("?")
                .append("apikey=")
                .append(APIKEY)
                .append("&")
                .append("language=en&")
                .append("details=true");
        String url = sb.toString();
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        okhttp3.Call call = client.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
    }

    private void findCityByOkHttp() {
        OkHttpClient client = new OkHttpClient.Builder().build();

        final Request request = new Request.Builder()
                .url(findCityByGeoLocation(GEOLOCATION, "en", false))
                .build();
        okhttp3.Call call = client.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                String result = response.body().string();
                int code = response.code();
                Log.d(TAG, "onResponse: " + code + ", " + result);
                currentWeatherByOkHttp(getLocationKey(result));
            }
        });
    }

    private int getLocationKey(String response) {
        int key = -1;
        try {
            JSONObject object = new JSONObject(response);
            if (object.has("Key")) {
                key = object.getInt("Key");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return key;
    }

    private String findCityByGeoLocation(String geolocation, String lang, boolean withLang) {
        StringBuilder builder = new StringBuilder();
        builder.append("http://dataservice.accuweather.com/locations/v1/cities/geoposition/search?")
                .append("apikey=")
                .append(APIKEY)
                .append("&q=")
                .append(geolocation);
        if (withLang) {
            builder.append("&language=")
                    .append(lang);
        }
        String string = builder.toString();
        Log.d(TAG, "findCityByGeoLocation: " + string);
        return string;
    }
}
