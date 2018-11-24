package com.example.administrator.appctct.Entity;

public class Book {
    private String imgBook;
    private String nameBook;
    private String ratioBook;

    public Book(String imgBook, String nameBook, String ratioBook) {
        this.imgBook = imgBook;
        this.nameBook = nameBook;
        this.ratioBook = ratioBook;
    }

    public String getImgBook() {
        return imgBook;
    }

    public void setImgBook(String imgBook) {
        this.imgBook = imgBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getRatioBook() {
        return ratioBook;
    }

    public void setRatioBook(String ratioBook) {
        this.ratioBook = ratioBook;
    }
}
