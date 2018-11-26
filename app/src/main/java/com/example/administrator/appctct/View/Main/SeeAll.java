package com.example.administrator.appctct.View.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.Fragment.FragmentSeeAllListBook.FragmentSellAllListBook;
import com.example.administrator.appctct.Fragment.FragmentSeeAllListBook.LoadMoreForFragment;
import com.example.administrator.appctct.Fragment.FragmentSeeAllListBook.SearchSeeAllListened;
import com.example.administrator.appctct.Presenter.PresenterController.PresenterSeeAll;
import com.example.administrator.appctct.Presenter.PresenterController.PresenterSeeAllListened;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.View.SearchView.SearchActivity;

import java.util.ArrayList;

public class SeeAll extends AppCompatActivity implements PresenterSeeAllListened, SearchSeeAllListened, LoadMoreForFragment {

    FragmentSellAllListBook fragmentSeeAll;
    private PresenterSeeAll presenter;
    private int type = 0;
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_giai_tich1);
        setID();
        setupView();
        getData();
    }

    private void setID(){
        fragmentSeeAll = (FragmentSellAllListBook) getSupportFragmentManager().findFragmentById(R.id.fragmentSeeAllListGiaiTich1);
    }

    private void setupView(){
        presenter = new PresenterSeeAll(this);
        fragmentSeeAll.setListened(this);
        fragmentSeeAll.setLoadMore(this);
    }

    private void getData(){
        int searchType = getIntent().getIntExtra(Strings.typeSearch,0);
        type = searchType;
        switch (searchType){
            case 1:
                presenter.getDataGiaiTich1(page);
                break;
            case 2:
                presenter.getDataGiaiTich2();
                break;
            case 3:
                presenter.getDataVatLy1();
                break;
            case 4:
                presenter.getDataVatLy2();
                break;
        }
    }

    @Override
    public void getAllSuccessed(ArrayList<FullBook> listBook) {
        fragmentSeeAll.setListBook(listBook,type);
    }

    @Override
    public void getAllFailed() {
        Toast.makeText(SeeAll.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed(String message) {
        Toast.makeText(SeeAll.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickSearch(int typeSearch) {
        Intent intent = new Intent(SeeAll.this, SearchActivity.class);
        intent.putExtra(Strings.typeSearch,typeSearch);
        startActivity(intent);
        overridePendingTransition(R.anim.show_view_present,R.anim.hide_view_present);
    }

    @Override
    public void onLoadMore() {
        page += 1;
        Log.d("BBB",page+"");
        presenter.getDataGiaiTich1(page);
    }
}
