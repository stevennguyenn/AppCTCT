package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Model.ModelTest.ModelInitList;
import com.example.administrator.appctct.Model.ModelTest.ModelInitListListened;

import java.util.ArrayList;

public class PresenterInitList implements ModelInitListListened {
    private ModelInitList model = new ModelInitList(this);
    private PresenterInitListened listened;

    public PresenterInitList(PresenterInitListened listened){
        this.listened = listened;
    }

    public void process(ArrayList<ModelQuestion> listQuestion){
        model.process(listQuestion);
    }

    @Override
    public void processSuccessed(ArrayList<IdAndResult> listResult) {
        listened.processSuccessed(listResult);
    }
}
