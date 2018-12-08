package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.ModelQuestion;

import java.util.ArrayList;

public interface PresenterMainGetQuestionListened {
    void getQuestionSuccessed(ArrayList<ModelQuestion> listQuestion);
    void noQuestion();
    void connectFailed(String message);
}
