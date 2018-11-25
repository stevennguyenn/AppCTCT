package com.example.administrator.appctct.Presenter.PresenterController;

import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Entity.ContentHeader;

import java.util.ArrayList;

public interface PresenterControllerListened {
    void getDataGiaiTich1Successed(ArrayList<Book> result);
    void noDataInGiaiTich1();
    void connectFailed();
    void getDataGiaiTich2Successed(ArrayList<Book> result);
    void noDataInGiaiTich2();
    void getDataVatLy1Successed(ArrayList<Book> result);
    void noDataInVatLy1();
    void getDataVatLy2Successed(ArrayList<Book> result);
    void noDataInVatLy2();
    void getHeader(ContentHeader header);
    void noHeader();
}
