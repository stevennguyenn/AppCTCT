package com.example.administrator.appctct.Fragment.FragmentSeeAllListBook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.appctct.Adapter.SeeAllListBook.SeeAllListBookAdapter;
import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class FragmentSellAllListBook extends Fragment implements View.OnClickListener {

    private RecyclerView rcSeeAll;
    private ImageView imgSearch;
    private SeeAllListBookAdapter adapter;
    private ArrayList<FullBook> listBook;
    private int typeSearch = 0;
    private SearchSeeAllListened listened;

    public void setListened(SearchSeeAllListened listened) {
        this.listened = listened;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seeall,container,false);
        rcSeeAll = view.findViewById(R.id.rcSeeAll);
        imgSearch = view.findViewById(R.id.imgSearch);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rcSeeAll.setLayoutManager(layoutManager);
        rcSeeAll.setHasFixedSize(true);
        listBook = new ArrayList<>();
        adapter = new SeeAllListBookAdapter(getLayoutInflater(),listBook);
        rcSeeAll.setAdapter(adapter);
        imgSearch.setOnClickListener(this);
    }

    public void setListBook(ArrayList<FullBook> listBook,int typeSearch){
        adapter.setListBook(listBook);
        this.typeSearch = typeSearch;
    }

    @Override
    public void onClick(View v) {
        listened.clickSearch(typeSearch);
    }
}
