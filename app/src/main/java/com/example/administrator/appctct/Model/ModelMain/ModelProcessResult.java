package com.example.administrator.appctct.Model.ModelMain;

import android.os.AsyncTask;
import android.os.Handler;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ModelQuestion;

import java.util.ArrayList;

public class ModelProcessResult{
    private ModelProcessResultListened listened;

    public ModelProcessResult(ModelProcessResultListened listened){
        this.listened = listened;
    }

    public void process(final ArrayList<ModelQuestion> listQuestion, final ArrayList<IdAndResult> listIdAndResult, final int position, final String result){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                if (listIdAndResult.size() > 0) {
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
                    if (result.equals("a")){
                        listIdAndResult.add(new IdAndResult(listQuestion.get(position).getId(), result,listQuestion.get(position).getQuestion_a(),position));
                    }
                    if (result.equals("b")){
                        listIdAndResult.add(new IdAndResult(listQuestion.get(position).getId(), result,listQuestion.get(position).getQuestion_b(),position));
                    }
                    if (result.equals("c")){
                        listIdAndResult.add(new IdAndResult(listQuestion.get(position).getId(), result,listQuestion.get(position).getQuestion_c(),position));
                    }
                    if (result.equals("d")){
                        listIdAndResult.add(new IdAndResult(listQuestion.get(position).getId(), result,listQuestion.get(position).getQuestion_d(),position));
                    }
                    listened.getResult(listIdAndResult);
                    return;
                }
                if (result.equals("a")){
                    listIdAndResult.add(new IdAndResult(listQuestion.get(position).getId(), result,listQuestion.get(position).getQuestion_a(),position));
                }
                if (result.equals("b")){
                    listIdAndResult.add(new IdAndResult(listQuestion.get(position).getId(), result,listQuestion.get(position).getQuestion_b(),position));
                }
                if (result.equals("c")){
                    listIdAndResult.add(new IdAndResult(listQuestion.get(position).getId(), result,listQuestion.get(position).getQuestion_c(),position));
                }
                if (result.equals("d")){
                    listIdAndResult.add(new IdAndResult(listQuestion.get(position).getId(), result,listQuestion.get(position).getQuestion_d(),position));
                }
                listened.getResult(listIdAndResult);
                return;
            }
        });
    }
    public void processRemove(ArrayList<IdAndResult> listIdAndResult,String id){
        int index = -1;
        for(IdAndResult x: listIdAndResult){
            if (x.getId().equals(id)){
                index = listIdAndResult.indexOf(x);
            }
        }
        if (index != -1){
            listIdAndResult.remove(index);
            listened.removeList(listIdAndResult);
        }
    }
}



