package com.example.administrator.appctct.View.Setting;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.administrator.appctct.Component.Custom.InformationImage;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.Fragment.FragmentButton.Fragment_Button;
import com.example.administrator.appctct.Presenter.PresenterRegister.PresenterRegisterListened;
import com.example.administrator.appctct.Presenter.PresenterRegister.PresenterRegister;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.View.Login.Login_Activity;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class Register_Activity extends AppCompatActivity implements View.OnClickListener, PresenterRegisterListened,ClickButton,TextWatcher, CompoundButton.OnCheckedChangeListener {

    EditText edFullName,edUserName,edPassword,edConfirmPassword;
    Fragment_Button btRegister;
    ImageView imgCamera,imgCollection,imgAvatar;
    Switch swShowPass;
    private PresenterRegister present;
    private int REQUEST_CAMERA = 100;
    private int REQUEST_COLLECTION = 101;
    String realPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        setupID();
        setupView();
    }

    private void setupID(){
        imgCamera = findViewById(R.id.imgCamera);
        imgCollection = findViewById(R.id.imgCollection);
        imgAvatar = findViewById(R.id.imgAvatar);
        edFullName = findViewById(R.id.edFullName);
        edUserName = findViewById(R.id.edUser);
        edPassword = findViewById(R.id.edPassword);
        edConfirmPassword = findViewById(R.id.edConfirmPassword);
        btRegister = (Fragment_Button) getSupportFragmentManager().findFragmentById(R.id.btRegister);
        swShowPass = findViewById(R.id.swShowPass);
    }

    private void setupView(){
        btRegister.setRegister(this);
        btRegister.setTitleButton(getResources().getString(R.string.register));
        present = new PresenterRegister(this);
        imgCamera.setOnClickListener(this);
        imgCollection.setOnClickListener(this);
        edFullName.addTextChangedListener(this);
        edUserName.addTextChangedListener(this);
        edPassword.addTextChangedListener(this);
        edConfirmPassword.addTextChangedListener(this);
        swShowPass.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgCamera:
                requestPermissionCamera();
                break;
            case R.id.imgCollection:
                requestPermissionImageCollection();
                break;
        }
    }

    private void requestPermissionImageCollection(){
        if (ActivityCompat.checkSelfPermission(Register_Activity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Register_Activity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_COLLECTION);
            return;
        }
        collection();
    }

    private void collection(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,REQUEST_COLLECTION);
    }

    private void requestPermissionCamera(){
        if (ActivityCompat.checkSelfPermission(Register_Activity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Register_Activity.this,new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);
            return;
        }
        camera();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CAMERA){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                camera();
            }
            else{
                Toast.makeText(Register_Activity.this,"Permission is denied",Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == REQUEST_COLLECTION){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                collection();
            }
            else{
                Toast.makeText(Register_Activity.this,"Permission is denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CAMERA){
            if (data != null)
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    if (bundle != null) {
                        Bitmap bitmap = (Bitmap) bundle.get("data");
                        imgAvatar.setImageBitmap(bitmap);
                        Uri uri = InformationImage.getImageUri(this,bitmap);
                        realPath = InformationImage.getRealPathFromUri(this,uri);
                    }
                } else {
                    Toast.makeText(Register_Activity.this, "Camera not found", Toast.LENGTH_SHORT).show();
                }
            else {
                Toast.makeText(Register_Activity.this, "Camera not found", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == REQUEST_COLLECTION){
            if (resultCode == RESULT_OK && data != null){
                Uri uri = data.getData();
                realPath = realPath = InformationImage.getRealPathFromUri(this,uri);
                imgAvatar.setImageURI(uri);
            }
            else{
                Toast.makeText(Register_Activity.this,"Camera not found",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void camera(){
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_CAMERA);
    }

    @Override
    public void passwordIncorrect() {
        Toast.makeText(Register_Activity.this,"Please enter password and confirm password",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSuccess(final String fullName, final String userName, final String password, final String baseURL) {
        if (!realPath.equals("")){
            File file = new File(realPath);
            String filePath = file.getAbsolutePath();
            String[] arrFilePath = filePath.split("\\.");
            filePath = arrFilePath[0] + System.currentTimeMillis() +"."+arrFilePath[1];
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("upload_file",filePath,requestBody);
            present.insertAccountIntoDatabase(body,fullName,userName,password);
        }
    }

    @Override
    public void baseURLIsEmpty() {
        Toast.makeText(Register_Activity.this,"Please choice avatar",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadImageFailed() {
        Toast.makeText(Register_Activity.this,"Load Image to Databease failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed() {
        Toast.makeText(Register_Activity.this,"Connect Failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void insertAccountSuccessed() {
        startActivity(new Intent(Register_Activity.this,Login_Activity.class));
        overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);

    }

    @Override
    public void insertAccountFailed() {
        Toast.makeText(Register_Activity.this,"Create account failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickView(View v) {
        switch (v.getId()){
            case R.id.btRegister:
                String fullName = edFullName.getText().toString();
                String userName = edUserName.getText().toString();
                String password = edPassword.getText().toString();
                String confirmPassword = edConfirmPassword.getText().toString();
                present.notifyModelRegister(fullName,userName,password,confirmPassword,realPath);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!edFullName.getText().toString().equals("")&&!edUserName.getText().toString().equals("")&&!edPassword.getText().toString().equals("")&&!edConfirmPassword.getText().toString().equals("")&&!realPath.equals("")){
            btRegister.setButtonVisible();
            return;
        }
        btRegister.setButtonDisable();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!isChecked){
            edPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            edConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            return;
        }
        edPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        edConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }
}
