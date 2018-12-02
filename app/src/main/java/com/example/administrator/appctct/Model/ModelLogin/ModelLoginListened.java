package com.example.administrator.appctct.Model.ModelLogin;

public interface ModelLoginListened {
    void loginSuccessed(String token);
    void loginFailed();
    void connectFailed();
}
