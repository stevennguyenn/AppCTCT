package com.example.administrator.appctct.Model.ModelRegister;

public interface ModelRegisterListened {
    void passwordIncorrect();
    void registerSuccess(String fullName,String userName,String password,String baseURL);
    void baseURLIsEmpty();
    void loadImageFailed();
    void connectFailed();
    void insertAccountSuccessed();
    void insertAccountFailed();
}
