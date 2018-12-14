package com.example.administrator.appctct.Model.ModelTest;

import com.example.administrator.appctct.Entity.ModelQuestion;

import java.util.ArrayList;

public interface ModelGetQuestionOfflineListened {
    void getQuestionOfflineSuccessed(ArrayList<ModelQuestion> listQuestion);
    void noQuestion();
    void connectFailed(String message);
}
