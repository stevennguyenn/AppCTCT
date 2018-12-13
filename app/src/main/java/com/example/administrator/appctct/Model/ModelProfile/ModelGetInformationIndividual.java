package com.example.administrator.appctct.Model.ModelProfile;

import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.Service.APIUtils;
import com.example.administrator.appctct.Service.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGetInformationIndividual {
    private DataClient client = APIUtils.getData();
    private ModelGetInformationIndividualListened listened;

    public  ModelGetInformationIndividual(ModelGetInformationIndividualListened listened) {
        this.listened = listened;
    }

    public void process(String id){
        Call<InformationIndividual> call = client.getInformationIndividual(id);
        call.enqueue(new Callback<InformationIndividual>() {
            @Override
            public void onResponse(Call<InformationIndividual> call, Response<InformationIndividual> response) {
                if (response.body()!= null){
                    listened.getIndiformationIndividualSuccessed(response.body());
                    return;
                }
                listened.informationIndividualNull();
            }

            @Override
            public void onFailure(Call<InformationIndividual> call, Throwable t) {
                listened.connectFailed(t.getMessage());
            }
        });
    }
}
