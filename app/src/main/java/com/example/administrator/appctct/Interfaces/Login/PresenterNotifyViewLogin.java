package com.example.administrator.appctct.Interfaces.Login;

public interface PresenterNotifyViewLogin {
    void userIsEmpty();
    void passwordIsEmpty();
    void loginSuccess(String account, String password);
}
