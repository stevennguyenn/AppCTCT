package com.example.administrator.appctct.View.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.administrator.appctct.Adapter.Profile.AdapterInformationIndividual;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationIndividual;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationIndividualListened;
import com.example.administrator.appctct.R;

public class IndividualActivity extends AppCompatActivity implements PresenterGetInformationIndividualListened {

    RecyclerView rcViewInformationIndividual;
    PresenterGetInformationIndividual presenter;
    private AdapterInformationIndividual adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
        setID();
        setupView();
    }

    public void setID(){
        rcViewInformationIndividual = findViewById(R.id.rcViewInformationIndividual);
    }

    public void setupView(){
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcViewInformationIndividual.setLayoutManager(manager);
        adapter = new AdapterInformationIndividual(getLayoutInflater(),new InformationIndividual());
        rcViewInformationIndividual.setAdapter(adapter);
        presenter = new PresenterGetInformationIndividual(this);
        presenter.process(getToken());
    }

    @Override
    public void getIndiformationIndividualSuccessed(InformationIndividual info) {
        adapter.setInfo(info);
    }

    @Override
    public void informationIndividualNull() {
        Log.d("AAAA","NULL");
    }

    @Override
    public void connectFailed(String message) {
        Log.d("AAA",message);
    }

    private String getToken(){
        return getSharedPreferences(Strings.data,MODE_PRIVATE).getString(Strings.token,"");
    }
}
