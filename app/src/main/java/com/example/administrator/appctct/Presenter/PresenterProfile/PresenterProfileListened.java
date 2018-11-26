package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Entity.Profile;

public interface PresenterProfileListened {
    void getInformationSuccessed(Profile profile);
    void getInformationFailed();
    void connectFailed(String message);
    void checkCodeSuccessed();
    void checkCodeFailed();
}
