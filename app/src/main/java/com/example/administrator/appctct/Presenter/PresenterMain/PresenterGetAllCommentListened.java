package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.RateBook.CommentSeeAll;

public interface PresenterGetAllCommentListened {
    void getCommentSuccessed(CommentSeeAll data);
    void nomoreComment();
    void connectFailed(String message);
}
