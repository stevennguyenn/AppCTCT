package com.example.administrator.appctct.Adapter.AdapterChoiceTest;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.appctct.Adapter.SettingsApdater.SettingsAdapter;
import com.example.administrator.appctct.Entity.Section;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class AdapterChocieTest extends RecyclerView.Adapter<AdapterChocieTest.HolderChoiceTest>{
    private LayoutInflater inflater;
    private ArrayList<Section> listSection;
    private SettingsAdapter adapter;

    public AdapterChocieTest(LayoutInflater inflater,ArrayList<Section> listSection,SettingsAdapter adapter){
        this.inflater = inflater;
        this.listSection = listSection;
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public HolderChoiceTest onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_chocie_test_section,viewGroup,false);
        return new HolderChoiceTest(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderChoiceTest holderChoiceTest, final int i) {
        holderChoiceTest.bind(listSection.get(i));
        LinearLayoutManager manager = new LinearLayoutManager(inflater.getContext(),LinearLayoutManager.VERTICAL,false);
        holderChoiceTest.rcStatusSection.setLayoutManager(manager);
        holderChoiceTest.rcStatusSection.setHasFixedSize(true);
        holderChoiceTest.rcStatusSection.setAdapter(adapter);
        holderChoiceTest.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean expanded = listSection.get(i).getExpanding();
                listSection.get(i).setExpanding(!expanded);
                notifyItemChanged(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSection.size();
    }


    public class HolderChoiceTest extends RecyclerView.ViewHolder{
        TextView tvSection;
        ImageView imgDown;
        RecyclerView rcStatusSection;
        public HolderChoiceTest(@NonNull View itemView) {
            super(itemView);
            tvSection = itemView.findViewById(R.id.tvSection);
            imgDown = itemView.findViewById(R.id.imgDown);
            rcStatusSection = itemView.findViewById(R.id.rcStatusSection);
        }

        public void bind(Section section){
            Boolean expanded = section.getExpanding();
            rcStatusSection.setVisibility(expanded?View.VISIBLE:View.GONE);
            tvSection.setText(section.getName());
        }
    }
}
