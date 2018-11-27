package com.example.administrator.appctct.View.Test;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.example.administrator.appctct.Adapter.QuestionApdater.CheckBoxClick;
import com.example.administrator.appctct.Adapter.QuestionApdater.QuestionAdapter;
import com.example.administrator.appctct.Adapter.QuestionApdater.ItemClick;
import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterMain;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterMainGetQuestion;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterMainGetQuestionListened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterMainListened;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterProcessResult;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterProcessResultListened;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CheckBoxClick,ClickButton,PresenterMainListened,PresenterMainGetQuestionListened,PresenterProcessResultListened{

    RecyclerView rcQuestion;
    private ArrayList<ModelQuestion> listQuestion;
    private QuestionAdapter adapter;
    private ArrayList<IdAndResult> listIdandResult;
    private RecyclerViewSkeletonScreen skeleton;
    fragment_button btCTCT;
    private PresenterMain presenter;
    private PresenterMainGetQuestion presenterGetQuestion;
    private PresenterProcessResult processResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setID();
        setupView();
        getData();
    }

    private void getData(){
        presenterGetQuestion.getQuestion();
    }

    private void setID(){
        rcQuestion = findViewById(R.id.rcMain);
        btCTCT = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.btCTCT);
    }

    private void setupView(){
        btCTCT.setTitleButton(getResources().getString(R.string.confirm));
        btCTCT.setRegister(this);
        btCTCT.setButtonVisible();
        presenter = new PresenterMain(this);
        presenterGetQuestion = new PresenterMainGetQuestion(this);
        processResult = new PresenterProcessResult(this);
        rcQuestion.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcQuestion.setLayoutManager(layoutManager);
        listQuestion = new ArrayList<>();
        adapter = new QuestionAdapter(listQuestion,MainActivity.this);
        adapter.setCheckBoxClickListened(this);
        rcQuestion.setAdapter(adapter);
        skeleton = Skeleton.bind(rcQuestion)
                            .adapter(adapter)
                            .load(R.layout.layout_default_item_skeleton)
                            .angle(0)
                            .show();
        listIdandResult = new ArrayList<>();
    }

    @Override
    public void checkboxListened(int position, String result) {
        Object[] objects = new Object[4];
        objects[0] = listIdandResult;
        objects[1] = position;
        objects[2] = result;
        objects[3] = listQuestion;
        processResult.process(objects);
    }

    private void showResult(){
        presenter.getResult(listIdandResult);
    }

    @Override
    public void clickView(View v) {
        showResult();
    }

    @Override
    public void noChoice() {
        Toast.makeText(MainActivity.this,"Please Choice Question",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getPointSuccessed(int point) {
        Toast.makeText(MainActivity.this,point+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getPointFailed() {
        Toast.makeText(MainActivity.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getQuestionSuccessed(ArrayList<ModelQuestion> listQuestion) {
        this.listQuestion.addAll(listQuestion);
        adapter.notifyDataSetChanged();
        if (skeleton != null){
            skeleton.hide();
            skeleton = null;
        }
    }

    @Override
    public void getQuestionFailed() {
        Toast.makeText(MainActivity.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed(String message) {
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getResult(ArrayList<IdAndResult> list) {
        listIdandResult = list;
    }
}
