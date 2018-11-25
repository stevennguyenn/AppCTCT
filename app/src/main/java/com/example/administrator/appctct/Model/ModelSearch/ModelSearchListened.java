package com.example.administrator.appctct.Model.ModelSearch;

import com.example.administrator.appctct.Entity.Book;

import java.util.ArrayList;

public interface ModelSearchListened {
    void successed(ArrayList<Book> result);
    void failed();
    void connectFailed();
}
