package com.example.administrator.appctct.Adapter.AdapterBookDetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class AdapterComment extends RecyclerView.Adapter<AdapterComment.HolderComment> {
    private LayoutInflater inflater;
    private ArrayList<BookComment> listComment;

    public AdapterComment(LayoutInflater inflater, ArrayList<BookComment> listComment) {
        this.inflater = inflater;
        this.listComment = listComment;
    }

    public void setListComment(ArrayList<BookComment> listComment){
        this.listComment = listComment;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderComment onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_comment,viewGroup,false);
        return new HolderComment(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderComment holderComment, int i) {
        holderComment.bind(listComment.get(i));
    }

    @Override
    public int getItemCount() {
        return listComment.size();
    }

    class HolderComment extends RecyclerView.ViewHolder{
        ImageView imgAVTComment;
        RatingBar rbRatioBookComment;
        TextView tvNameComment,tvTextComment;
        public HolderComment(@NonNull View itemView) {
            super(itemView);
            imgAVTComment = itemView.findViewById(R.id.imgAVTComment);
            tvNameComment = itemView.findViewById(R.id.tvNameComment);
            tvTextComment = itemView.findViewById(R.id.tvTextComment);
            rbRatioBookComment = itemView.findViewById(R.id.rbRatioBookComment);
        }
        void bind(BookComment data){
            Glide.with(inflater.getContext())
                    .load(data.getImgPerson())
                    .apply(RequestOptions.circleCropTransform())
                    .into(imgAVTComment);
            tvNameComment.setText(data.getNamePerson());
            tvTextComment.setText(data.getComment());
            rbRatioBookComment.setRating(data.getRatio());
        }
    }
}
