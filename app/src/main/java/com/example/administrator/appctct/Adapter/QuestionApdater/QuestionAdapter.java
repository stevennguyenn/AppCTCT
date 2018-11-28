package com.example.administrator.appctct.Adapter.QuestionApdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{
    @NonNull
    private ArrayList<ModelQuestion> listQuestion;
    private LayoutInflater layoutInflater;
    private CheckBoxClick checkBoxClickListened;

    public QuestionAdapter(@NonNull ArrayList<ModelQuestion> listQuestion, Context context){
        this.layoutInflater = LayoutInflater.from(context);
        this.listQuestion = listQuestion;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)  {
        View view = layoutInflater.inflate(R.layout.layout_line_question,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        ModelQuestion modelQuestion = listQuestion.get(i);
        viewHolder.tvContentQuestion.setText(modelQuestion.getContent_question());
        viewHolder.tvQuestionA.setText(modelQuestion.getQuestion_a());
        viewHolder.tvQuestionB.setText(modelQuestion.getQuestion_b());
        viewHolder.tvQuestionC.setText(modelQuestion.getQuestion_c());
        viewHolder.tvQuestionD.setText(modelQuestion.getQuestion_d());
    }

    @Override
    public int getItemCount() {
        return listQuestion.size();
    }
//
//    public void removeItem(int postion){
//        listQuestion.remove(postion);
//        notifyItemRemoved(postion);
//    }

    public void setCheckBoxClickListened(CheckBoxClick checkBoxClickListened){
        this.checkBoxClickListened = checkBoxClickListened;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener{
        TextView tvContentQuestion, tvQuestionA, tvQuestionB, tvQuestionC, tvQuestionD;
        CheckBox rdQuestionA,rdQuestionB,rdQuestionC,rdQuestionD;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContentQuestion =  itemView.findViewById(R.id.tvContentQuestion);
            tvQuestionA =  itemView.findViewById(R.id.tvQuestionA);
            tvQuestionB = itemView.findViewById(R.id.tvQuestionB);
            tvQuestionC = itemView.findViewById(R.id.tvQuestionC);
            tvQuestionD = itemView.findViewById(R.id.tvQuestionD);
            rdQuestionA = itemView.findViewById(R.id.rdQuestionA);
            rdQuestionB = itemView.findViewById(R.id.rdQuestionB);
            rdQuestionC = itemView.findViewById(R.id.rdQuestionC);
            rdQuestionD = itemView.findViewById(R.id.rdQuestionD);
            rdQuestionA.setOnCheckedChangeListener(this);
            rdQuestionB.setOnCheckedChangeListener(this);
            rdQuestionC.setOnCheckedChangeListener(this);
            rdQuestionD.setOnCheckedChangeListener(this);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                switch (buttonView.getId()){
                    case R.id.rdQuestionA:
                        rdQuestionA.setChecked(true);
                        rdQuestionB.setChecked(false);
                        rdQuestionC.setChecked(false);
                        rdQuestionD.setChecked(false);
                        if (checkBoxClickListened != null){
                            checkBoxClickListened.checkboxListened(getAdapterPosition(), "a");
                        }
                        break;
                    case R.id.rdQuestionB:
                        rdQuestionB.setChecked(true);
                        rdQuestionA.setChecked(false);
                        rdQuestionC.setChecked(false);
                        rdQuestionD.setChecked(false);
                        if (checkBoxClickListened != null){
                            checkBoxClickListened.checkboxListened(getAdapterPosition(),"b");
                        }
                        break;
                    case R.id.rdQuestionC:
                        rdQuestionC.setChecked(true);
                        rdQuestionA.setChecked(false);
                        rdQuestionB.setChecked(false);
                        rdQuestionD.setChecked(false);
                        if (checkBoxClickListened != null){
                            checkBoxClickListened.checkboxListened(getAdapterPosition(),"c");
                        }
                        break;
                    case R.id.rdQuestionD:
                        rdQuestionD.setChecked(true);
                        rdQuestionA.setChecked(false);
                        rdQuestionC.setChecked(false);
                        rdQuestionB.setChecked(false);
                        if (checkBoxClickListened != null){
                            checkBoxClickListened.checkboxListened(getAdapterPosition(),"d");
                        }
                        break;
                        default:
                            break;
                }
            }
        }
    }
}
