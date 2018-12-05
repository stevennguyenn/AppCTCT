package com.example.administrator.appctct.Adapter.AdapterChoiceTest;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.administrator.appctct.Entity.Section;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class AdapterChocieTest extends RecyclerView.Adapter<AdapterChocieTest.HolderChoiceTest>{
    private LayoutInflater inflater;
    private ArrayList<Section> listSection;
    private AdapterStatusSections adapter;
    private ChoiceTestListened listened;

    public void setListened(ChoiceTestListened listened){
        this.listened = listened;
    }

    public AdapterChocieTest(LayoutInflater inflater,ArrayList<Section> listSection,AdapterStatusSections adapter){
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
    public void onBindViewHolder(@NonNull final HolderChoiceTest holderChoiceTest, int i) {
        holderChoiceTest.bind(listSection.get(holderChoiceTest.getAdapterPosition()));
        LinearLayoutManager manager = new LinearLayoutManager(inflater.getContext(),LinearLayoutManager.VERTICAL,false);
        holderChoiceTest.rcStatusSection.setLayoutManager(manager);
        holderChoiceTest.rcStatusSection.setHasFixedSize(true);
        holderChoiceTest.rcStatusSection.setAdapter(adapter);
        holderChoiceTest.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean expanded = listSection.get(holderChoiceTest.getAdapterPosition()).getExpanding();
                listSection.get(holderChoiceTest.getAdapterPosition()).setExpanding(!expanded);
                notifyItemChanged(holderChoiceTest.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSection.size();
    }


     class HolderChoiceTest extends RecyclerView.ViewHolder implements ChoiceStatusListened{
         TextView tvSection;
         ImageView imgDown;
         RecyclerView rcStatusSection;
         Animation animationDown = AnimationUtils.loadAnimation(inflater.getContext(),R.anim.rotate_down);
         Animation animationUp = AnimationUtils.loadAnimation(inflater.getContext(),R.anim.rotate_up);
         HolderChoiceTest(@NonNull View itemView) {
            super(itemView);
            tvSection = itemView.findViewById(R.id.tvSection);
            imgDown = itemView.findViewById(R.id.imgDown);
            rcStatusSection = itemView.findViewById(R.id.rcStatusSection);
            adapter.setListened(this);
        }

         void bind(Section section){
             adapter.setListened(this);
             Boolean expanded = section.getExpanding();
             Log.d("BBBB",expanded+"");
             rcStatusSection.setVisibility(expanded?View.VISIBLE:View.GONE);
             imgDown.startAnimation(expanded?animationDown:animationUp);
             tvSection.setText(section.getName());
         }

         @Override
         public void clickStatusSections(int postion) {
             listened.clickTest(getAdapterPosition(),postion);
         }
     }
}
