package com.example.administrator.appctct.View.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.Fragment.FragmentSeeAllListBook.FragmentSellAllListBook;
import com.example.administrator.appctct.Presenter.PresenterController.PresenterSeeAll;
import com.example.administrator.appctct.Presenter.PresenterController.PresenterSeeAllListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SeeAll extends AppCompatActivity implements PresenterSeeAllListened {

    FragmentSellAllListBook fragmentSeeAllGiaiTich1;
    private PresenterSeeAll presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_giai_tich1);
        setID();
        setupView();
        getData();
    }

    private void setID(){
        fragmentSeeAllGiaiTich1 = (FragmentSellAllListBook) getSupportFragmentManager().findFragmentById(R.id.fragmentSeeAllListGiaiTich1);
    }

    private void setupView(){
        presenter = new PresenterSeeAll(this);
    }

    private void getData(){
        int searchType = getIntent().getIntExtra(Strings.typeSearch,0);
        switch (searchType){
            case 1:
                presenter.getDataGiaiTich1();
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
        fragmentSeeAllGiaiTich1.setListBook(listBook);
    }

    @Override
    public void getAllFailed() {
        Toast.makeText(SeeAll.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed() {
        Toast.makeText(SeeAll.this,"Connect Failed",Toast.LENGTH_SHORT).show();
    }
}
