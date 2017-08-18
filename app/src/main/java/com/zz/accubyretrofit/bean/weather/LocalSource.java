package com.zz.accubyretrofit.bean.weather;

public class LocalSource {

    private int Id;
    private String Name;
    private String WeatherCode;

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return this.Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return this.Name;
    }

    public void setWeatherCode(String WeatherCode) {
        this.WeatherCode = WeatherCode;
    }

    public String getWeatherCode() {
        return this.WeatherCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(Id)
                .append(", Name: ").append(Name)
                .append(", WeatherCode: ").append(WeatherCode);
        return sb.toString();
    }
}