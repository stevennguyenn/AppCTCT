package com.example.administrator.appctct.View.Profile;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.appctct.Adapter.AdapterViewPager.AdapterViewPager;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Component.Custom.WrapContentHeightViewPager;
import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.Entity.InformationProfile;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationProfile;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationProfileListened;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.Fragment.FragmentProfile.fragment_load_data;
import com.example.administrator.appctct.Fragment.FragmentProfile.Fragment_test_tested;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileIndividual extends AppCompatActivity implements PresenterGetInformationProfileListened {
    TabLayout tabLayout;
    WrapContentHeightViewPager viewPager;
    PresenterGetInformationProfile presenter;
    CircleImageView imgAVT;
    ConstraintLayout viewImg;
    TextView tvTitleName,tvTitleDetail,tvTitleEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_individual);
        setID();
        setupView();
    }

    private void setID(){
        tvTitleName = findViewById(R.id.tvTitleName);
        tvTitleDetail = findViewById(R.id.tvTitleDetail);
        tvTitleEmail = findViewById(R.id.tvTitleEmail);
        viewImg = findViewById(R.id.imgAvt);
        imgAVT = viewImg.findViewById(R.id.imgAvtCircle);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);

        presenter = new PresenterGetInformationProfile(this);
    }

    private void setupView(){
        presenter.process(getToken());
        ArrayList<Fragment> listFragment = new ArrayList<>();
        fragment_load_data fragment1 = fragment_load_data.newInstance();
        Fragment_test_tested fragment2 = Fragment_test_tested.newInstance();
        listFragment.add(fragment1);
        listFragment.add(fragment2);
        ArrayList<String> listTitle = new ArrayList<>();
        listTitle.add("Status");
        listTitle.add("Tested");
        AdapterViewPager adapter = new AdapterViewPager(getSupportFragmentManager());
        adapter.setData(listFragment,listTitle);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void getInformationProfileSuccessed(InformationProfile data){
        setData(data);
    }

    @Override
    public void informationIndividualNull() {

    }

    @Override
    public void connectFailed(String message) {

    }

    private String getToken(){
        return getSharedPreferences(Strings.data,MODE_PRIVATE).getString(Strings.token,"");
    }

    private void setData(InformationProfile profile){
        Glide.with(this).load(profile.getAvatar()).into(imgAVT);
        tvTitleName.setText(String.valueOf("Name: " + profile.getFullname()));
        if (profile.getLive() != null){
            tvTitleDetail.setText(String.valueOf("Live: "+ profile.getLive()));
        } else {
            tvTitleDetail.setText(String.valueOf("Live: "+ "No Infor"));
        }

        if (profile.getSchool() != null){
            tvTitleEmail.setText(String.valueOf("School: " +profile.getSchool() ));
        } else {
            tvTitleEmail.setText(String.valueOf("School: "+ "No Infor"));
        }
    }
}
