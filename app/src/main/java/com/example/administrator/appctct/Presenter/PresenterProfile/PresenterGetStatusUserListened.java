package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Entity.Profile.Status;

import java.util.ArrayList;

public interface PresenterGetStatusUserListened {
    void getStatusSuccessed(ArrayList<Status> data);
    void getStatusNull();
    void connectFailed(String message);
}
