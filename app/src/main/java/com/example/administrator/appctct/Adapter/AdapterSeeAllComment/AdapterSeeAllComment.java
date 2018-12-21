package com.example.administrator.appctct.Adapter.AdapterSeeAllComment;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
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
import com.example.administrator.appctct.Fragment.FragmentRate.Fragment_Number_Rate;
import com.example.administrator.appctct.R;

public class AdapterSeeAllComment extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private FragmentManager manager;

    public AdapterSeeAllComment(LayoutInflater inflater, FragmentManager manager){
        this.inflater = inflater;
        this.manager = manager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i){
            case 0:
                view = inflater.inflate(R.layout.line_title_see_all_comment,viewGroup,false);
                return new HolderTitleSeeAllComment(view);
            case 2:
                view = inflater.inflate(R.layout.line_comment_see_all,viewGroup,false);
                return  new HolderComment(view);
                default:
                    view = inflater.inflate(R.layout.line_choice_start_see_all_comment,viewGroup,false);
                    return new HolderChoiceStartSeeAllComment(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0 : (position == 1) ? 1 : 2;
    }

    class HolderTitleSeeAllComment extends RecyclerView.ViewHolder{

         HolderTitleSeeAllComment(@NonNull View itemView) {
            super(itemView);
         }
    }

    class HolderChoiceStartSeeAllComment extends RecyclerView.ViewHolder{

         Fragment_Number_Rate view5Start,view4Start,view3Start,view2Start,view1Start;

         HolderChoiceStartSeeAllComment(@NonNull View itemView) {
            super(itemView);
            view5Start = (Fragment_Number_Rate) manager.findFragmentById(R.id.view5Rate);
            view4Start = (Fragment_Number_Rate) manager.findFragmentById(R.id.view4Rate);
            view3Start = (Fragment_Number_Rate) manager.findFragmentById(R.id.view3Rate);
            view2Start = (Fragment_Number_Rate) manager.findFragmentById(R.id.view2Rate);
            view1Start = (Fragment_Number_Rate) manager.findFragmentById(R.id.view1Rate);
            view4Start.enableView();
            view5Start.enableView();
         }
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
}
