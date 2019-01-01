package com.example.administrator.appctct.Adapter.NaviAdapter;

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
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.appctct.Entity.CellNavi;
import com.example.administrator.appctct.Entity.ContentHeader;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class NaviApdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<CellNavi> lisCell;
    private ContentHeader header;
    private ClickNaviItem listened;

    public void setListened(ClickNaviItem listened) {
        this.listened = listened;
    }

    public void setHeader(ContentHeader header){
        this.header = header;
        notifyDataSetChanged();
    }

    public NaviApdater(LayoutInflater layoutInflater, ArrayList<CellNavi> lisCell, ContentHeader header){
        this.layoutInflater = layoutInflater;
        this.lisCell = lisCell;
        this.header = header;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    View view = layoutInflater.inflate(R.layout.line_header_nav, viewGroup, false);
                    return new ViewHoldHeader(view);
                case 1:
                    view = layoutInflater.inflate(R.layout.line_in_navigationview, viewGroup, false);
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
            Log.d("BBB",header.getAvatar());
            ViewHoldHeader viewHoldHeader = (ViewHoldHeader) viewHolder;
            Glide.with(layoutInflater.getContext())
                        .load(Uri.parse(header.getAvatar()))
                        .apply(RequestOptions.circleCropTransform())
                        .into(viewHoldHeader.imgHeader);
            viewHoldHeader.tvName.setText(header.getFullname());
            viewHoldHeader.tvPoint.setText(header.getPoints());
        }

        if (type == 1) {
            ViewHolderCell viewHolderCell = (ViewHolderCell) viewHolder;
            viewHolderCell.tvTile.setText(lisCell.get(i - 1).getTitle());
            viewHolderCell.imgIconNavi.setImageResource(lisCell.get(i-1).getImg());
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

    public class ViewHoldHeader extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgHeader;
        TextView tvName,tvPoint;
        ViewHoldHeader(@NonNull View itemView) {
            super(itemView);
            imgHeader = itemView.findViewById(R.id.imgHeader);
            tvName = itemView.findViewById(R.id.tvNameUser);
            tvPoint = itemView.findViewById(R.id.tvPoint);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listened.clickHeader();
        }
    }

    public class ViewHolderCell extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvTile;
        ImageView imgIconNavi;
        ViewHolderCell(@NonNull View itemView) {
            super(itemView);
            tvTile = itemView.findViewById(R.id.lbTitleNavi);
            imgIconNavi = itemView.findViewById(R.id.imgIconNavi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listened.clickLineCell(getAdapterPosition()-1);
        }
    }

    public class ViewHolderLogoutNavi extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvLogout;
        ViewHolderLogoutNavi(@NonNull View itemView) {
            super(itemView);
            tvLogout = itemView.findViewById(R.id.tvLogout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listened.clickLogout();
        }
    }

}
