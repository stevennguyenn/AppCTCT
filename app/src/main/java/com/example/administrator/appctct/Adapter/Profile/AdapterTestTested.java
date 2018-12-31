package com.example.administrator.appctct.Adapter.Profile;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.appctct.Entity.PointNameCourse;
import com.example.administrator.appctct.R;
import java.util.ArrayList;


public class AdapterTestTested extends RecyclerView.Adapter<AdapterTestTested.HolderTestTested> {
    private ArrayList<PointNameCourse> list;
    private LayoutInflater inflater;

    public AdapterTestTested(LayoutInflater inflater){
        this.inflater = inflater;
    }

    public void setList(ArrayList<PointNameCourse> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderTestTested onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_three_individual,viewGroup,false);
        return new HolderTestTested(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderTestTested holderTestTested, int i) {
        if (list != null){
            holderTestTested.bind(list.get(i));
            return;
        }
        holderTestTested.dataNull();
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 1;
    }

    class HolderTestTested extends RecyclerView.ViewHolder{

        ImageView imgIconInformationIndividual;
        TextView tvNameCourseIndividual,tvPointIndividual,tvNoInformationIndividual;
        HolderTestTested(@NonNull View itemView) {
            super(itemView);
            tvNameCourseIndividual = itemView.findViewById(R.id.tvNameCourseIndividual);
            tvPointIndividual = itemView.findViewById(R.id.tvPointIndividual);
            imgIconInformationIndividual = itemView.findViewById(R.id.imgIconNotificationIndividual);
            tvNoInformationIndividual = itemView.findViewById(R.id.tvNoInformationIndividual);
        }

        void bind(PointNameCourse data){
            imgIconInformationIndividual.setVisibility(View.VISIBLE);
            tvNameCourseIndividual.setVisibility(View.VISIBLE);
            tvPointIndividual.setVisibility(View.VISIBLE);
            tvNoInformationIndividual.setVisibility(View.INVISIBLE);
            tvNameCourseIndividual.setText(String.valueOf("Name Course: "+ data.getName()));
            tvPointIndividual.setText(String.valueOf("Point: "+data.getPoint()));
        }

        void dataNull(){
            imgIconInformationIndividual.setVisibility(View.INVISIBLE);
            tvNameCourseIndividual.setVisibility(View.INVISIBLE);
            tvPointIndividual.setVisibility(View.INVISIBLE);
            tvNoInformationIndividual.setVisibility(View.VISIBLE);
        }
    }
}
