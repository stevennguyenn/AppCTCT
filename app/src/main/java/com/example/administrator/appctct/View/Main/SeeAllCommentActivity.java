package com.example.administrator.appctct.View.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.appctct.Adapter.AdapterSeeAllComment.AdapterSeeAllComment;
import com.example.administrator.appctct.Entity.RateBook.TitleCommentSeeAll;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetTitleSeeAllComment;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetTitleSeeAllCommentListened;
import com.example.administrator.appctct.R;

public class SeeAllCommentActivity extends AppCompatActivity implements PresenterGetTitleSeeAllCommentListened {

    private RecyclerView rcSeeAllComment;
    private AdapterSeeAllComment adapter;
    private String idBook = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_comment);
        setID();
        setupView();
    }
    private void setID(){
        rcSeeAllComment = findViewById(R.id.rcSeeAllComment);
        idBook = getIntent().getStringExtra("id_book");
    }

    private void setupView(){
        PresenterGetTitleSeeAllComment presenter = new PresenterGetTitleSeeAllComment(this);
        presenter.process(idBook);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcSeeAllComment.setLayoutManager(manager);
        adapter = new AdapterSeeAllComment(getLayoutInflater(),getSupportFragmentManager());
        rcSeeAllComment.setAdapter(adapter);
    }

    @Override
    public void getTitleSeeAllSuccessed(TitleCommentSeeAll data) {
        adapter.setTitleCommentSeeAll(data);
    }

    @Override
    public void connectFailed(String message) {

    }
}
