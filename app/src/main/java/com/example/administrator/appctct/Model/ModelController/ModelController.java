package com.example.administrator.appctct.Model.ModelController;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Entity.ContentHeader;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelController {

    private DataClient client = APIUtils.getData();
    private ModelControllerListened listened;

    public ModelController(ModelControllerListened listened){
        this.listened = listened;
    }
    public void getDataGiaiTich1(){
        Call<ArrayList<Book>> call = client.getDataGiaiTich1();
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Book>> call, @NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listened.getDataGiaiTich1Successed(response.body());
                    return;
                }
                listened.noDataInGiaiTich1();
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Book>> call,@NonNull Throwable t) {
                listened.connectFailed();
            }
        });
    }

    public void getDataGiaiTich2(){
        Call<ArrayList<Book>> call = client.getDataGiaiTich2();
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Book>> call, @NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listened.getDataGiaiTich2Successed(response.body());
                    return;
                }
                listened.noDataInGiaiTich2();
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Book>> call,@NonNull Throwable t) {
                listened.connectFailed();
            }
        });

    }
    public void getDataVatLy1(){
        Call<ArrayList<Book>> call = client.getDataVatLy1();
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Book>> call, @NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listened.getDataVatLy1Successed(response.body());
                    return;
                }
                listened.noDataInVatLy1();
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Book>> call,@NonNull Throwable t) {
                listened.connectFailed();
            }
        });
    }

    public void getDataVatLy2(){
        Call<ArrayList<Book>> call = client.getDataVatLy2();
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Book>> call, @NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listened.getDataVatLy2Successed(response.body());
                    return;
                }
                listened.noDataInVatLy2();
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Book>> call,@NonNull Throwable t) {
                listened.connectFailed();
            }
        });
    }

    public void getHeader(String token){
        Call<ContentHeader> call = client.getContentHeader(token);
        call.enqueue(new Callback<ContentHeader>() {
            @Override
            public void onResponse(@NonNull  Call<ContentHeader> call,@NonNull Response<ContentHeader> response) {
                if (response.body() != null){
                   listened.getHeader(response.body());
                   return;
                }
                listened.noHeader();
            }

            @Override
            public void onFailure(@NonNull Call<ContentHeader> call,@NonNull Throwable t) {
                listened.connectFailed();
            }
        });
    }
}
