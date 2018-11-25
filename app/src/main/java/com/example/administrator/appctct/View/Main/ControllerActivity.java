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
import android.widget.Toast;

import com.example.administrator.appctct.Adapter.NaviAdapter.ClickNaviItem;
import com.example.administrator.appctct.Adapter.NaviAdapter.NaviApdater;
import com.example.administrator.appctct.Adapter.SettingsApdater.ItemOffetsetDecoration;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Entity.CellNavi;
import com.example.administrator.appctct.Entity.ContentHeader;
import com.example.administrator.appctct.Fragment.FragmentListBook.FragmentListBook;
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
    private FragmentListBook listBookOne,listBookTwo,listBookThree,listBookFor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        setID();
        setupView();
        setToolbar();
        getData();
    }

    private void setID(){
        listBookOne = (FragmentListBook) getSupportFragmentManager().findFragmentById(R.id.viewListBookOne);
        listBookTwo = (FragmentListBook) getSupportFragmentManager().findFragmentById(R.id.viewListBookTwo);
        listBookThree = (FragmentListBook) getSupportFragmentManager().findFragmentById(R.id.viewListBookThree);
        listBookFor = (FragmentListBook) getSupportFragmentManager().findFragmentById(R.id.viewListBookFor);
        drawerLayout = findViewById(R.id.drawer_layout);
        rcNavi = findViewById(R.id.rc_navi);
        NavigationView navi = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.tb_Controller);
        getDataListBookOne();
        getDataListBookTwo();
        getDataListBookThree();
        getDataListBookFor();
    }

    private void setupView(){
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

    private void getDataListBookOne(){
        listBookOne.setupView(getResources().getString(R.string.math1));
        DataClient client = APIUtils.getData();
        Call<ArrayList<Book>> call = client.getDataGiaiTich1();
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Book>> call,@NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listBookOne.setListBook(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Book>> call,@NonNull Throwable t) {

            }
        });
    }

    private void getDataListBookTwo(){
        listBookTwo.setupView(getResources().getString(R.string.math2));
        DataClient client = APIUtils.getData();
        Call<ArrayList<Book>> call = client.getDataGiaiTich2();
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Book>> call,@NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listBookTwo.setListBook(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Book>> call,@NonNull Throwable t) {

            }
        });
    }
    private void getDataListBookThree(){
        listBookThree.setupView(getResources().getString(R.string.physical1));
        DataClient client = APIUtils.getData();
        Call<ArrayList<Book>> call = client.getDataVatLy1();
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Book>> call,@NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listBookThree.setListBook(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Book>> call,@NonNull Throwable t) {

            }
        });
    }

    private void getDataListBookFor(){
        listBookFor.setupView(getResources().getString(R.string.physical2));
        DataClient client = APIUtils.getData();
        Call<ArrayList<Book>> call = client.getDataVatLy2();
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Book>> call,@NonNull Response<ArrayList<Book>> response) {
                if (response.body() != null){
                    listBookFor.setListBook(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Book>> call,@NonNull Throwable t) {

            }
        });
    }


    private void setToolbar(){
        toolbar.setTitle(getResources().getString(R.string.ctct));
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_red));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.tbnavi);
    }

    private void getData(){
        DataClient client = APIUtils.getData();
        Call<ContentHeader> call = client.getContentHeader(getToken());
        call.enqueue(new Callback<ContentHeader>() {
            @Override
            public void onResponse(@NonNull  Call<ContentHeader> call,@NonNull Response<ContentHeader> response) {
                if (response.body() != null){
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

    private String getToken(){
        return getSharedPreferences("data",MODE_PRIVATE).getString("token","");
    }
}
