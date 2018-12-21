package com.example.administrator.appctct.View.Profile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Component.Custom.ProcessDialog;
import com.example.administrator.appctct.Entity.Profile;
import com.example.administrator.appctct.Component.Custom.ProcessCustomDialogClick;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterProfile;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterProfileListened;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.View.CTCT.MemberCTCTActivity;
import com.example.administrator.appctct.View.Setting.ChangePasswordActivity;
import com.example.administrator.appctct.View.Setting.UpdatePhoneNumberActivity;

public class ProfileActitivy extends AppCompatActivity implements View.OnClickListener,ProcessCustomDialogClick, PresenterProfileListened{

    TextView tvChangPassword,tvPhoneNumber,tvMemberCTCT,textFullNameProfile,textPhoneNumber,tvUpdateEmail;
    ImageView imgAvatarProfile;
    private PresenterProfile presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_actitivy);
        setID();
        getData();
    }

    private void setID(){
        tvChangPassword = findViewById(R.id.tvChangePassword);
        tvPhoneNumber = findViewById(R.id.tvUpdatePhoneNumber);
        tvMemberCTCT = findViewById(R.id.tvMemberCTCT);
        textPhoneNumber = findViewById(R.id.textPhoneNumber);
        textFullNameProfile = findViewById(R.id.textFullNameProfile);
        imgAvatarProfile = findViewById(R.id.imgAvatarProfile);
        tvUpdateEmail = findViewById(R.id.tvUpdateEmail);
        tvChangPassword.setOnClickListener(this);
        tvPhoneNumber.setOnClickListener(this);
        tvMemberCTCT.setOnClickListener(this);
        presenter = new PresenterProfile(this);
    }

    private void getData(){
        //get token:
        String id = getToken();
        presenter.getInformation(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvChangePassword:
                openChangePaswword();
                break;
            case R.id.tvUpdatePhoneNumber:
                openUpdatePhoneNumber();
                break;
            case R.id.tvMemberCTCT:
                setTvPhoneNumber();
                break;
            case R.id.tvUpdateEmail:
                break;
        }
    }

    private void openUpdatePhoneNumber(){
        Intent in = new Intent(ProfileActitivy.this,UpdatePhoneNumberActivity.class);
        Boolean result = true;
        if (textPhoneNumber.getText().toString().equals("")){
            result = false;
        }
        in.putExtra("showcurrent",result);
        startActivity(in);
        overridePendingTransition(R.anim.show_view_present,R.anim.hide_view_present);
    }

    private void openChangePaswword(){
        Intent intent = new Intent(ProfileActitivy.this,ChangePasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.show_view_present,R.anim.hide_view_present);
    }

    private void setTvPhoneNumber(){
        ProcessDialog dialog = new ProcessDialog();
        dialog.setListenedCustom(this);
        dialog.showDialogInputCode(this);
    }

    @Override
    public void onClickPositive(String code) {
        presenter.checkCode(getToken(),code);
    }

    private String getToken(){
        return getSharedPreferences(Strings.data,MODE_PRIVATE).getString(Strings.token,"");
    }

    @Override
    public void getInformationSuccessed(Profile profile) {
        textFullNameProfile.setText(profile.getFullname());
        Glide.with(this).load(Uri.parse(profile.getAvatar())).into(imgAvatarProfile);
    }

    @Override
    public void getInformationFailed() {
        Toast.makeText(ProfileActitivy.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed(String message) {
        Toast.makeText(ProfileActitivy.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void checkCodeSuccessed() {
        ProcessDialog.dismissCustomDialog();
        startActivity(new Intent(ProfileActitivy.this,MemberCTCTActivity.class));
        overridePendingTransition(R.anim.show_view_present,R.anim.hide_view_present);
    }

    @Override
    public void checkCodeFailed() {
        ProcessDialog.dismissCustomDialog();
        Toast.makeText(ProfileActitivy.this,"Code Error",Toast.LENGTH_SHORT).show();
    }
}
