package com.example.administrator.appctct.Adapter.QuestionApdater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class ShowResultAdapter extends RecyclerView.Adapter<ShowResultAdapter.HolderShowResult> {
    private LayoutInflater inflater;
    private ArrayList<IdAndResult> listResult;

    public ShowResultAdapter(LayoutInflater inflater,ArrayList<IdAndResult> listResult){
        this.inflater = inflater;
        this.listResult = listResult;
    }
    @NonNull
    @Override
    public ShowResultAdapter.HolderShowResult onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.line_show_result_question,viewGroup,false);
        return new HolderShowResult(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderShowResult holderShowResult, int i) {
        holderShowResult.tvNumberResult.setText(String.valueOf((holderShowResult.getAdapterPosition()+1)+"/"));
        if (!listResult.get(i).getResult().equals("") && !listResult.get(i).getContentResult().equals("")) {
            holderShowResult.tvResult.setText(String.valueOf(listResult.get(i).getResult().toUpperCase()+"."));
            holderShowResult.tvContentResult.setText(listResult.get(i).getContentResult());
            return;
        }
        holderShowResult.tvResult.setText(inflater.getContext().getResources().getString(R.string.nochoice));
    }

    @Override
    public int getItemCount() {
        return listResult.size();
    }

    class HolderShowResult extends RecyclerView.ViewHolder{

        TextView tvNumberResult,tvResult,tvContentResult;

        HolderShowResult(@NonNull View itemView) {
            super(itemView);
            tvNumberResult = itemView.findViewById(R.id.tvNumberResult);
            tvResult = itemView.findViewById(R.id.tvResult);
            tvContentResult = itemView.findViewById(R.id.tvContentResult);
        }
    }
}
