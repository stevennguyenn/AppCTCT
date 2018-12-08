package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Model.ModelTest.ModelGetQuestionOffline;
import com.example.administrator.appctct.Model.ModelTest.ModelMainGetQuestionListened;

import java.util.ArrayList;

public class PresenterGetQuestionOffline implements ModelMainGetQuestionListened {
    private ModelGetQuestionOffline model = new ModelGetQuestionOffline(this);
    private PresenterMainGetQuestionListened listened;

    public PresenterGetQuestionOffline(PresenterMainGetQuestionListened listened) {
        this.listened = listened;
    }

    public void getQuestion(int typeSection, String testCode) {
        model.getQuestion(typeSection, testCode);
    }

    @Override
    public void getQuestionSuccessed(ArrayList<ModelQuestion> listQuestion) {
        listened.getQuestionSuccessed(listQuestion);
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
