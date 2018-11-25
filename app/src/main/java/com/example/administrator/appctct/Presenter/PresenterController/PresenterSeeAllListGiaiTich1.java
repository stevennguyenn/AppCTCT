package com.example.administrator.appctct.Presenter.PresenterController;

import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.Model.ModelController.ModelSeeAllListGiaiTich1;
import com.example.administrator.appctct.Model.ModelController.ModelSeeAllListGiaiTich1Listened;

import java.util.ArrayList;

public class PresenterSeeAllListGiaiTich1 implements ModelSeeAllListGiaiTich1Listened {

    private ModelSeeAllListGiaiTich1 model = new ModelSeeAllListGiaiTich1(this);
    private PresenterSeeAllListGiaiTich1Listened listened;

    public PresenterSeeAllListGiaiTich1(PresenterSeeAllListGiaiTich1Listened listened){
        this.listened = listened;
    }

    public void getData(){
        model.getData();
    }

    @Override
    public void getAllSuccessed(ArrayList<FullBook> listBook) {
        listened.getAllSuccessed(listBook);
    }

    @Override
    public void getAllFailed() {
        listened.getAllFailed();
    }

    @Override
    public void connectFailed() {
        listened.connectFailed();
    }
}
