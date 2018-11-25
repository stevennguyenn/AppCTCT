package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FullBook {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("dateupload")
    @Expose
    private String dateupload;
    @SerializedName("ratio")
    @Expose
    private String ratio;


    public FullBook(String id, String name, String author, String dateupload, String ratio) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.dateupload = dateupload;
        this.ratio = ratio;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDateupload() {
        return dateupload;
    }

    public String getRatio() {
        return ratio;
    }
}
