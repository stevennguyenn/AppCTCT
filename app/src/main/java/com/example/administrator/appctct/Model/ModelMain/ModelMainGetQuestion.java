package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;
import com.example.administrator.appctct.View.Test.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelMainGetQuestion {

    private ModelMainGetQuestionListened listened;
    private DataClient client = APIUtils.getData();

    public ModelMainGetQuestion(ModelMainGetQuestionListened listened){
        this.listened = listened;
    }

    public void getQuestion(){
        Call<ArrayList<ModelQuestion>> call = client.getQuestion();
        call.enqueue(new Callback<ArrayList<ModelQuestion>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<ModelQuestion>> call, @NonNull Response<ArrayList<ModelQuestion>> response) {
                if (response.body() != null) {
                    Log.d("AAAA",response.body().size()+"");
                    listened.getQuestionSuccessed(response.body());
                    return;
                }
                listened.getQuestionFailed();
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ModelQuestion>> call, @NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });

    }
}
