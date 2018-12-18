package com.example.administrator.appctct.Entity.BookDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TitleBook {

    private String imgBook;

    @SerializedName("name_book")
    @Expose
    private String nameBook;

    @SerializedName("ratio_book")
    @Expose
    private Float ratioBook;


    public TitleBook(String imgBook, String nameBook, Float ratioBook) {
        this.imgBook = imgBook;
        this.nameBook = nameBook;
        this.ratioBook = ratioBook;
    }

    public String getImgBook() {
        return "https://purepng.com/public/uploads/large/purepng.com-booksbookillustratedwrittenprintedliteratureclipart-1421526451707uyace.png";
    }

    public String getNameBook() {
        return nameBook;
    }

    public Float getRatioBook() {
        return ratioBook;
    }
}
