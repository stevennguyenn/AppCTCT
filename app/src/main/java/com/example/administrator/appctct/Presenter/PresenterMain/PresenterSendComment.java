package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Model.ModelMain.ModelSendComment;
import com.example.administrator.appctct.Model.ModelMain.ModelSendCommentListened;

public class PresenterSendComment implements ModelSendCommentListened {
    private ModelSendComment model = new ModelSendComment(this);
    private PresenterSendCommentListened listened;

    public PresenterSendComment(PresenterSendCommentListened listened){
        this.listened = listened;
    }

    public void process(String idUser,String idBook,String contentcomment,Float ratio){
        model.process(idUser,idBook,contentcomment,ratio);
    }

    @Override
    public void successed() {
        listened.successed();
    }

    @Override
    public void failed() {
        listened.failed();
    }
}
