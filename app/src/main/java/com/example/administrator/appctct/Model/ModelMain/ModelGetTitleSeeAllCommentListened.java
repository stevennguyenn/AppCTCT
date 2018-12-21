package com.example.administrator.appctct.Model.ModelMain;

import com.example.administrator.appctct.Entity.RateBook.TitleCommentSeeAll;

public interface ModelGetTitleSeeAllCommentListened {
    void getTitleSeeAllSuccessed(TitleCommentSeeAll data);
    void connectFailed(String message);
}
