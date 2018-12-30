package com.example.administrator.appctct.View.Profile.fragment_profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.appctct.R;

public class fragment_load_data extends Fragment {

    public fragment_load_data(){

    }

    public static fragment_load_data newInstance(){
        return new fragment_load_data();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_load_data,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
