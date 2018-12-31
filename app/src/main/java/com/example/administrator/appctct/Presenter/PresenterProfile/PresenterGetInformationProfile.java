package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.Entity.InformationProfile;
import com.example.administrator.appctct.Model.ModelProfile.ModelGetInformationProfile;
import com.example.administrator.appctct.Model.ModelProfile.ModelGetInformationProfileListened;


public class PresenterGetInformationProfile implements ModelGetInformationProfileListened {
    private ModelGetInformationProfile model = new ModelGetInformationProfile(this);
    private PresenterGetInformationProfileListened listened;

    public PresenterGetInformationProfile(PresenterGetInformationProfileListened listened){
        this.listened = listened;
    }

    public void process(String id){
        model.process(id);
    }

    @Override
    public void getInformationProfileSuccessed(InformationProfile data) {
        listened.getInformationProfileSuccessed(data);
    }

    @Override
    public void informationIndividualNull() {
        listened.informationIndividualNull();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
