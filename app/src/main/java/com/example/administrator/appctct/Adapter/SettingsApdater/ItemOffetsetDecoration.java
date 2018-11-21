package com.example.administrator.appctct.Adapter.SettingsApdater;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemOffetsetDecoration extends RecyclerView.ItemDecoration {
    private int mItemOffset;

    public ItemOffetsetDecoration(int mItemOffset){
        this.mItemOffset = mItemOffset;
    }
    
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0,0,0,mItemOffset);
    }
}
