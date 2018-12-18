package com.example.administrator.appctct.View.Main;

import android.content.Intent;
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
import android.view.View;
import android.widget.Toast;

import com.example.administrator.appctct.Adapter.NaviAdapter.ClickNaviItem;
import com.example.administrator.appctct.Adapter.NaviAdapter.NaviApdater;
import com.example.administrator.appctct.Adapter.SettingsApdater.ItemOffetsetDecoration;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Component.Constant.TypeSearch;
import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Entity.CellNavi;
import com.example.administrator.appctct.Entity.ContentHeader;
import com.example.administrator.appctct.Fragment.FragmentListBook.Fragment_line_viewcontroller;
import com.example.administrator.appctct.Fragment.FragmentListBook.ProcessPragmentListBook;
import com.example.administrator.appctct.Fragment.FragmentListBook.clickLineController;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterController;
import com.example.administrator.appctct.Presenter.PresenterMain.PresenterControllerListened;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.View.Profile.ProfileActitivy;
import com.example.administrator.appctct.View.Setting.SettingActivity;
import com.example.administrator.appctct.View.Test.ChoiceTestActivity;

import java.util.ArrayList;

public class ControllerActivity extends AppCompatActivity implements ClickNaviItem, PresenterControllerListened, ProcessPragmentListBook,clickLineController {

    private DrawerLayout drawerLayout;
    private RecyclerView rcNavi;
    private NaviApdater adapter;
    private Toolbar toolbar;
    private ContentHeader header = new ContentHeader();
    private Fragment_line_viewcontroller listBookOne,listBookTwo,listBookThree,listBookFor;
    private PresenterController present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        setID();
        setupView();
        setToolbar();
        getData();
//        startService(new Intent(this, NotificationService.class));
    }

    private void setID(){
        listBookOne = (Fragment_line_viewcontroller) getSupportFragmentManager().findFragmentById(R.id.viewListBookOne);
        listBookTwo = (Fragment_line_viewcontroller) getSupportFragmentManager().findFragmentById(R.id.viewListBookTwo);
        listBookThree = (Fragment_line_viewcontroller) getSupportFragmentManager().findFragmentById(R.id.viewListBookThree);
        listBookFor = (Fragment_line_viewcontroller) getSupportFragmentManager().findFragmentById(R.id.viewListBookFor);
        drawerLayout = findViewById(R.id.drawer_layout);
        rcNavi = findViewById(R.id.rc_navi);
        //NavigationView navi = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.tb_Controller);
    }

    private void setupView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(ControllerActivity.this,LinearLayoutManager.VERTICAL,false);
        rcNavi.setLayoutManager(layoutManager);
        ArrayList<CellNavi> listNavi = Strings.lineNavi.getLineNavi();
        adapter = new NaviApdater(this.getLayoutInflater(), listNavi,header);
        adapter.setListened(this);
        rcNavi.setAdapter(adapter);
        ItemOffetsetDecoration itemOffetsetDecoration = new ItemOffetsetDecoration(5);
        rcNavi.addItemDecoration(itemOffetsetDecoration);
        present = new PresenterController(this);
        listBookOne.setTitle(getResources().getString(R.string.math1));
        listBookOne.setListened(this);
        listBookOne.setListenedClick(this);
        listBookTwo.setTitle(getResources().getString(R.string.math2));
        listBookTwo.setListened(this);
        listBookTwo.setListenedClick(this);
        listBookThree.setTitle(getResources().getString(R.string.physical1));
        listBookThree.setListened(this);
        listBookThree.setListenedClick(this);
        listBookFor.setTitle(getResources().getString(R.string.physical2));
        listBookFor.setListened(this);
        listBookFor.setListenedClick(this);
    }

    private void setToolbar(){
        toolbar.setTitle(getResources().getString(R.string.ctct));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.tbnavi);
        }
    }

    private void getData(){
        present.getDataGiaiTich1();
        present.getDataGiaiTich2();
        present.getDataVatLy1();
        present.getDataVatLy2();
        present.getHeader(getToken());
    }

    @Override
    public void clickHeader() {
        Toast.makeText(ControllerActivity.this,"click header",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickLineCell(int position) {
        switch (position){
            case 0:
                Intent intent = new Intent(ControllerActivity.this, ProfileActitivy.class);
                startActivity(intent);
                overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
                break;
            case 4:
                Intent intent3 = new Intent(ControllerActivity.this, SettingActivity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
                break;
            case 1:
                //go to test
//                Intent intent1 = new Intent(ControllerActivity.this, MainActivity.class);
                //go to chocie test
                Intent intent1 = new Intent(ControllerActivity.this, ChoiceTestActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
                break;
        }
    }

    @Override
    public void clickLogout() {
        Toast.makeText(ControllerActivity.this,"click logout",Toast.LENGTH_SHORT).show();
    }

    private String getToken(){
        return getSharedPreferences("data",MODE_PRIVATE).getString("token","");
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_search,menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
//            case R.id.icSeach:
//                startActivity(new Intent(ControllerActivity.this, SearchActivity.class));
//                overridePendingTransition(R.anim.show_view_present,R.anim.hide_view_present);
//                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getDataGiaiTich1Successed(ArrayList<Book> result) {
        listBookOne.setListBook(result);
    }

    @Override
    public void noDataInGiaiTich1() {
        Toast.makeText(ControllerActivity.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectFailed() {
        Toast.makeText(ControllerActivity.this,"Network Failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDataGiaiTich2Successed(ArrayList<Book> result) {
        listBookTwo.setListBook(result);
    }

    @Override
    public void noDataInGiaiTich2() {
        Toast.makeText(ControllerActivity.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDataVatLy1Successed(ArrayList<Book> result) {
        listBookThree.setListBook(result);
    }

    @Override
    public void noDataInVatLy1() {
        Toast.makeText(ControllerActivity.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDataVatLy2Successed(ArrayList<Book> result) {
        listBookFor.setListBook(result);
    }

    @Override
    public void noDataInVatLy2() {
        Toast.makeText(ControllerActivity.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getHeader(ContentHeader header) {
        adapter.setHeader(header);
    }

    @Override
    public void noHeader() {
        Toast.makeText(ControllerActivity.this,"Null",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickSeeAll(View view) {
        Intent intent = new Intent(ControllerActivity.this,SeeAllActivity.class);
        int typeSearch = 0;
        switch (view.getId()){
            case R.id.viewListBookOne:
                typeSearch = TypeSearch.SEARCHGT1.rawValue();
                break;
            case R.id.viewListBookTwo:
                typeSearch = TypeSearch.SEARCHGT2.rawValue();
                break;
            case R.id.viewListBookThree:
                typeSearch = TypeSearch.SEARCHVL1.rawValue();
                break;
            case R.id.viewListBookFor:
                typeSearch = TypeSearch.SEARCHVL2.rawValue();
                break;
        }
        intent.putExtra(Strings.typeSearch,typeSearch);
        startActivity(intent);
        overridePendingTransition(R.anim.show_view_navigation,R.anim.show_view_navigation);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void clickLinePosition(String idBook) {
        Intent intent = new Intent(ControllerActivity.this,BookDetailActivity.class);
        intent.putExtra("id_book",idBook);
        startActivity(intent);
        overridePendingTransition(R.anim.show_view_navigation,R.anim.hide_view_navigation);
    }
}
