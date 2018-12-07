package com.example.administrator.appctct.Model.ModelTest;

import com.example.administrator.appctct.Entity.QuestionTestTested;

import java.util.ArrayList;

public interface ModelGetQuestionTestTestedListened {
    void getQuestionSuccessed(ArrayList<QuestionTestTested> listQuestion);
    void connectFailed(String message);
}
