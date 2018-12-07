package com.example.administrator.appctct.Model.ModelTest;


import android.support.annotation.NonNull;

import com.example.administrator.appctct.Component.Constant.TypeSection;
import com.example.administrator.appctct.Entity.TitleSection;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelSectionOffline  {
    private ModelSectionOfflineListened listened;
    private DataClient client = APIUtils.getData();

    public ModelSectionOffline(ModelSectionOfflineListened listened){
        this.listened = listened;
    }

    public void getData(Integer typeSection,String token){
        Call<ArrayList<TitleSection>> call = null;
        if (typeSection == TypeSection.GT1.rawValue()){
            call = client.getTitleOfflineGT1(token);
        }
        if (typeSection == TypeSection.GT2.rawValue()){
            call = client.getTitleOfflineGT2(token);
        }
        if (typeSection == TypeSection.VL1.rawValue()){
            call = client.getTitleOfflineVL1(token);
        }
        if (typeSection == TypeSection.VL2.rawValue()){
            call = client.getTitleOfflineVL2(token);
        }
        if (call != null){
            call.enqueue(new Callback<ArrayList<TitleSection>>() {
                @Override
                public void onResponse(@NonNull  Call<ArrayList<TitleSection>> call,@NonNull Response<ArrayList<TitleSection>> response) {
                    if (response.body() != null){
                        listened.getTitleSectionSuccessed(response.body());
                        return;
                    }
                    listened.getTitleSectionFailed();
                }

                @Override
                public void onFailure(@NonNull Call<ArrayList<TitleSection>> call,@NonNull Throwable t) {
                    listened.connectFailed(t.getMessage());
                }
            });
        }
    }
}
