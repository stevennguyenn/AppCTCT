package com.example.administrator.appctct.Model;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Interfaces.ChangePassword.ModelNotifyPresenter;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelChangPassword {
    private ModelNotifyPresenter listened;

    public void setListened(ModelNotifyPresenter listened){
        this.listened = listened;
    }

    public void process(String currentPass,String newPass,String confirmPass){
        if (currentPass.equals("")){
            listened.currentPassEmpty();
            return;
        }
        if (newPass.equals("")){
            listened.newPassEmpty();
            return;
        }
        if (confirmPass.equals("")){
            listened.confirmPassEmpty();
            return;
        }
        if(!newPass.equals(confirmPass)){
            listened.newDiffenceConfirm();
            return;
        }
        DataClient client = APIUtils.getData();
        Call<String> call = client.changePassword("28",currentPass,newPass);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull  Call<String> call,@NonNull Response<String> response) {
                if (response.body() != null){
                    if (response.body().equals("Successed")){
                        listened.successed();
                    }
                }
            }
            @Override
            public void onFailure(@NonNull  Call<String> call,@NonNull Throwable t) {

            }
        });
    }
}
