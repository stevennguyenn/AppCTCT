package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Entity.InformationProfile;

public interface PresenterGetInformationProfileListened {
    void getInformationProfileSuccessed(InformationProfile data);
    void informationIndividualNull();
    void connectFailed(String message);
}
