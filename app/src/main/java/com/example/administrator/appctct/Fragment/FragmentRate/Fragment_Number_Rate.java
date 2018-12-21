package com.example.administrator.appctct.Fragment.FragmentRate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.appctct.R;

public class Fragment_Number_Rate extends Fragment implements View.OnClickListener {
    ConstraintLayout bgViewRate;
    TextView tvNumberStart;
    ImageView imgStart;
    private Boolean isClick = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_number_rate,container,false);
        bgViewRate = view.findViewById(R.id.viewChildren);
        tvNumberStart = view.findViewById(R.id.tvStartRate);
        imgStart = view.findViewById(R.id.imgStartRate);
        return view;
    }

    public void enableView(){
        if (getActivity() != null) {
            tvNumberStart.setTextColor(getActivity().getResources().getColor(R.color.black));
            imgStart.setImageResource(R.drawable.ic_start_enable);
            bgViewRate.setOnClickListener(this);
        }
    }

    public void setTitle(String text){
        tvNumberStart.setText(text);
    }

    void click(){
        if (getActivity() != null){
            bgViewRate.setBackground(getActivity().getResources().getDrawable(R.drawable.background_corner_overorange));
            imgStart.setImageResource(R.drawable.ic_start_enable_choice);
            tvNumberStart.setTextColor(getActivity().getResources().getColor(R.color.colorOrange));
        }
    }

    void dontClick(){
        if (getActivity() != null){
            bgViewRate.setBackground(getActivity().getResources().getDrawable(R.drawable.background_corner_blackoveroverlay));
            imgStart.setImageResource(R.drawable.ic_start_enable);
            tvNumberStart.setTextColor(getActivity().getResources().getColor(R.color.black));
        }
    }

    @Override
    public void onClick(View v) {
        if (!isClick){
            click();
            isClick = true;
            return;
        }
        dontClick();
        isClick = false;
    }
}
