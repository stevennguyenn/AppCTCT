package com.example.administrator.appctct.Model.ModelTest;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Component.Constant.TypeSection;
import com.example.administrator.appctct.Entity.QuestionTestTested;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetQuestionTestTested {

    private ModelGetQuestionTestTestedListened listened;
    private DataClient client = APIUtils.getData();

    public ModelGetQuestionTestTested(ModelGetQuestionTestTestedListened listened){
        this.listened = listened;
    }

    public void getQuestion(int typeSection,String token,String testCode){
        Call<ArrayList<QuestionTestTested>> call = null;

        if (typeSection == TypeSection.GT1.rawValue()){
            call = client.getQuestionTestTestedGT1(token,testCode);
        }
        if (typeSection == TypeSection.GT2.rawValue()){
            call = client.getQuestionTestTestedGT2(token,testCode);
        }
        if (typeSection == TypeSection.VL1.rawValue()){
            call = client.getQuestionTestTestedVL1(token,testCode);
        }
        if (typeSection == TypeSection.VL2.rawValue()){
            call = client.getQuestionTestTestedVL2(token,testCode);
        }

        if (call != null) {
            call.enqueue(new Callback<ArrayList<QuestionTestTested>>() {
                @Override
                public void onResponse(@NonNull Call<ArrayList<QuestionTestTested>> call, @NonNull Response<ArrayList<QuestionTestTested>> response) {
                    if (response.body() != null) {
                        listened.getQuestionSuccessed(response.body());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ArrayList<QuestionTestTested>> call, @NonNull Throwable t) {
                    listened.connectFailed(t.getMessage());
                }
            });
        }

    }
}
