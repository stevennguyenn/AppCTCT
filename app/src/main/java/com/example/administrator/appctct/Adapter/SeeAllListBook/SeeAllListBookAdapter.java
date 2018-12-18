package com.example.administrator.appctct.Adapter.SeeAllListBook;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.appctct.Adapter.ListBookAdapter.clickItemListBook;
import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SeeAllListBookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<FullBook> listBook;
    private LoadMore loadMore;
    private Boolean isLoading = false;
    private Boolean isHiddenLoadmore = false;
    private clickItemListBook listened;

    public void setListened(clickItemListBook listened) {
        this.listened = listened;
    }

    public void setLoadMore(LoadMore loadMore){
        this.loadMore = loadMore;
    }

    public SeeAllListBookAdapter(RecyclerView rcView, LayoutInflater inflater, final ArrayList<FullBook> listBook) {
        this.inflater = inflater;
        this.listBook = listBook;
        final LinearLayoutManager layoutManager = (LinearLayoutManager) rcView.getLayoutManager();
        rcView.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
               int lastVisible = 0;

               if (layoutManager!= null) {
                   lastVisible = layoutManager.findLastVisibleItemPosition();
               }

               if (!isLoading && lastVisible == listBook.size() - 5){
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
        View view = inflater.inflate(R.layout.line_loading, viewGroup, false);
        return new LoadingViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == TypeSeeAll.Line.rawValue()){
             SeeAllViewHolder seeAllViewHolder = (SeeAllViewHolder) viewHolder;
             seeAllViewHolder.bind(listBook.get(i));
        }
    }

    public void setListBook(ArrayList<FullBook> listBook){
        this.listBook.addAll(listBook);
        notifyDataSetChanged();
    }

    public void hidenLoadMore(){
        isHiddenLoadmore = true;
        isLoading = true;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (isHiddenLoadmore){
            return listBook.size();
        }
        return listBook.size() + 1;
    }


    @Override
    public int getItemViewType(int position) {
        return position < listBook.size() ? TypeSeeAll.Line.rawValue(): TypeSeeAll.Loading.rawValue();
    }

    class LoadingViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout viewLoadMore;
        ProgressBar pbLoading;
        LoadingViewHolder(@NonNull View itemView){
            super(itemView);
            pbLoading = itemView.findViewById(R.id.pbLoading);
            viewLoadMore = itemView.findViewById(R.id.viewLoadMore);
        }
    }

    class SeeAllViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvName,tvAuthor,tvDateupload;
        RatingBar rbRatio;
        SeeAllViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameBook);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvDateupload = itemView.findViewById(R.id.tvDateUpload);
            rbRatio = itemView.findViewById(R.id.rbRatio);
            itemView.setOnClickListener(this);
        }

        void bind(FullBook data){
            tvName.setText(data.getName());
            tvAuthor.setText(data.getAuthor());
            tvDateupload.setText(data.getDateupload());
            rbRatio.setRating(Float.parseFloat(data.getRatio()));
        }

        @Override
        public void onClick(View v) {
            listened.clickItem(listBook.get(getAdapterPosition()).getId());
        }
    }
}
