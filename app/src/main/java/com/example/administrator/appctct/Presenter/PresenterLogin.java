package com.example.administrator.appctct.Presenter;

import com.example.administrator.appctct.Interfaces.Login.ModelAccountNotifyPresenter;
import com.example.administrator.appctct.Interfaces.Login.PresenterNotifyViewLogin;
import com.example.administrator.appctct.Model.ModelAccount;

public class PresenterLogin implements ModelAccountNotifyPresenter {

    private PresenterNotifyViewLogin callback;

    public PresenterLogin(PresenterNotifyViewLogin callback){
        this.callback = callback;
    }

    public void notifyodelProcessLogin(String userName, String password){
        ModelAccount model;
        model = new ModelAccount(this);
        model.handlerLogin(userName,password);
    }

    @Override
    public void userIsEmpty() {
        callback.userIsEmpty();
    }

    @Override
    public void passwordIsEmpty() {
        callback.passwordIsEmpty();
    }

    @Override
    public void loginSuccess(String account, String password) {
        callback.loginSuccess(account,password);
    }
}
