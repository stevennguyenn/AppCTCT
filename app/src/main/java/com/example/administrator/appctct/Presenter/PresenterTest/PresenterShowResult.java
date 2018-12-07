package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ResultQuestion;
import com.example.administrator.appctct.Model.ModelTest.ModelShowResult;
import com.example.administrator.appctct.Model.ModelTest.ModelShowResultListened;

import java.util.ArrayList;

public class PresenterShowResult implements ModelShowResultListened{
    private ModelShowResult model = new ModelShowResult(this);
    private PresenterShowResultListened listened;

    public PresenterShowResult(PresenterShowResultListened listened){
        this.listened = listened;
    }

    public void getResult(ArrayList<IdAndResult> list,String token){
        model.getResult(list,token);
    }

    @Override
    public void getPointSuccessed(ResultQuestion result) {
        listened.getPointSuccessed(result);
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
