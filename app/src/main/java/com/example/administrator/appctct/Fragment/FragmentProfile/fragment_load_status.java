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

import com.example.administrator.appctct.Adapter.Profile.AdapterStatus;
import com.example.administrator.appctct.Entity.Profile.Status;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetStatusUser;
import com.example.administrator.appctct.Presenter.PresenterProfile.PresenterGetStatusUserListened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class fragment_load_status extends Fragment implements PresenterGetStatusUserListened {
    private String id;
    private AdapterStatus adapter;

    public fragment_load_status(){

    }

    public static fragment_load_status newInstance(String id){
        fragment_load_status fragment = new fragment_load_status();
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
            id = getArguments().getString("id");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_load_status,container,false);
        RecyclerView rcStatus = view.findViewById(R.id.rcStatus);
        PresenterGetStatusUser presenter = new PresenterGetStatusUser(this);
        presenter.process(id);
        adapter = new AdapterStatus(inflater);
        LinearLayoutManager manager = new LinearLayoutManager(inflater.getContext(),LinearLayoutManager.VERTICAL,false);
        rcStatus.setLayoutManager(manager);
        rcStatus.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void getStatusSuccessed(ArrayList<Status> data) {
        adapter.setListStatus(data);
    }

    @Override
    public void getStatusNull() {

    }

    @Override
    public void connectFailed(String message) {

    }
}
