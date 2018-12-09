package com.example.administrator.appctct.Presenter.PresenterRanking;

import com.example.administrator.appctct.Entity.PointRank;

import java.util.ArrayList;

public interface PresenterRankingListened {
    void getRankingSuccessed(ArrayList<PointRank> list);
    void getRankingNull();
    void connectFailed(String message);
}
