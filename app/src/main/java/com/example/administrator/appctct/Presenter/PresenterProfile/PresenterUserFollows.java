package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Model.ModelProfile.ModelUserFollows;
import com.example.administrator.appctct.Model.ModelProfile.ModelUserFollowsListened;


public class PresenterUserFollows implements ModelUserFollowsListened {

    private ModelUserFollows model = new ModelUserFollows(this);
    private PresenterUserFollowsListened listened;

    public PresenterUserFollows(PresenterUserFollowsListened listened){
        this.listened = listened;
    }

    public void process(int idUser,String idUserFollows){
        model.process(idUser,idUserFollows);
    }
    @Override
    public void userFollowsSuccessed() {
        listened.userFollowsSuccessed();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
