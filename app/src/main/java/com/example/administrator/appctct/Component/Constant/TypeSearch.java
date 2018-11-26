package com.example.administrator.appctct.Component.Constant;

public enum TypeSearch {
    SEARCHGT1,
    SEARCHGT2,
    SEARCHVL1,
    SEARCHVL2;

    public int rawValue(){
        switch (this){
            case SEARCHGT1:
                return 1;
            case SEARCHGT2:
                return 2;
            case SEARCHVL1:
                return 3;
            case SEARCHVL2:
                return 4;
                default:
                    return 0;
        }
    };
}
