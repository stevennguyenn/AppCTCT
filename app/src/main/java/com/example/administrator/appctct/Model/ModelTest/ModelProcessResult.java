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
                            Collections.sort(listIdAndResult, new Comparator<IdAndResult>() {
                                @Override
                                public int compare(IdAndResult o1, IdAndResult o2) {
                                    return o1.getPosition()<o2.getPosition()?1:0;
                                }
                            });
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
                    Collections.sort(listIdAndResult, new Comparator<IdAndResult>() {
                        @Override
                        public int compare(IdAndResult o1, IdAndResult o2) {
                            return o1.getPosition()<o2.getPosition()?1:0;
                        }
                    });
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

                Collections.sort(listIdAndResult, new Comparator<IdAndResult>() {
                    @Override
                    public int compare(IdAndResult o1, IdAndResult o2) {
                        return o1.getPosition()<o2.getPosition()?1:0;
                    }
                });
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



