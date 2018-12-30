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

    private int mPage = 0;
    private String mTitle = "";
    private height heightListented;

    public void setHeightListented(height heightListented){
        this.heightListented = heightListented;
    }

    public fragment_load_data(){

    }

    public static fragment_load_data newInstance(int page, String title){
        fragment_load_data fragment = new fragment_load_data();
        Bundle args = new Bundle();
        args.putInt("page",page);
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null) {
            mPage = getArguments().getInt("page", 0);
            mTitle = getArguments().getString("title");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_load_data,container,false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
