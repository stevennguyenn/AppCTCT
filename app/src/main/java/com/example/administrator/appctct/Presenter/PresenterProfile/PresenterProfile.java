package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Entity.Profile.Profile;
import com.example.administrator.appctct.Model.ModelProfile.ModelProfile;
import com.example.administrator.appctct.Model.ModelProfile.ModelProfileListened;

public class PresenterProfile implements ModelProfileListened {

    private ModelProfile model = new ModelProfile(this);
    private PresenterProfileListened listened;

    public PresenterProfile(PresenterProfileListened listened){
        this.listened = listened;
    }

    public void getInformation(String id){
        model.getInformation(id);
    }

    @Override
    public void getInformationSuccessed(Profile profile) {
        listened.getInformationSuccessed(profile);
    }

    public void checkCode(String token,String code){
        model.checkCode(token,code);
    }

    @Override
    public void getInformationFailed() {
        listened.getInformationFailed();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }

    @Override
    public void checkCodeSuccessed() {
        listened.checkCodeSuccessed();
    }

    @Override
    public void checkCodeFailed() {
        listened.checkCodeFailed();
    }
}
