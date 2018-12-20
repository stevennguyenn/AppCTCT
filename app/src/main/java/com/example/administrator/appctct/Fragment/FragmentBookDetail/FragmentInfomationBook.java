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
import com.example.administrator.appctct.Adapter.AdapterBookDetail.AddComment;
import com.example.administrator.appctct.Adapter.AdapterBookDetail.ClickToSeeDocument;
import com.example.administrator.appctct.Adapter.AdapterBookDetail.OnLoadMorebookDetail;
import com.example.administrator.appctct.Entity.BookDetail.BookDetail;
import com.example.administrator.appctct.Entity.BookDetail.BookExtened;
import com.example.administrator.appctct.Entity.BookDetail.FullBookComment;
import com.example.administrator.appctct.R;

public class FragmentInfomationBook extends Fragment implements OnLoadMorebookDetail,ClickToSeeDocument,AddComment {
    RecyclerView rcInfomationBook;
    AdapterBookDetail adapter;
    private NotifyOnLoadMore onLoadMore;
    private NotifyClickToSeeTheDocument listenedNotifyClickToSeeTheDocument;
    private NotifyAddComment addCommentListened;

    public void setAddCommentListened(NotifyAddComment addCommentListened){
        this.addCommentListened = addCommentListened;
    }

    public void setListenedNotifyClickToSeeTheDocument(NotifyClickToSeeTheDocument listenedNotifyClickToSeeTheDocument){
        this.listenedNotifyClickToSeeTheDocument = listenedNotifyClickToSeeTheDocument;
    }

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
        if (getActivity() != null) {
            adapter = new AdapterBookDetail(rcInfomationBook,getActivity().getLayoutInflater(), getActivity().getSupportFragmentManager());
            adapter.setOnLoadMore(this);
            adapter.setListenedClickToSeeDocument(this);
            adapter.setAddCommentListened(this);
            rcInfomationBook.setAdapter(adapter);
        }
        return view;
    }
    public void setBookDetail(BookDetail bookDetail){
        adapter.setBookDetail(bookDetail);
    }

    public void setBookComment(FullBookComment listBookComment){
        adapter.setComment(listBookComment);
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

    @Override
    public void click(String linkDocument) {
        listenedNotifyClickToSeeTheDocument.click(linkDocument);
    }

    @Override
    public void send() {
        addCommentListened.send();
    }
}
