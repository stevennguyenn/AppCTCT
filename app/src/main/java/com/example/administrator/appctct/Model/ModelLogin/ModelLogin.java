package com.example.administrator.appctct.Model.ModelLogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.appctct.Component.Custom.CountTimer;
import com.example.administrator.appctct.Entity.Student;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;
import com.example.administrator.appctct.View.Login.Login_Activity;
import com.example.administrator.appctct.View.Main.ControllerActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

public class ModelLogin {

    private ModelLoginListened callback;
    private DataClient dataClient = APIUtils.getData();

    public ModelLogin(ModelLoginListened callback){
        this.callback = callback;
    }


    public void login(String account,String password){
        Call<Student> call = dataClient.login(account,password);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(@NonNull Call<Student> call, @NonNull Response<Student> response) {
                CountTimer.cancelTimer();
                if (response.body() != null){
                    callback.loginSuccessed(response.body().getId());
                    return;
                }
                callback.loginFailed();
            }

            @Override
            public void onFailure(@NonNull Call<Student> call,@NonNull Throwable t) {
                callback.connectFailed();
            }
        });
    }
}
