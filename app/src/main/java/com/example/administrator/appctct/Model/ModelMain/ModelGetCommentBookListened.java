package com.example.administrator.appctct.Model.ModelMain;

import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.BookDetail.FullBookComment;

import java.util.ArrayList;

public interface ModelGetCommentBookListened {
    void getBookCommentSuccessed(FullBookComment data);
    void connectFailed(String message);
}
