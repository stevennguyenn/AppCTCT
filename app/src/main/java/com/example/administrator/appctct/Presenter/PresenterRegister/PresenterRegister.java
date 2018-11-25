package com.example.administrator.appctct.Presenter.PresenterRegister;

import com.example.administrator.appctct.Model.ModelRegister.ModelRegisterListened;
import com.example.administrator.appctct.Model.ModelRegister.ModelRegister;

import okhttp3.MultipartBody;

public class PresenterRegister implements ModelRegisterListened {

    private PresenterRegisterListened callback;
    ModelRegister model = new ModelRegister(this);

    public PresenterRegister(PresenterRegisterListened callback){
        this.callback = callback;
    }

    public void notifyModelRegister(String fullName,String userName,String password, String confirmPassord,String baseURL){
        model.processRegister(fullName,userName,password,confirmPassord,baseURL);
    }

    public void insertAccountIntoDatabase(MultipartBody.Part body,String  fullName, String userName, String password){
        model.insertAccountIntoDatabase(body, fullName,userName,password);
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

    @Override
    public void loadImageFailed() {
        callback.loadImageFailed();
    }

    @Override
    public void connectFailed() {
        callback.connectFailed();
    }

    @Override
    public void insertAccountSuccessed() {
        callback.insertAccountSuccessed();
    }

    @Override
    public void insertAccountFailed() {
        callback.insertAccountFailed();
    }
}
