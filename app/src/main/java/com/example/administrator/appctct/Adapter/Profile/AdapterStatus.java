package com.example.administrator.appctct.Adapter.Profile;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.appctct.Entity.Profile.Status;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class AdapterStatus extends RecyclerView.Adapter<AdapterStatus.HolderStatus> {

    private LayoutInflater inflater;
    private ArrayList<Status> listStatus;

    public AdapterStatus(LayoutInflater inflater){
        this.inflater = inflater;
    }

    public void setListStatus(ArrayList<Status> listStatus){
        this.listStatus = listStatus;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderStatus onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_status,viewGroup,false);
        return new HolderStatus(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderStatus holderStatus, int i) {
        if (listStatus != null){
            holderStatus.bind(listStatus.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return listStatus == null ? 0 : listStatus.size();
    }

    class HolderStatus extends RecyclerView.ViewHolder{
        TextView tvDateUpLoad,tvContentStatus;
        ImageView imgStatus;
        HolderStatus(@NonNull View itemView) {
            super(itemView);
            tvDateUpLoad = itemView.findViewById(R.id.tvDateStatus);
            tvContentStatus = itemView.findViewById(R.id.tvContentStatus);
            imgStatus = itemView.findViewById(R.id.imgStatus);
        }

        void bind(Status status){
            tvDateUpLoad.setText(status.getDataupload());
            tvContentStatus.setText(status.getContentStatus());
            if (status.getImgStatus() != null){
                Glide.with(inflater.getContext()).load(status.getImgStatus()).into(imgStatus);
                imgStatus.setVisibility(View.VISIBLE);
            } else {
                imgStatus.setVisibility(View.GONE);
            }
        }
    }
}
