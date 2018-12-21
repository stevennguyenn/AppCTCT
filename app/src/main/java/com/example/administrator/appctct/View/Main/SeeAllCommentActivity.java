package com.example.administrator.appctct.View.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.appctct.Adapter.AdapterSeeAllComment.AdapterSeeAllComment;
import com.example.administrator.appctct.Adapter.AdapterSeeAllComment.OnLoadMoreComment;
import com.example.administrator.appctct.Entity.RateBook.CommentSeeAll;
import com.example.administrator.appctct.Entity.RateBook.TitleCommentSeeAll;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetAllComment;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetAllCommentListened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetTitleSeeAllComment;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetTitleSeeAllCommentListened;
import com.example.administrator.appctct.R;

public class SeeAllCommentActivity extends AppCompatActivity implements PresenterGetTitleSeeAllCommentListened, PresenterGetAllCommentListened,OnLoadMoreComment {

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
        rcSeeAllComment.setAdapter(adapter);
    }

    @Override
    public void getTitleSeeAllSuccessed(TitleCommentSeeAll data) {
        adapter.setTitleCommentSeeAll(data);
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
    public void connectFailed() {

    }

    @Override
    public void loadMoreComment() {
        presenterGetAllComment.process(page,idBook);
    }
}
