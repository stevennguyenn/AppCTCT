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
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.administrator.appctct.Adapter.NaviAdapter.ClickNaviItem;
import com.example.administrator.appctct.Adapter.NaviAdapter.NaviApdater;
import com.example.administrator.appctct.Adapter.SettingsApdater.ItemOffetsetDecoration;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.CellNavi;
import com.example.administrator.appctct.Entity.ContentHeader;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ControllerActivity extends AppCompatActivity implements ClickNaviItem{

    private DrawerLayout drawerLayout;
    private RecyclerView rcNavi;
    private NaviApdater adapter;
    private Toolbar toolbar;
    private ArrayList<CellNavi> listNavi;
    private ContentHeader header = new ContentHeader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        setupView();
        setToolbar();
        getData();
    }

    private void getData(){
        DataClient client = APIUtils.getData();
        Call<ContentHeader> call = client.getContentHeader("31");
        call.enqueue(new Callback<ContentHeader>() {
            @Override
            public void onResponse(@NonNull  Call<ContentHeader> call,@NonNull Response<ContentHeader> response) {
                if (response.body() != null){
                    Log.d("AAA",response.body().getAvatar());
                    header.setAvatar(response.body().getAvatar());
                    header.setFullname(response.body().getFullname());
                    header.setPoints(response.body().getPoints());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ContentHeader> call,@NonNull Throwable t) {

            }
        });
    }

     private void setupView(){
         drawerLayout = findViewById(R.id.drawer_layout);
         //NavigationView navi = findViewById(R.id.nav_view);
         rcNavi = findViewById(R.id.rc_navi);
         LinearLayoutManager layoutManager = new LinearLayoutManager(ControllerActivity.this,LinearLayoutManager.VERTICAL,false);
         rcNavi.setLayoutManager(layoutManager);
         listNavi = new ArrayList<>();
         listNavi = Strings.lineNavi.getLineNavi();
         adapter = new NaviApdater(this.getLayoutInflater(), listNavi,header);
         adapter.setListened(this);
         rcNavi.setAdapter(adapter);
         ItemOffetsetDecoration itemOffetsetDecoration = new ItemOffetsetDecoration(5);
         rcNavi.addItemDecoration(itemOffetsetDecoration);
     }

     private void setToolbar(){
         toolbar = findViewById(R.id.tb_Controller);
         toolbar.setTitle(getResources().getString(R.string.ctct));
         toolbar.setTitleTextColor(getResources().getColor(R.color.color_red));
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

    @Override
    public void clickHeader() {
        Toast.makeText(ControllerActivity.this,"click header",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickLineCell(int position) {
        Toast.makeText(ControllerActivity.this,"click line " + position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickLogout() {
        Toast.makeText(ControllerActivity.this,"click logout",Toast.LENGTH_SHORT).show();
    }
}
