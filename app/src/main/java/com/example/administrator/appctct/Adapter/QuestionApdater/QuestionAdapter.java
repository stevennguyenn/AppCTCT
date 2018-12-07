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
import com.example.administrator.appctct.Entity.QuestionTestTested;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{
    @NonNull
    private ArrayList<ModelQuestion> listQuestion;
    private LayoutInflater layoutInflater;
    private CheckBoxClick checkBoxClickListened;
    private Animation rotate_down,rotate_up;
//    private Boolean choicePermission = true;
    private ArrayList<QuestionTestTested> listTestTested;

    public QuestionAdapter(@NonNull ArrayList<ModelQuestion> listQuestion, Context context){
        this.layoutInflater = LayoutInflater.from(context);
        this.listQuestion = listQuestion;
    }

    public void setListTestTested(ArrayList<QuestionTestTested> listTestTested){
        this.listTestTested = listTestTested;
        notifyDataSetChanged();
    }


//    public void setDontChoicePermission(){
//        choicePermission = false;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)  {
        View view = layoutInflater.inflate(R.layout.layout_line_question,viewGroup,false);
        rotate_down = AnimationUtils.loadAnimation(layoutInflater.getContext(),R.anim.rotate_down);
        rotate_up = AnimationUtils.loadAnimation(layoutInflater.getContext(),R.anim.rotate_up);
        return new ViewHolder(view);
    }

    //should move into viewholder
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        if (listTestTested != null){
            QuestionTestTested questionTestTested = listTestTested.get(i);
            viewHolder.bindTested(questionTestTested);
            return;
        }
        ModelQuestion modelQuestion = listQuestion.get(i);
        viewHolder.bindOnlineorOffline(modelQuestion);
    }


    @Override
    public int getItemCount() {
        return listTestTested != null? listTestTested.size():listQuestion.size();
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
        }

        void bindTested(QuestionTestTested questionTestTested){
            tvNumberQuestion.setText(String.valueOf("Question "+(getAdapterPosition()+1)+":"));
            tvContentQuestion.setText(questionTestTested.getContentQuestion());
            tvQuestionA.setText(questionTestTested.getQuestionA());
            tvQuestionB.setText(questionTestTested.getQuestionB());
            tvQuestionC.setText(questionTestTested.getQuestionC());
            tvQuestionD.setText(questionTestTested.getQuestionD());
            rdQuestionA.setEnabled(false);
            rdQuestionB.setEnabled(false);
            rdQuestionC.setEnabled(false);
            rdQuestionD.setEnabled(false);
            rdQuestionA.setChecked(false);
            rdQuestionB.setChecked(false);
            rdQuestionC.setChecked(false);
            rdQuestionD.setChecked(false);
            if (questionTestTested.getValueUserChocie().equals("a")){
                rdQuestionA.setChecked(true);
            }
            if(questionTestTested.getValueUserChocie().equals("b")){
                rdQuestionB.setChecked(true);
            }
            if(questionTestTested.getValueUserChocie().equals("c")){
                rdQuestionC.setChecked(true);
            }
            if(questionTestTested.getValueUserChocie().equals("d")){
                rdQuestionD.setChecked(true);
            }
        }

        void bindOnlineorOffline(ModelQuestion modelQuestion){
            tvNumberQuestion.setText(String.valueOf("Question "+(getAdapterPosition()+1)+":"));
            tvContentQuestion.setText(modelQuestion.getContent_question());
            tvQuestionA.setText(modelQuestion.getQuestion_a());
            tvQuestionB.setText(modelQuestion.getQuestion_b());
            tvQuestionC.setText(modelQuestion.getQuestion_c());
            tvQuestionD.setText(modelQuestion.getQuestion_d());
            imgText.setVisibility(View.GONE);
            imgExpanding.setVisibility(View.GONE);
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
                    Boolean expanded = listQuestion.get(getAdapterPosition()).getExpanding();
                    imgText.setVisibility(expanded?View.GONE:View.VISIBLE);
                    imgExpanding.startAnimation(expanded?rotate_up:rotate_down);
                    listQuestion.get(getAdapterPosition()).setIsExpanding(!expanded);
                    break;
            }
        }
    }
}
