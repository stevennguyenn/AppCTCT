package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.TitleSection;

import java.util.ArrayList;

public interface PresenterSectionOfflineListened {
    void getTitleSectionSuccessed(ArrayList<TitleSection> listSection);
    void getTitleSectionFailed();
    void connectFailed(String message);
}
