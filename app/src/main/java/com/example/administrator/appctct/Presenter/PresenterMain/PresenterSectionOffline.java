package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.TitleSection;
import com.example.administrator.appctct.Model.ModelMain.ModelSectionOffline;
import com.example.administrator.appctct.Model.ModelMain.ModelSectionOfflineListened;

import java.util.ArrayList;

public class PresenterSectionOffline implements ModelSectionOfflineListened {

    private ModelSectionOffline model = new ModelSectionOffline(this);
    private PresenterSectionOfflineListened listened;

    public PresenterSectionOffline(PresenterSectionOfflineListened listened){
        this.listened = listened;
    }

    public void getData(Integer typeSection){
        model.getData(typeSection);
    }

    @Override
    public void getTitleSectionSuccessed(ArrayList<TitleSection> listSection) {
        listened.getTitleSectionSuccessed(listSection);
    }

    @Override
    public void getTitleSectionFailed() {
        listened.getTitleSectionFailed();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
