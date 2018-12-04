package com.example.administrator.appctct.Model.ModelMain;

import com.example.administrator.appctct.Entity.ResultQuestion;

public interface ModelShowResultListened {
    void getPointSuccessed(ResultQuestion result);
    void getPointFailed();
    void connectFailed(String message);
}
