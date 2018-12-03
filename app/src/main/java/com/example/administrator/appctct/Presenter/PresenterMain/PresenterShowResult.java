package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Model.ModelMain.ModelShowResult;
import com.example.administrator.appctct.Model.ModelMain.ModelShowResultListened;

import java.util.ArrayList;

public class PresenterShowResult implements ModelShowResultListened{
    private ModelShowResult model = new ModelShowResult(this);
    private PresenterShowResultListened listened;

    public PresenterShowResult(PresenterShowResultListened listened){
        this.listened = listened;
    }

    public void getResult(ArrayList<IdAndResult> list){
        model.getResult(list);
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
