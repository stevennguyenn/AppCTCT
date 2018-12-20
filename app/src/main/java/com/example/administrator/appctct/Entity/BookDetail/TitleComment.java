package com.example.administrator.appctct.Entity.BookDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TitleComment {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("avg_rate")
    @Expose
    private Float avgRate;

    @SerializedName("number_rate")
    @Expose
    private int numberRate;

    public String getMessage() {
        return message;
    }

    public Float getAvgRate() {
        return avgRate;
    }

    public int getNumberRate() {
        return numberRate;
    }
}
