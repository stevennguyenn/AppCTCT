package com.example.administrator.appctct.Adapter.AdapterRanking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.appctct.Entity.PointRank;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class AdapterRanking extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<PointRank> list;
    private SeeInformationIndividualListened listened;

    public void setListened(SeeInformationIndividualListened listened){
        this.listened = listened;
    }

    public AdapterRanking(LayoutInflater inflater, ArrayList<PointRank> list) {
        this.inflater = inflater;
        this.list = list;
    }

    public void setList(ArrayList<PointRank> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == ViewTopType.ViewImage.getRawValue()){
            view = inflater.inflate(R.layout.line_point_rank_top,viewGroup,false);
            return new HolderPointRankTop(view);
        } else {
            view = inflater.inflate(R.layout.line_point_rank,viewGroup,false);
            return new HolderPointRank(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == ViewTopType.ViewImage.getRawValue()){
            HolderPointRankTop holder = (HolderPointRankTop) viewHolder;
            holder.bind(list.get(i));
            return;
        }
        HolderPointRank holder = (HolderPointRank) viewHolder;
        holder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position<3?ViewTopType.ViewImage.getRawValue():ViewTopType.ViewNumber.getRawValue();
    }

    class HolderPointRank extends RecyclerView.ViewHolder implements View.OnClickListener{
         TextView tvNameRank,tvPointRank,tvNumberRank;
         private String id = "";
         HolderPointRank(@NonNull View itemView) {
            super(itemView);
            tvNameRank = itemView.findViewById(R.id.tvNameRank);
            tvNumberRank = itemView.findViewById(R.id.tvNumberRank);
            tvPointRank = itemView.findViewById(R.id.tvPointRank);
         }

         void bind(PointRank data){
             tvNameRank.setText(data.getFullname());
             tvPointRank.setText(String.valueOf("Points: "+data.getPoint()));
             tvNumberRank.setText(String.valueOf(getAdapterPosition()));
             id = data.getId();
         }

        @Override
        public void onClick(View v) {
            listened.seeInfor(id);
        }
    }

    class HolderPointRankTop extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvNameRank,tvPointRank;
        private String id = "";

         HolderPointRankTop(@NonNull View itemView) {
            super(itemView);
            tvNameRank = itemView.findViewById(R.id.tvNameRankTop);
            tvPointRank = itemView.findViewById(R.id.tvPointRankTop);
            itemView.setOnClickListener(this);
         }

         void bind(PointRank data){
             tvNameRank.setText(data.getFullname());
             tvPointRank.setText(String.valueOf("Points: "+data.getPoint()));
             id = data.getId();
         }

        @Override
        public void onClick(View v) {
            listened.seeInfor(id);
        }
    }
}
