package com.example.administrator.appctct.Model.ModelMain;

import com.example.administrator.appctct.Entity.BookDetail.BookDetail;

public interface ModelGetBookDetailListened {
    void getBookDetailSuccessed(BookDetail data);
    void getBookNoInformation();
    void connectFailed(String message);
}
