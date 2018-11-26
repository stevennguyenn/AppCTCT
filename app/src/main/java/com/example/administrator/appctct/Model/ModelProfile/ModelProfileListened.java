package com.example.administrator.appctct.Model.ModelProfile;

import com.example.administrator.appctct.Entity.Profile;

public interface ModelProfileListened {
    void getInformationSuccessed(Profile profile);
    void getInformationFailed();
    void connectFailed(String message);
    void checkCodeSuccessed();
    void checkCodeFailed();
}
