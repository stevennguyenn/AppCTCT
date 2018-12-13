package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PointNameCourse {
    @SerializedName("point")
    @Expose
    private String point;

    @SerializedName("name")
    @Expose
    private String name;

    public String getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }
}
