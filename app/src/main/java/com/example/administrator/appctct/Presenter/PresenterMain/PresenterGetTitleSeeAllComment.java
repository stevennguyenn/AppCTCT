package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.BookDetail.FullBookComment;
import com.example.administrator.appctct.Entity.RateBook.TitleCommentSeeAll;
import com.example.administrator.appctct.Model.ModelMain.ModelGetCommentBook;
import com.example.administrator.appctct.Model.ModelMain.ModelGetTitleSeeAllComment;
import com.example.administrator.appctct.Model.ModelMain.ModelGetTitleSeeAllCommentListened;

public class PresenterGetTitleSeeAllComment implements ModelGetTitleSeeAllCommentListened {
    private ModelGetTitleSeeAllComment model = new ModelGetTitleSeeAllComment(this);
    private PresenterGetTitleSeeAllCommentListened listened;

    public PresenterGetTitleSeeAllComment(PresenterGetTitleSeeAllCommentListened listened){
        this.listened = listened;
    }

    public void process(String idBook){
        model.process(idBook);
    }


    @Override
    public void getTitleSeeAllSuccessed(TitleCommentSeeAll data) {
        listened.getTitleSeeAllSuccessed(data);
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
