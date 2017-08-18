package com.zz.accubyretrofit.bean.city;

import java.util.List;

/**
 * Created by user on 2017/8/16.
 */

public class CityBean {

    private int Version;
    private String Key;     //location key
    private String Type;
    private int Rank;
    private String LocalizedName;
    private String EnglishName;
    private Country Country;
    private AdministrativeArea AdministrativeArea;
    private GeoPosition GeoPosition;
    private List<SupplementalAdminAreas> SupplementalAdminAreas;

    public void setVersion(int Version) {
        this.Version = Version;
    }

    public int getVersion() {
        return this.Version;
    }

    public void setKey(String Key) {
        this.Key = Key;
    }

    public String getKey() {
        return this.Key;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getType() {
        return this.Type;
    }

    public void setRank(int Rank) {
        this.Rank = Rank;
    }

    public int getRank() {
        return this.Rank;
    }

    public void setLocalizedName(String LocalizedName) {
        this.LocalizedName = LocalizedName;
    }

    public String getLocalizedName() {
        return this.LocalizedName;
    }

    public void setEnglishName(String EnglishName) {
        this.EnglishName = EnglishName;
    }

    public String getEnglishName() {
        return this.EnglishName;
    }

    public void setCountry(Country Country) {
        this.Country = Country;
    }

    public Country getCountry() {
        return this.Country;
    }

    public void setAdministrativeArea(AdministrativeArea AdministrativeArea) {
        this.AdministrativeArea = AdministrativeArea;
    }

    public AdministrativeArea getAdministrativeArea() {
        return this.AdministrativeArea;
    }

    public void setGeoPosition(GeoPosition GeoPosition) {
        this.GeoPosition = GeoPosition;
    }

    public GeoPosition getGeoPosition() {
        return this.GeoPosition;
    }

    public void setSupplementalAdminAreas(List<SupplementalAdminAreas> SupplementalAdminAreas) {
        this.SupplementalAdminAreas = SupplementalAdminAreas;
    }

    public List<SupplementalAdminAreas> getSupplementalAdminAreas() {
        return this.SupplementalAdminAreas;
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "Version=" + Version +
                ", Key='" + Key + '\'' +
                ", Type='" + Type + '\'' +
                ", Rank=" + Rank +
                ", LocalizedName='" + LocalizedName + '\'' +
                ", EnglishName='" + EnglishName + '\'' +
                ", Country=" + Country +
                ", AdministrativeArea=" + AdministrativeArea +
                ", GeoPosition=" + GeoPosition +
                ", SupplementalAdminAreas=" + SupplementalAdminAreas +
                '}';
    }
}
