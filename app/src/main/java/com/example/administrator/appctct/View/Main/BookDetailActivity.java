package com.example.administrator.appctct.View.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.appctct.Component.Custom.KeyWord;
import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Entity.BookDetail.BookExtened;
import com.example.administrator.appctct.Entity.BookDetail.FullBookComment;
import com.example.administrator.appctct.Fragment.FragmentBookDetail.FragmentInfomationBook;
import com.example.administrator.appctct.Fragment.FragmentBookDetail.NotifyAddComment;
import com.example.administrator.appctct.Fragment.FragmentBookDetail.NotifyClickToSeeTheDocument;
import com.example.administrator.appctct.Fragment.FragmentBookDetail.NotifyOnLoadMore;
import com.example.administrator.appctct.Fragment.FragmentBookDetail.NotifyViewClickSeeAllComment;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetBookDetail;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetBookDetailListened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetBookExtendListened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetBookExtened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetCommentBook;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetCommentBookListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class BookDetailActivity extends AppCompatActivity implements PresenterGetCommentBookListened,PresenterGetBookDetailListened,PresenterGetBookExtendListened,NotifyOnLoadMore,NotifyClickToSeeTheDocument,NotifyAddComment,NotifyViewClickSeeAllComment {

    FragmentInfomationBook viewInformationBook;
    private String idBook = "";
    private String keyword=  "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        setID();
        setupView();
    }

    private void setID(){
        viewInformationBook = (FragmentInfomationBook) getSupportFragmentManager().findFragmentById(R.id.fragmentInformationBook);
        idBook = getIntent().getStringExtra("id_book");
        keyword = KeyWord.getKeyWord(idBook);
    }
    private void setupView(){
        PresenterGetBookDetail presenterGetBookDetail = new PresenterGetBookDetail(this);
        presenterGetBookDetail.process(idBook);
        viewInformationBook.setOnLoadMore(this);
        viewInformationBook.setListenedNotifyClickToSeeTheDocument(this);
        viewInformationBook.setAddCommentListened(this);
        viewInformationBook.setNotifyViewClickSeeAllCommentListened(this);
    }

    @Override
    public void getBookCommentSuccessed(FullBookComment data) {
        viewInformationBook.setBookComment(data);
    }


    @Override
    public void getBookDetailSuccessed(BookDetail data) {
        viewInformationBook.setBookDetail(data);
    }

    @Override
    public void getBookNoInformation() {

    }

    @Override
    public void getBookExtendSuccessed(BookExtened data) {
        viewInformationBook.setBookExntend(data);
    }


    @Override
    public void connectFailed(String message) {
        Toast.makeText(BookDetailActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMoreComment() {
        PresenterGetCommentBook presenterGetCommentBook = new PresenterGetCommentBook(this);
        presenterGetCommentBook.process(idBook);
    }

    @Override
    public void onLoadMoreBookExtened() {
        if (!keyword.equals("")) {
            PresenterGetBookExtened presenterGetBookExtened = new PresenterGetBookExtened(this);
            presenterGetBookExtened.process(keyword);
        }
    }

    @Override
    public void click(String link) {
        Intent intent = new Intent(BookDetailActivity.this,PDFActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.show_view_navigation,0);

    }

    @Override
    public void send() {
        Intent intent = new Intent(BookDetailActivity.this,RateActivity.class);
        intent.putExtra("id_book",idBook);
        startActivity(intent);
        overridePendingTransition(R.anim.show_view_present,0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,R.anim.hide_view_navigation);
    }

    @Override
    public void clickSeeAllComment() {

    }
}
