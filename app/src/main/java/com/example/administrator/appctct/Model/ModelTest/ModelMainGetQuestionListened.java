package com.example.administrator.appctct.Model.ModelTest;

import com.example.administrator.appctct.Entity.ModelQuestion;

import java.util.ArrayList;

public interface ModelMainGetQuestionListened {
    void getQuestionSuccessed(ArrayList<ModelQuestion> listQuestion);
    void getQuestionFailed();
    void connectFailed(String message);
}