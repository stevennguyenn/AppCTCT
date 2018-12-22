package com.example.administrator.appctct.Model.ModelMain;

import com.example.administrator.appctct.Entity.RateBook.CommentSeeAll;

public interface ModelGetAllCommentListened {
    void getCommentSuccessed(CommentSeeAll data);
    void nomoreComment();
    void connectFailed(String message);
}
