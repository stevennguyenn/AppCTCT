package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InformationIndividual {
    @SerializedName("fullname")
    @Expose
    private String fullname;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("school")
    @Expose
    private String school;

    @SerializedName("live")
    @Expose
    private String live;

    @SerializedName("tested")
    @Expose
    private ArrayList<PointNameCourse> listTested;

    public InformationIndividual() {
        this.fullname = "";
        this.avatar = "";
        this.school = "";
        this.live = "";
        this.listTested = new ArrayList<>();
    }


    public String getFullname() {
        return fullname;
    }

    public ArrayList<PointNameCourse> getListTested() {
        return listTested;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getLive() {
        return live;
    }

    public String getSchool() {
        return school;
    }
}
