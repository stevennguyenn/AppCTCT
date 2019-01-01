package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Model.ModelProfile.ModelUserUnfollows;
import com.example.administrator.appctct.Model.ModelProfile.ModelUserUnfollowsListened;

public class PresenterUserUnFollows implements ModelUserUnfollowsListened {

    private ModelUserUnfollows model = new ModelUserUnfollows(this);
    private PresenterUserUnFollowsListened listened;

    public PresenterUserUnFollows(PresenterUserUnFollowsListened listened){
        this.listened = listened;
    }

    public void process(int idUser,String idUserFollows){
        model.process(idUser,idUserFollows);
    }
    @Override
    public void userUnFollowsSuccessed() {
        listened.userUnFollowsSuccessed();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
