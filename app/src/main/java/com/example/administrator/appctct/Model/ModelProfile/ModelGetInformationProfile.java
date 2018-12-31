package com.example.administrator.appctct.Model.ModelProfile;

import android.support.annotation.NonNull;

import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.Entity.InformationProfile;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetInformationProfile {
    private DataClient client = APIUtils.getData();
    private ModelGetInformationProfileListened listened;

    public  ModelGetInformationProfile(ModelGetInformationProfileListened listened) {
        this.listened = listened;
    }

    public void process(String id){
        Call<InformationProfile> call = client.getInformationProfile(id);
        call.enqueue(new Callback<InformationProfile>() {
            @Override
            public void onResponse(@NonNull Call<InformationProfile> call, @NonNull Response<InformationProfile> response) {
                if (response.body()!= null){
                    listened.getInformationProfileSuccessed(response.body());
                    return;
                }
                listened.informationIndividualNull();
            }

            @Override
            public void onFailure(@NonNull  Call<InformationProfile> call,@NonNull Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
