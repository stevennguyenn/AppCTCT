package com.example.administrator.appctct.View.Test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.Fragment.Fragment_question.fragment_completion_result;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterShowResult;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterShowResultListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;
import java.util.IdentityHashMap;

public class ResultActivity extends AppCompatActivity implements PresenterShowResultListened{

    private ArrayList<IdAndResult> listResult = new ArrayList<>();
    private PresenterShowResult presenter;
    private fragment_completion_result viewConpletion;
    private fragment_button btShowResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setID();
        setupView();
        setupData();
    }

    private void setID(){
        btShowResult = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.btShowResult);
        viewConpletion = (fragment_completion_result) getSupportFragmentManager().findFragmentById(R.id.fragmentCompletionResult);

    }

    private void setupView(){

    }

    private void setupData(){
        presenter = new PresenterShowResult(this);
        listResult = (ArrayList<IdAndResult>) getIntent().getSerializableExtra("list_result");
        presenter.getResult(listResult);
    }

    @Override
    public void getPointSuccessed(int point) {

    }

    @Override
    public void getPointFailed() {

    }

    @Override
    public void connectFailed(String message) {

    }
}
