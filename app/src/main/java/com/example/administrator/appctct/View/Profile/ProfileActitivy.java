package com.example.administrator.appctct.View.Profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Component.Custom.ProcessDialog;
import com.example.administrator.appctct.Component.Custom.Shared;
import com.example.administrator.appctct.Entity.Profile;
import com.example.administrator.appctct.Interfaces.Dialog.ProcessCustomDialogClick;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;
import com.example.administrator.appctct.View.CTCT.MemberCTCTActivity;
import com.example.administrator.appctct.View.Setting.ChangePasswordActivity;
import com.example.administrator.appctct.View.Setting.UpdatePhoneNumberActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActitivy extends AppCompatActivity implements View.OnClickListener,ProcessCustomDialogClick{

    TextView tvChangPassword,tvPhoneNumber,tvMemberCTCT,textFullNameProfile,textPhoneNumber;
    ImageView imgAvatarProfile;

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
        tvChangPassword.setOnClickListener(this);
        tvPhoneNumber.setOnClickListener(this);
        tvMemberCTCT.setOnClickListener(this);
    }



    private void getData(){
        //get token:
        String id = getSharePre();
        DataClient client = APIUtils.getData();
        Call<Profile> call = client.getProfile(id);
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(@NonNull  Call<Profile> call,@NonNull Response<Profile> response) {
                if (response.body() != null){
                    if (response.body().getFullname() != null && response.body().getAvatar() != null) {
                        setProfile(response.body().getFullname(), response.body().getAvatar());
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<Profile> call,@NonNull Throwable t) {

            }
        });

    }

    private void setProfile(String fullname,String avatar){
        textFullNameProfile.setText(fullname);
        Glide.with(this).load(Uri.parse(avatar)).into(imgAvatarProfile);
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
    }

    private void openChangePaswword(){
        Intent intent = new Intent(ProfileActitivy.this,ChangePasswordActivity.class);
        startActivity(intent);
    }

    private String getSharePre(){
        SharedPreferences share = getSharedPreferences(Strings.data,MODE_PRIVATE);
        if (!share.getString("id", "").equals("")){
            return share.getString("id","");
        }
        return "";
    }

    private void setTvPhoneNumber(){
        ProcessDialog dialog = new ProcessDialog();
        dialog.setListenedCustom(this);
        dialog.showDialogInputCode(this);
    }

    @Override
    public void onClickPositive(String code) {
        DataClient client = APIUtils.getData();
        Call<String> call = client.findCode("31",code);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call,@NonNull Response<String> response) {
                if (response.body() != null){
                    ProcessDialog.dismissCustomDialog();
                    if (response.body().equals("successed")){
                        Intent in = new Intent(ProfileActitivy.this,MemberCTCTActivity.class);
                        startActivity(in);
                        return;
                    }
                    Shared.showToast(ProfileActitivy.this,"Code Failed");
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call,@NonNull Throwable t) {

            }
        });
    }
}
