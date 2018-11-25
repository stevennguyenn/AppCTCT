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

    public void setListened(ModelSearchListened listened){
        this.listened = listened;
    }
    public void searchForKey(String key){
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
}
