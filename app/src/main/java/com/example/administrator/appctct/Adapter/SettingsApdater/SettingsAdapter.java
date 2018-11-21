package com.example.administrator.appctct.Adapter.SettingsApdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class SettingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private LayoutInflater layoutInflater;
    private ArrayList<String> listSettings;

    public SettingsAdapter(LayoutInflater layoutInflater,ArrayList<String> listSettings){
        this.layoutInflater = layoutInflater;
        this.listSettings = listSettings;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       switch (i) {
           case 0:
               View view = layoutInflater.inflate(R.layout.line_setting, viewGroup, false);
               return new ViewHolderLineSetting(view);
           case 1:
               view = layoutInflater.inflate(R.layout.line_logout, viewGroup, false);
               return new ViewHolderLogOut(view);
               default:
                   return  null;
       }
    }

    @Override
    public int getItemViewType(int position) {
        if (position < listSettings.size() - 1){
            return 0;
        }
        return 1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == 0){
            ViewHolderLineSetting view = (ViewHolderLineSetting) viewHolder;
            view.tvTile.setText(listSettings.get(i).toString());
        }
    }

    @Override
    public int getItemCount() {
        return listSettings.size();
    }

    public class ViewHolderLineSetting extends RecyclerView.ViewHolder{
        TextView tvTile;
        public ViewHolderLineSetting(@NonNull View itemView) {
            super(itemView);
            tvTile = itemView.findViewById(R.id.tvLineSetting);
        }
    }

    public class ViewHolderLogOut extends RecyclerView.ViewHolder{
        TextView tvTitle;
        public ViewHolderLogOut(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvLogout);
        }
    }
}
