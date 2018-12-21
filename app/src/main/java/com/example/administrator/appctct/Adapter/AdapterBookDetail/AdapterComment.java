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
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.BookDetail.FullBookComment;
import com.example.administrator.appctct.Entity.BookDetail.TitleComment;
import com.example.administrator.appctct.R;


public class AdapterComment extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private FullBookComment comment;
    private ClickSeeAllComment clickSeeAllCommentListened;

    public  void setClickSeeAllCommentListened(ClickSeeAllComment clickSeeAllCommentListened){
        this.clickSeeAllCommentListened = clickSeeAllCommentListened;
    }

    AdapterComment(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setComment(FullBookComment comment){
        this.comment = comment;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0 : (comment.getListComment() != null && position <= comment.getListComment().size()) ? 1 : 2;
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

        if (viewHolder.getItemViewType() == 1){
            if (comment != null && comment.getListComment().size() > 0){
                HolderComment holderBookComment = (HolderComment) viewHolder;
                holderBookComment.bind(comment.getListComment().get(i - 1));
            }
        }

        if (viewHolder.getItemViewType() == 0) {
            if (comment.getTitleComment().getMessage().equals(Strings.successed)) {
                HolderCommentFirst holderCommentFirst = (HolderCommentFirst) viewHolder;
                holderCommentFirst.bind(comment.getTitleComment());
            }
        }
    }




    @Override
    public int getItemCount() {
        if (comment != null) {
            return comment.getListComment().size() == 0 ? 2 : 1 + comment.getListComment().size();
        }
        return 2;
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

    class HolderCommentFirst extends RecyclerView.ViewHolder implements View.OnClickListener{
         RatingBar rbCommentFirst;
         TextView tvNumberRateCommentFirst,tvNumberPersonCommentFirst,tvSeeAllComment;
         HolderCommentFirst(@NonNull View itemView) {
            super(itemView);
            rbCommentFirst = itemView.findViewById(R.id.rbRatioBookCommentFirst);
            tvNumberPersonCommentFirst = itemView.findViewById(R.id.tvNumberPersonCommentFirst);
            tvNumberRateCommentFirst = itemView.findViewById(R.id.tvNumberRateCommentFirst);
            tvSeeAllComment = itemView.findViewById(R.id.tvSeeAllCommentFirst);
            tvSeeAllComment.setOnClickListener(this);
         }

         void bind(TitleComment data){
             rbCommentFirst.setRating(data.getAvgRate());
             tvNumberRateCommentFirst.setText(String.valueOf(data.getAvgRate()));
             tvNumberPersonCommentFirst.setText(String.valueOf("(" +data.getNumberRate()+")"));
         }

        @Override
        public void onClick(View v) {
            clickSeeAllCommentListened.clickSeeAllComment();
        }
    }

    class HolderNoComment extends RecyclerView.ViewHolder{
//        ConstraintLayout layout;
        HolderNoComment(@NonNull View itemView) {
            super(itemView);
//            layout = itemView.findViewById(R.id.viewNoComment);
        }
    }
}
