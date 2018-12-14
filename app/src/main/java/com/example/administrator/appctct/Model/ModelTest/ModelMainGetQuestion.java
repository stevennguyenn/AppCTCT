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

public class ModelMainGetQuestion {

    private ModelMainGetQuestionListened listened;
    private DataClient client = APIUtils.getData();

    public ModelMainGetQuestion(ModelMainGetQuestionListened listened){
        this.listened = listened;
    }

    public void  getQuestion(int typeSection,String token){
        Call<ModelQuestionOnlineOffline> call = null;

        if (typeSection == TypeSection.GT1.rawValue()){
            call = client.getQuestionGT1(token);
        }
        if (typeSection == TypeSection.GT2.rawValue()){
            call = client.getQuestionGT2(token);
        }
        if (typeSection == TypeSection.VL1.rawValue()){
            call = client.getQuestionVL1(token);
        }
        if (typeSection == TypeSection.VL2.rawValue()){
            call = client.getQuestionVL2(token);
        }

        if (call != null) {
            call.enqueue(new Callback<ModelQuestionOnlineOffline>() {
                @Override
                public void onResponse(@NonNull Call<ModelQuestionOnlineOffline> call, @NonNull Response<ModelQuestionOnlineOffline> response) {
                    if (response.body() != null) {
                        if (response.body().getListQuestion().size() > 0){
                            listened.getQuestionSuccessed(response.body());
                            return;
                        }
                        listened.noQuestion();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ModelQuestionOnlineOffline> call, @NonNull Throwable t) {
                    listened.connectFailed(t.getMessage());
                }
            });
        }

    }
}
