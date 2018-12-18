package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.BookDetail.BookDetail;

public interface PresenterGetBookDetailListened {
    void getBookDetailSuccessed(BookDetail data);
    void getBookNoInformation();
    void connectFailed(String message);
}
