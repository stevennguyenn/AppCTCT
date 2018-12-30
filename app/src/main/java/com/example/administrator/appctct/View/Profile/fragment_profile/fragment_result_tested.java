package com.example.administrator.appctct.View.Profile.fragment_profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.appctct.Adapter.Profile.AdapterInformationIndividual;
import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationIndividual;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationIndividualListened;
import com.example.administrator.appctct.R;

public class fragment_result_tested extends Fragment implements PresenterGetInformationIndividualListened {

    private AdapterInformationIndividual adapter;

    public fragment_result_tested(){

    }

    public static fragment_result_tested newInstance(){
        return new fragment_result_tested();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_tested,container,false);
        RecyclerView rcViewInformationIndividual = view.findViewById(R.id.rcViewInformationIndividual);
        if (getActivity() != null){
            PresenterGetInformationIndividual presenter = new PresenterGetInformationIndividual(this);
            presenter.process("51");
            LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rcViewInformationIndividual.setLayoutManager(manager);
            adapter = new AdapterInformationIndividual(getLayoutInflater(), new InformationIndividual());
            rcViewInformationIndividual.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void getIndiformationIndividualSuccessed(InformationIndividual info) {
        adapter.setInfo(info);
    }

    @Override
    public void informationIndividualNull() {

    }

    @Override
    public void connectFailed(String message) {

    }
}

