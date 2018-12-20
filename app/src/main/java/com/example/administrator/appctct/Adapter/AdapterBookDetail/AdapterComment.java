package com.example.administrator.appctct.Adapter.AdapterBookDetail;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
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

public class AdapterComment extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
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

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0:(listComment != null && position == listComment.size())?1:2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i){
            case 1:
                view = inflater.inflate(R.layout.line_comment,viewGroup,false);
                return new HolderComment(view);
            case 0:
                view = inflater.inflate(R.layout.line_comment_first,viewGroup,false);
                return new HolderCommentFirst(view);
                default:
                    view = inflater.inflate(R.layout.line_no_comment,viewGroup,false);
                    return new HolderNoComment(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (listComment.size() > 0) {
            if (viewHolder.getItemViewType() == 1) {
                HolderComment holderBookComment = (HolderComment) viewHolder;
                holderBookComment.bind(listComment.get(i - 1));
            }
        }
    }




    @Override
    public int getItemCount() {
        return listComment.size()==0?2:1+listComment.size();
    }

    class HolderComment extends RecyclerView.ViewHolder{
        ImageView imgAVTComment;
        RatingBar rbRatioBookComment;
        TextView tvNameComment,tvTextComment;
         HolderComment(@NonNull View itemView) {
            super(itemView);
            imgAVTComment = itemView.findViewById(R.id.imgAVTComment);
            tvNameComment = itemView.findViewById(R.id.tvNameComment);
            tvTextComment = itemView.findViewById(R.id.tvTextComment);
            rbRatioBookComment = itemView.findViewById(R.id.rbRatioBookComment);
         }
        void bind(BookComment data){
            Glide.with(inflater.getContext())
                    .load(data.getAvatar())
                    .apply(RequestOptions.circleCropTransform())
                    .into(imgAVTComment);
            tvNameComment.setText(data.getFullName());
            tvTextComment.setText(data.getContentComment());
            rbRatioBookComment.setRating(data.getRatio());
        }
    }

    class HolderCommentFirst extends RecyclerView.ViewHolder{
         RatingBar rbCommentFirstl;
         TextView tvNumberRateCommentFirst,tvNumberPersonCommentFirst,tvSeeAllComment;
         HolderCommentFirst(@NonNull View itemView) {
            super(itemView);
            rbCommentFirstl = itemView.findViewById(R.id.rbRatioBookCommentFirst);
            tvNumberPersonCommentFirst = itemView.findViewById(R.id.tvNumberPersonCommentFirst);
            tvNumberRateCommentFirst = itemView.findViewById(R.id.tvNumberRateCommentFirst);
            tvSeeAllComment = itemView.findViewById(R.id.tvSeeAllCommentFirst);
         }
    }

    class HolderNoComment extends RecyclerView.ViewHolder{
        ConstraintLayout layout;
        HolderNoComment(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.viewNoComment);
        }

        void setInvisible(){
            layout.setVisibility(View.GONE);
        }
    }
}
