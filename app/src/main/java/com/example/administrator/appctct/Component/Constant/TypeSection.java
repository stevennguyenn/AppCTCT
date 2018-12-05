package com.example.administrator.appctct.Component.Constant;

public enum TypeSection {
    GT1,
    GT2,
    VL1,
    VL2;

    public int rawValue(){
        switch (this){
            case GT1:
                return 0;
            case GT2:
                return 1;
            case VL1:
                return 2;
            case VL2:
                return 3;
                default:
                    return -1;
        }
    }

}
