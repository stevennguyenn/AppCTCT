package com.example.administrator.appctct.Model.ModelTest;

import android.os.Handler;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ModelQuestion;

import java.util.ArrayList;

public class ModelInitList {
    private ModelInitListListened listened;
    public ModelInitList(ModelInitListListened listened){
        this.listened = listened;
    }
    public void process(final ArrayList<ModelQuestion> listQuestion){
        final ArrayList<IdAndResult> listResult = new ArrayList<>();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                for (ModelQuestion item:listQuestion){
                    listResult.add(new IdAndResult(item.getId()));
                }
                listened.processSuccessed(listResult);
            }
        });
    }
}
