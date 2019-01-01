package com.example.administrator.appctct.Model.ModelProfile;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelUserFollows {
    private DataClient client = APIUtils.getData();
    private ModelUserFollowsListened listened;

    public ModelUserFollows(ModelUserFollowsListened listened){
        this.listened = listened;
    }

    public void process(int idUser,String idUserFollows){
        Call<String> call = client.userFollows(idUser,idUserFollows);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call,@NonNull Response<String> response) {
                if (response.body()!= null){
                    if (response.body().equals(Strings.successed)){
                        listened.userFollowsSuccessed();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}