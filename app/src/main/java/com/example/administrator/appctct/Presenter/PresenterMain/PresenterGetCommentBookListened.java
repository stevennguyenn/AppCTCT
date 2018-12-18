package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.BookDetail.BookComment;

import java.util.ArrayList;

public interface PresenterGetCommentBookListened {
    void getBookCommentSuccessed(ArrayList<BookComment> data);
    void connectFailed(String message);
}
