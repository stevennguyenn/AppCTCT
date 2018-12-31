package com.example.administrator.appctct.Model.ModelProfile;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.PointNameCourse;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetInformationTestTested {
    private DataClient client = APIUtils.getData();
    private ModelGetInformationTestTestedListened listened;

    public  ModelGetInformationTestTested(ModelGetInformationTestTestedListened listened) {
        this.listened = listened;
    }

    public void process(String id){
        Call<ArrayList<PointNameCourse>> call = client.getInformationTestTested(id);
        call.enqueue(new Callback<ArrayList<PointNameCourse>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<PointNameCourse>> call,@NonNull Response<ArrayList<PointNameCourse>> response) {
                if (response.body()!= null){
                    listened.getIndiformationIndividualSuccessed(response.body());
                    return;
                }
                listened.informationIndividualNull();
            }

            @Override
            public void onFailure(@NonNull  Call<ArrayList<PointNameCourse>> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
