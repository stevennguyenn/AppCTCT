package com.example.administrator.appctct.Interfaces.Register;

public interface PresenterNotifyViewRegister {
    void passwordIncorrect();
    void registerSuccess(String fullName,String userName,String password,String baseURL);
    void baseURLIsEmpty();
}
