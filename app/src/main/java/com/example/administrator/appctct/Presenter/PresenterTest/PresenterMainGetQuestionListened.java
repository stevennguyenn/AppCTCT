package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Entity.ModelQuestionOnlineOffline;

import java.util.ArrayList;

public interface PresenterMainGetQuestionListened {
    void getQuestionSuccessed(ModelQuestionOnlineOffline data);
    void noQuestion();
    void connectFailed(String message);
}
