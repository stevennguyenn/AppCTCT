package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Model.ModelMain.ModelGetBookDetail;
import com.example.administrator.appctct.Model.ModelMain.ModelGetBookDetailListened;

public class PresenterGetBookDetail implements ModelGetBookDetailListened {
    private ModelGetBookDetail model = new ModelGetBookDetail(this);
    private PresenterGetBookDetailListened listened;

    public PresenterGetBookDetail(PresenterGetBookDetailListened listened){
        this.listened = listened;
    }

    public void process(String idBook){
        model.process(idBook);
    }

    @Override
    public void getBookDetailSuccessed(BookDetail data) {
        listened.getBookDetailSuccessed(data);
    }

    @Override
    public void getBookNoInformation() {
        listened.getBookNoInformation();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
