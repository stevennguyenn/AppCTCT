package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.TestTested;

import java.util.ArrayList;

public interface PresenterTestTestedListened {
    void getTestTestedSuccessed(ArrayList<TestTested> listResult);
    void  getTestTestedFailed();
    void connectFailed(String message);
}
