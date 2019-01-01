package com.example.administrator.appctct.Component.Custom;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

import com.example.administrator.appctct.R;

public class ConstraintLayoutCustom extends ConstraintLayout {

    private Boolean isEnable = true;

    public ConstraintLayoutCustom(Context context) {
        super(context);
    }

    public ConstraintLayoutCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (isEnable){
            this.setBackground(getResources().getDrawable(R.drawable.background_corner_enable));
            return;
        }
        this.setBackground(getResources().getDrawable(R.drawable.background_corner_disable));
    }

    public Boolean isEnableView(){
        return isEnable;
    }

    public void setEnable(){
        this.isEnable = true;
        requestLayout();
    }

    public void setDisable(){
        this.isEnable = false;
        requestLayout();
    }
}
