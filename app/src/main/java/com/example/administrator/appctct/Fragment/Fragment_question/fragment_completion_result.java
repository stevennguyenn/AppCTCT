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

import com.example.administrator.appctct.R;

public class fragment_completion_result extends Fragment {

    private ImageView imgBell;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completion_result,container,false);
        imgBell = view.findViewById(R.id.imgBell);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Animation anim = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_bell);
        imgBell.setAnimation(anim);
    }
}
