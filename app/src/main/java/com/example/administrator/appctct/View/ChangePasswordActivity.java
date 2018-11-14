package com.example.administrator.appctct;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.appctct.Fragment.ChangPassword.fragment_edittext_changepassword;

public class ChangePasswordActivity extends AppCompatActivity {
    fragment_edittext_changepassword fragmentCurrentPassword,fragmentNewPassword,fragmentConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        fragmentCurrentPassword = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragmentcurrentpassword);
        fragmentCurrentPassword.setDataFagment("Current Passowrd","Current Password");
        fragmentCurrentPassword.showPass(true);
    }
}
