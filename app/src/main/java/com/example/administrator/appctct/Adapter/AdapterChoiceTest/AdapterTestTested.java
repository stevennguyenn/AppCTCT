package com.example.administrator.appctct.Adapter.AdapterChoiceTest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.administrator.appctct.Entity.TestTested;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class AdapterTestTested extends RecyclerView.Adapter<AdapterTestTested.HolderTestTested> {
    private LayoutInflater inflater;
    private ArrayList<TestTested> listTest;

    public AdapterTestTested(LayoutInflater inflater,ArrayList<TestTested> listTest){
        this.inflater = inflater;
        this.listTest = listTest;
    }

    public void setListTest(ArrayList<TestTested> listTest){
        this.listTest = listTest;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderTestTested onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_test_tested,viewGroup,false);
        return new HolderTestTested(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderTestTested holderTestTested, int i) {
        holderTestTested.tvNumberTestTested.setText(String.valueOf((holderTestTested.getAdapterPosition()+1)+"."));
        holderTestTested.tvNameTestTested.setText(listTest.get(i).getName());
        holderTestTested.tvPointTestTested.setText(String.valueOf("Point: "+listTest.get(i).getPoint()));
        holderTestTested.tvRateTestTested.setText(String.valueOf("Rate: "+listTest.get(i).getRate()));
        holderTestTested.tvNumberUserTestTested.setText(String.valueOf("Number Test: "+ listTest.get(i).getNumberTest()));
    }

    @Override
    public int getItemCount() {
        return listTest.size();
    }

    class HolderTestTested extends RecyclerView.ViewHolder{
        TextView tvNumberTestTested,tvNameTestTested,tvPointTestTested,tvRateTestTested,tvNumberUserTestTested;
         HolderTestTested(@NonNull View itemView) {
            super(itemView);
            tvNameTestTested = itemView.findViewById(R.id.tvNameTestTested);
            tvNumberTestTested = itemView.findViewById(R.id.tvNumberTestTested);
            tvPointTestTested = itemView.findViewById(R.id.tvPointTestTested);
            tvRateTestTested = itemView.findViewById(R.id.tvRateTestTested);
            tvNumberUserTestTested = itemView.findViewById(R.id.tvNumberUserTestTested);
         }
    }
}
