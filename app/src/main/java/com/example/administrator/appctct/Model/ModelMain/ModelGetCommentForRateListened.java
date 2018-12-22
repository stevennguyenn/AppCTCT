package com.example.administrator.appctct.Model.ModelMain;

import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.RateBook.CommentSeeAll;

import java.util.ArrayList;

public interface ModelGetCommentForRateListened {
    void getCommentForRateSuccessed(ArrayList<BookComment> data);
    void noComment();
    void connectFailed(String message);
}
