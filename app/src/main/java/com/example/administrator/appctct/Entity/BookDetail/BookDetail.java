package com.example.administrator.appctct.Entity.BookDetail;

import com.example.administrator.appctct.Entity.Book;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class BookDetail implements Serializable {

    @SerializedName("title_book")
    @Expose
    private TitleBook titleBook;

    @SerializedName("information_book")
    @Expose
    private InformationBook informationBook;


    public InformationBook getInformationBook() {
        return informationBook;
    }

    public TitleBook getTitleBook() {
        return titleBook;
    }
}
