package com.example.administrator.appctct.Entity.BookDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InformationBook {

    @SerializedName("name_author")
    @Expose
    private String nameAuthor;

    private String kind;

    @SerializedName("information")
    @Expose
    private String content;

    @SerializedName("dateupload")
    @Expose
    private String dateupload;

    public InformationBook(String nameAuthor, String kind, String information, String dateupload) {
        this.nameAuthor = nameAuthor;
        this.kind = kind;
        this.content = information;
        this.dateupload = dateupload;
    }

    public String getDateupload() {
        return dateupload;
    }

    public String getContent() {
        return content;
    }

    public String getKind() {
        return "Book";
    }

    public String getNameAuthor() {
        return nameAuthor;
    }
}
