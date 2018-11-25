package com.example.administrator.appctct.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String nameBook;

    @SerializedName("ratio")
    @Expose
    private String ratioBook;

    public Book( String nameBook, String ratioBook) {
        this.nameBook = nameBook;
        this.ratioBook = ratioBook;
    }

    public String getId() {
        return id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getRatioBook() {
        return ratioBook;
    }
}
