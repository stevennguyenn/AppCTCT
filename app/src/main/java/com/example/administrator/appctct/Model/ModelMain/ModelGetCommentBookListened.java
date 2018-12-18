package com.example.administrator.appctct.Model.ModelMain;

import com.example.administrator.appctct.Entity.BookDetail.BookComment;

import java.util.ArrayList;

public interface ModelGetCommentBookListened {
    void getBookCommentSuccessed(ArrayList<BookComment> data);
    void connectFailed(String message);
}
