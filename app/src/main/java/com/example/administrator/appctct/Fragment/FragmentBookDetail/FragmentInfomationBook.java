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
import com.example.administrator.appctct.Adapter.AdapterBookDetail.OnLoadMorebookDetail;
import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Entity.BookDetail.BookExtened;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class FragmentInfomationBook extends Fragment implements OnLoadMorebookDetail {
    RecyclerView rcInfomationBook;
    AdapterBookDetail adapter;
    private NotifyOnLoadMore onLoadMore;

    public void setOnLoadMore(NotifyOnLoadMore onLoadMore){
        this.onLoadMore = onLoadMore;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information_book,container,false);
        rcInfomationBook = view.findViewById(R.id.rc_information_book);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcInfomationBook.setLayoutManager(manager);
        if (getLayoutInflater() != null) {
            adapter = new AdapterBookDetail(rcInfomationBook,getActivity().getLayoutInflater(), getActivity().getSupportFragmentManager());
            adapter.setOnLoadMore(this);
            rcInfomationBook.setAdapter(adapter);
        }
        return view;
    }
    public void setBookDetail(BookDetail bookDetail){
        adapter.setBookDetail(bookDetail);
    }

    public void setBookComment(ArrayList<BookComment> listBookComment){
        adapter.setListComment(listBookComment);
    }

    public void setBookExntend(BookExtened bookExntend){
        adapter.setBookExtened(bookExntend);
    }

    @Override
    public void onLoadMoreComment() {
        onLoadMore.onLoadMoreComment();
    }

    @Override
    public void onLoadMoreBookExtened() {
        onLoadMore.onLoadMoreBookExtened();
    }
}
