package com.example.administrator.appctct.Presenter.PresenterMain;


import com.example.administrator.appctct.Entity.BookDetail.BookExtened;
import com.example.administrator.appctct.Model.ModelMain.ModelGetBookExtend;
import com.example.administrator.appctct.Model.ModelMain.ModelGetBookExtendListened;

public class PresenterGetBookExtened implements ModelGetBookExtendListened {

    private ModelGetBookExtend model = new ModelGetBookExtend(this);
    private PresenterGetBookExtendListened listened;

    public PresenterGetBookExtened(PresenterGetBookExtendListened listened){
        this.listened = listened;
    }

    public void process(String keyword){
        model.process(keyword);
    }


    @Override
    public void getBookExtendSuccessed(BookExtened data) {
        listened.getBookExtendSuccessed(data);
    }


    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
