package com.example.administrator.appctct.Fragment.EditText;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.appctct.R;

public class fragment_edittext_changepassword extends Fragment{
    private TextView tvTitle;
    private EditText editText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edittext_changepassword,container,false);
        tvTitle = view.findViewById(R.id.tvTitle);
        editText = view.findViewById(R.id.edText);
        return view;
    }

    public void setDataFagment(String title, String hintText){
        tvTitle.setText(title);
        editText.setHint(hintText);
    }

    public void showPass(Boolean isShow){
        if (isShow){
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }
//
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
}
