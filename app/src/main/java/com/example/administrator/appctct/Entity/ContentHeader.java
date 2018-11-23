package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentHeader {
    @SerializedName("fullname")
    @Expose
    private String fullname;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("points")
    @Expose
    private String points;

    public ContentHeader(){
        this.avatar = "";
        this.fullname = "";
        this.points = "";
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPoints() {
        return points;
    }
}
