package com.example.administrator.appctct.Model.ModelRanking;

import com.example.administrator.appctct.Entity.PointRank;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelRanking {

    private ModelRankingListened listened;
    private DataClient client = APIUtils.getData();

    public ModelRanking(ModelRankingListened listened) {
        this.listened = listened;
    }

    public void setListened(ModelRankingListened listened){
        this.listened = listened;
    }

    public void process(String testCode){
        Call<ArrayList<PointRank>> call = client.getTopRaking(testCode);
        call.enqueue(new Callback<ArrayList<PointRank>>() {
            @Override
            public void onResponse(Call<ArrayList<PointRank>> call, Response<ArrayList<PointRank>> response) {
                if (response.body() != null){
                    if (response.body().size()>0){
                        listened.getRankingSuccessed(response.body());
                        return;
                    }
                    listened.getRankingNull();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PointRank>> call, Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
