package com.example.administrator.appctct.Presenter.PresenterController;

import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.Model.ModelController.ModelSeeAll;
import com.example.administrator.appctct.Model.ModelController.ModelSeeAllListened;

import java.util.ArrayList;

public class PresenterSeeAll implements ModelSeeAllListened {

    private ModelSeeAll model = new ModelSeeAll(this);
    private PresenterSeeAllListened listened;

    public PresenterSeeAll(PresenterSeeAllListened listened){
        this.listened = listened;
    }

    public void getDataGiaiTich1(){
        model.getData();
    }

    public void getDataGiaiTich2(){
        model.getDataGiaiTich2();
    }

    public void getDataVatLy1(){
        model.getDataVatLy1();
    }

    public void getDataVatLy2(){
        model.getDataVatLy2();
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
