package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelSeeAll {

    private DataClient client = APIUtils.getData();
    private ModelSeeAllListened listened;

    public ModelSeeAll(ModelSeeAllListened listened){
        this.listened = listened;
    }

    public void getData(int page){
        Call<ArrayList<FullBook>> call = client.getAllGiaiTich1(page);
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
                listened.connectFailed(t.getMessage());
            }
        });
    }

    public void getDataGiaiTich2(int page){
        Call<ArrayList<FullBook>> call = client.getAllGiaiTich2(page);
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
                listened.connectFailed(t.getMessage());
            }
        });
    }

    public void getDataVatLy1(int page){
        Call<ArrayList<FullBook>> call = client.getAllVatLy1(page);
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
                listened.connectFailed(t.getMessage());
            }
        });
    }

    public void getDataVatLy2(int page){
        Call<ArrayList<FullBook>> call = client.getAllVatLy2(page);
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
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
