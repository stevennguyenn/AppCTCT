package com.example.administrator.appctct.Model;

import com.example.administrator.appctct.Interfaces.Register.ModelRegisterNotifyPresenter;

public class ModelRegister {

    private ModelRegisterNotifyPresenter callback;

    public ModelRegister(ModelRegisterNotifyPresenter callback){
        this.callback = callback;
    }

    public void processRegister(String fullName,String userName,String password, String confirmPassord,String baseURL){

        if (fullName.equals("")){
            callback.fullNameIsEmpty();
            return;
        }
        if (userName.equals("")){
            callback.userNameIsEmpty();
            return;
        }
        if (password.equals("")){
            callback.passwordIsEmpty();
        }
        if(confirmPassord.equals("")){
            callback.confirmPasswordIsEmpty();
            return;
        }
        if (!password.equals(confirmPassord)){
            callback.passwordIncorrect();
            return;
        }
        if (baseURL.equals("")){
            callback.baseURLIsEmpty();
        }
        callback.registerSuccess(fullName,userName,password,baseURL);
    }
}
