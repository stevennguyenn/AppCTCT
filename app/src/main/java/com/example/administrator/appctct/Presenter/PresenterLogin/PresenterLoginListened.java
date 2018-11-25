package com.example.administrator.appctct.Presenter.PresenterLogin;

public interface PresenterLoginListened {
    void userIsEmpty();
    void passwordIsEmpty();
    void loginSuccess(String account, String password);
    void loginSuccessed(String token);
    void loginFailed();
    void connectFailed();

}
