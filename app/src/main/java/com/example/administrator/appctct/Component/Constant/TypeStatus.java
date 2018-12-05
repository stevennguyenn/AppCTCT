package com.example.administrator.appctct.Component.Constant;

public enum TypeStatus {
    Online,
    Tested,
    Offline;

    public int rawVlue(){
        switch (this){
            case Online:
                return 0;
            case Tested:
                return 1;
            case Offline:
                return 2;
                default:
                    return -1;
        }
    }
}
