package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.ModelQuestion;

import java.util.ArrayList;

public interface PresenterMainGetQuestionListened {
    void getQuestionSuccessed(ArrayList<ModelQuestion> listQuestion);
    void getQuestionFailed();
    void connectFailed(String message);
}
