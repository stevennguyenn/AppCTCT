package com.example.administrator.appctct.View.Test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.example.administrator.appctct.Adapter.AdapterChoiceTest.AdapterOfflineTest;
import com.example.administrator.appctct.Adapter.AdapterChoiceTest.ClickRecyeOfflineTest;
import com.example.administrator.appctct.Component.Constant.TypeStatus;
import com.example.administrator.appctct.Entity.TitleSection;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterSectionOffline;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterSectionOfflineListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SectionOfflineActivity extends AppCompatActivity implements PresenterSectionOfflineListened, ClickRecyeOfflineTest {

    private RecyclerView rcOfflineTest;
    private Integer typeSection = -1;
    private RecyclerViewSkeletonScreen skeleton;
    AdapterOfflineTest adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_offline);
        setID();
        setupView();
        getData();
    }

    private void setID(){
        rcOfflineTest = findViewById(R.id.rcOfflineTest);
    }

    private void setupView(){
        typeSection = getIntent().getIntExtra("type_section",-1);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcOfflineTest.setLayoutManager(manager);
        rcOfflineTest.setHasFixedSize(true);
        adapter = new AdapterOfflineTest(getLayoutInflater(),new ArrayList<TitleSection>());
        adapter.setListened(this);
        rcOfflineTest.setAdapter(adapter);
        skeleton = Skeleton.bind(rcOfflineTest)
                .adapter(adapter)
                .load(R.layout.layout_skeleton_load_title_offline)
                .count(4)
                .show();
    }

    private void getData(){
        PresenterSectionOffline presenter = new PresenterSectionOffline(this);
        presenter.getData(typeSection);
    }

    @Override
    public void getTitleSectionSuccessed(ArrayList<TitleSection> listSection) {
        adapter.setListSection(listSection);
        if (skeleton != null){
            skeleton.hide();
            skeleton = null;
        }
    }

    @Override
    public void getTitleSectionFailed() {
        Toast.makeText(this,"No Courser",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickItem(String testCode) {
        Intent in = new Intent(SectionOfflineActivity.this,MainActivity.class);
        in.putExtra("type_section",typeSection);
        in.putExtra("status", TypeStatus.Offline.rawVlue());
        in.putExtra("testCode",testCode);
        startActivity(in);
        overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
    }
}
