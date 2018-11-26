package com.example.administrator.appctct.View.SearchView;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.appctct.Adapter.SearchBookAdapter.SearchBookAdapter;
import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Presenter.PresenterSearch.PresenterSearch;
import com.example.administrator.appctct.Presenter.PresenterSearch.PresenterSearchListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher, PresenterSearchListened {

    EditText edSearch;
    TextView tvCancel;
    private PresenterSearch presentSearch;
    RecyclerView rcSearch;
    LinearLayoutManager layoutManager;
    SearchBookAdapter adapter;
    ConstraintLayout viewNoResultSearch;

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
        rcSearch = findViewById(R.id.rcSearch);
        viewNoResultSearch = findViewById(R.id.viewNoResultSearch);
    }

    private void setupView(){
        tvCancel.setOnClickListener(this);
        edSearch.addTextChangedListener(this);
        presentSearch = new PresenterSearch();
        presentSearch.setListened(this);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcSearch.setLayoutManager(layoutManager);
        rcSearch.setHasFixedSize(true);
        adapter = new SearchBookAdapter(getLayoutInflater(),new ArrayList<Book>());
        rcSearch.setAdapter(adapter);
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
    public void successed(ArrayList<Book> listBook) {
        if (listBook.size() > 0) {
            adapter.setListBook(listBook);
            viewNoResultSearch.setVisibility(View.GONE);
            return;
        }
        viewNoResultSearch.setVisibility(View.VISIBLE);
    }

    @Override
    public void failed() {
        viewNoResultSearch.setVisibility(View.VISIBLE);
    }

    @Override
    public void connectFailed() {
        viewNoResultSearch.setVisibility(View.VISIBLE);
    }
}
