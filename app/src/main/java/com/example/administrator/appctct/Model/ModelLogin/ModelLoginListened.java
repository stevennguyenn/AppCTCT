package com.example.administrator.appctct.Model.ModelLogin;

public interface ModelLoginListened {
    void userIsEmpty();
    void passwordIsEmpty();
    void loginSuccess(String account, String password);
    void loginSuccessed(String token);
    void loginFailed();
    void connectFailed();
}
