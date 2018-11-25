package com.example.administrator.appctct.Model.ModelController;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelSeeAllListGiaiTich1 {

    private DataClient client = APIUtils.getData();
    private ModelSeeAllListGiaiTich1Listened listened;

    public ModelSeeAllListGiaiTich1(ModelSeeAllListGiaiTich1Listened listened){
        this.listened = listened;
    }

    public void getData(){
        Call<ArrayList<FullBook>> call = client.getAllGiaiTich1();
        call.enqueue(new Callback<ArrayList<FullBook>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<FullBook>> call,@NonNull Response<ArrayList<FullBook>> response) {
                if (response.body() != null){
                    listened.getAllSuccessed(response.body());
                    return;
                }
                listened.getAllFailed();
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<FullBook>> call,@NonNull Throwable t) {
                listened.connectFailed();
            }
        });
    }
}
