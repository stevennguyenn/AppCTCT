package com.example.administrator.appctct.Presenter.PresenterSearch;

import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Model.ModelSearch.ModelSearch;
import com.example.administrator.appctct.Model.ModelSearch.ModelSearchListened;

import java.util.ArrayList;

public class PresenterSearch implements ModelSearchListened {

    private PresenterSearchListened listened;
    private ModelSearch model = new ModelSearch(this);

    public void setListened(PresenterSearchListened listened){
        this.listened = listened;
    }

    public void searchForKeyGiaiTich1(String key){
        model.searchForKeyGiaiTich1(key);
    }

    public void searchForKeyGiaiTich2(String key){
        model.searchForKeyGiaiTich2(key);
    }

    public void searchForKeyVatLy1(String key){
        model.searchForKeyVatLy1(key);
    }

    public void searchForKeyVatLy2(String key){
        model.searchForKeyVatLy2(key);
    }

    @Override
    public void successed(ArrayList<Book> result) {
        listened.successed(result);
    }

    @Override
    public void failed() {
        listened.failed();
    }

    @Override
    public void connectFailed() {
        listened.connectFailed();
    }
}
