package com.example.administrator.appctct.Presenter.PresenterLogin;

public interface PresenterLoginListened {
    void loginSuccessed(String token);
    void loginFailed();
    void connectFailed();

}
