package com.example.administrator.appctct.Model.ModelController;

import com.example.administrator.appctct.Entity.FullBook;

import java.util.ArrayList;

public interface ModelSeeAllListGiaiTich1Listened {
    void getAllSuccessed(ArrayList<FullBook> listBook);
    void getAllFailed();
    void connectFailed();
}
