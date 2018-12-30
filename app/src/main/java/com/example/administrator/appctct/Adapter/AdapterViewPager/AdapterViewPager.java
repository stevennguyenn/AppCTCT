package com.example.administrator.appctct.Adapter.AdapterViewPager;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


public class AdapterViewPager extends FragmentStatePagerAdapter  {

    private ArrayList<Fragment> listFragment;
    private ArrayList<String> listTitle;

    public void setData(ArrayList<Fragment> listFragment,ArrayList<String> listTitle){
        this.listFragment = listFragment;
        this.listTitle = listTitle;
        notifyDataSetChanged();
    }

    public AdapterViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment;
        fragment = listFragment.get(i);
        return fragment;
    }

    @Override
    public int getCount() {
        if (listFragment != null) {
            return listFragment.size();
        }
        return 0;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (listTitle != null) {
            return listTitle.get(position);
        }
        return "";
    }
}
