package com.example.administrator.appctct.Fragment.FragmentListBook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.appctct.Adapter.ListBookAdapter.ListBookAdapter;
import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class FragmentListBook extends Fragment implements View.OnClickListener{
    TextView tvSeeAll,tvTile;
    RecyclerView rcListBook;
    private LinearLayoutManager layoutManager;
    private ListBookAdapter adapter;
    private ArrayList<Book> listBook;
    private ProcessPragmentListBook listened;

    public void setListened(ProcessPragmentListBook listened){
        this.listened = listened;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_line_viewcontroller,container,false);
        tvSeeAll = view.findViewById(R.id.tvSeeAll);
        tvTile = view.findViewById(R.id.tvTitle);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvSeeAll.setOnClickListener(this);
        rcListBook = view.findViewById(R.id.rcListBook);
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        rcListBook.setLayoutManager(layoutManager);
        rcListBook.setHasFixedSize(true);
        listBook = new ArrayList<>();
        adapter = new ListBookAdapter(getActivity().getLayoutInflater(),listBook);
        rcListBook.setAdapter(adapter);
    }

    public void setupView(String title){
        tvTile.setText(title);
    }

    public void setListBook(ArrayList<Book> listBook){
        adapter.setListBook(listBook);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvSeeAll:
                listened.clickSeeAll(getView());
                break;
        }
    }
}
