package com.example.administrator.appctct.Entity.RateBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailRateNum {
    @SerializedName("ratio5")
    @Expose
    private float ratio5;

    @SerializedName("ratio4")
    @Expose
    private float ratio4;

    @SerializedName("ratio3")
    @Expose
    private float ratio3;

    @SerializedName("ratio2")
    @Expose
    private float ratio2;

    @SerializedName("ratio1")
    @Expose
    private float ratio1;

    public float getRatio1() {
        return ratio1;
    }

    public float getRatio2() {
        return ratio2;
    }

    public float getRatio3() {
        return ratio3;
    }

    public float getRatio4() {
        return ratio4;
    }

    public float getRatio5() {
        return ratio5;
    }
}
