package com.example.administrator.appctct.Adapter.SeeAllListBook;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SeeAllListBookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<FullBook> listBook;
    private LoadMore loadMore;

    public void setLoadMore(LoadMore loadMore){
        this.loadMore = loadMore;
    }

    public SeeAllListBookAdapter(RecyclerView rcView,LayoutInflater inflater, ArrayList<FullBook> listBook) {
        this.inflater = inflater;
        this.listBook = listBook;
        final LinearLayoutManager layoutManager = (LinearLayoutManager) rcView.getLayoutManager();
        rcView.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
               int totalCount = getItemCount();
               int lastVisible = layoutManager.findLastVisibleItemPosition();
               if (lastVisible == totalCount - 2){
                   loadMore.onLoadMore();
               }
            }
        });
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == TypeSeeAll.Line.rawValue()) {
            View view = inflater.inflate(R.layout.line_see_all, viewGroup, false);
            return new SeeAllViewHolder(view);
        }
        View view = inflater.inflate(R.layout.line_loading,viewGroup,false);
        return new LoadingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == TypeSeeAll.Line.rawValue()){
            SeeAllViewHolder seeAllViewHolder = (SeeAllViewHolder) viewHolder;
            seeAllViewHolder.tvName.setText(listBook.get(i).getName());
            seeAllViewHolder.tvAuthor.setText(listBook.get(i).getAuthor());
            seeAllViewHolder.tvDateupload.setText(listBook.get(i).getDateupload());
            seeAllViewHolder.rbRatio.setRating(Float.parseFloat(listBook.get(i).getRatio()));
            return;
        }
    }

    public void setListBook(ArrayList<FullBook> listBook){
        this.listBook.addAll(listBook);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listBook.size() + 1;
    }


    @Override
    public int getItemViewType(int position) {
        return position < listBook.size() ? TypeSeeAll.Line.rawValue(): TypeSeeAll.Loading.rawValue();
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder{
        ProgressBar pbLoading;
        LoadingViewHolder(@NonNull View itemView){
            super(itemView);
            pbLoading = itemView.findViewById(R.id.pbLoading);

        }
    }

    public class SeeAllViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvAuthor,tvDateupload;
        RatingBar rbRatio;
        SeeAllViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameBook);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvDateupload = itemView.findViewById(R.id.tvDateUpload);
            rbRatio = itemView.findViewById(R.id.rbRatio);
        }
    }

}
