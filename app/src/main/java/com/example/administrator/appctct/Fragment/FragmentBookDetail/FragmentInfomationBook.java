package com.example.administrator.appctct.Fragment.FragmentBookDetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.appctct.Adapter.AdapterBookDetail.AdapterBookDetail;
import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.R;

public class FragmentInfomationBook extends Fragment {
    RecyclerView rcInfomationBook;
    AdapterBookDetail adapterBookDetail;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information_book,container,false);
        rcInfomationBook = view.findViewById(R.id.rc_information_book);
        return view;
    }
    public void setBookDetail(BookDetail bookDetail){
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcInfomationBook.setLayoutManager(manager);
        if (getLayoutInflater() != null) {
            adapterBookDetail = new AdapterBookDetail(getActivity().getLayoutInflater(), bookDetail, getActivity().getSupportFragmentManager());
            rcInfomationBook.setAdapter(adapterBookDetail);
        }
    }
}
