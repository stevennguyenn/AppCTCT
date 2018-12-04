package com.example.administrator.appctct.View.Test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.appctct.Adapter.AdapterChoiceTest.AdapterChocieTest;
import com.example.administrator.appctct.Adapter.SettingsApdater.SettingsAdapter;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.R;

public class ChoiceTestActivity extends AppCompatActivity {

    private RecyclerView rcChocieSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_test);
        setID();
        setupView();
    }

    private void setID(){
        rcChocieSection = findViewById(R.id.rcChoiceSection);
    }

    private void setupView(){
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcChocieSection.setLayoutManager(manager);
        rcChocieSection.setHasFixedSize(true);
        SettingsAdapter adapterSettings = new SettingsAdapter(getLayoutInflater(),Strings.ListStatusSection.getListStatusSection());
        AdapterChocieTest adapter = new AdapterChocieTest(getLayoutInflater(), Strings.ListSection.getListSection(),adapterSettings);
        rcChocieSection.setAdapter(adapter);
    }
}
