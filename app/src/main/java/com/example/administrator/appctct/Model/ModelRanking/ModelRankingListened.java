package com.example.administrator.appctct.Model.ModelRanking;

import android.graphics.Point;

import com.example.administrator.appctct.Entity.PointRank;

import java.util.ArrayList;

public interface ModelRankingListened {
    void getRankingSuccessed(ArrayList<PointRank> list);
    void getRankingNull();
    void connectFailed(String message);
}
