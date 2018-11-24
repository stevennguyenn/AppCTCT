package com.example.administrator.appctct.View.Setting;
import com.example.administrator.appctct.Fragment.EditText.fragment_edittext_changepassword;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UpdatePhoneNumberActivity extends AppCompatActivity implements View.OnClickListener,ClickButton {

    fragment_edittext_changepassword fragCurrentPhoneNumber,fragNewPhoneNumber,codePhoneNumber;
    fragment_button fragConfirm;
    TextView tvConfirmCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_phone_number);
        setID();
        setupView();
    }

    private void setupView(){
            fragNewPhoneNumber.setDataFagment(getResources().getString(R.string.newphonenumber));
        fragCurrentPhoneNumber.setDataFagment(getResources().getString(R.string.currentphonenumber));
        codePhoneNumber.setDataFagment(getResources().getString(R.string.codeverification));
        fragConfirm.setTitleButton(getResources().getString(R.string.confirm));
        fragConfirm.setRegister(this);
    }

    private void setID(){
        fragCurrentPhoneNumber = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragCurrentPhoneNumber);
        fragNewPhoneNumber = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.fragNewPhoneNumber);
        codePhoneNumber = (fragment_edittext_changepassword) getSupportFragmentManager().findFragmentById(R.id.codePhoneNumber);
        fragConfirm = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.fragConfirm);
        tvConfirmCode = findViewById(R.id.tvConfirmCode);
        tvConfirmCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvConfirmCode:
                break;
                default:
                    break;
        }
    }


    @Override
    public void clickView(View v) {

    }
}
