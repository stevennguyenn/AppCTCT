package com.example.administrator.appctct.View.Test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.example.administrator.appctct.Adapter.AdapterChoiceTest.AdapterTestTested;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.TestTested;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterTestTested;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterTestTestedListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class TestedActivity extends AppCompatActivity implements PresenterTestTestedListened{
    private RecyclerView rcTestTested;
    private PresenterTestTested presenter;
    private RecyclerViewSkeletonScreen skeleton;
    private AdapterTestTested adapter;
    private int typeSection = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tested);
        setID();
        setupView();
    }

    private void setID(){
        rcTestTested = findViewById(R.id.rcTestTested);
        presenter = new PresenterTestTested(this);
        typeSection = getIntent().getIntExtra("type_section",-1);
    }

    private void setupView(){
        presenter.getTestTested(typeSection,Integer.valueOf(getToken()));
        adapter = new AdapterTestTested(getLayoutInflater(),new ArrayList<TestTested>());
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcTestTested.setLayoutManager(manager);
        rcTestTested.setAdapter(adapter);
        skeleton = Skeleton.bind(rcTestTested)
                .adapter(adapter)
                .load(R.layout.layout_default_item_skeleton)
                .count(4)
                .show();

    }

    @Override
    public void getTestTestedSuccessed(ArrayList<TestTested> listResult) {
        adapter.setListTest(listResult);
        if (skeleton != null){
            skeleton.hide();
            skeleton = null;
        }
    }

    @Override
    public void getTestTestedFailed() {
        Toast.makeText(TestedActivity.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed(String message) {
        Toast.makeText(TestedActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    private String getToken(){
        return getSharedPreferences(Strings.data,MODE_PRIVATE).getString(Strings.token,"");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
    }
}
