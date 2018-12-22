package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.BookDetail.BookComment;

import java.util.ArrayList;

public interface PresenterGetCommentForRateListened {
    void getCommentForRateSuccessed(ArrayList<BookComment> data);
    void noComment();
    void connectFailed(String message);
}
