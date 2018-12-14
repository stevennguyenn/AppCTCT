package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Entity.ModelQuestionOnlineOffline;
import com.example.administrator.appctct.Model.ModelTest.ModelMainGetQuestion;
import com.example.administrator.appctct.Model.ModelTest.ModelMainGetQuestionListened;

import java.util.ArrayList;

public class PresenterMainGetQuestion implements ModelMainGetQuestionListened{

    private ModelMainGetQuestion model = new ModelMainGetQuestion(this);
    private PresenterMainGetQuestionListened listened;

    public PresenterMainGetQuestion(PresenterMainGetQuestionListened listened){
        this.listened = listened;
    }

    public void getQuestion(int typeSection,String token){
        model.getQuestion(typeSection,token);
    }

    @Override
    public void getQuestionSuccessed(ModelQuestionOnlineOffline data) {
        listened.getQuestionSuccessed(data);
    }

    @Override
    public void noQuestion() {
        listened.noQuestion();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
