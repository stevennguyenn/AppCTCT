package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.TitleSection;
import com.example.administrator.appctct.Model.ModelTest.ModelSectionOffline;
import com.example.administrator.appctct.Model.ModelTest.ModelSectionOfflineListened;

import java.util.ArrayList;

public class PresenterSectionOffline implements ModelSectionOfflineListened {

    private ModelSectionOffline model = new ModelSectionOffline(this);
    private PresenterSectionOfflineListened listened;

    public PresenterSectionOffline(PresenterSectionOfflineListened listened){
        this.listened = listened;
    }

    public void getData(Integer typeSection,String token){
        model.getData(typeSection,token);
    }

    @Override
    public void getTitleSectionSuccessed(ArrayList<TitleSection> listSection) {
        listened.getTitleSectionSuccessed(listSection);
    }

    @Override
    public void noTestOffline() {
        listened.noTestOffline();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
