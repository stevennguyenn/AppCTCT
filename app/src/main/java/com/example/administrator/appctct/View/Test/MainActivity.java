package com.example.administrator.appctct.View.Test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.example.administrator.appctct.Adapter.QuestionApdater.CheckBoxClick;
import com.example.administrator.appctct.Adapter.QuestionApdater.QuestionAdapter;
import com.example.administrator.appctct.Component.Constant.TypeStatus;
import com.example.administrator.appctct.Component.Custom.Notification;
import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.Fragment.FragmentButton.TimeEnd;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterMainGetQuestion;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterMainGetQuestionListened;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterProcessResult;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterProcessResultListened;
import com.example.administrator.appctct.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CheckBoxClick,ClickButton,PresenterMainGetQuestionListened,PresenterProcessResultListened,TimeEnd{

    RecyclerView rcQuestion;
    private ArrayList<ModelQuestion> listQuestion;
    private QuestionAdapter adapter;
    private ArrayList<IdAndResult> listIdandResult;
    private RecyclerViewSkeletonScreen skeleton;
    fragment_button btCTCT;
    private PresenterMainGetQuestion presenterGetQuestion;
    private PresenterProcessResult processResult;
    private int typeStatus = -1;
    private int typeSection = -1;
    private String testCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setID();
        setupView();
        getData();
//        stopService(new Intent(this, NotificationService.class));
    }

    private void getData(){
        presenterGetQuestion.getQuestion(typeSection,testCode);
    }

    private void setID(){
        rcQuestion = findViewById(R.id.rcMain);
        btCTCT = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.btCTCT);
        typeStatus = getIntent().getIntExtra("status",-1);
        typeSection = getIntent().getIntExtra("type_section",-1);
        testCode = getIntent().getStringExtra("testCode");
    }

    private void setupView(){
        //btCTCT.setTitleButton(getResources().getString(R.string.confirm));
        //btCTCT.setRegister(this);

        if (typeStatus == TypeStatus.Online.rawVlue()){
            btCTCT.setTimeEndListened(this);
            btCTCT.timeTest(10000);
        }
        if (typeStatus ==  TypeStatus.Offline.rawVlue()){
            btCTCT.setTitleButton(getResources().getString(R.string.confirm));
            btCTCT.setRegister(this);
            btCTCT.setButtonVisible();
        }

        if (typeStatus == TypeStatus.Tested.rawVlue()){
            if (btCTCT.getView() != null) {
                btCTCT.getView().setVisibility(View.GONE);
            }
        }
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
    public void checkboxListenedChecked(int position, String result) {
        processResult.process(listQuestion,listIdandResult,position,result);
    }

    @Override
    public void checkboxListenedUnChecked(int position) {
        processResult.processRemove(listIdandResult,listQuestion.get(position).getId());
    }

    @Override
    public void clickView(View v) {
        Notification.notify(MainActivity.this);
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

    @Override
    public void removeList(ArrayList<IdAndResult> list) {
        listIdandResult = list;
    }

    @Override
    public void timeEnd() {
        btCTCT.cancelTimer();
        if (btCTCT.getView() != null) {
            btCTCT.getView().setVisibility(View.GONE);
        }
        Intent in = new Intent(MainActivity.this,ShowResultActivity.class);
        in.putExtra("list_result",listIdandResult);
        startActivity(in);
        overridePendingTransition(R.anim.show_view_present,R.anim.hide_view_present);
    }

    @Override
    protected void onPause() {
        super.onPause();
        btCTCT.cancelTimer();
        if (btCTCT.getView() != null) {
            btCTCT.getView().setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
       if (typeStatus == TypeStatus.Online.rawVlue()){ }
       else{
           super.onBackPressed();
           overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
       }
    }
}
