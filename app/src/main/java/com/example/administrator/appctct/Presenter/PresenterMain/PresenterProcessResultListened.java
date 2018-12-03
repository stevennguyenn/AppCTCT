package com.example.administrator.appctct.Presenter.PresenterMain;

import com.example.administrator.appctct.Entity.IdAndResult;

import java.util.ArrayList;

public interface PresenterProcessResultListened {
    void getResult(ArrayList<IdAndResult> list);
    void removeList(ArrayList<IdAndResult> list);
}
