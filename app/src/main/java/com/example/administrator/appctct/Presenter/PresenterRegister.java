package com.example.administrator.appctct.Presenter;

import com.example.administrator.appctct.Interfaces.Register.ModelRegisterNotifyPresenter;
import com.example.administrator.appctct.Interfaces.Register.PresenterNotifyViewRegister;
import com.example.administrator.appctct.Model.ModelRegister;

public class PresenterRegister implements ModelRegisterNotifyPresenter{

    private PresenterNotifyViewRegister callback;

    public PresenterRegister(PresenterNotifyViewRegister callback){
        this.callback = callback;
    }

    public void notifyModelRegister(String fullName,String userName,String password, String confirmPassord,String baseURL){
        ModelRegister model = new ModelRegister(this);
        model.processRegister(fullName,userName,password,confirmPassord,baseURL);
    }

    @Override
    public void fullNameIsEmpty() {
        callback.fullNameIsEmpty();
    }

    @Override
    public void userNameIsEmpty() {
        callback.userNameIsEmpty();
    }

    @Override
    public void passwordIsEmpty() {
        callback.passwordIsEmpty();
    }

    @Override
    public void confirmPasswordIsEmpty() {
        callback.confirmPasswordIsEmpty();
    }

    @Override
    public void passwordIncorrect() {
        callback.passwordIncorrect();
    }

    @Override
    public void registerSuccess(String fullName,String userName,String password,String baseURL) {
        callback.registerSuccess(fullName,userName,password,baseURL);
    }

    @Override
    public void baseURLIsEmpty() {
        callback.baseURLIsEmpty();
    }
}
