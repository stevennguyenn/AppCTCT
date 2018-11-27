package com.example.administrator.appctct.Presenter.PresenterMain;

public interface PresenterMainListened {
    void noChoice();
    void getPointSuccessed(int point);
    void getPointFailed();
    void connectFailed(String message);
}
