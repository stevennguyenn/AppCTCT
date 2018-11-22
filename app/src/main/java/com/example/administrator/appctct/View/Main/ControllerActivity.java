package com.example.administrator.appctct.View.Main;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.appctct.Adapter.NaviAdapter.NaviApdater;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.R;

public class ControllerActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private RecyclerView rcNavi;
    private NaviApdater adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        setupView();
        setToolbar();
    }
     private void setupView(){
         drawerLayout = findViewById(R.id.drawer_layout);
         NavigationView navi = findViewById(R.id.nav_view);
         rcNavi = findViewById(R.id.rc_navi);
         LinearLayoutManager layoutManager = new LinearLayoutManager(ControllerActivity.this,LinearLayoutManager.VERTICAL,false);
         rcNavi.setLayoutManager(layoutManager);
         adapter = new NaviApdater(this.getLayoutInflater(), Strings.lineNavi.getLineNavi(),Strings.header);
         rcNavi.setAdapter(adapter);
         drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
             @Override
             public void onDrawerSlide(@NonNull View view, float v) {
                 
             }

             @Override
             public void onDrawerOpened(@NonNull View view) {

             }

             @Override
             public void onDrawerClosed(@NonNull View view) {

             }

             @Override
             public void onDrawerStateChanged(int i) {

             }
         });
     }

     private void setToolbar(){
         toolbar = findViewById(R.id.tb_Controller);
         setSupportActionBar(toolbar);
         ActionBar actionBar = getSupportActionBar();
         actionBar.setDisplayHomeAsUpEnabled(true);
         actionBar.setHomeAsUpIndicator(R.drawable.tbnavi);
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
