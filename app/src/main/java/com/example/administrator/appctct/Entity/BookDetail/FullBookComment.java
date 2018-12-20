package com.example.administrator.appctct.Entity.BookDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FullBookComment {
    @SerializedName("title_comment")
    @Expose
    private TitleComment titleComment;

    @SerializedName("list_comment")
    @Expose
    private ArrayList<BookComment> listComment;

    public ArrayList<BookComment> getListComment() {
        return listComment;
    }

    public TitleComment getTitleComment() {
        return titleComment;
    }
}
