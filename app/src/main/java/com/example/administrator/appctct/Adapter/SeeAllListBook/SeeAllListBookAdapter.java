package com.example.administrator.appctct.Adapter.SeeAllListBook;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.appctct.Entity.FullBook;
import com.example.administrator.appctct.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SeeAllListBookAdapter extends RecyclerView.Adapter<SeeAllListBookAdapter.SeeAllViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<FullBook> listBook;

    public SeeAllListBookAdapter(LayoutInflater inflater, ArrayList<FullBook> listBook) {
        this.inflater = inflater;
        this.listBook = listBook;
    }

    @NonNull
    @Override
    public SeeAllViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_see_all,viewGroup,false);
        return new SeeAllViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeeAllViewHolder seeAllViewHolder, int i) {
        seeAllViewHolder.tvName.setText(listBook.get(i).getName());
        seeAllViewHolder.tvAuthor.setText(listBook.get(i).getAuthor());
        seeAllViewHolder.tvDateupload.setText(listBook.get(i).getDateupload());
        seeAllViewHolder.rbRatio.setRating(Float.parseFloat(listBook.get(i).getRatio()));
    }

    public void setListBook(ArrayList<FullBook> listBook){
        this.listBook = listBook;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listBook.size();
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
