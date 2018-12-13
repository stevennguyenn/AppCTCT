package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.View.Profile.IndividualActivity;

public interface PresenterGetInformationIndividualListened {
    void getIndiformationIndividualSuccessed(InformationIndividual info);
    void informationIndividualNull();
    void connectFailed(String message);
}
