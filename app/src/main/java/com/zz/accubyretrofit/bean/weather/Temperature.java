package com.zz.accubyretrofit.bean.weather;

import com.zz.accubyretrofit.bean.Imperial;
import com.zz.accubyretrofit.bean.Metric;

/**
 * Created by zhonglei on 2017/8/16.
 */

public class Temperature {

    private Metric Metric;
    private Imperial Imperial;

    public void setMetric(Metric Metric) {
        this.Metric = Metric;
    }

    public Metric getMetric() {
        return this.Metric;
    }

    public void setImperial(Imperial Imperial) {
        this.Imperial = Imperial;
    }

    public Imperial getImperial() {
        return this.Imperial;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "Metric=" + Metric +
                ", Imperial=" + Imperial +
                '}';
    }
}
