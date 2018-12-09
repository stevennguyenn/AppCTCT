package com.example.administrator.appctct.View.Test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.appctct.Adapter.AdapterRanking.AdapterRanking;
import com.example.administrator.appctct.Entity.PointRank;
import com.example.administrator.appctct.Presenter.PresenterRanking.PresenterRanking;
import com.example.administrator.appctct.Presenter.PresenterRanking.PresenterRankingListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SeeTopActivity extends AppCompatActivity implements PresenterRankingListened {

    private TextView tvNamePoint;
    private RecyclerView rcPointRanking;
    private AdapterRanking adapter;

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
    }

    private void setupView(){
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcPointRanking.setLayoutManager(manager);
        adapter = new AdapterRanking(getLayoutInflater(),new ArrayList<PointRank>());
        rcPointRanking.setAdapter(adapter);
        PresenterRanking presenter = new PresenterRanking(this);
        presenter.process("GT1_1001");

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
}
