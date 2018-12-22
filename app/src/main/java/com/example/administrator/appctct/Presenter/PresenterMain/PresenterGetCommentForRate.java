package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Model.ModelMain.ModelGetCommentForRate;
import com.example.administrator.appctct.Model.ModelMain.ModelGetCommentForRateListened;

import java.util.ArrayList;

public class PresenterGetCommentForRate implements ModelGetCommentForRateListened {
    private ModelGetCommentForRate model = new ModelGetCommentForRate(this);
    private PresenterGetCommentForRateListened listened;

    public PresenterGetCommentForRate(PresenterGetCommentForRateListened listened){
        this.listened = listened;
    }

    public void process(int rate,String idBook){
        model.process(rate,idBook);
    }
    @Override
    public void getCommentForRateSuccessed(ArrayList<BookComment> data) {
        listened.getCommentForRateSuccessed(data);
    }

    @Override
    public void noComment() {
        listened.noComment();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
