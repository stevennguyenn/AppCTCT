package com.example.administrator.appctct.Model.ModelMain;

import com.example.administrator.appctct.Entity.FullBook;

import java.util.ArrayList;

public interface ModelSeeAllListened {
    void getAllSuccessed(ArrayList<FullBook> listBook);
    void loadmoreFaield();
    void connectFailed(String message);
}
