package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Entity.PointNameCourse;
import com.example.administrator.appctct.Model.ModelProfile.ModelGetInformationTestTested;
import com.example.administrator.appctct.Model.ModelProfile.ModelGetInformationTestTestedListened;

import java.util.ArrayList;

public class PresenterGetInformationTestTested implements ModelGetInformationTestTestedListened {
    private ModelGetInformationTestTested model = new ModelGetInformationTestTested(this);
    private PresenterGetInformationTestTestedListened listened;

    public PresenterGetInformationTestTested(PresenterGetInformationTestTestedListened listened){
        this.listened = listened;
    }

    public void process(String id){
        model.process(id);
    }

    @Override
    public void getIndiformationIndividualSuccessed(ArrayList<PointNameCourse> data) {
        listened.getIndiformationIndividualSuccessed(data);
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
