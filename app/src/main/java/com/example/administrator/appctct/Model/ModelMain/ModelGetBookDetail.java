package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetBookDetail {
    private DataClient client = APIUtils.getData();
    private ModelGetBookDetailListened listened;

    public ModelGetBookDetail(ModelGetBookDetailListened listened){
        this.listened = listened;
    }

    public void process(String idBook){
        retrofit2.Call<BookDetail> call = client.getBookDetail(idBook);
        call.enqueue(new Callback<BookDetail>() {
            @Override
            public void onResponse(@NonNull Call<BookDetail> call,@NonNull Response<BookDetail> response) {
                if (response.body() != null){
                    listened.getBookDetailSuccessed(response.body());
                    return;
                }
                listened.getBookNoInformation();
            }

            @Override
            public void onFailure(@NonNull Call<BookDetail> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });

    }
}
