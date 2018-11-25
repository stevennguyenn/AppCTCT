package com.example.administrator.appctct.Entity;

public class Book {
    private String nameBook;
    private String ratioBook;

    public Book( String nameBook, String ratioBook) {
        this.nameBook = nameBook;
        this.ratioBook = ratioBook;
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
