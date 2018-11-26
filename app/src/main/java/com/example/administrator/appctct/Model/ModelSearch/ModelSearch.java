package com.example.administrator.appctct.Model.ModelSearch;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class ModelSearch {

    private ModelSearchListened listened;
    private DataClient client = APIUtils.getData();

    public ModelSearch(ModelSearchListened listened){
        this.listened = listened;
    }

    public void searchForKeyGiaiTich1(String key){
        retrofit2.Call<ArrayList<Book>> call = client.searchGiaiTich1(key);
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<ArrayList<Book>> call, @NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listened.successed(response.body());
                    return;
                }
                listened.failed();
            }

            @Override
            public void onFailure(@NonNull  retrofit2.Call<ArrayList<Book>> call,@NonNull Throwable t) {
                listened.connectFailed();
            }
        });
    }

    public void searchForKeyGiaiTich2(String key){
        retrofit2.Call<ArrayList<Book>> call = client.searchGiaiTich2(key);
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<ArrayList<Book>> call, @NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listened.successed(response.body());
                    return;
                }
                listened.failed();
            }

            @Override
            public void onFailure(@NonNull  retrofit2.Call<ArrayList<Book>> call,@NonNull Throwable t) {
                listened.connectFailed();
            }
        });
    }

    public void searchForKeyVatLy1(String key){
        retrofit2.Call<ArrayList<Book>> call = client.searchVatLy1(key);
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<ArrayList<Book>> call, @NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listened.successed(response.body());
                    return;
                }
                listened.failed();
            }

            @Override
            public void onFailure(@NonNull  retrofit2.Call<ArrayList<Book>> call,@NonNull Throwable t) {
                listened.connectFailed();
            }
        });
    }

    public void searchForKeyVatLy2(String key){
        retrofit2.Call<ArrayList<Book>> call = client.searchVatLy2(key);
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<ArrayList<Book>> call, @NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listened.successed(response.body());
                    return;
                }
                listened.failed();
            }

            @Override
            public void onFailure(@NonNull  retrofit2.Call<ArrayList<Book>> call,@NonNull Throwable t) {
                listened.connectFailed();
            }
        });
    }
}
