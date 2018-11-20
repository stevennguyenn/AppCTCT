package com.example.administrator.appctct.View;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.appctct.R;

import java.io.File;

public class PDFReaderActivity extends AppCompatActivity {

    String webUrl = "https://www.ets.org/Media/Tests/GRE/pdf/gre_research_validity_data.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        WebView wvPDF = new WebView(PDFReaderActivity.this);
//        wvPDF.getSettings().setJavaScriptEnabled(true);
//        wvPDF.loadUrl("http://docs.google.com/gview?embedded=true&url=" + webUrl);
//        setContentView(wvPDF);
        setContentView(R.layout.activity_pdfreader);
        File file = new File("/Download/gre_research_validity_data.pdf");
        //Log.d("AAAA",Environment.getExternalStorageDirectory().getAbsolutePath() + "/gre_research_validity_data.pdf");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent target = Intent.createChooser(intent, "Open File");
        try {
            startActivity(target);
        } catch (ActivityNotFoundException e) {
            // Instruct the user to install a PDF reader here, or something
        }


    }
}
