package com.example.administrator.appctct.View.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Fragment.FragmentButton.ClickButton;
import com.example.administrator.appctct.Fragment.FragmentButton.fragment_button;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterSendComment;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterSendCommentListened;
import com.example.administrator.appctct.R;

public class RateActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener, View.OnClickListener, TextWatcher,ClickButton, PresenterSendCommentListened {

    fragment_button btSendComment;
    RatingBar rbCountStart;
    EditText edComment;
    TextView tvCancel;
    private Boolean changeratingbar = false;
    private Boolean changeEdComment = false;
    private String idBook = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        setID();
        setupView();
    }

    private void setID(){
        btSendComment = (fragment_button) getSupportFragmentManager().findFragmentById(R.id.tvSendComment);
        idBook = getIntent().getStringExtra("id_book");
        rbCountStart = findViewById(R.id.rbCountStart);
        edComment = findViewById(R.id.edComment);
        tvCancel = findViewById(R.id.tvCancel);
    }

    private void setupView(){
        btSendComment.setTitleButton(getResources().getString(R.string.sendcomment));
        btSendComment.setButtonDisable();
        rbCountStart.setOnRatingBarChangeListener(this);
        tvCancel.setOnClickListener(this);
        edComment.addTextChangedListener(this);
        btSendComment.setRegister(this);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        if (fromUser){
            changeratingbar = true;
            if (changeEdComment){
                btSendComment.setButtonVisible();
                return;
            }
            btSendComment.setButtonDisable();
        }
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,R.anim.hide_view_present);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!edComment.getText().toString().equals("")){
            changeEdComment = true;
            if (changeratingbar) {
                btSendComment.setButtonVisible();
            }
            return;
        }
        changeEdComment = false;
        btSendComment.setButtonDisable();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,R.anim.hide_view_present);
    }

    @Override
    public void clickView(View v) {
        PresenterSendComment presenter = new PresenterSendComment(this);
        presenter.process(getToken(),idBook,edComment.getText().toString(),rbCountStart.getRating());
    }

    @Override
    public void successed() {
        finish();
    }

    @Override
    public void failed() {

    }
    private String getToken(){
        return getSharedPreferences(Strings.data,MODE_PRIVATE).getString(Strings.token,"");
    }
}
