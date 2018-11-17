package com.example.administrator.appctct.Presenter;

import com.example.administrator.appctct.Interfaces.ChangePassword.ModelNotifyPresenter;
import com.example.administrator.appctct.Interfaces.ChangePassword.PresenterNotifyView;
import com.example.administrator.appctct.Model.ModelChangPassword;

public class PresentChangPassword implements ModelNotifyPresenter{
    private PresenterNotifyView listened;

    public void setListened(PresenterNotifyView listened){
        this.listened = listened;
    }
    public void noticeModelChangePassword(String currentPass,String newPass,String confirmPass){
        ModelChangPassword model = new ModelChangPassword();
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
