package com.example.administrator.appctct.Model.ModelTest;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Component.Constant.TypeSection;
import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Entity.ModelQuestionOnlineOffline;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetQuestionOffline {
    private ModelGetQuestionOfflineListened listened;
    private DataClient client = APIUtils.getData();

    public ModelGetQuestionOffline(ModelGetQuestionOfflineListened listened){
        this.listened = listened;
    }

    public void  getQuestion(int typeSection,String testCode){
        Call<ArrayList<ModelQuestion>> call = null;

        if (typeSection == TypeSection.GT1.rawValue()){
            call = client.getQuestionOfflineGT1(testCode);
        }
        if (typeSection == TypeSection.GT2.rawValue()){
            call = client.getQuestionOfflineGT2(testCode);
        }
        if (typeSection == TypeSection.VL1.rawValue()){
            call = client.getQuestionOfflineVL1(testCode);
        }
        if (typeSection == TypeSection.VL2.rawValue()){
            call = client.getQuestionOfflineVL2(testCode);
        }

        if (call != null) {
            call.enqueue(new Callback<ArrayList<ModelQuestion>>() {
                @Override
                public void onResponse(@NonNull Call<ArrayList<ModelQuestion>> call, @NonNull Response<ArrayList<ModelQuestion>> response) {
                    if (response.body() != null) {
                        if (response.body().size()>0) {
                            listened.getQuestionOfflineSuccessed(response.body());
                            return;
                        }
                        listened.noQuestion();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ArrayList<ModelQuestion>> call, @NonNull Throwable t) {
                    listened.connectFailed(t.getMessage());
                }
            });
        }

    }
}
