package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Entity.Profile.Status;
import com.example.administrator.appctct.Model.ModelProfile.ModelGetStatusUser;
import com.example.administrator.appctct.Model.ModelProfile.ModelGetStatusUserListened;

import java.util.ArrayList;

public class PresenterGetStatusUser  implements ModelGetStatusUserListened {
    private ModelGetStatusUser model = new ModelGetStatusUser(this);
    private PresenterGetStatusUserListened listened;

    public PresenterGetStatusUser(PresenterGetStatusUserListened listened){
        this.listened = listened;
    }

    public void process(String id){
        model.process(id);
    }

    @Override
    public void getStatusSuccessed(ArrayList<Status> data) {
        listened.getStatusSuccessed(data);
    }

    @Override
    public void getStatusNull() {
        listened.getStatusNull();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
