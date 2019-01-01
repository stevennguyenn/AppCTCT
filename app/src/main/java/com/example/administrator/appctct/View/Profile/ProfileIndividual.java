package com.example.administrator.appctct.View.Profile;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.example.administrator.appctct.Adapter.AdapterViewPager.AdapterViewPager;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Component.Custom.ConstraintLayoutCustom;
import com.example.administrator.appctct.Component.Custom.CustomAnimation;
import com.example.administrator.appctct.Component.Custom.WrapContentHeightViewPager;
import com.example.administrator.appctct.Entity.InformationProfile;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationProfile;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationProfileListened;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterUserUnFollows;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterUserFollows;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterUserFollowsListened;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterUserUnFollowsListened;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.Fragment.FragmentProfile.fragment_load_status;
import com.example.administrator.appctct.Fragment.FragmentProfile.Fragment_test_tested;

import java.util.ArrayList;

public class ProfileIndividual extends AppCompatActivity implements PresenterGetInformationProfileListened, View.OnClickListener,PresenterUserUnFollowsListened,PresenterUserFollowsListened {
    TabLayout tabLayout;
    WrapContentHeightViewPager viewPager;
    PresenterGetInformationProfile presenter;
    ImageView imgAVT;
    AppBarLayout viewToolBar;
    ConstraintLayoutCustom btFollows;
    ConstraintLayout viewImg,viewLikes,viewFollows,view, viewNotificationUnfollow,viewBtUnfollows,viewBtCancel;
    TextView tvTitleName,tvTitleDetail,tvTitleEmail,tvLikesName,tvFollowsName,tvLikesNumber,tvFollowsNumber,tvBtFollows;

    private int idUser= 51;
    private ViewSkeletonScreen skeleton;
    private int follows = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_individual);
        setID();
        setupView();
    }

    private void setID(){
        viewNotificationUnfollow = findViewById(R.id.viewNotificationUnfollow);
        viewToolBar = findViewById(R.id.toolbar);
        btFollows = viewToolBar.findViewById(R.id.btFollows);
        tvBtFollows = btFollows.findViewById(R.id.tvBtFollows);
        viewBtUnfollows = viewNotificationUnfollow.findViewById(R.id.viewUnFollow);
        viewBtCancel = viewNotificationUnfollow.findViewById(R.id.viewCancel);
        viewBtUnfollows.setOnClickListener(this);
        viewBtCancel.setOnClickListener(this);
        view = findViewById(R.id.viewChildParent);
        viewLikes = findViewById(R.id.viewLikes);
        viewFollows = findViewById(R.id.viewFollows);
        tvLikesName = viewLikes.findViewById(R.id.tvName);
        tvLikesNumber = viewLikes.findViewById(R.id.tvNumber);
        tvFollowsName = viewFollows.findViewById(R.id.tvName);
        tvFollowsNumber = viewFollows.findViewById(R.id.tvNumber);
        tvTitleName = findViewById(R.id.tvTitleName);
        tvTitleDetail = findViewById(R.id.tvTitleDetail);
        tvTitleEmail = findViewById(R.id.tvTitleEmail);
        viewImg = findViewById(R.id.imgAvt);
        imgAVT = viewImg.findViewById(R.id.imgAvtCircle);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
        skeleton = Skeleton.bind(view)
                            .angle(0)
                            .load(R.layout.layout_default_item_skeleton)
                            .show();
        btFollows.setOnClickListener(this);
        presenter = new PresenterGetInformationProfile(this);
    }


    private void setupView(){
        viewNotificationUnfollow.setY(300);
        tvLikesName.setText(getResources().getString(R.string.like));
        tvFollowsName.setText(getResources().getString(R.string.follow));
        presenter.process(getToken());
        ArrayList<Fragment> listFragment = new ArrayList<>();
        fragment_load_status fragment1 = fragment_load_status.newInstance(getToken());
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
        if (skeleton != null){
            skeleton.hide();
            skeleton = null;
        }
    }

    @Override
    public void informationIndividualNull() {

    }

    @Override
    public void userUnFollowsSuccessed() {
        follows -= 1;
        tvFollowsNumber.setText(String.valueOf(follows));
    }

    @Override
    public void userFollowsSuccessed() {
        follows += 1;
        tvFollowsNumber.setText(String.valueOf(follows));
    }

    @Override
    public void connectFailed(String message) {

    }

    private void setData(InformationProfile profile){
        Glide.with(this).load(profile.getAvatar())
                .apply(RequestOptions.circleCropTransform())
                .into(imgAVT);
        follows = profile.getLieks();
        tvTitleName.setText(profile.getFullname());
        tvLikesNumber.setText(String.valueOf(profile.getLieks()));
        tvFollowsNumber.setText(String.valueOf(profile.getFollows()));
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btFollows:
                if (btFollows.isEnableView()) {
                    userFollows();
                    disableView();
                    hideNotification();
                    break;
                }
                enableView();
                showNotification();
                break;
            case R.id.viewUnFollow:
                userUnFollows();
                hideNotification();
                break;
            case R.id.viewCancel:
                hideNotification();
                if (btFollows.isEnableView()) {
                    disableView();
                    break;
                }
                enableView();
                break;
            default:
                break;

        }
    }

    void enableView(){
        tvBtFollows.setText(getResources().getString(R.string.follow));
        btFollows.setEnable();
    }
    void disableView(){
        tvBtFollows.setText(getResources().getString(R.string.unfollow));
        btFollows.setDisable();
    }

    void hideNotification(){
        CustomAnimation.hideNotification(viewNotificationUnfollow);
    }

    void showNotification(){
        CustomAnimation.showNotification(viewNotificationUnfollow);
    }

    void userFollows(){
        PresenterUserFollows presenter = new PresenterUserFollows(this);
        presenter.process(idUser,getToken());
    }

    void userUnFollows(){
        PresenterUserUnFollows presenter = new PresenterUserUnFollows(this);
        presenter.process(idUser,getToken());
    }

    private String getToken(){
        return getSharedPreferences(Strings.data,MODE_PRIVATE).getString(Strings.token,"");
    }
}
