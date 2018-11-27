package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Model.ModelMain.ModelMain;
import com.example.administrator.appctct.Model.ModelMain.ModelMainListened;

import java.util.ArrayList;

public class PresenterMain implements ModelMainListened {

    private ModelMain model = new ModelMain(this);
    private PresenterMainListened listened;

    public PresenterMain(PresenterMainListened listened){
        this.listened = listened;
    }

    public void getResult(ArrayList<IdAndResult>listResult){
        model.getResult(listResult);
    }

    @Override
    public void noChoice() {
        listened.noChoice();
    }

    @Override
    public void getPointSuccessed(int point) {
        listened.getPointSuccessed(point);
    }

    @Override
    public void getPointFailed() {
        listened.getPointFailed();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
