package com.example.administrator.appctct.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.appctct.Component.CustomView.SetupView;
import com.example.administrator.appctct.Entity.Student;
import com.example.administrator.appctct.Interfaces.Login.PresenterNotifyViewLogin;
import com.example.administrator.appctct.Presenter.PresenterLogin;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.Service.Retrofit.APIUtils;
import com.example.administrator.appctct.Service.Retrofit.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener, PresenterNotifyViewLogin {

    EditText edUserName,edPassword;
    Button btLogin;
    TextView tvRegister;
    ProgressBar indicator;

    private PresenterLogin presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        setID();
    }

    private void setID(){
        edUserName = findViewById(R.id.edUser);
        edPassword = findViewById(R.id.edPassword);
        btLogin = findViewById(R.id.btLogin);
        tvRegister = findViewById(R.id.tvRegister);
        indicator = findViewById(R.id.pbIndicator);
        tvRegister.setOnClickListener(this);
        btLogin.setOnClickListener(this);
        presenter = new PresenterLogin(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btLogin:
               String userName = edUserName.getText().toString();
               String password = edPassword.getText().toString();
               presenter.notifyodelProcessLogin(userName,password);
               break;
           case R.id.tvRegister:
               Intent intent = new Intent(Login_Activity.this,Register_Activity.class);
               startActivity(intent);
               break;
       }
    }

    @Override
    public void userIsEmpty() {
        edUserName.setError("User Name is empty");
    }

    @Override
    public void passwordIsEmpty() {
        edPassword.setError("Password is empty");
    }

    @Override
    public void loginSuccess(String account, String password) {
        indicator.setVisibility(View.VISIBLE);
        DataClient dataClient = APIUtils.getData();
        Call<Student> call = dataClient.login(account,password);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(@NonNull Call<Student> call,@NonNull Response<Student> response) {
                if (response.body() != null){
                    Toast.makeText(Login_Activity.this,"Login Success", LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Login_Activity.this,response.message(), LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<Student> call,@NonNull Throwable t) {

            }
        });
    }
}
