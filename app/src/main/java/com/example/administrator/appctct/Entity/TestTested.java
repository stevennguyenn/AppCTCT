package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestTested {
    @SerializedName("test_code")
    @Expose
    private String testCode;

    @SerializedName("point")
    @Expose
    private String point;

    @SerializedName("rate")
    @Expose
    private String rate;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("number_test")
    @Expose
    private String numberTest;

    public String getName() {
        return name;
    }

    public String getTestCode() {
        return testCode;
    }

    public String getRate() {
        return rate;
    }

    public String getPoint() {
        return point;
    }

    public String getNumberTest() {
        return numberTest;
    }
}
