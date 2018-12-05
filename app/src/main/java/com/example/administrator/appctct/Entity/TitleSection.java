package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TitleSection {
    @SerializedName("test_code")
    @Expose
    private String testCode;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("number_test")
    @Expose
    private int numberTest;

    public String getTestCode() {
        return testCode;
    }

    public String getName() {
        return name;
    }

    public int getNumberTest() {
        return numberTest;
    }
}
