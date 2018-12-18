package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResultSeeAll {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private ArrayList<FullBook> data;

    public ArrayList<FullBook> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
