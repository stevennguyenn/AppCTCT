package com.example.administrator.appctct.Adapter.AdapterRanking;

public enum ViewTopType {
    ViewImage(1),
    ViewNumber(0);

    private int rawValue;

    ViewTopType(int rawValue){
        this.rawValue = rawValue;
    }

    int getRawValue(){
        return this.rawValue;
    }
}
