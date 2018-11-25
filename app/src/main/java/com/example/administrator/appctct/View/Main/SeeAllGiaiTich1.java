package com.example.administrator.appctct.View.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.Fragment.FragmentSeeAllListBook.FragmentSellAllListBook;
import com.example.administrator.appctct.Presenter.PresenterController.PresenterSeeAllListGiaiTich1;
import com.example.administrator.appctct.Presenter.PresenterController.PresenterSeeAllListGiaiTich1Listened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SeeAllGiaiTich1 extends AppCompatActivity implements PresenterSeeAllListGiaiTich1Listened {

    FragmentSellAllListBook fragmentSeeAllGiaiTich1;
    private PresenterSeeAllListGiaiTich1 presenter;

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
        presenter = new PresenterSeeAllListGiaiTich1(this);
    }
    private void getData(){
        presenter.getData();
    }

    @Override
    public void getAllSuccessed(ArrayList<FullBook> listBook) {
        fragmentSeeAllGiaiTich1.setListBook(listBook);
    }

    @Override
    public void getAllFailed() {
        Toast.makeText(SeeAllGiaiTich1.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed() {
        Toast.makeText(SeeAllGiaiTich1.this,"Connect Failed",Toast.LENGTH_SHORT).show();
    }
}
