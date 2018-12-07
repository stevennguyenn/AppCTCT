package com.example.administrator.appctct.Model.ModelTest;

import android.os.Handler;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ModelQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ModelProcessResult{
    private ModelProcessResultListened listened;

    public ModelProcessResult(ModelProcessResultListened listened){
        this.listened = listened;
    }

    public void process(final ArrayList<ModelQuestion> listQuestion, final ArrayList<IdAndResult> listIdAndResult, final int position, final String result){
        new Handler().post(new Runnable() {
            @Override
                public void run() {
                    for (IdAndResult x : listIdAndResult) {
                        if (x.getId().equals(listQuestion.get(position).getId())) {
                            Integer index = listIdAndResult.indexOf(x);
                            listIdAndResult.get(index).setResult(result);
                            if (result.equals("a")){
                                listIdAndResult.get(index).setContentResult(listQuestion.get(index).getQuestion_a());
                            }
                            if (result.equals("b")){
                                listIdAndResult.get(index).setContentResult(listQuestion.get(index).getQuestion_b());
                            }
                            if (result.equals("c")){
                                listIdAndResult.get(index).setContentResult(listQuestion.get(index).getQuestion_c());
                            }
                            if (result.equals("c")){
                                listIdAndResult.get(index).setContentResult(listQuestion.get(index).getQuestion_b());
                            }
                            listened.getResult(listIdAndResult);
                            return;
                        }
                    }
            }
        });
    }
    public void processRemove(final ArrayList<IdAndResult> listIdAndResult, final String id){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                for(IdAndResult x: listIdAndResult){
                    if (x.getId().equals(id)){
                        x.setResult("");
                        x.setContentResult("");
                        listened.removeList(listIdAndResult);
                    }
                }
            }
        });
    }
}



