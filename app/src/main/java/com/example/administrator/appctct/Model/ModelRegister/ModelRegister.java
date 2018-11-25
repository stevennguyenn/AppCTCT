package com.example.administrator.appctct.Model.ModelRegister;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.appctct.R;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;
import com.example.administrator.appctct.View.Login.Login_Activity;
import com.example.administrator.appctct.View.Setting.Register_Activity;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelRegister {

    private ModelRegisterListened callback;
    private DataClient dataClient = APIUtils.getData();

    public ModelRegister(ModelRegisterListened callback){
        this.callback = callback;
    }

    public void processRegister(String fullName,String userName,String password, String confirmPassord,String baseURL){

        if (!password.equals(confirmPassord)){
            callback.passwordIncorrect();
            return;
        }
        if (baseURL.equals("")){
            callback.baseURLIsEmpty();
        }
        callback.registerSuccess(fullName,userName,password,baseURL);
    }

    public void insertAccountIntoDatabase(MultipartBody.Part body, final String fullName, final String userName, final String password){
        retrofit2.Call<String> call = dataClient.uploadImage(body);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.body() != null){
                    retrofit2.Call<String> callInsert = dataClient.insertData(fullName,userName,password,APIUtils.baseURL + "image/" + response.body());
                    callInsert.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(@NonNull retrofit2.Call<String> call,@NonNull Response<String> response) {
                            String result = response.body();
                            if (result != null && result.equals("Successed")){
                                callback.insertAccountSuccessed();
                                return;
                            }
                            callback.insertAccountFailed();
                        }
                        @Override
                        public void onFailure(@NonNull  retrofit2.Call<String> call,@NonNull Throwable t) {
                            callback.connectFailed();
                        }
                    });
                    return;
                }
                callback.loadImageFailed();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.connectFailed();
            }
        });
    }
}
