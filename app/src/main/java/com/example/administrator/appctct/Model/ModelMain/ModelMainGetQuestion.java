package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Component.Constant.TypeSection;
import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

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

    public void getQuestion(int typeSection,String testCode){
        Call<ArrayList<ModelQuestion>> call = null;

        if (typeSection == TypeSection.GT1.rawValue()){
            call = client.getQuestionGT1(testCode);
        }
        if (typeSection == TypeSection.GT2.rawValue()){
            call = client.getQuestionGT2();
        }
        if (typeSection == TypeSection.VL1.rawValue()){
            call = client.getQuestionVL1();
        }
        if (typeSection == TypeSection.VL2.rawValue()){
            call = client.getQuestionVL2();
        }

        if (call != null) {
            call.enqueue(new Callback<ArrayList<ModelQuestion>>() {
                @Override
                public void onResponse(@NonNull Call<ArrayList<ModelQuestion>> call, @NonNull Response<ArrayList<ModelQuestion>> response) {
                    if (response.body() != null) {
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
}
