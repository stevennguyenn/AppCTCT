package com.example.administrator.appctct.View.Test;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
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
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Component.Constant.TypeStatus;
import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.Entity.ModelQuestionOnlineOffline;
import com.example.administrator.appctct.Entity.QuestionTestTested;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.Fragment.FragmentButton.TimeEnd;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterGetQuestionOffline;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterGetQuestionOfflineListened;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterGetQuestionTestTested;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterGetQuestionTestTestedListened;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterInitList;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterInitListened;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterMainGetQuestion;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterMainGetQuestionListened;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterProcessResult;
import com.example.administrator.appctct.Presenter.PresenterTest.PresenterProcessResultListened;
import com.example.administrator.appctct.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CheckBoxClick,ClickButton,PresenterMainGetQuestionListened,PresenterProcessResultListened,TimeEnd,PresenterInitListened,PresenterGetQuestionTestTestedListened,PresenterGetQuestionOfflineListened {

    RecyclerView rcQuestion;
    private ArrayList<ModelQuestion> listQuestion;
    private ConstraintLayout layoutNoQuestion;
    private QuestionAdapter adapter;
    private ArrayList<IdAndResult> listIdandResult;
    private RecyclerViewSkeletonScreen skeleton;
    private fragment_button btCTCT;
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
//        stopService(new Intent(this, NotificationService.class));
    }

    private void setID(){
        rcQuestion = findViewById(R.id.rcMain);
        layoutNoQuestion = findViewById(R.id.viewChildren);
        btCTCT = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.btCTCT);
        typeStatus = getIntent().getIntExtra("status",-1);
        typeSection = getIntent().getIntExtra("type_section",-1);
        testCode = getIntent().getStringExtra("testCode");
    }

    private void setupView(){
        //btCTCT.setTitleButton(getResources().getString(R.string.confirm));
        //btCTCT.setRegister(this);

        listQuestion = new ArrayList<>();
        adapter = new QuestionAdapter(listQuestion,MainActivity.this);

        if (typeStatus == TypeStatus.Online.rawVlue()){
            btCTCT.setTimeEndListened(this);
            btCTCT.timeTest(10000);
            PresenterMainGetQuestion presenterGetQuestion = new PresenterMainGetQuestion(this);
            presenterGetQuestion.getQuestion(typeSection,getToken());
        }
        if (typeStatus ==  TypeStatus.Offline.rawVlue()){
            btCTCT.setTitleButton(getResources().getString(R.string.confirm));
            btCTCT.setRegister(this);
            btCTCT.setButtonVisible();
            PresenterGetQuestionOffline presenterGetQuestionOffline = new PresenterGetQuestionOffline(this);
            presenterGetQuestionOffline.getQuestion(typeSection,testCode);
        }

        if (typeStatus == TypeStatus.Tested.rawVlue()){
            if (btCTCT.getView() != null) {
                btCTCT.getView().setVisibility(View.GONE);
                PresenterGetQuestionTestTested presenterGetQuestionTestTested = new PresenterGetQuestionTestTested(this);
                presenterGetQuestionTestTested.getQuestion(typeSection,getToken(),testCode);
            }
        }

        processResult = new PresenterProcessResult(this);
        rcQuestion.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcQuestion.setLayoutManager(layoutManager);

        adapter.setCheckBoxClickListened(this);
        rcQuestion.setAdapter(adapter);
        skeleton = Skeleton.bind(rcQuestion)
                            .adapter(adapter)
                            .load(R.layout.layout_default_item_skeleton)
                            .angle(0)
                            .show();
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
//        Notification.notify(MainActivity.this);
        Intent in = new Intent(MainActivity.this,ShowResultActivity.class);
        in.putParcelableArrayListExtra("list_result",listIdandResult);
        in.putExtra("test_code",testCode);
        startActivity(in);
        overridePendingTransition(R.anim.show_view_present,R.anim.hide_view_present);
    }

    @Override
    public void getQuestionSuccessed(ModelQuestionOnlineOffline data) {
        PresenterInitList presenterInitList = new PresenterInitList(this);
        presenterInitList.process(data.getListQuestion());
        adapter.setListQuestion(data.getListQuestion());
        //have test code online
        this.testCode = data.getTestCode();
        this.listQuestion = data.getListQuestion();
        if (skeleton != null){
            skeleton.hide();
            skeleton = null;
        }
    }

    @Override
    public void getQuestionOfflineSuccessed(ArrayList<ModelQuestion> listQuestion) {
        PresenterInitList presenterInitList = new PresenterInitList(this);
        presenterInitList.process(listQuestion);
        adapter.setListQuestion(listQuestion);
        this.listQuestion = listQuestion;
        if (skeleton != null){
            skeleton.hide();
            skeleton = null;
        }
    }

    @Override
    public void noQuestion() {
        layoutNoQuestion.setVisibility(View.VISIBLE);
        btCTCT.cancelTimer();
    }

    @Override
    public void getQuestionSuccessedTestTested(ArrayList<QuestionTestTested> listQuestion) {
        adapter.setListTestTested(listQuestion);
        if (skeleton != null){
            skeleton.hide();
            skeleton = null;
        }
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
        in.putParcelableArrayListExtra("list_result",listIdandResult);
        startActivity(in);
        overridePendingTransition(R.anim.show_view_present,R.anim.hide_view_present);
    }

    @Override
    protected void onPause() {
        super.onPause();
        btCTCT.cancelTimer();
        if (btCTCT.getView() != null) btCTCT.getView().setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if (typeStatus != TypeStatus.Online.rawVlue()) {
            super.onBackPressed();
            overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
        }
    }

    @Override
    public void processSuccessed(ArrayList<IdAndResult> listResult) {
        listIdandResult = listResult;
    }

    private String getToken(){
        return getSharedPreferences(Strings.data,MODE_PRIVATE).getString(Strings.token,"");
    }
}
