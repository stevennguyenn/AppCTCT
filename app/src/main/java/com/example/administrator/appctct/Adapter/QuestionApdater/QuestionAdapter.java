package com.example.administrator.appctct.Adapter.QuestionApdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{
    @NonNull
    private ArrayList<ModelQuestion> listQuestion;
    private LayoutInflater layoutInflater;
    private CheckBoxClick checkBoxClickListened;
    private Animation start,end,rotate_down,rotate_up;

    public QuestionAdapter(@NonNull ArrayList<ModelQuestion> listQuestion, Context context){
        this.layoutInflater = LayoutInflater.from(context);
        this.listQuestion = listQuestion;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)  {
        View view = layoutInflater.inflate(R.layout.layout_line_question,viewGroup,false);
        start = AnimationUtils.loadAnimation(layoutInflater.getContext(),R.anim.slide_down);
        end = AnimationUtils.loadAnimation(layoutInflater.getContext(),R.anim.slide_up);
        rotate_down = AnimationUtils.loadAnimation(layoutInflater.getContext(),R.anim.rotate_down);
        rotate_up = AnimationUtils.loadAnimation(layoutInflater.getContext(),R.anim.rotate_up);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        ModelQuestion modelQuestion = listQuestion.get(i);
        viewHolder.tvNumberQuestion.setText(String.valueOf("Question "+(i+1)+":"));
        viewHolder.tvContentQuestion.setText(modelQuestion.getContent_question());
        viewHolder.tvQuestionA.setText(modelQuestion.getQuestion_a());
        viewHolder.tvQuestionB.setText(modelQuestion.getQuestion_b());
        viewHolder.tvQuestionC.setText(modelQuestion.getQuestion_c());
        viewHolder.tvQuestionD.setText(modelQuestion.getQuestion_d());
        viewHolder.imgText.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        return listQuestion.size();
    }

    public void setCheckBoxClickListened(CheckBoxClick checkBoxClickListened){
        this.checkBoxClickListened = checkBoxClickListened;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener, View.OnClickListener{
        TextView tvContentQuestion, tvQuestionA, tvQuestionB, tvQuestionC, tvQuestionD,tvNumberQuestion;
        CheckBox rdQuestionA,rdQuestionB,rdQuestionC,rdQuestionD;
        ImageView imgExpanding,imgText;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNumberQuestion = itemView.findViewById(R.id.tvQuestion);
            tvContentQuestion =  itemView.findViewById(R.id.tvContentQuestion);
            tvQuestionA =  itemView.findViewById(R.id.tvQuestionA);
            tvQuestionB = itemView.findViewById(R.id.tvQuestionB);
            tvQuestionC = itemView.findViewById(R.id.tvQuestionC);
            tvQuestionD = itemView.findViewById(R.id.tvQuestionD);
            rdQuestionA = itemView.findViewById(R.id.rdQuestionA);
            rdQuestionB = itemView.findViewById(R.id.rdQuestionB);
            rdQuestionC = itemView.findViewById(R.id.rdQuestionC);
            rdQuestionD = itemView.findViewById(R.id.rdQuestionD);
            imgExpanding = itemView.findViewById(R.id.imgExpanding);
            imgText = itemView.findViewById(R.id.imgText);
            imgExpanding.setOnClickListener(this);
            rdQuestionA.setOnCheckedChangeListener(this);
            rdQuestionB.setOnCheckedChangeListener(this);
            rdQuestionC.setOnCheckedChangeListener(this);
            rdQuestionD.setOnCheckedChangeListener(this);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switch (buttonView.getId()) {
                        case R.id.rdQuestionA:
                            rdQuestionA.setChecked(true);
                            rdQuestionB.setChecked(false);
                            rdQuestionC.setChecked(false);
                            rdQuestionD.setChecked(false);
                            if (checkBoxClickListened != null) {
                                checkBoxClickListened.checkboxListenedChecked(getAdapterPosition(), "a");
                            }
                            break;
                        case R.id.rdQuestionB:
                            rdQuestionB.setChecked(true);
                            rdQuestionA.setChecked(false);
                            rdQuestionC.setChecked(false);
                            rdQuestionD.setChecked(false);
                            if (checkBoxClickListened != null) {
                                checkBoxClickListened.checkboxListenedChecked(getAdapterPosition(), "b");
                            }
                            break;
                        case R.id.rdQuestionC:
                            rdQuestionC.setChecked(true);
                            rdQuestionA.setChecked(false);
                            rdQuestionB.setChecked(false);
                            rdQuestionD.setChecked(false);
                            if (checkBoxClickListened != null) {
                                checkBoxClickListened.checkboxListenedChecked(getAdapterPosition(), "c");
                            }
                            break;
                        case R.id.rdQuestionD:
                            rdQuestionD.setChecked(true);
                            rdQuestionA.setChecked(false);
                            rdQuestionC.setChecked(false);
                            rdQuestionB.setChecked(false);
                            if (checkBoxClickListened != null) {
                                checkBoxClickListened.checkboxListenedChecked(getAdapterPosition(), "d");
                            }
                            break;
                        default:
                            break;
                    }
                    return;
                }
                checkBoxClickListened.checkboxListenedUnChecked(getAdapterPosition());
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imgExpanding:
                    if (listQuestion.get(getAdapterPosition()).getExpanding()){
                        imgText.setVisibility(View.GONE);
                        imgText.setAnimation(end);
                        imgExpanding.setAnimation(rotate_up);
                        listQuestion.get(getAdapterPosition()).setIsExpanding(false);
                        return;
                    }
                    imgText.setVisibility(View.VISIBLE);
                    imgText.setAnimation(start);
                    imgExpanding.setAnimation(rotate_down);
                    listQuestion.get(getAdapterPosition()).setIsExpanding(true);
            }
        }
    }
}
