package com.example.administrator.appctct.Model.ModelProfile;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.Profile.Respone;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetStatusUser {
    private DataClient client = APIUtils.getData();
    private ModelGetStatusUserListened listened;

    public ModelGetStatusUser(ModelGetStatusUserListened listened){
        this.listened = listened;
    }

    public void process(String id){
        Call<Respone> call = client.getStatusUser(id);
        call.enqueue(new Callback<Respone>() {
            @Override
            public void onResponse(@NonNull Call<Respone> call,@NonNull Response<Respone> response) {
                if (response.body() != null){
                    if (response.body().getMessage().equals("Successed")){
                        if (response.body().getListStatus().size() > 0){
                            listened.getStatusSuccessed(response.body().getListStatus());
                            return;
                        }
                        listened.getStatusNull();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Respone> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
