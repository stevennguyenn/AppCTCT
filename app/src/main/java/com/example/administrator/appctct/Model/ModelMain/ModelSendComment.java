package com.example.administrator.appctct.Model.ModelMain;


import android.support.annotation.NonNull;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelSendComment {
    private DataClient client = APIUtils.getData();
    private ModelSendCommentListened listened;

    public ModelSendComment(ModelSendCommentListened listened){
        this.listened = listened;
    }

    public void process(String idUser,String idBook,String contentcomment,Float ratio){
        retrofit2.Call<String> call = client.sendComment(idUser,idBook,contentcomment,ratio);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call,@NonNull Response<String> response) {
                if (response.body() != null){
                    if (response.body().equals(Strings.successed)){
                        listened.successed();
                        return;
                    }
                    listened.failed();
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call,@NonNull Throwable t) {

            }
        });

    }
}
