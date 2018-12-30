package com.example.administrator.appctct.View.Profile;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.appctct.Adapter.AdapterViewPager.AdapterViewPager;
import com.example.administrator.appctct.Component.Custom.WrapContentHeightViewPager;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.View.Profile.fragment_profile.fragment_load_data;
import com.example.administrator.appctct.View.Profile.fragment_profile.fragment_result_tested;
import com.example.administrator.appctct.View.Profile.fragment_profile.height;

import java.util.ArrayList;


public class ProfileIndividual extends AppCompatActivity implements height {
    TabLayout tabLayout;
    WrapContentHeightViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_individual);
        setID();
        setupView();
    }

    private void setID(){
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupView(){
        ArrayList<Fragment> listFragment = new ArrayList<>();
        fragment_load_data fragment1 = fragment_load_data.newInstance(0,"Load");
        fragment_result_tested fragment2 = fragment_result_tested.newInstance(1,"Tested");
        listFragment.add(fragment1);
        listFragment.add(fragment2);
        fragment1.setHeightListented(this);
        fragment2.setHeightListened(this);
        ArrayList<String> listTitle = new ArrayList<>();
        listTitle.add("Status");
        listTitle.add("Tested");
        AdapterViewPager adapter = new AdapterViewPager(getSupportFragmentManager());
        adapter.setData(listFragment,listTitle);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void getHeight(float height) {
        Log.d("AAAAA",height+"");
        viewPager.getLayoutParams().height = (int) height;
        viewPager.requestLayout();
    }
}
