package com.example.administrator.appctct.Entity.BookDetail;

import com.example.administrator.appctct.Entity.Book;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BookExtened {
    @SerializedName("array_book_same")
    @Expose
    private ArrayList<Book> listBookSame;

    @SerializedName("array_book_ratio")
    @Expose
    private ArrayList<Book> listBookRatio;

    public ArrayList<Book> getListBookSame() {
        return listBookSame;
    }

    public ArrayList<Book> getListBookRatio() {
        return listBookRatio;
    }
}
