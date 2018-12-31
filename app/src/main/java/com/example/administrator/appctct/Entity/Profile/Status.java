package com.example.administrator.appctct.Entity.Profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {
    @SerializedName("dateupload")
    @Expose
    private String dataupload;

    @SerializedName("contentstatus")
    @Expose
    private String contentStatus;

    @SerializedName("imgstatus")
    @Expose
    private String imgStatus;

    public String getContentStatus() {
        return contentStatus;
    }

    public String getDataupload() {
        return dataupload;
    }

    public String getImgStatus() {
        return imgStatus;
    }
}
