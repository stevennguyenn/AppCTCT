package com.example.administrator.appctct.Fragment.FragmentButton;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Handler;
import com.example.administrator.appctct.R;

public class fragment_button extends Fragment implements View.OnClickListener{
    private Button btButton;
    private ClickButton listened;
    final Handler handler = new Handler();
    private CountDownTimer timer;
    private int count = 0;
    private TimeEnd timeEndListened;

    public void setTimeEndListened(TimeEnd timeEndListened){
        this.timeEndListened = timeEndListened;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button_ctct,container,false);
        btButton = view.findViewById(R.id.btButton);
        btButton.setOnClickListener(this);
        return view;
    }

    public void setRegister(ClickButton listened){
        this.listened = listened;
    }

    public void setTitleButton(String title){
        btButton.setText(title);
    }

    public void setButtonFacebook(){
        btButton.setBackground(getResources().getDrawable(R.drawable.custom_button_facebook));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btButton:
                listened.clickView(getView());
                break;
                default:
                    break;
        }
    }

    public void setButtonDisable(){
        btButton.setEnabled(false);
    }

    public void setButtonVisible(){
        btButton.setEnabled(true);
    }

    public void timeTest(final int time){
        btButton.setEnabled(false);
        timer = new CountDownTimer(time+2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        countTime();
                    }
                });
            }

            @Override
            public void onFinish() {
                timeEndListened.timeEnd();
                btButton.setText(getResources().getString(R.string.endtime));
            }
        };
        timer.start();
    }

    public void cancelTimer(){
        if (timer != null){
            timer.cancel();
            timer = null;
        }
    }

    private void countTime(){
        int min = count/1000/60;
        int mili = count/1000%60;
        String sMin = min < 10 ? "0" + min : min + "";
        String sMili = mili<10 ? "0" + mili : mili + "";
        btButton.setText(String.valueOf(sMin + ":" + sMili));
        count += 1000;
    }
}


