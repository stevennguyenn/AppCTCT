package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.ResultSeeAll;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

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
        Call<ResultSeeAll> call = client.getAllGiaiTich1(page);
        call.enqueue(new Callback<ResultSeeAll>() {
            @Override
            public void onResponse(@NonNull Call<ResultSeeAll> call,@NonNull Response<ResultSeeAll> response) {
                if (response.body() != null){
                   if (response.body().getData() != null){
                       listened.getAllSuccessed(response.body().getData());
                       return;
                   }
                   if (response.body().getMessage().equals(Strings.failed)){
                       listened.connectFailed(response.body().getMessage());
                       return;
                   }
                   if (response.body().getMessage().equals(Strings.nodata)){
                       listened.loadmoreFaield();
                   }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultSeeAll> call,@NonNull Throwable t) {
            }
        });
    }

    public void getDataGiaiTich2(int page){
        Call<ResultSeeAll> call = client.getAllGiaiTich2(page);
        call.enqueue(new Callback<ResultSeeAll>() {
            @Override
            public void onResponse(@NonNull Call<ResultSeeAll> call,@NonNull Response<ResultSeeAll> response) {
                if (response.body() != null){
                    if (response.body().getData() != null){
                        listened.getAllSuccessed(response.body().getData());
                        return;
                    }
                    if (response.body().getMessage().equals(Strings.failed)){
                        listened.connectFailed(response.body().getMessage());
                        return;
                    }
                    if (response.body().getMessage().equals(Strings.nodata)){
                        listened.loadmoreFaield();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultSeeAll> call,@NonNull Throwable t) {
            }
        });
    }

    public void getDataVatLy1(int page){
        Call<ResultSeeAll> call = client.getAllVatLy1(page);
        call.enqueue(new Callback<ResultSeeAll>() {
            @Override
            public void onResponse(@NonNull Call<ResultSeeAll> call,@NonNull Response<ResultSeeAll> response) {
                if (response.body() != null){
                    if (response.body().getData() != null){
                        listened.getAllSuccessed(response.body().getData());
                        return;
                    }
                    if (response.body().getMessage().equals(Strings.failed)){
                        listened.connectFailed(response.body().getMessage());
                        return;
                    }
                    if (response.body().getMessage().equals(Strings.nodata)){
                        listened.loadmoreFaield();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultSeeAll> call,@NonNull Throwable t) {
            }
        });
    }

    public void getDataVatLy2(int page){
        Call<ResultSeeAll> call = client.getAllVatLy2(page);
        call.enqueue(new Callback<ResultSeeAll>() {
            @Override
            public void onResponse(@NonNull Call<ResultSeeAll> call,@NonNull Response<ResultSeeAll> response) {
                if (response.body() != null){
                    if (response.body().getData() != null){
                        listened.getAllSuccessed(response.body().getData());
                        return;
                    }
                    if (response.body().getMessage().equals(Strings.failed)){
                        listened.connectFailed(response.body().getMessage());
                        return;
                    }
                    if (response.body().getMessage().equals(Strings.nodata)){
                        listened.loadmoreFaield();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultSeeAll> call,@NonNull Throwable t) {
            }
        });
    }
}
