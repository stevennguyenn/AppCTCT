package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResultQuestion implements Serializable {
    @SerializedName("point")
    @Expose
    private String point;

    @SerializedName("ratio")
    @Expose
    private String ratio;

    @SerializedName("rate")
    @Expose
    private String rate;

    public String getPoint() {
        return point;
    }

    public String getRate() {
        return rate;
    }

    public String getRatio() {
        return ratio;
    }
}
