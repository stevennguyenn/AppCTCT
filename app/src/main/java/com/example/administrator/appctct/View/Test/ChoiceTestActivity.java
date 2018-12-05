package com.example.administrator.appctct.View.Test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.administrator.appctct.Adapter.AdapterChoiceTest.AdapterChocieTest;
import com.example.administrator.appctct.Adapter.AdapterChoiceTest.AdapterStatusSections;
import com.example.administrator.appctct.Adapter.AdapterChoiceTest.ChoiceTestListened;
import com.example.administrator.appctct.Adapter.SettingsApdater.SettingsAdapter;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Component.Constant.TypeSection;
import com.example.administrator.appctct.Component.Constant.TypeStatus;
import com.example.administrator.appctct.R;

import java.net.Proxy;

public class ChoiceTestActivity extends AppCompatActivity implements ChoiceTestListened {

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
        AdapterStatusSections adapterSettings = new AdapterStatusSections(getLayoutInflater(),Strings.ListStatusSection.getListStatusSection());
        AdapterChocieTest adapter = new AdapterChocieTest(getLayoutInflater(), Strings.ListSection.getListSection(),adapterSettings);
        adapter.setListened(this);
        rcChocieSection.setAdapter(adapter);
    }

    @Override
    public void clickTest(int positionTest, int positionStatus) {

        switch (positionStatus){
            case 0:
                if (positionTest == 0){
                    Intent intent = new Intent(ChoiceTestActivity.this,MainActivity.class);
                    intent.putExtra("status",TypeStatus.Online.rawVlue());
                    intent.putExtra("type_section",TypeSection.GT1.rawValue());
                    startActivity(intent);
                    overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
                }
                break;
            case 2:
                if (positionTest == 0) {
                    Intent intent = new Intent(ChoiceTestActivity.this, SectionOfflineActivity.class);
                    intent.putExtra("type_section", TypeSection.GT1.rawValue());
                    startActivity(intent);
                    overridePendingTransition(R.anim.show_view_navigation, R.anim.hide_view_navigation);
                }
                break;
        }
    }
}
