package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.BookDetail.FullBookComment;

import java.util.ArrayList;

public interface PresenterGetCommentBookListened {
    void getBookCommentSuccessed(FullBookComment data);
    void connectFailed(String message);
}
