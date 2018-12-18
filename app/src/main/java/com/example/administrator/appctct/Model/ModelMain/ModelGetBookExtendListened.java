package com.example.administrator.appctct.Model.ModelMain;
import com.example.administrator.appctct.Entity.BookDetail.BookExtened;

public interface ModelGetBookExtendListened {
    void getBookExtendSuccessed(BookExtened data);
    void connectFailed(String message);
}
