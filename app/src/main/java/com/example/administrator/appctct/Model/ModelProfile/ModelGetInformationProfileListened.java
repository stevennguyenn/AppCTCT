package com.example.administrator.appctct.Model.ModelProfile;

import com.example.administrator.appctct.Entity.InformationProfile;

public interface ModelGetInformationProfileListened {
    void getInformationProfileSuccessed(InformationProfile data);
    void informationIndividualNull();
    void connectFailed(String message);
}
