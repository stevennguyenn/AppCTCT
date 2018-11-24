package com.example.administrator.appctct.View.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.appctct.Component.Custom.CheckPhoneEmail;
import com.example.administrator.appctct.Fragment.EditText.TextWatcherListened;
import com.example.administrator.appctct.Fragment.EditText.fragment_edittext_changepassword;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.R;

public class ForgotPasswordActivity extends AppCompatActivity implements ClickButton,TextWatcherListened {

    fragment_edittext_changepassword edPhoneMail;
    fragment_button btConfirm;
    Boolean isPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        setID();
        setupView();
    }

    private void setID(){
        edPhoneMail = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragmentPhoneEmail);
        btConfirm = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.fragmentConfirm);
    }
    private void setupView(){
        isPhone = getIntent().getBooleanExtra("isPhone",false);
        if (isPhone){
            edPhoneMail.setDataFagment(getResources().getString(R.string.phonenumber));
        } else {
            edPhoneMail.setDataFagment(getResources().getString(R.string.email));
        }
        edPhoneMail.setListened(this);
        edPhoneMail.showPass(true);
        btConfirm.setButtonDisable();
        btConfirm.setRegister(this);
        btConfirm.setTitleButton(getResources().getString(R.string.confirm));
    }

    @Override
    public void clickView(View v) {

    }

    @Override
    public void textWatcher(String text) {
        if (isPhone){
            if (CheckPhoneEmail.checkPhone(text)){
                btConfirm.setButtonVisible();
                return;
            }
            btConfirm.setButtonDisable();
            return;
        }
        if (CheckPhoneEmail.checkEmail(text)){
            btConfirm.setButtonVisible();
            return;
        }
        btConfirm.setButtonDisable();
    }
}
