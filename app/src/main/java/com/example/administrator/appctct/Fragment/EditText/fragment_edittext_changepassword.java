package com.example.administrator.appctct.Fragment.EditText;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.appctct.R;

public class fragment_edittext_changepassword extends Fragment implements TextWatcher {
    private TextView tvTitle;
    private EditText editText;
    private TextWatcherListened listened;

    public void setListened(TextWatcherListened listened) {
        this.listened = listened;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edittext_changepassword,container,false);
        tvTitle = view.findViewById(R.id.tvTitle);
        editText = view.findViewById(R.id.edText);
        editText.addTextChangedListener(this);
        return view;
    }

    public void setDataFagment(String title){
        tvTitle.setText(title);
        editText.setHint(title);
    }

    public void showPass(Boolean isShow) {
        if (!isShow) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            return;
        }
        editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }

//    public void noPermission(){
//        editText.setEnabled(false);
//        editText.setBackgroundColor(getResources().getColor(R.color.black_overlay));
//        tvTitle.setEnabled(false);
//    }

    public void setError(){
        editText.setError(getResources().getString(R.string.empty));
    }

    public String getText(){
        return editText.getText().toString();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        listened.textWatcher(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
