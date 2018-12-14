package com.example.administrator.appctct.View.Test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.appctct.Adapter.AdapterRanking.AdapterRanking;
import com.example.administrator.appctct.Adapter.AdapterRanking.SeeInformationIndividualListened;
import com.example.administrator.appctct.Entity.PointRank;
import com.example.administrator.appctct.Presenter.PresenterRanking.PresenterRanking;
import com.example.administrator.appctct.Presenter.PresenterRanking.PresenterRankingListened;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.View.Profile.IndividualActivity;

import java.util.ArrayList;

public class SeeTopActivity extends AppCompatActivity implements PresenterRankingListened, SeeInformationIndividualListened {

    private TextView tvNamePoint;
    private RecyclerView rcPointRanking;
    private AdapterRanking adapter;
    private String testCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_top);
        setID();
        setupView();
    }

    private void setID(){
        tvNamePoint = findViewById(R.id.tvNamePoint);
        rcPointRanking = findViewById(R.id.rcPointRanking);
        testCode = getIntent().getStringExtra("test_code");
    }

    private void setupView(){
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcPointRanking.setLayoutManager(manager);
        adapter = new AdapterRanking(getLayoutInflater(),new ArrayList<PointRank>());
        adapter.setListened(this);
        rcPointRanking.setAdapter(adapter);
        PresenterRanking presenter = new PresenterRanking(this);
        presenter.process(testCode);

    }

    @Override
    public void getRankingSuccessed(ArrayList<PointRank> list) {
        adapter.setList(list);
    }

    @Override
    public void getRankingNull() {
        Toast.makeText(SeeTopActivity.this,"null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed(String message) {
        Toast.makeText(SeeTopActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void seeInfor(String id) {
        Intent intent = new Intent(SeeTopActivity.this,IndividualActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
        overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
    }
}
