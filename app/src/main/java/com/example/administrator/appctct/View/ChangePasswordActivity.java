package com.example.administrator.appctct.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.appctct.Fragment.EditText.FragmentButton.fragment_button;
import com.example.administrator.appctct.Fragment.EditText.FragmentButton.register;
import com.example.administrator.appctct.Fragment.EditText.fragment_edittext_changepassword;
import com.example.administrator.appctct.Interfaces.ChangePassword.PresenterNotifyView;
import com.example.administrator.appctct.Presenter.PresentChangPassword;
import com.example.administrator.appctct.R;

public class ChangePasswordActivity extends AppCompatActivity implements register, PresenterNotifyView {
    fragment_edittext_changepassword fragmentCurrentPassword,fragmentNewPassword,fragmentConfirmPassword;
    fragment_button fragment_button_changpassword;
    private PresentChangPassword presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        setID();
        setupView();
    }

    private void setID(){
        fragmentCurrentPassword = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragmentcurrentpassword);
        fragmentNewPassword = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragmentnewpassword);
        fragmentConfirmPassword = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragmentconfirmpassword);
        fragment_button_changpassword = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.fragmentbuttonchangepassword);
        fragment_button_changpassword.setRegister(this);
        presenter = new PresentChangPassword();
        presenter.setListened(this);
    }

    private void setupView(){
        String currentPass = getResources().getString(R.string.currentpassword);
        String newPass = getResources().getString(R.string.newpassword);
        String confirmPass = getResources().getString(R.string.confirmPassword);
        String confirm = getResources().getString(R.string.confirm);
        fragmentCurrentPassword.setDataFagment(currentPass,currentPass);
        fragmentCurrentPassword.showPass(true);
        fragmentNewPassword.setDataFagment(newPass,newPass);
        fragmentConfirmPassword.setDataFagment(confirmPass, confirmPass);
        fragment_button_changpassword.setTitleButton(confirm);
    }

    @Override
    public void processRegister() {
        String currentPass = fragmentCurrentPassword.getText();
        String newPass = fragmentNewPassword.getText();
        String confirmPass = fragmentConfirmPassword.getText();
        presenter.noticeModelChangePassword(currentPass,newPass,confirmPass);
    }

    @Override
    public void currentPassEmpty() {
        fragmentCurrentPassword.setError();
    }

    @Override
    public void newPassEmpty() {
        fragmentNewPassword.setError();
    }

    @Override
    public void confirmPassEmpty() {
        fragmentConfirmPassword.setError();
    }

    @Override
    public void newDiffenceConfirm() {
        Toast.makeText(ChangePasswordActivity.this,"New Password and Confirm Password is diffenced",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successed() {
        Toast.makeText(ChangePasswordActivity.this,"Change password successed",Toast.LENGTH_SHORT).show();
    }
}
