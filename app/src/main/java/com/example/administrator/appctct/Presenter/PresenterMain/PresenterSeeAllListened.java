package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.FullBook;
import java.util.ArrayList;

public interface PresenterSeeAllListened {
    void getAllSuccessed(ArrayList<FullBook> listBook);
    void getAllFailed();
    void connectFailed(String message);
}