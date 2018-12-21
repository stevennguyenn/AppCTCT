package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.RateBook.TitleCommentSeeAll;

public interface PresenterGetTitleSeeAllCommentListened {
    void getTitleSeeAllSuccessed(TitleCommentSeeAll data);
    void connectFailed(String message);
}
