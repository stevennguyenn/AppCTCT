package com.example.administrator.appctct.Model.ModelTest;

import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Entity.ModelQuestionOnlineOffline;

import java.util.ArrayList;

public interface ModelMainGetQuestionListened {
    void getQuestionSuccessed(ModelQuestionOnlineOffline data);
    void noQuestion();
    void connectFailed(String message);
}
