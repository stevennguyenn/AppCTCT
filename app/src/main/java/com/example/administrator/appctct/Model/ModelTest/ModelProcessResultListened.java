package com.example.administrator.appctct.Model.ModelTest;

import com.example.administrator.appctct.Entity.IdAndResult;

import java.util.ArrayList;

public interface ModelProcessResultListened {
    void getResult(ArrayList<IdAndResult> list);
    void removeList(ArrayList<IdAndResult> list);
}
