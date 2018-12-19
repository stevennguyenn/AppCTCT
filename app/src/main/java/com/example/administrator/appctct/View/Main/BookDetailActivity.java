package com.example.administrator.appctct.View.Main;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.administrator.appctct.Adapter.AdapterBookDetail.AdapterBookDetail;
import com.example.administrator.appctct.Component.Custom.KeyWord;
import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Entity.BookDetail.BookExtened;
import com.example.administrator.appctct.Entity.BookDetail.InformationBook;
import com.example.administrator.appctct.Entity.BookDetail.TitleBook;
import com.example.administrator.appctct.Fragment.FragmentBookDetail.FragmentInfomationBook;
import com.example.administrator.appctct.Fragment.FragmentBookDetail.NotifyClickToSeeTheDocument;
import com.example.administrator.appctct.Fragment.FragmentBookDetail.NotifyOnLoadMore;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetBookDetail;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetBookDetailListened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetBookExtendListened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetBookExtened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetCommentBook;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterGetCommentBookListened;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.View.Test.PDFActivity;

import java.util.ArrayList;

public class BookDetailActivity extends AppCompatActivity implements PresenterGetCommentBookListened,PresenterGetBookDetailListened,PresenterGetBookExtendListened,NotifyOnLoadMore,NotifyClickToSeeTheDocument {

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
    }

    @Override
    public void getBookCommentSuccessed(ArrayList<BookComment> data) {
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
        overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);

    }
}
