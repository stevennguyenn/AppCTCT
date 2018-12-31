package com.example.administrator.appctct.Model.ModelProfile;

import com.example.administrator.appctct.Entity.Profile.Status;

import java.util.ArrayList;

public interface ModelGetStatusUserListened {
    void getStatusSuccessed(ArrayList<Status> data);
    void getStatusNull();
    void connectFailed(String message);
}
