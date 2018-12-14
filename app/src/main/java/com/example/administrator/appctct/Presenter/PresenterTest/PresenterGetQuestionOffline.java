package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Entity.ModelQuestionOnlineOffline;
import com.example.administrator.appctct.Model.ModelTest.ModelGetQuestionOffline;
import com.example.administrator.appctct.Model.ModelTest.ModelGetQuestionOfflineListened;
import com.example.administrator.appctct.Model.ModelTest.ModelMainGetQuestionListened;

import java.util.ArrayList;

public class PresenterGetQuestionOffline implements ModelGetQuestionOfflineListened {
    private ModelGetQuestionOffline model = new ModelGetQuestionOffline(this);
    private PresenterGetQuestionOfflineListened listened;

    public PresenterGetQuestionOffline(PresenterGetQuestionOfflineListened listened) {
        this.listened = listened;
    }

    public void getQuestion(int typeSection, String testCode) {
        model.getQuestion(typeSection, testCode);
    }

    @Override
    public void getQuestionOfflineSuccessed(ArrayList<ModelQuestion> listQuestion) {
        listened.getQuestionOfflineSuccessed(listQuestion);
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
