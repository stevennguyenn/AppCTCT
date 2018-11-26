package com.example.administrator.appctct.Adapter.SeeAllListBook;

public enum  TypeSeeAll {
    Line,
    Loading;

    public int rawValue(){
        switch (this){
            case Line:
                return 1;
            case Loading:
                return 2;
                default:
                    return 0;
        }
    }
}
