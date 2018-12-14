package com.example.administrator.appctct.View.Test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.appctct.Adapter.QuestionApdater.ShowResultAdapter;
import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class ShowResultActivity extends AppCompatActivity implements ClickButton {

    private ArrayList<IdAndResult> listResult;
    private RecyclerView rcShowResult;
    private ShowResultAdapter adapter;
    private fragment_button btConfirm;
    private String testCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        setID();
        setupView();
        setRcShowResult();
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.light_transparent));
    }


    private void setRcShowResult(){
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcShowResult.setLayoutManager(manager);
        listResult =  getIntent().getParcelableArrayListExtra("list_result");
        testCode = getIntent().getStringExtra("test_code");
        adapter = new ShowResultAdapter(getLayoutInflater(),listResult);
        rcShowResult.setAdapter(adapter);
    }

    private void setupView(){
        btConfirm.setButtonVisible();
        btConfirm.setTitleButton(getResources().getString(R.string.confirm));
        btConfirm.setRegister(this);
    }

    private void setID(){
        rcShowResult = findViewById(R.id.rcShowResult);
        btConfirm =  (fragment_button) getSupportFragmentManager().findFragmentById(R.id.btConfirmShowResult);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void clickView(View v) {
        Intent intent = new Intent(ShowResultActivity.this,ResultActivity.class);
        intent.putParcelableArrayListExtra("list_result",listResult);
        intent.putExtra("test_code",testCode);
        startActivity(intent);
        overridePendingTransition(R.anim.show_view_present,R.anim.hide_view_present);
    }

}
