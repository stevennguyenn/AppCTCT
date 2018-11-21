package com.example.administrator.appctct.View.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.appctct.Adapter.SettingsApdater.ItemOffetsetDecoration;
import com.example.administrator.appctct.Adapter.SettingsApdater.SettingsAdapter;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.R;

public class SettingActivity extends AppCompatActivity {

    RecyclerView rcSettings;
    SettingsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setID();
        setupView();
    }

    private void setID(){
        rcSettings = findViewById(R.id.rcSettings);
    }

    private void setupView(){
        rcSettings.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcSettings.setLayoutManager(layoutManager);
        adapter = new SettingsAdapter(SettingActivity.this.getLayoutInflater(), Strings.Settings.getStringSettings());
        ItemOffetsetDecoration itemOffetsetDecoration = new ItemOffetsetDecoration(5);
        rcSettings.setAdapter(adapter);
        rcSettings.addItemDecoration(itemOffetsetDecoration);
    }
}
