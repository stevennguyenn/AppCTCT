package com.example.administrator.appctct.Adapter.SearchBookAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SearchBookAdapter extends RecyclerView.Adapter<SearchBookAdapter.SearchBookViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Book> listBook;

    public  SearchBookAdapter(LayoutInflater inflater,ArrayList<Book> listBook){
        this.inflater = inflater;
        this.listBook = listBook;
    }

    public void setListBook(ArrayList<Book> listBook){
        this.listBook = listBook;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchBookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_search,viewGroup,false);
        return new SearchBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchBookViewHolder searchBookViewHolder, int i) {
        searchBookViewHolder.tvTitleSearch.setText("Book Name: " + listBook.get(i).getNameBook());
        searchBookViewHolder.tvRatioSearch.setText("Rate: "+listBook.get(i).getRatioBook());
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    class SearchBookViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitleSearch,tvRatioSearch;
        SearchBookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitleSearch = itemView.findViewById(R.id.tvTitleSearch);
            tvRatioSearch = itemView.findViewById(R.id.tvRatioSearch);
        }
    }


}
