package com.example.administrator.appctct.Interfaces.Login;

public interface ModelAccountNotifyPresenter {
    void userIsEmpty();
    void passwordIsEmpty();
    void loginSuccess(String account, String password);
}
