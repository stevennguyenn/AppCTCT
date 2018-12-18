package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.Model.ModelMain.ModelSeeAll;
import com.example.administrator.appctct.Model.ModelMain.ModelSeeAllListened;

import java.util.ArrayList;

public class PresenterSeeAll implements ModelSeeAllListened {

    private ModelSeeAll model = new ModelSeeAll(this);
    private PresenterSeeAllListened listened;

    public PresenterSeeAll(PresenterSeeAllListened listened){
        this.listened = listened;
    }

    public void getDataGiaiTich1(int page){
        model.getData(page);
    }

    public void getDataGiaiTich2(int page){
        model.getDataGiaiTich2(page);
    }

    public void getDataVatLy1(int page){
        model.getDataVatLy1(page);
    }

    public void getDataVatLy2(int page){
        model.getDataVatLy2(page);
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
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
