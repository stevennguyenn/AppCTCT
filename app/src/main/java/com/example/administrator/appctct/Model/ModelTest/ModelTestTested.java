package com.example.administrator.appctct.Model.ModelTest;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Component.Constant.TypeSection;
import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Entity.TestTested;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelTestTested {
    private ModelTestTestedListened listened;
    private DataClient client = APIUtils.getData();

    public ModelTestTested(ModelTestTestedListened listened){
        this.listened = listened;
    }

    public void getTestTested(int typeSection,int id){
        Call<ArrayList<TestTested>> call = null;

        if (typeSection == TypeSection.GT1.rawValue()){
            call = client.getTestTestedGT1(id);
        }
        if (typeSection == TypeSection.GT2.rawValue()){
            call = client.getTestTestedGT2(id);
        }
        if (typeSection == TypeSection.VL1.rawValue()){
            call = client.getTestTestedVL1(id);
        }
        if (typeSection == TypeSection.VL2.rawValue()){
            call = client.getTestTestedVL2(id);
        }

        if (call != null) {
            call.enqueue(new Callback<ArrayList<TestTested>>() {
                @Override
                public void onResponse(@NonNull Call<ArrayList<TestTested>> call, @NonNull Response<ArrayList<TestTested>> response) {
                    if (response.body() != null) {
                        listened.getTestTestedSuccessed(response.body());
                        return;
                    }
                    listened.getTestTestedFailed();
                }

                @Override
                public void onFailure(@NonNull Call<ArrayList<TestTested>> call, @NonNull Throwable t) {
                    listened.connectFailed(t.getMessage());
                }
            });
        }

    }
}
