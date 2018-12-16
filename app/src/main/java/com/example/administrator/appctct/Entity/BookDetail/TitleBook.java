package com.example.administrator.appctct.Entity.BookDetail;

public class TitleBook {
    private String imgBook;
    private String nameBook;
    private Float ratioBook;


    public TitleBook(String imgBook, String nameBook, Float ratioBook) {
        this.imgBook = imgBook;
        this.nameBook = nameBook;
        this.ratioBook = ratioBook;
    }

    public String getImgBook() {
        return imgBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public Float getRatioBook() {
        return ratioBook;
    }
}
