package com.example.administrator.appctct.View.SearchView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Presenter.PresenterSearch.PresenterSearch;
import com.example.administrator.appctct.Presenter.PresenterSearch.PresenterSearchListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher, PresenterSearchListened {

    EditText edSearch;
    TextView tvCancel;
    private PresenterSearch presentSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setID();
        setupView();
    }

    private void setID(){
        edSearch = findViewById(R.id.edSearch);
        tvCancel = findViewById(R.id.tvCancel);
    }

    private void setupView(){
        tvCancel.setOnClickListener(this);
        edSearch.addTextChangedListener(this);
        presentSearch = new PresenterSearch();
        presentSearch.setListened(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvCancel:
                finish();
                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.hide_view_present,R.anim.hide_view_search);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        presentSearch.searchForKey(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void successed(ArrayList<Book> result) {
        Log.d("AAA",result.size()+"");
    }

    @Override
    public void failed() {
        Log.d("AAA","null");
    }

    @Override
    public void connectFailed() {
        Log.d("AAA","connect failed");
    }
}
