package com.example.administrator.appctct.Entity.Profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Respone {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("result")
    @Expose
    private ArrayList<Status> listStatus;

    public String getMessage() {
        return message;
    }

    public ArrayList<Status> getListStatus() {
        return listStatus;
    }
}
