package com.example.administrator.appctct.View.Setting;
import com.example.administrator.appctct.Fragment.EditText.FragmentButton.fragment_button;
import com.example.administrator.appctct.Fragment.EditText.FragmentButton.register;
import com.example.administrator.appctct.Fragment.EditText.fragment_edittext_changepassword;
import com.example.administrator.appctct.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class UpdatePhoneNumberActivity extends AppCompatActivity implements View.OnClickListener,register {

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
        fragNewPhoneNumber.setDataFagment("New Phone Number","New Phone Number");
        fragCurrentPhoneNumber.setDataFagment("Current Phone Number","Current Phone Number");
        codePhoneNumber.setDataFagment("Code Verigication","Code Verification");
        fragConfirm.setTitleButton("Confirm");
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
    public void processRegister() {

    }
}
