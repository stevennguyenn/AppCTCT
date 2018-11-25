package com.example.administrator.appctct.Adapter.ListBookAdapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.appctct.Entity.Book;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class ListBookAdapter extends RecyclerView.Adapter<ListBookAdapter.ViewHolderBook>  {
    private LayoutInflater inflater;
    private ArrayList<Book> listBook;

    public ListBookAdapter(LayoutInflater inflater,ArrayList<Book> listBook){
        this.inflater = inflater;
        this.listBook = listBook;
    }

    public void setListBook(ArrayList<Book> listBook){
        this.listBook = listBook;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListBookAdapter.ViewHolderBook onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_list_book,viewGroup,false);
        return new ViewHolderBook(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListBookAdapter.ViewHolderBook viewHolder, int i) {
        viewHolder.tvNameBook.setText(listBook.get(i).getNameBook());
        viewHolder.tvRatio.setText("Rate: "+listBook.get(i).getRatioBook());
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public class ViewHolderBook extends RecyclerView.ViewHolder{
        TextView tvNameBook, tvRatio;
        ViewHolderBook(@NonNull View itemView) {
            super(itemView);
            tvNameBook = itemView.findViewById(R.id.tvNameBook);
            tvRatio = itemView.findViewById(R.id.tvRatio);
        }
    }

}
