package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

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
        retrofit2.Call<ArrayList<BookComment>> call = client.getCommentBook(idBook);
        call.enqueue(new Callback<ArrayList<BookComment>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<BookComment>> call, @NonNull Response<ArrayList<BookComment>> response) {
                if (response.body() != null){
                    listened.getBookCommentSuccessed(response.body());
                    return;
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<BookComment>> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
