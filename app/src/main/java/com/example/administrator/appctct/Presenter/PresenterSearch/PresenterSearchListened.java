package com.example.administrator.appctct.Presenter.PresenterSearch;

import com.example.administrator.appctct.Entity.Book;
import java.util.ArrayList;

public interface PresenterSearchListened {
    void successed(ArrayList<Book> result);
    void failed();
    void connectFailed();
}
