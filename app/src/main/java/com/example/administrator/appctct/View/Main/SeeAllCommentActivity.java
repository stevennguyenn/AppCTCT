package com.example.administrator.appctct.View.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.appctct.Adapter.AdapterSeeAllComment.AdapterSeeAllComment;
import com.example.administrator.appctct.Adapter.AdapterSeeAllComment.LoadCommentForRate;
import com.example.administrator.appctct.Adapter.AdapterSeeAllComment.OnLoadMoreComment;
import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.RateBook.CommentSeeAll;
import com.example.administrator.appctct.Entity.RateBook.TitleCommentSeeAll;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetAllComment;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetAllCommentListened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetCommentForRate;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetCommentForRateListened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetTitleSeeAllComment;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetTitleSeeAllCommentListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SeeAllCommentActivity extends AppCompatActivity implements PresenterGetTitleSeeAllCommentListened, PresenterGetAllCommentListened,OnLoadMoreComment, View.OnClickListener,LoadCommentForRate,PresenterGetCommentForRateListened {

    private RecyclerView rcSeeAllComment;
    private AdapterSeeAllComment adapter;
    private String idBook = "";
    private int page = 0;
    private PresenterGetAllComment presenterGetAllComment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_comment);
        setID();
        setupView();
    }
    private void setID(){
        rcSeeAllComment = findViewById(R.id.rcSeeAllComment);
        TextView tvSendComment = findViewById(R.id.tvSendComment);
        tvSendComment.setOnClickListener(this);
        idBook = getIntent().getStringExtra("id_book");
    }

    private void setupView(){
        PresenterGetTitleSeeAllComment presenter = new PresenterGetTitleSeeAllComment(this);
        presenter.process(idBook);
        presenterGetAllComment = new PresenterGetAllComment(this);
        presenterGetAllComment.process(page,idBook);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcSeeAllComment.setLayoutManager(manager);
        adapter = new AdapterSeeAllComment(rcSeeAllComment,getLayoutInflater(),getSupportFragmentManager());
        adapter.setLoadMoreCommentListened(this);
        adapter.setLoadCommentForRateLisntened(this);
        rcSeeAllComment.setAdapter(adapter);
    }

    @Override
    public void getTitleSeeAllSuccessed(TitleCommentSeeAll data) {
        adapter.setTitleCommentSeeAll(data);
    }

    @Override
    public void getCommentForRateSuccessed(ArrayList<BookComment> data) {
        adapter.setListComment(data);
    }

    @Override
    public void noComment() {

    }

    @Override
    public void connectFailed(String message) {

    }

    @Override
    public void getCommentSuccessed(CommentSeeAll data) {
        page ++ ;
        adapter.setListComment(data.getListComment());
    }

    @Override
    public void nomoreComment() {
        adapter.setNoLoadMore();
    }

    @Override
    public void loadMoreComment() {
        presenterGetAllComment.process(page,idBook);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SeeAllCommentActivity.this,RateActivity.class);
        intent.putExtra("id_book",idBook);
        startActivity(intent);
        overridePendingTransition(R.anim.show_view_present,0);
    }

    @Override
    public void loadComment(int rate) {
        PresenterGetCommentForRate presenterGetCommentForRate = new PresenterGetCommentForRate(this);
        presenterGetCommentForRate.process(rate,idBook);
    }
}
