package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.ResultQuestion;

public interface PresenterShowResultListened {
    void getPointSuccessed(ResultQuestion result);
    void getPointFailed();
    void connectFailed(String message);
}
