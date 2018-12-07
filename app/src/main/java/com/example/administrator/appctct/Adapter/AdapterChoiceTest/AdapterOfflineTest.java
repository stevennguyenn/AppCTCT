package com.example.administrator.appctct.Adapter.AdapterChoiceTest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.appctct.Entity.TitleSection;
import com.example.administrator.appctct.R;


import java.util.ArrayList;

public class AdapterOfflineTest extends RecyclerView.Adapter<AdapterOfflineTest.HolderOfflineTest> {

    private LayoutInflater inflater;
    private ArrayList<TitleSection> listSection;
    private ClickRecyeOfflineTest listened;

    public void setListened(ClickRecyeOfflineTest listened){
        this.listened = listened;
    }

    public AdapterOfflineTest(LayoutInflater inflater,ArrayList<TitleSection> listSection){
        this.inflater = inflater;
        this.listSection = listSection;
    }

    public void setListSection(ArrayList<TitleSection> listSection){
        this.listSection = listSection;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderOfflineTest onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_section_offline,viewGroup,false);
        return new HolderOfflineTest(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderOfflineTest holderOfflineTest, int i) {
        holderOfflineTest.bind(listSection.get(i));
    }

    @Override
    public int getItemCount() {
        return listSection.size();
    }

    class HolderOfflineTest extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvNumberOfflineTest,tvNameOfflineTest,tvNumberUser;

         HolderOfflineTest(@NonNull View itemView) {
            super(itemView);
            tvNameOfflineTest = itemView.findViewById(R.id.tvNameOfflineTest);
            tvNumberOfflineTest = itemView.findViewById(R.id.tvNumberOfflineTest);
            tvNumberUser = itemView.findViewById(R.id.tvNumberUser);
            itemView.setOnClickListener(this);
        }

        void bind(TitleSection title){
            tvNumberUser.setText(String.valueOf(title.getNumberTest()));
            tvNameOfflineTest.setText(title.getName());
            tvNumberOfflineTest.setText(String.valueOf((getAdapterPosition()+1)+"."));
        }

        @Override
        public void onClick(View v) {
            listened.clickItem(listSection.get(getAdapterPosition()).getTestCode());
        }
    }
}
