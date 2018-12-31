package com.example.administrator.appctct.Entity.Profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("avatar")
    @Expose
    private String avatar;

    public String getFullname() {
        return fullname;
    }

    public String getAvatar() {
        return avatar;
    }
}
