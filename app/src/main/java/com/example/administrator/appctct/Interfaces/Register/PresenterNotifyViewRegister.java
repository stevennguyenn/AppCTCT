package com.example.administrator.appctct.Interfaces.Register;

public interface PresenterNotifyViewRegister {
    void fullNameIsEmpty();
    void userNameIsEmpty();
    void passwordIsEmpty();
    void confirmPasswordIsEmpty();
    void passwordIncorrect();
    void registerSuccess(String fullName,String userName,String password,String baseURL);
    void baseURLIsEmpty();
}
