package com.zz.accubyretrofit.bean.city;

/**
 * Created by user on 2017/8/16.
 */

public class Country {

    private String ID;
    private String LocalizedName;
    private String EnglishName;

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return this.ID;
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
}
