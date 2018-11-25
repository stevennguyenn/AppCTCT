package com.example.administrator.appctct.Presenter.PresenterController;

import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Entity.ContentHeader;
import com.example.administrator.appctct.Model.ModelController.ModelController;
import com.example.administrator.appctct.Model.ModelController.ModelControllerListened;

import java.util.ArrayList;

public class PresenterController implements ModelControllerListened {

    private ModelController model = new ModelController(this);
    private PresenterControllerListened listened;

    public PresenterController(PresenterControllerListened listened){
        this.listened = listened;
    }

    public void getDataGiaiTich1(){
        model.getDataGiaiTich1();
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

    public void getHeader(String token){
        model.getHeader(token);
    }

    @Override
    public void getDataGiaiTich1Successed(ArrayList<Book> result) {
        listened.getDataGiaiTich1Successed(result);
    }

    @Override
    public void noDataInGiaiTich1() {
        listened.noDataInGiaiTich1();
    }

    @Override
    public void connectFailed() {
        listened.connectFailed();
    }

    @Override
    public void getDataGiaiTich2Successed(ArrayList<Book> result) {
        listened.getDataGiaiTich2Successed(result);
    }

    @Override
    public void noDataInGiaiTich2() {
        listened.noDataInGiaiTich2();
    }

    @Override
    public void getDataVatLy1Successed(ArrayList<Book> result) {
        listened.getDataVatLy1Successed(result);
    }

    @Override
    public void noDataInVatLy1() {
        listened.noDataInVatLy1();
    }

    @Override
    public void getDataVatLy2Successed(ArrayList<Book> result) {
        listened.getDataVatLy2Successed(result);
    }

    @Override
    public void noDataInVatLy2() {
        listened.noDataInVatLy2();
    }

    @Override
    public void getHeader(ContentHeader header) {
        listened.getHeader(header);
    }

    @Override
    public void noHeader() {
        listened.noHeader();
    }
}
