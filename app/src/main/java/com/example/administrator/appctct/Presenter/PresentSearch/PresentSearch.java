package com.example.administrator.appctct.Presenter.PresentSearch;

import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Model.ModelSearch.ModelSearch;
import com.example.administrator.appctct.Model.ModelSearch.ModelSearchListened;

import java.util.ArrayList;

public class PresentSearch implements ModelSearchListened {

    private PresenterSearchListened listened;

    public void setListened(PresenterSearchListened listened){
        this.listened = listened;
    }

    public void searchForKey(String key){
        ModelSearch model = new ModelSearch();
        model.setListened(this);
        model.searchForKey(key);
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
