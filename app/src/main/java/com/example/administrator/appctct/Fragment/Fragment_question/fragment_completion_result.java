package com.example.administrator.appctct.Fragment.Fragment_question;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.appctct.Entity.ResultQuestion;
import com.example.administrator.appctct.R;

public class fragment_completion_result extends Fragment implements View.OnClickListener{

    private ImageView imgBell;
    private TextView tvTextPoint,tvTextRate,tvClickSeeTop;
    private RatingBar rbRatioResult;
    private ClickTVSeeTop listened;

    public void setListened(ClickTVSeeTop listened){
        this.listened = listened;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completion_result,container,false);
        imgBell = view.findViewById(R.id.imgBell);
        tvTextPoint = view.findViewById(R.id.tvTextPoint);
        tvTextRate = view.findViewById(R.id.tvTextRate);
        tvClickSeeTop = view.findViewById(R.id.tvClickToSeeTop);
        rbRatioResult = view.findViewById(R.id.rbRatioResult);
        if (getArguments()!= null){
            ResultQuestion data = (ResultQuestion) getArguments().getSerializable("data");
            tvTextPoint.setText(data.getPoint());
            tvTextRate.setText(data.getRate());
            Float ratio = Float.valueOf(data.getRatio());
            rbRatioResult.setRating(ratio);
        }
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvClickSeeTop.setOnClickListener(this);
        Animation anim = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_bell);
        imgBell.setAnimation(anim);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvClickToSeeTop:
                listened.click();
                break;
        }
    }
}
