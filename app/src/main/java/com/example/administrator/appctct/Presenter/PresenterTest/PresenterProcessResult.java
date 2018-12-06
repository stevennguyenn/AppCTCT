package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Model.ModelTest.ModelProcessResult;
import com.example.administrator.appctct.Model.ModelTest.ModelProcessResultListened;

import java.util.ArrayList;

public class PresenterProcessResult implements ModelProcessResultListened {
    private ModelProcessResult model = new ModelProcessResult(this);
    private PresenterProcessResultListened listened;
    public PresenterProcessResult(PresenterProcessResultListened listened){
        this.listened = listened;
    }
    public void process(ArrayList<ModelQuestion> listQuestion,ArrayList<IdAndResult> listIdAndResult,int position,String result){
        model.process(listQuestion,listIdAndResult,position,result);
    }

    public void processRemove(ArrayList<IdAndResult> listIdAndResult,String id){
        model.processRemove(listIdAndResult,id);
    }

    @Override
    public void getResult(ArrayList<IdAndResult> list) {
        listened.getResult(list);
    }

    @Override
    public void removeList(ArrayList<IdAndResult> list) {
        listened.removeList(list);
    }
}
