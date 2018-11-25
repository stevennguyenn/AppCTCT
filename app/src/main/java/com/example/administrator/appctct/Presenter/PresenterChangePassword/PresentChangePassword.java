package com.example.administrator.appctct.Presenter.PresenterChangePassword;

import com.example.administrator.appctct.Model.ModelChangePassword.ModelChangePasswordListened;
import com.example.administrator.appctct.Model.ModelChangePassword.ModelChangePassword;

public class PresentChangePassword implements ModelChangePasswordListened {
    private PresenterChangePasswordListened listened;

    public void setListened(PresenterChangePasswordListened listened){
        this.listened = listened;
    }
    public void noticeModelChangePassword(String currentPass,String newPass,String confirmPass){
        ModelChangePassword model = new ModelChangePassword();
        model.setListened(this);
        model.process(currentPass,newPass,confirmPass);
    }

    @Override
    public void currentPassEmpty() {
        listened.currentPassEmpty();
    }

    @Override
    public void newPassEmpty() {
        listened.newPassEmpty();
    }

    @Override
    public void confirmPassEmpty() {
        listened.confirmPassEmpty();
    }

    @Override
    public void newDiffenceConfirm() {
        listened.newDiffenceConfirm();
    }

    @Override
    public void successed() {
        listened.successed();
    }
}
