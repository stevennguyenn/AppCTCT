package com.example.administrator.appctct.Adapter.NaviAdapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.appctct.Entity.CellHeader;
import com.example.administrator.appctct.Entity.CellNavi;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class NaviApdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<CellNavi> lisCell;
    private CellHeader header;

    public NaviApdater(LayoutInflater layoutInflater,ArrayList<CellNavi> lisCell,CellHeader header){
        this.layoutInflater = layoutInflater;
        this.lisCell = lisCell;
        this.header = header;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    View view = layoutInflater.inflate(R.layout.header_nav, viewGroup, false);
                    return new ViewHoldHeader(view);
                case 1:
                    view = layoutInflater.inflate(R.layout.line_setting, viewGroup, false);
                    return new ViewHolderCell(view);
                default:
                    view = layoutInflater.inflate(R.layout.line_logout, viewGroup, false);
                    return new ViewHolderLogoutNavi(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final int type = viewHolder.getItemViewType();
        if (type == 0){
            ViewHoldHeader viewHoldHeader = (ViewHoldHeader) viewHolder;
            Glide.with(layoutInflater.getContext())
                    .load(Uri.parse(header.getImg()))
                    .into(viewHoldHeader.imgHeader);
            viewHoldHeader.tvName.setText(header.getName());
            viewHoldHeader.tvPoint.setText(header.getPoints());
            return;
        }

        if (type == 1) {
            ViewHolderCell viewHolderCell = (ViewHolderCell) viewHolder;
            viewHolderCell.tvTile.setText(lisCell.get(i - 1).getTitle());
            return;
        }
    }

    @Override
    public int getItemCount() {
        return lisCell.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 0;
        }
        if(position == lisCell.size() + 1){
            return 2;
        }

        return 1;
    }

    public class ViewHoldHeader extends RecyclerView.ViewHolder {
        ImageView imgHeader;
        TextView tvName,tvPoint;
        ViewHoldHeader(@NonNull View itemView) {
            super(itemView);
            imgHeader = itemView.findViewById(R.id.imgHeader);
            tvName = itemView.findViewById(R.id.tvNameUser);
            tvPoint = itemView.findViewById(R.id.tvPoint);
        }
    }

    public class ViewHolderCell extends RecyclerView.ViewHolder{
        TextView tvTile;
        ViewHolderCell(@NonNull View itemView) {
            super(itemView);
            tvTile = itemView.findViewById(R.id.tvLineSetting);
        }
    }

    public class ViewHolderLogoutNavi extends RecyclerView.ViewHolder{
        TextView tvLogout;
        ViewHolderLogoutNavi(@NonNull View itemView) {
            super(itemView);
            tvLogout = itemView.findViewById(R.id.tvLogout);
        }
    }

}
