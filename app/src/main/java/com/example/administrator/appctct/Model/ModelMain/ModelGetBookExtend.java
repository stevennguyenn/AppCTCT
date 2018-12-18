package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Entity.BookDetail.BookExtened;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetBookExtend {
    private DataClient client = APIUtils.getData();
    private ModelGetBookExtendListened listened;

    public ModelGetBookExtend(ModelGetBookExtendListened listened){
        this.listened = listened;
    }

    public void process(String keyword){
        retrofit2.Call<BookExtened> call = client.getBookExtend(keyword);
        call.enqueue(new Callback<BookExtened>() {
            @Override
            public void onResponse(@NonNull Call<BookExtened> call, @NonNull Response<BookExtened> response) {
                if (response.body() != null){
                    listened.getBookExtendSuccessed(response.body());
                    return;
                }
            }

            @Override
            public void onFailure(@NonNull Call<BookExtened> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
