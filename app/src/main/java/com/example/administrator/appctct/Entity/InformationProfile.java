package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InformationProfile {
    @SerializedName("fullname")
    @Expose
    private String fullname;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("school")
    @Expose
    private String school;

    @SerializedName("live")
    @Expose
    private String live;

    public String getSchool() {
        return school;
    }

    public String getLive() {
        return live;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getFullname() {
        return fullname;
    }
}
