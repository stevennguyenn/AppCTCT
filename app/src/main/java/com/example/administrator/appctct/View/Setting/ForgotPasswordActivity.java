package com.example.administrator.appctct.View.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.appctct.Fragment.EditText.fragment_edittext_changepassword;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.Fragment.FragmentButton.register;
import com.example.administrator.appctct.R;

public class ForgotPasswordActivity extends AppCompatActivity implements register {

    fragment_edittext_changepassword fragmentPhoneEmail;
    fragment_button fragmentConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        setID();
        setupView();
    }

    private void setID(){
        fragmentPhoneEmail = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragmentPhoneEmail);
        fragmentConfirm = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.fragmentConfirm);
    }
    private void setupView(){
        Boolean isPhone = getIntent().getBooleanExtra("isPhone",false);
        if (isPhone){
            fragmentPhoneEmail.setDataFagment("Phone Number","Phone Number");
        } else {
            fragmentPhoneEmail.setDataFagment("Email","Email");
        }
        fragmentConfirm.setRegister(this);
        fragmentConfirm.setTitleButton(getResources().getString(R.string.confirm));
    }

    @Override
    public void processRegister() {

    }
}
