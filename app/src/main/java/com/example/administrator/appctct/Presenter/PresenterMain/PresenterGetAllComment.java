package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.RateBook.CommentSeeAll;
import com.example.administrator.appctct.Model.ModelMain.ModelGetAllComment;
import com.example.administrator.appctct.Model.ModelMain.ModelGetAllCommentListened;

public class PresenterGetAllComment implements ModelGetAllCommentListened {

    private ModelGetAllComment model = new ModelGetAllComment(this);
    private PresenterGetAllCommentListened listened;

    public PresenterGetAllComment(PresenterGetAllCommentListened listened){
        this.listened = listened;
    }

    public void process(int page,String idBook){
        model.process(page,idBook);
    }

    @Override
    public void getCommentSuccessed(CommentSeeAll data) {
        listened.getCommentSuccessed(data);
    }

    @Override
    public void nomoreComment() {
        listened.nomoreComment();
    }

    @Override
    public void connectFailed() {
        listened.connectFailed();
    }
}
