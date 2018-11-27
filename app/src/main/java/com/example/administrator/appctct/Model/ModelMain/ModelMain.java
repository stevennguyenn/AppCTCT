package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;
import com.example.administrator.appctct.View.Test.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelMain {
    private ModelMainListened listened;
    private DataClient client = APIUtils.getData();

    public ModelMain(ModelMainListened listened){
        this.listened = listened;
    }
    public void getResult(final ArrayList<IdAndResult> listResult){
        if (listResult.size() == 0){
            listened.noChoice();
            return;
        }

        String[] arrid = new String[listResult.size()];
        String[] arrresult = new String[listResult.size()];

        for (int i = 0 ;i<listResult.size();i++){
            arrid[i] = listResult.get(i).getId();
            arrresult[i] = listResult.get(i).getResult();
        }

        Call<Integer> callback = client.getResult(arrid,arrresult);
        callback.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(@NonNull Call<Integer> call, @NonNull Response<Integer> response) {
                if (response.body() != null){
                    listened.getPointSuccessed(response.body());
                    return;
                }
                listened.getPointFailed();
            }

            @Override
            public void onFailure(@NonNull  Call<Integer> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
