package com.example.administrator.appctct.Adapter.AdapterChoiceTest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.appctct.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterStatusSections extends RecyclerView.Adapter<AdapterStatusSections.HolderStatusSections> {
    private LayoutInflater inflater;
    private ArrayList<String> listStatus;
    private ChoiceStatusListened listened;

    public void setListened(ChoiceStatusListened listened){
        this.listened = listened;
    }

    public AdapterStatusSections(LayoutInflater inflater,ArrayList<String> listStatus){
        this.inflater = inflater;
        this.listStatus = listStatus;
    }
    @NonNull
    @Override
    public HolderStatusSections onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_setting,viewGroup,false);
        return new HolderStatusSections(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderStatusSections holderStatusSections, int i) {
        holderStatusSections.tvLineSetting.setText(listStatus.get(i));
    }

    @Override
    public int getItemCount() {
        return listStatus.size();
    }

    public class HolderStatusSections extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvLineSetting;
        HolderStatusSections(@NonNull View itemView) {
            super(itemView);
            tvLineSetting = itemView.findViewById(R.id.tvLineSetting);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listened.clickStatusSections(getAdapterPosition());
        }
    }
}
