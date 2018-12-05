package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SectionTest {
    @SerializedName("test_code")
    @Expose
    private String testCode;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("number_test")
    @Expose
    private int number_test;

    public int getNumber_test() {
        return number_test;
    }

    public String getName() {
        return name;
    }

    public String getTestCode() {
        return testCode;
    }
}
