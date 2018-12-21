package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Entity.RateBook.TitleCommentSeeAll;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetTitleSeeAllComment {
    private DataClient client = APIUtils.getData();
    private ModelGetTitleSeeAllCommentListened listened;

    public ModelGetTitleSeeAllComment(ModelGetTitleSeeAllCommentListened listened){
        this.listened = listened;
    }

    public void process(String idBook){
        retrofit2.Call<TitleCommentSeeAll> call = client.getTitleSeeAllComment(idBook);
        call.enqueue(new Callback<TitleCommentSeeAll>() {
            @Override
            public void onResponse(@NonNull Call<TitleCommentSeeAll> call, @NonNull Response<TitleCommentSeeAll> response) {
                if (response.body() != null){
                    listened.getTitleSeeAllSuccessed(response.body());
                    return;
                }
            }

            @Override
            public void onFailure(@NonNull Call<TitleCommentSeeAll> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });

    }
}
