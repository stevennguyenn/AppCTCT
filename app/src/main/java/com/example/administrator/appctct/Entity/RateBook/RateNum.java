package com.example.administrator.appctct.Entity.RateBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RateNum {
    @SerializedName("ratio")
    @Expose
    private float ratio;

    @SerializedName("number_rate")
    @Expose
    private int numberRate;

    public int getNumberRate() {
        return numberRate;
    }

    public float getRatio() {
        return ratio;
    }
}
