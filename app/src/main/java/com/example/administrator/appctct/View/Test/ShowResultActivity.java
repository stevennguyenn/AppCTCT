package com.example.administrator.appctct.View.Test;
import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.appctct.R;

public class ShowResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
