package com.example.administrator.appctct.Adapter.AdapterSeeAllComment;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.appctct.Entity.BookDetail.BookComment;
import com.example.administrator.appctct.Entity.RateBook.DetailRateNum;
import com.example.administrator.appctct.Entity.RateBook.TitleCommentSeeAll;
import com.example.administrator.appctct.Fragment.FragmentRate.ClickFragmentRate;
import com.example.administrator.appctct.Fragment.FragmentRate.Fragment_Number_Rate;
import com.example.administrator.appctct.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AdapterSeeAllComment extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private FragmentManager manager;
    private TitleCommentSeeAll titleCommentSeeAll;
    private OnLoadMoreComment loadMoreCommentListened;
    private Boolean isLoadMore = false;
    private ArrayList<BookComment> listComment;
    private LoadCommentForRate loadCommentForRateLisntened;

    public void setLoadCommentForRateLisntened(LoadCommentForRate loadCommentForRateLisntened){
        this.loadCommentForRateLisntened = loadCommentForRateLisntened;
    }

    public void setLoadMoreCommentListened(OnLoadMoreComment loadMoreCommentListened){
        this.loadMoreCommentListened = loadMoreCommentListened;
    }

    public void setListComment(ArrayList<BookComment> listComment){
        if (this.listComment == null){
            this.listComment = listComment;
        } else {
            this.listComment.addAll(listComment);
        }
        notifyDataSetChanged();
    }

    public AdapterSeeAllComment(RecyclerView recyclerView, LayoutInflater inflater, final FragmentManager manager){
        this.inflater = inflater;
        this.manager = manager;
        final LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (layoutManager != null){
                    int itemCount = layoutManager.getItemCount();
                    int lastVisible = layoutManager.findLastVisibleItemPosition();

                    if (!isLoadMore && lastVisible >= itemCount - 2 && listComment!=null){
                        loadMoreCommentListened.loadMoreComment();
                    }
                }
            }
        });
    }

    public void setNoLoadMore(){
        this.isLoadMore = true;
    }

    public void setTitleCommentSeeAll(TitleCommentSeeAll titleCommentSeeAll){
        this.titleCommentSeeAll = titleCommentSeeAll;
        notifyDataSetChanged();
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
        switch (viewHolder.getItemViewType()){
            case 0:
                if (titleCommentSeeAll != null){
                    HolderTitleSeeAllComment holderTitleSeeAllComment = (HolderTitleSeeAllComment) viewHolder;
                    holderTitleSeeAllComment.bind(titleCommentSeeAll);
                }
                break;
            case 1:
                if (titleCommentSeeAll!= null){
                    HolderChoiceStartSeeAllComment holderChoiceStartSeeAllComment = (HolderChoiceStartSeeAllComment) viewHolder;
                    holderChoiceStartSeeAllComment.bind(titleCommentSeeAll.getDetailRateNum());
                }
                break;
                default:
                    if (listComment != null){
                        HolderComment holderComment = (HolderComment) viewHolder;
                        holderComment.bind(listComment.get(i-2));
                    }
                    break;
        }
    }

    @Override
    public int getItemCount() {
        return (listComment == null)? 2 : 2 + listComment.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0 : (position == 1) ? 1 : 2;
    }

    class HolderTitleSeeAllComment extends RecyclerView.ViewHolder{
        TextView tvRatingSeeAllComment,tvNumberPersonRate,tbNumerRate5Start,tbNumerRate4Start,tbNumerRate3Start,tbNumerRate2Start,tbNumerRate1Start;
        RatingBar rbRatioBookSeeAllComment;
        ProgressBar pbRate5Start,pbRate4Start,pbRate3Start,pbRate2Start,pbRate1Start;

        HolderTitleSeeAllComment(@NonNull View itemView) {
            super(itemView);
            tvNumberPersonRate = itemView.findViewById(R.id.tvNumberPersonRate);
            tvRatingSeeAllComment = itemView.findViewById(R.id.tvRatingSeeAllComment);
            rbRatioBookSeeAllComment = itemView.findViewById(R.id.rbRatioBookSeeAllComment);
            pbRate5Start = itemView.findViewById(R.id.pbRate5Start);
            pbRate4Start = itemView.findViewById(R.id.pbRate4Start);
            pbRate3Start = itemView.findViewById(R.id.pbRate3Start);
            pbRate2Start = itemView.findViewById(R.id.pbRate2Start);
            pbRate1Start = itemView.findViewById(R.id.pbRate1Start);
            tbNumerRate5Start = itemView.findViewById(R.id.tbNumerRate5Start);
            tbNumerRate4Start = itemView.findViewById(R.id.tbNumerRate4Start);
            tbNumerRate3Start = itemView.findViewById(R.id.tbNumerRate3Start);
            tbNumerRate2Start = itemView.findViewById(R.id.tbNumerRate2Start);
            tbNumerRate1Start = itemView.findViewById(R.id.tbNumerRate1Start);
         }

         void bind(TitleCommentSeeAll data){
            tvNumberPersonRate.setText(String.valueOf(data.getRateNum().getNumberRate() + " Person"));
            tvRatingSeeAllComment.setText(String.valueOf(data.getRateNum().getRatio()));
            rbRatioBookSeeAllComment.setRating(data.getRateNum().getRatio());
            pbRate5Start.setProgress((int)data.getDetailRateNum().getRatio5());
            pbRate4Start.setProgress((int)data.getDetailRateNum().getRatio4());
            pbRate3Start.setProgress((int)data.getDetailRateNum().getRatio3());
            pbRate2Start.setProgress((int)data.getDetailRateNum().getRatio2());
            pbRate1Start.setProgress((int)data.getDetailRateNum().getRatio1());
            tbNumerRate5Start.setText(String.valueOf((int)data.getDetailRateNum().getRatio5()));
            tbNumerRate4Start.setText(String.valueOf((int)data.getDetailRateNum().getRatio4()));
            tbNumerRate3Start.setText(String.valueOf((int)data.getDetailRateNum().getRatio3()));
            tbNumerRate2Start.setText(String.valueOf((int)data.getDetailRateNum().getRatio2()));
            tbNumerRate1Start.setText(String.valueOf((int)data.getDetailRateNum().getRatio1()));
         }
    }

    class HolderChoiceStartSeeAllComment extends RecyclerView.ViewHolder implements ClickFragmentRate {

         Fragment_Number_Rate view5Start,view4Start,view3Start,view2Start,view1Start;
         Boolean view5isEnabled = false,view4isEnabled= false,view3isEnabled= false,view2isEnabled= false,view1isEnabled= false;

         HolderChoiceStartSeeAllComment(@NonNull View itemView) {
            super(itemView);
            view5Start = (Fragment_Number_Rate) manager.findFragmentById(R.id.view5Rate);
            view4Start = (Fragment_Number_Rate) manager.findFragmentById(R.id.view4Rate);
            view3Start = (Fragment_Number_Rate) manager.findFragmentById(R.id.view3Rate);
            view2Start = (Fragment_Number_Rate) manager.findFragmentById(R.id.view2Rate);
            view1Start = (Fragment_Number_Rate) manager.findFragmentById(R.id.view1Rate);
            view5Start.setTitle("5");
            view4Start.setTitle("4");
            view3Start.setTitle("3");
            view2Start.setTitle("2");
            view1Start.setTitle("1");
            view5Start.setListened(this);
            view4Start.setListened(this);
            view2Start.setListened(this);
            view3Start.setListened(this);
            view1Start.setListened(this);
         }

         void processButton(final int id){
             new Handler().post(new Runnable() {
                 @Override
                 public void run() {
                     int rate = 0;
                     switch (id){
                         case R.id.view5Rate:
                             rate = 5;
                             if (view4isEnabled){
                                 view4Start.setDidChoice();
                                 view4Start.resetClick();
                             }
                             if (view3isEnabled){
                                 view3Start.setDidChoice();
                                 view3Start.resetClick();
                             }
                             if (view2isEnabled){
                                 view2Start.setDidChoice();
                                 view2Start.resetClick();
                             }
                             if (view1isEnabled) {
                                 view1Start.setDidChoice();
                                 view1Start.resetClick();
                             }
                             break;
                         case R.id.view4Rate:
                             rate = 4;
                             if (view5isEnabled){
                                 view5Start.setDidChoice();
                                 view5Start.resetClick();
                             }
                             if (view3isEnabled){
                                 view3Start.setDidChoice();
                                 view3Start.resetClick();
                             }
                             if (view2isEnabled){
                                 view2Start.setDidChoice();
                                 view2Start.resetClick();
                             }
                             if (view1isEnabled) {
                                 view1Start.setDidChoice();
                                 view1Start.resetClick();
                             }
                             break;
                         case R.id.view3Rate:
                             rate = 3;
                             if (view5isEnabled){
                                 view5Start.setDidChoice();
                                 view5Start.resetClick();
                             }
                             if (view4isEnabled){
                                 view4Start.setDidChoice();
                                 view4Start.resetClick();
                             }
                             if (view2isEnabled){
                                 view2Start.setDidChoice();
                                 view2Start.resetClick();
                             }
                             if (view1isEnabled) {
                                 view1Start.setDidChoice();
                                 view1Start.resetClick();
                             }
                             break;
                         case R.id.view2Rate:
                             rate = 2;
                             if (view5isEnabled){
                                 view5Start.setDidChoice();
                                 view5Start.resetClick();
                             }
                             if (view3isEnabled){
                                 view3Start.setDidChoice();
                                 view3Start.resetClick();
                             }
                             if (view4isEnabled){
                                 view4Start.setDidChoice();
                                 view4Start.resetClick();
                             }
                             if (view1isEnabled) {
                                 view1Start.setDidChoice();
                                 view1Start.resetClick();
                             }
                             break;
                         case R.id.view1Rate:
                             rate = 1;
                             if (view5isEnabled){
                                 view5Start.setDidChoice();
                                 view5Start.resetClick();
                             }
                             if (view3isEnabled){
                                 view3Start.setDidChoice();
                                 view3Start.resetClick();
                             }
                             if (view2isEnabled){
                                 view2Start.setDidChoice();
                                 view2Start.resetClick();
                             }
                             if (view4isEnabled) {
                                 view4Start.setDidChoice();
                                 view4Start.resetClick();
                             }
                             break;
                             default:
                                 break;
                     }
                     listComment.clear();
                     loadCommentForRateLisntened.loadComment(rate);
                 }
             });
         }

         void bind(DetailRateNum data){
             if (data.getRatio5() > 0){
                 view5Start.enableView();
                 view5isEnabled = true;
                 view5Start.isEnable = true;
             }
             if (data.getRatio4() > 0){
                 view4Start.enableView();
                 view4isEnabled = true;
                 view4Start.isEnable = true;
             }
             if (data.getRatio3() > 0){
                 view3Start.enableView();
                 view3isEnabled = true;
                 view3Start.isEnable = true;

             }
             if (data.getRatio2() > 0){
                 view2Start.enableView();
                 view2isEnabled = true;
                 view2Start.isEnable = true;

             }
             if (data.getRatio1() > 0){
                 view1Start.enableView();
                 view1isEnabled = true;
                 view1Start.isEnable = true;
             }
         }

        @Override
        public void ClickFragment(int id) {
            processButton(id);
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
