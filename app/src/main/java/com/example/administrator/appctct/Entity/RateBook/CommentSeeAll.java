package com.example.administrator.appctct.Entity.RateBook;

import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CommentSeeAll {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("list_comment")
    @Expose
    private ArrayList<BookComment> listComment;

    public ArrayList<BookComment> getListComment() {
        return listComment;
    }

    public String getMessage() {
        return message;
    }
}
