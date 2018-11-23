package com.example.administrator.appctct.View.Login;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Component.Custom.CountTimer;
import com.example.administrator.appctct.Entity.Student;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.Interfaces.Login.PresenterNotifyViewLogin;
import com.example.administrator.appctct.Presenter.PresenterLogin;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;
import com.example.administrator.appctct.View.Main.ControllerActivity;
import com.example.administrator.appctct.View.Setting.ForgotPasswordActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener, PresenterNotifyViewLogin,ClickButton,TextWatcher {

    EditText edUserName,edPassword;
    fragment_button btLogin,btLoginFacebook;
    TextView tvRegister,tvForgotPassword;
    Dialog dialog;
    SharedPreferences share;
    ConstraintLayout viewProgress;

    private PresenterLogin presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        setID();
        setupView();
    }

    private void setID(){
        tvRegister = findViewById(R.id.tvRegister);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        edUserName = findViewById(R.id.edUser);
        edPassword = findViewById(R.id.edPassword);
        btLogin = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.btLogin);
        btLoginFacebook = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.btLoginFacebook);
        viewProgress = findViewById(R.id.viewProgress);
    }

    private void setupView(){
        btLogin.setTitleButton(getResources().getString(R.string.login));
        btLoginFacebook.setTitleButton(getResources().getString(R.string.loginFacebook));
        btLoginFacebook.setButtonFacebook();
        tvForgotPassword.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        presenter = new PresenterLogin(this);
        share = getSharedPreferences(Strings.data,MODE_PRIVATE);
        btLogin.setRegister(this);
        edUserName.addTextChangedListener(this);
        edPassword.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.tvRegister:
               Intent intent = new Intent(Login_Activity.this,Register_Activity.class);
               startActivity(intent);
               break;
           case R.id.tvForgotPassword:
               showForgotPassword();
               break;
       }
    }

    private void showForgotPassword(){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_choice_email_phone);

        Button btConfirm = dialog.findViewById(R.id.btConfirm);
        final CheckBox cbEmail = dialog.findViewById(R.id.cbEmail);
        final CheckBox cbPhone = dialog.findViewById(R.id.cbPhone);
        cbEmail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbPhone.setChecked(false);
                    cbEmail.setChecked(true);
                }
            }
        });
        cbPhone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbEmail.setChecked(false);
                    cbPhone.setChecked(true);
                }
            }
        });
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (!cbPhone.isChecked() && !cbEmail.isChecked()){
                    return;
                }
                Intent intent = new Intent(Login_Activity.this,ForgotPasswordActivity.class);
                if (cbPhone.isChecked()){
                    intent.putExtra("isPhone",true);
                } else {
                    intent.putExtra("isPhone", false);
                }
                startActivity(intent);
            }
        });
        dialog.show();
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
        DataClient dataClient = APIUtils.getData();
        Call<Student> call = dataClient.login(account,password);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(@NonNull Call<Student> call,@NonNull Response<Student> response) {
                viewProgress.setVisibility(View.GONE);
                CountTimer.cancelTimer();
                if (response.body() != null){
                    Intent in = new Intent(Login_Activity.this, ControllerActivity.class);
                    startActivity(in);
                    commitShare(response.body().getId());
                    return;
                }
                Toast.makeText(Login_Activity.this,"Login Failed", LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<Student> call,@NonNull Throwable t) {
                Toast.makeText(Login_Activity.this,t.getMessage(), LENGTH_SHORT).show();
            }
        });
    }
    private void commitShare(String id){
        SharedPreferences.Editor editor = share.edit();
        editor.putString("id", id);
        editor.apply();
    }

    @Override
    public void clickView(View v) {
        switch (v.getId()){
            case R.id.btLogin:
                CountTimer.count(this, (long) 10000,"Network Error");
                viewProgress.setVisibility(View.VISIBLE);
                String userName = edUserName.getText().toString();
                String password = edPassword.getText().toString();
                presenter.notifyodelProcessLogin(userName,password);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (!edUserName.getText().toString().equals("") && !edPassword.getText().toString().equals("")){
            btLogin.setButtonVisible();
            return;
        }
        btLogin.setButtonDisable();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

