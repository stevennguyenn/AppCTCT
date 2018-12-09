package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PointRank {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("fullname")
    @Expose
    private String fullname;

    @SerializedName("point")
    @Expose
    private String point;

    public String getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPoint() {
        return point;
    }
}
