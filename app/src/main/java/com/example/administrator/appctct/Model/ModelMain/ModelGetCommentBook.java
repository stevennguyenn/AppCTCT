package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.BookDetail.FullBookComment;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetCommentBook {
    private DataClient client = APIUtils.getData();
    private ModelGetCommentBookListened listened;

    public ModelGetCommentBook(ModelGetCommentBookListened listened){
        this.listened = listened;
    }

    public void process(String idBook){
        retrofit2.Call<FullBookComment> call = client.getCommentBook(idBook);
        call.enqueue(new Callback<FullBookComment>() {
            @Override
            public void onResponse(@NonNull Call<FullBookComment> call, @NonNull Response<FullBookComment> response) {
                if (response.body() != null){
                    listened.getBookCommentSuccessed(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<FullBookComment> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
