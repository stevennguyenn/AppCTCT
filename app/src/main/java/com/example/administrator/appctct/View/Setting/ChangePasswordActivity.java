package com.example.administrator.appctct.View.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.appctct.Fragment.EditText.TextWatcherListened;
import com.example.administrator.appctct.Fragment.EditText.fragment_edittext_changepassword;
import com.example.administrator.appctct.Fragment.FragmentButton.Fragment_Button;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.Presenter.PresenterChangePassword.PresenterChangePasswordListened;
import com.example.administrator.appctct.Presenter.PresenterChangePassword.PresentChangePassword;
import com.example.administrator.appctct.R;

public class ChangePasswordActivity extends AppCompatActivity implements ClickButton,PresenterChangePasswordListened,TextWatcherListened {
    fragment_edittext_changepassword edCurrentPassword, edNewPassword, edConfirmPassword;
    Fragment_Button btConfirm;
    private PresentChangePassword presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        setID();
        setupView();
    }

    private void setID(){
        edCurrentPassword = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragmentcurrentpassword);
        edNewPassword = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragmentnewpassword);
        edConfirmPassword = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragmentconfirmpassword);
        btConfirm = (Fragment_Button) getSupportFragmentManager().findFragmentById(R.id.fragmentbuttonchangepassword);
        presenter = new PresentChangePassword();
        presenter.setListened(this);
    }

    private void setupView(){
        String currentPass = getResources().getString(R.string.currentpassword);
        String newPass = getResources().getString(R.string.newpassword);
        String confirmPass = getResources().getString(R.string.confirmPassword);
        String confirm = getResources().getString(R.string.confirm);
        edNewPassword.setDataFagment(newPass);
        edConfirmPassword.setDataFagment(confirmPass);
        btConfirm.setTitleButton(confirm);
        btConfirm.setRegister(this);
        edCurrentPassword.setDataFagment(currentPass);
        edCurrentPassword.setListened(this);
        edConfirmPassword.setListened(this);
        edNewPassword.setListened(this);
        edCurrentPassword.showPass(true);
    }

    @Override
    public void currentPassEmpty() {
        edCurrentPassword.setError();
    }

    @Override
    public void newPassEmpty() {
        edNewPassword.setError();
    }

    @Override
    public void confirmPassEmpty() {
        edConfirmPassword.setError();
    }

    @Override
    public void newDiffenceConfirm() {
        Toast.makeText(ChangePasswordActivity.this,"New Password and Confirm Password is diffenced",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successed() {
        Toast.makeText(ChangePasswordActivity.this,"Change password successed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickView(View v) {
        String currentPass = edCurrentPassword.getText();
        String newPass = edNewPassword.getText();
        String confirmPass = edConfirmPassword.getText();
        presenter.noticeModelChangePassword(currentPass,newPass,confirmPass);
    }

    @Override
    public void textWatcher(String text) {
        if (!edCurrentPassword.getText().equals("")&&!edCurrentPassword.getText().equals("")&&!edConfirmPassword.getText().equals("")){
            btConfirm.setButtonVisible();
            return;
        }
        btConfirm.setButtonDisable();
    }
}
