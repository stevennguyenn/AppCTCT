package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.BookDetail.BookExtened;

public interface PresenterGetBookExtendListened {
    void getBookExtendSuccessed(BookExtened data);
    void connectFailed(String message);
}
