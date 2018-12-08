package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.TestTested;
import com.example.administrator.appctct.Model.ModelTest.ModelTestTested;
import com.example.administrator.appctct.Model.ModelTest.ModelTestTestedListened;

import java.util.ArrayList;

public class PresenterTestTested implements ModelTestTestedListened{
    private ModelTestTested model = new ModelTestTested(this);
    private PresenterTestTestedListened listened;

    public PresenterTestTested(PresenterTestTestedListened listened){
        this.listened = listened;
    }

    public void getTestTested(int typeSection,int id){
        model.getTestTested(typeSection,id);
    }
    @Override
    public void getTestTestedSuccessed(ArrayList<TestTested> listResult) {
        listened.getTestTestedSuccessed(listResult);
    }

    @Override
    public void noTestTested() {
        listened.noTestTested();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
