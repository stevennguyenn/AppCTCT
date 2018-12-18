package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.BookDetail.BookExtened;
import com.example.administrator.appctct.Model.ModelMain.ModelGetBookExtend;
import com.example.administrator.appctct.Model.ModelMain.ModelGetCommentBook;
import com.example.administrator.appctct.Model.ModelMain.ModelGetCommentBookListened;

import java.util.ArrayList;

public class PresenterGetCommentBook implements ModelGetCommentBookListened {
    private ModelGetCommentBook model = new ModelGetCommentBook(this);
    private PresenterGetCommentBookListened listened;

    public PresenterGetCommentBook(PresenterGetCommentBookListened listened){
        this.listened = listened;
    }

    public void process(String idBook){
        model.process(idBook);
    }


    @Override
    public void getBookCommentSuccessed(ArrayList<BookComment> data) {
        listened.getBookCommentSuccessed(data);
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
