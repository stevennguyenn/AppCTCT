package com.example.administrator.appctct.Entity.BookDetail;

import com.example.administrator.appctct.Entity.Book;

import java.io.Serializable;
import java.util.ArrayList;

public class BookDetail implements Serializable {
    private TitleBook titleBook;
    private InformationBook informationBook;
    private ArrayList<BookComment> listComment;
    private ArrayList<Book> listBookTop;
    private ArrayList<Book> listBookSame;
    private ArrayList<Book> listBookRatio;

    public BookDetail(TitleBook titleBook, InformationBook informationBook, ArrayList<BookComment> listComment,ArrayList<Book> listBookTop,ArrayList<Book> listBookSame,ArrayList<Book> listBookRatio) {
        this.titleBook = titleBook;
        this.informationBook = informationBook;
        this.listComment = listComment;
        this.listBookTop = listBookTop;
        this.listBookSame = listBookSame;
        this.listBookRatio = listBookRatio;
    }

    public ArrayList<Book> getListBookSame() {
        return listBookSame;
    }

    public ArrayList<Book> getListBookRatio() {
        return listBookRatio;
    }

    public ArrayList<Book> getListBookTop() {
        return listBookTop;
    }

    public ArrayList<BookComment> getListComment() {
        return listComment;
    }

    public InformationBook getInformationBook() {
        return informationBook;
    }

    public TitleBook getTitleBook() {
        return titleBook;
    }
}
