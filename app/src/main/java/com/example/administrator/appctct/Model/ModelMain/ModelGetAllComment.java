package com.example.administrator.appctct.Model.ModelMain;

import android.support.annotation.NonNull;
import android.telecom.Call;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.RateBook.CommentSeeAll;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetAllComment {
    private DataClient client = APIUtils.getData();
    private ModelGetAllCommentListened listened;

    public  ModelGetAllComment(ModelGetAllCommentListened listened){
        this.listened = listened;
    }

    public void process(int page,String idBook){
        retrofit2.Call<CommentSeeAll> call = client.getAllComment(page,idBook);
        call.enqueue(new Callback<CommentSeeAll>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<CommentSeeAll> call,@NonNull Response<CommentSeeAll> response) {
                if (response.body()!= null){
                    if (response.body().getMessage().equals(Strings.successed)){
                        listened.getCommentSuccessed(response.body());
                        return;
                    }
                    if (response.body().getMessage().equals(Strings.nodata)){
                        listened.nomoreComment();
                        return;
                    }
                    listened.connectFailed(Strings.nodata);
                }
            }

            @Override
            public void onFailure(@NonNull retrofit2.Call<CommentSeeAll> call,@NonNull Throwable t) {

            }
        });
    }
}
