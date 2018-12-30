package com.example.administrator.appctct.View.Profile.fragment_profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.appctct.Adapter.Profile.AdapterInformationIndividual;
import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationIndividual;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetInformationIndividualListened;
import com.example.administrator.appctct.R;

public class fragment_result_tested extends Fragment implements PresenterGetInformationIndividualListened {

//    private int mPage;
//    private String mTitle;
    private RecyclerView rcViewInformationIndividual;
    private AdapterInformationIndividual adapter;
    private PresenterGetInformationIndividual presenter;
    private height heightListened;

    public void setHeightListened(height heightListened){
        this.heightListened = heightListened;
    }

    public fragment_result_tested(){

    }

    public static fragment_result_tested newInstance(int page, String title){
        fragment_result_tested fragment = new fragment_result_tested();
//        Bundle args = new Bundle();
//        args.putInt("page",page);
//        args.putString("title",title);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
//            mPage = getArguments().getInt("page",0);
//            mTitle = getArguments().getString("title");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_tested,container,false);
        rcViewInformationIndividual = view.findViewById(R.id.rcViewInformationIndividual);
        if (getActivity() != null){
            presenter = new PresenterGetInformationIndividual(this);
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
        Log.d("AAAAAA",rcViewInformationIndividual.getHeight()+"");
        heightListened.getHeight(rcViewInformationIndividual.getMeasuredHeight());
    }

    @Override
    public void informationIndividualNull() {

    }

    @Override
    public void connectFailed(String message) {

    }
}

