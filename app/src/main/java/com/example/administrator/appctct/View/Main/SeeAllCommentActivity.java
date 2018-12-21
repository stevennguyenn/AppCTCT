package com.example.administrator.appctct.View.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.appctct.Adapter.AdapterSeeAllComment.AdapterSeeAllComment;
import com.example.administrator.appctct.R;

public class SeeAllCommentActivity extends AppCompatActivity {

    private RecyclerView rcSeeAllComment;
    private AdapterSeeAllComment adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_comment);
        setID();
        setupView();
    }
    private void setID(){
        rcSeeAllComment = findViewById(R.id.rcSeeAllComment);
    }

    private void setupView(){
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcSeeAllComment.setLayoutManager(manager);
        adapter = new AdapterSeeAllComment(getLayoutInflater(),getSupportFragmentManager());
        rcSeeAllComment.setAdapter(adapter);
    }
}
