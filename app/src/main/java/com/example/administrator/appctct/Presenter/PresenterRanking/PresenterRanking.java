package com.example.administrator.appctct.Presenter.PresenterRanking;

import com.example.administrator.appctct.Entity.PointRank;
import com.example.administrator.appctct.Model.ModelRanking.ModelRanking;
import com.example.administrator.appctct.Model.ModelRanking.ModelRankingListened;

import java.util.ArrayList;

public class PresenterRanking implements ModelRankingListened {

    private ModelRanking model = new ModelRanking(this);
    private PresenterRankingListened listened;

    public PresenterRanking(PresenterRankingListened listened) {
        this.listened = listened;
    }

    public void process(String testCode){
        model.process(testCode);
    }

    @Override
    public void getRankingSuccessed(ArrayList<PointRank> list) {
        listened.getRankingSuccessed(list);
    }

    @Override
    public void getRankingNull() {
        listened.getRankingNull();
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
