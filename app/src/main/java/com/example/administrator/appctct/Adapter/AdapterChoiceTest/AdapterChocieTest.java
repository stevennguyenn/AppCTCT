package com.example.administrator.appctct.Adapter.AdapterChoiceTest;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Entity.Section;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class AdapterChocieTest extends RecyclerView.Adapter<AdapterChocieTest.HolderChoiceTest>{
    private LayoutInflater inflater;
    private ArrayList<Section> listSection;
    private ChoiceTestListened listened;

    public void setListened(ChoiceTestListened listened){
        this.listened = listened;
    }

    public AdapterChocieTest(LayoutInflater inflater,ArrayList<Section> listSection){
        this.inflater = inflater;
        this.listSection = listSection;
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
         AdapterStatusSections adapter;
         LinearLayoutManager manager;

         HolderChoiceTest(@NonNull View itemView) {
            super(itemView);
            tvSection = itemView.findViewById(R.id.tvSection);
            imgDown = itemView.findViewById(R.id.imgDown);
            adapter = new AdapterStatusSections(inflater,Strings.ListStatusSection.getListStatusSection());
            rcStatusSection = itemView.findViewById(R.id.rcStatusSection);
            manager = new LinearLayoutManager(inflater.getContext(),LinearLayoutManager.VERTICAL,false);
            rcStatusSection.setLayoutManager(manager);
            adapter.setListened(this);
            rcStatusSection.setAdapter(adapter);
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Boolean expanded = listSection.get(getAdapterPosition()).getExpanding();
                     listSection.get(getAdapterPosition()).setExpanding(!expanded);
                     notifyItemChanged(getAdapterPosition());
                 }
             });
        }

         void bind(Section section){
             Boolean expanded = section.getExpanding();
             imgDown.startAnimation(expanded?animationDown:animationUp);
             rcStatusSection.setVisibility(expanded?View.VISIBLE:View.GONE);
             tvSection.setText(section.getName());
         }

         @Override
         public void clickStatusSections(int postion) {
             listened.clickTest(getAdapterPosition(),postion);
         }
     }
}
