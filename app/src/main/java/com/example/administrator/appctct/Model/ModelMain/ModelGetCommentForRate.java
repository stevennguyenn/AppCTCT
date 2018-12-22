package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.RateBook.CommentSeeAll;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetCommentForRate {
    private DataClient client = APIUtils.getData();
    private ModelGetCommentForRateListened listened;

    public  ModelGetCommentForRate(ModelGetCommentForRateListened listened){
        this.listened = listened;
    }

    public void process(int rate,String idBook){
        retrofit2.Call<ArrayList<BookComment>> call = client.getBookCommentForRate(rate,idBook);
        call.enqueue(new Callback<ArrayList<BookComment>>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<ArrayList<BookComment>> call, @NonNull Response<ArrayList<BookComment>> response) {
                if (response.body()!= null){
                    if (response.body().size()>0){
                        listened.getCommentForRateSuccessed(response.body());
                        return;
                    }
                    listened.noComment();
                }
            }

            @Override
            public void onFailure(@NonNull retrofit2.Call<ArrayList<BookComment>> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
