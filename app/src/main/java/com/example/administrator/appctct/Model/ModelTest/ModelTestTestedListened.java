package com.example.administrator.appctct.Model.ModelTest;

import com.example.administrator.appctct.Entity.TestTested;

import java.util.ArrayList;

public interface ModelTestTestedListened {
    void getTestTestedSuccessed(ArrayList<TestTested> listResult);
    void  getTestTestedFailed();
    void connectFailed(String message);
}
