package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ResultQuestion;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelShowResult {
    private DataClient client = APIUtils.getData();
    private ModelShowResultListened listened;

    public ModelShowResult(ModelShowResultListened listened){
        this.listened = listened;
    }

    public void getResult(final ArrayList<IdAndResult> listResult){
        new android.os.Handler().post(new Runnable() {
            @Override
            public void run() {
                String[] arrid = new String[listResult.size()];
                String[] arrresult = new String[listResult.size()];

                for (int i = 0 ;i<listResult.size();i++){
                    arrid[i] = listResult.get(i).getId();
                    arrresult[i] = listResult.get(i).getResult();
                }

                Call<ResultQuestion> callback = client.getResult("31",arrid,arrresult);
                callback.enqueue(new Callback<ResultQuestion>() {
                    @Override
                    public void onResponse(@NonNull Call<ResultQuestion> call, @NonNull Response<ResultQuestion> response) {
                        if (response.body() != null){
                            listened.getPointSuccessed(response.body());
                            return;
                        }
                        listened.getPointFailed();
                    }

                    @Override
                    public void onFailure(@NonNull  Call<ResultQuestion> call,@NonNull Throwable t) {
                        listened.connectFailed(t.getMessage());
                    }
                });
            }
        });
    }
}
