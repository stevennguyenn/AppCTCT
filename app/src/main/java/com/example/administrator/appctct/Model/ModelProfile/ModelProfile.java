package com.example.administrator.appctct.Model.ModelProfile;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Component.Custom.ProcessDialog;
import com.example.administrator.appctct.Component.Custom.Shared;
import com.example.administrator.appctct.Entity.Profile;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;
import com.example.administrator.appctct.View.CTCT.MemberCTCTActivity;
import com.example.administrator.appctct.View.Profile.ProfileActitivy;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelProfile {
    private DataClient client = APIUtils.getData();
    private ModelProfileListened listened;

    public ModelProfile(ModelProfileListened listened){
        this.listened = listened;
    }

    public void getInformation(String id){
        Call<Profile> call = client.getProfile(id);
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(@NonNull Call<Profile> call, @NonNull Response<Profile> response) {
                if (response.body() != null){
                    listened.getInformationSuccessed(response.body());
                    return;
                }
                listened.getInformationFailed();
            }
            @Override
            public void onFailure(@NonNull Call<Profile> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }

    public void checkCode(String token,String code){
        Call<String> call = client.findCode(token,code);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call,@NonNull Response<String> response) {
                if (response.body() != null){
                    ProcessDialog.dismissCustomDialog();
                    if (response.body().equals(Strings.successed)){
                        listened.checkCodeSuccessed();
                        return;
                    }
                    listened.checkCodeFailed();
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
