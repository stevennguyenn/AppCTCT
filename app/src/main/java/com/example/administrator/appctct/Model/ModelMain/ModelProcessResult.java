package com.example.administrator.appctct.Model.ModelMain;

import android.os.AsyncTask;
import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ModelQuestion;

import java.util.ArrayList;

public class ModelProcessResult{
    private ModelProcessResultListened listened;

    public ModelProcessResult(ModelProcessResultListened listened){
        this.listened = listened;
    }

    public void process(Object... objects){
        new ProcessArrayList().execute(objects);
    }

    class ProcessArrayList extends AsyncTask<Object,Void,ArrayList<IdAndResult>> {

        @Override
        protected ArrayList<IdAndResult> doInBackground(Object... objects) {
            ArrayList<IdAndResult> listIdandResult = (ArrayList<IdAndResult>) objects[0];
            Integer position = (Integer) objects[1];
            String result = (String) objects[2];
            ArrayList<ModelQuestion> listQuestion = (ArrayList<ModelQuestion>) objects[3];
            if (listIdandResult.size() > 0) {
                for (IdAndResult x : listIdandResult) {
                    if (x.getId().equals(listQuestion.get(position).getId())) {
                        Integer index = listIdandResult.indexOf(x);
                        listIdandResult.get(index).setResult(result);
                        return listIdandResult;
                    }
                }
                listIdandResult.add(new IdAndResult(listQuestion.get(position).getId(), result));
                return listIdandResult;
            }
            listIdandResult.add(new IdAndResult(listQuestion.get(position).getId(), result));
            return listIdandResult;
        }

        @Override
        protected void onPostExecute(ArrayList<IdAndResult> idAndResults) {
            super.onPostExecute(idAndResults);
            listened.getResult(idAndResults);
        }
    }
}



