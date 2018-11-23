package com.example.administrator.appctct.Fragment.FragmentButton;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.appctct.R;

public class fragment_button extends Fragment implements View.OnClickListener{
    private Button btButton;
    private ClickButton listened;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button_ctct,container,false);
        btButton = view.findViewById(R.id.btButton);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btButton.setOnClickListener(this);
    }

    public void setRegister(ClickButton listened){
        this.listened = listened;
    }

    public void setTitleButton(String title){
        btButton.setText(title);
    }

    public void setButtonFacebook(){
        btButton.setBackground(getResources().getDrawable(R.drawable.custom_button_facebook));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btButton:
                listened.clickView(getView());
                break;
                default:
                    break;
        }
    }

    public void setButtonDisable(){
        btButton.setEnabled(false);
    }

    public void setButtonVisible(){
        btButton.setEnabled(true);
    }
}


