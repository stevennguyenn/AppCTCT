package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Model.ModelMain.ModelMainGetQuestion;
import com.example.administrator.appctct.Model.ModelMain.ModelMainGetQuestionListened;

import java.util.ArrayList;

public class PresenterMainGetQuestion implements ModelMainGetQuestionListened{

    private ModelMainGetQuestion model = new ModelMainGetQuestion(this);
    private PresenterMainGetQuestionListened listened;

    public PresenterMainGetQuestion(PresenterMainGetQuestionListened listened){
        this.listened = listened;
    }

    public void getQuestion(int typeSection){
        model.getQuestion(typeSection);
    }

    @Override
    public void getQuestionSuccessed(ArrayList<ModelQuestion> listQuestion) {
        listened.getQuestionSuccessed(listQuestion);
    }

    @Override
    public void getQuestionFailed() {
        listened.getQuestionFailed();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
