package com.example.administrator.appctct.Presenter.PresenterLogin;

import com.example.administrator.appctct.Model.ModelLogin.ModelLoginListened;
import com.example.administrator.appctct.Model.ModelLogin.ModelLogin;

public class PresenterLogin implements ModelLoginListened {

    private PresenterLoginListened callback;
    private  ModelLogin model = new ModelLogin(this);

    public PresenterLogin(PresenterLoginListened callback){
        this.callback = callback;
    }


    public void login(String account,String password){
        model.login(account,password);
    }

    @Override
    public void loginSuccessed(String token) {
        callback.loginSuccessed(token);
    }

    @Override
    public void loginFailed() {
        callback.loginFailed();
    }

    @Override
    public void connectFailed() {
        callback.connectFailed();
    }

}
