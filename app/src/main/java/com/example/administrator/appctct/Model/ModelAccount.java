package com.example.administrator.appctct.Model;

import com.example.administrator.appctct.Interfaces.Login.ModelAccountNotifyPresenter;

public class ModelAccount {

    private ModelAccountNotifyPresenter callback;

    public ModelAccount(ModelAccountNotifyPresenter callback){
        this.callback = callback;
    }

    public void handlerLogin(String userName, String password){
        if (userName.equals("")){
            callback.userIsEmpty();
            return;
        }
        if (password.equals("")){
            callback.passwordIsEmpty();
            return;
        }
        callback.loginSuccess(userName,password);
    }
}
