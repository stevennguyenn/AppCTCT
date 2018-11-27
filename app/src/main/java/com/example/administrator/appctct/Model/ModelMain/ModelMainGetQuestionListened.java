package com.example.administrator.appctct.Model.ModelMain;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.ModelQuestion;

import java.util.ArrayList;

public interface ModelMainGetQuestionListened {
    void getQuestionSuccessed(ArrayList<ModelQuestion> listQuestion);
    void getQuestionFailed();
    void connectFailed(String message);
}
