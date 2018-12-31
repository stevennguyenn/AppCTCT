package com.example.administrator.appctct.Fragment.FragmentProfile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.appctct.Adapter.Profile.AdapterTestTested;
import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.Entity.PointNameCourse;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationTestTested;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationTestTestedListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class Fragment_test_tested extends Fragment implements PresenterGetInformationTestTestedListened {

    private AdapterTestTested adapter;

    public Fragment_test_tested(){

    }

    public static Fragment_test_tested newInstance(){
        return new Fragment_test_tested();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_tested,container,false);
        RecyclerView rcViewInformationIndividual = view.findViewById(R.id.rcTestTested);
        if (getActivity() != null){
            PresenterGetInformationTestTested presenter = new PresenterGetInformationTestTested(this);
            presenter.process("31");
            LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rcViewInformationIndividual.setLayoutManager(manager);
            adapter = new AdapterTestTested(getLayoutInflater());
            rcViewInformationIndividual.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void getIndiformationIndividualSuccessed(ArrayList<PointNameCourse> data) {
        adapter.setList(data);
    }

    @Override
    public void informationIndividualNull() {

    }

    @Override
    public void connectFailed(String message) {

    }
}

