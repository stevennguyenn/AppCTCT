package com.example.administrator.appctct.Model.ModelMain;

import com.example.administrator.appctct.Entity.TitleSection;

import java.util.ArrayList;

public interface ModelSectionOfflineListened {
    void getTitleSectionSuccessed(ArrayList<TitleSection> listSection);
    void getTitleSectionFailed();
    void connectFailed(String message);
}
