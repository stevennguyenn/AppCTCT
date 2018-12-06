package com.example.administrator.appctct.View.Test;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ResultQuestion;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.Fragment.Fragment_question.ClickTVSeeTop;
import com.example.administrator.appctct.Fragment.Fragment_question.fragment_completion_result;
import com.example.administrator.appctct.Fragment.Fragment_question.fragment_load_data;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterShowResult;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterShowResultListened;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.View.Main.ControllerActivity;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity implements PresenterShowResultListened,ClickButton,ClickTVSeeTop{

    private ArrayList<IdAndResult> listResult = new ArrayList<>();
    private PresenterShowResult presenter;
    private fragment_button btShowResult;
    private fragment_load_data viewLoadData = new fragment_load_data();
    private fragment_completion_result viewConpletion = new fragment_completion_result();
    private Boolean isCancelLoad = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setID();
        setupView();
    }

    private void setID(){
        btShowResult = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.btShowResult);
    }

    private void setupView(){
        listResult = (ArrayList<IdAndResult>) getIntent().getSerializableExtra("list_result");
        btShowResult.setButtonVisible();
        btShowResult.setRegister(this);
        btShowResult.setTitleButton(getResources().getString(R.string.cancel));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.viewChildren,viewLoadData);
        transaction.commit();
        presenter = new PresenterShowResult(this);
        presenter.getResult(listResult);
    }

    @Override
    public void getPointSuccessed(ResultQuestion result) {
        isCancelLoad = false;
        btShowResult.setTitleButton(getResources().getString(R.string.gotodocument));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        viewConpletion.setListened(this);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data",result);
        viewConpletion.setArguments(bundle);
        transaction.replace(R.id.viewChildren,viewConpletion);
        transaction.commit();
    }

    @Override
    public void getPointFailed() {
        Toast.makeText(ResultActivity.this,"Failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed(String message) {
        Toast.makeText(ResultActivity.this,"Nextwork Failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickView(View v) {
        if (isCancelLoad) {
            finish();
            return;
        }
        Intent intent = new Intent(ResultActivity.this, ControllerActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void click() {
        Log.d("AAAAA","click");
    }
}
