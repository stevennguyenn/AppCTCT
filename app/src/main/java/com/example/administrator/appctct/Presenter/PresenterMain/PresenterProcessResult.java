package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Model.ModelMain.ModelProcessResult;
import com.example.administrator.appctct.Model.ModelMain.ModelProcessResultListened;

import java.util.ArrayList;

public class PresenterProcessResult implements ModelProcessResultListened {
    private ModelProcessResult model = new ModelProcessResult(this);
    private PresenterProcessResultListened listened;
    public PresenterProcessResult(PresenterProcessResultListened listened){
        this.listened = listened;
    }
    public void process(Object...objects){
        model.process(objects);
    }

    @Override
    public void getResult(ArrayList<IdAndResult> list) {
        listened.getResult(list);
    }
}
