package com.zz.accubyretrofit.bean.weather;

/**
 * Created by user on 2017/8/16.
 */

public class WeatherBean {

    private String LocalObservationDateTime;
    private int EpochTime;
    private String WeatherText;
    private int WeatherIcon;
    private LocalSource LocalSource;
    private boolean IsDayTime;
    private Temperature Temperature;
    private String MobileLink;
    private String Link;

    public void setLocalObservationDateTime(String LocalObservationDateTime) {
        this.LocalObservationDateTime = LocalObservationDateTime;
    }

    public String getLocalObservationDateTime() {
        return this.LocalObservationDateTime;
    }

    public void setEpochTime(int EpochTime) {
        this.EpochTime = EpochTime;
    }

    public int getEpochTime() {
        return this.EpochTime;
    }

    public void setWeatherText(String WeatherText) {
        this.WeatherText = WeatherText;
    }

    public String getWeatherText() {
        return this.WeatherText;
    }

    public void setWeatherIcon(int WeatherIcon) {
        this.WeatherIcon = WeatherIcon;
    }

    public int getWeatherIcon() {
        return this.WeatherIcon;
    }

    public void setLocalSource(LocalSource LocalSource) {
        this.LocalSource = LocalSource;
    }

    public LocalSource getLocalSource() {
        return this.LocalSource;
    }

    public void setIsDayTime(boolean IsDayTime) {
        this.IsDayTime = IsDayTime;
    }

    public boolean getIsDayTime() {
        return this.IsDayTime;
    }

    public void setTemperature(Temperature Temperature) {
        this.Temperature = Temperature;
    }

    public Temperature getTemperature() {
        return this.Temperature;
    }

    public void setMobileLink(String MobileLink) {
        this.MobileLink = MobileLink;
    }

    public String getMobileLink() {
        return this.MobileLink;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public String getLink() {
        return this.Link;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("LocalObservationDateTime: ").append(LocalObservationDateTime)
                .append(", EpochTime: ").append(EpochTime)
                .append(", WeatherText: ").append(WeatherText)
                .append(", WeatherIcon: ").append(WeatherIcon)
                .append(", LocalSource: ").append(LocalSource)
                .append(", IsDayTime: ").append(IsDayTime)
                .append(", Temperature: ").append(Temperature)
                .append(", MobileLink: ").append(MobileLink)
                .append(", Link: ").append(Link);
        return sb.toString();
    }
}

