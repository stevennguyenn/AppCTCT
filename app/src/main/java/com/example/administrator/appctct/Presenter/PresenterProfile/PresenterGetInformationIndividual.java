package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.Model.ModelProfile.ModelGetInformationIndividual;
import com.example.administrator.appctct.Model.ModelProfile.ModelGetInformationIndividualListened;

public class PresenterGetInformationIndividual implements ModelGetInformationIndividualListened {
    private ModelGetInformationIndividual model = new ModelGetInformationIndividual(this);
    private PresenterGetInformationIndividualListened listened;

    public PresenterGetInformationIndividual(PresenterGetInformationIndividualListened listened){
        this.listened = listened;
    }

    public void process(String id){
        model.process(id);
    }
    @Override
    public void getIndiformationIndividualSuccessed(InformationIndividual info) {
        listened.getIndiformationIndividualSuccessed(info);
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
