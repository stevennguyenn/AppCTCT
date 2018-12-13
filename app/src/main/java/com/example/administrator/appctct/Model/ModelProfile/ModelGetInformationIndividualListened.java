package com.example.administrator.appctct.Model.ModelProfile;

import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.View.Profile.IndividualActivity;

public interface ModelGetInformationIndividualListened {
    void getIndiformationIndividualSuccessed(InformationIndividual info);
    void informationIndividualNull();
    void connectFailed(String message);
}
