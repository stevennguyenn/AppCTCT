package com.example.administrator.appctct.Adapter.Profile;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.appctct.Entity.InformationIndividual;
import com.example.administrator.appctct.Entity.PointNameCourse;
import com.example.administrator.appctct.R;

public class AdapterInformationIndividual extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private InformationIndividual info;

    public AdapterInformationIndividual(LayoutInflater inflater, InformationIndividual info) {
        this.inflater = inflater;
        this.info = info;
    }

    public void setInfo(InformationIndividual info){
        this.info = info;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == 0){
            view = inflater.inflate(R.layout.line_first_individual,viewGroup,false);
            return new HolderFirstIndividual(view);
        }
        if (i == 1){
            view = inflater.inflate(R.layout.line_second_individual,viewGroup,false);
            return new HolderSecondIndividual(view);
        }
        view = inflater.inflate(R.layout.line_three_individual,viewGroup,false);
        return new HolderThreeIndividual(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == 0){
            HolderFirstIndividual holder = (HolderFirstIndividual) viewHolder;
            holder.bind();
            return;
        }

        if (viewHolder.getItemViewType() == 1){
            HolderSecondIndividual holder = (HolderSecondIndividual) viewHolder;
            holder.bind();
            return;
        }

        HolderThreeIndividual holder = (HolderThreeIndividual) viewHolder;
        if (info.getListTested().size()>0){
            holder.bind(info.getListTested().get(i-2));
            return;
        }
        holder.dataNull();
    }

    @Override
    public int getItemCount() {
        return info.getListTested().size() == 0 ? 3 : 2 + info.getListTested().size();
    }

    @Override
    public int getItemViewType(int position) {
        return position < 1 ? 0 : position == 1 ? 1  : 2;
    }

    class HolderFirstIndividual extends RecyclerView.ViewHolder{
        ImageView imgBGIndividual,imgAVTIndividual;
        TextView tvNameIndividual;
         HolderFirstIndividual(@NonNull View itemView) {
            super(itemView);
            imgBGIndividual = itemView.findViewById(R.id.imgBGIndividual);
            imgAVTIndividual = itemView.findViewById(R.id.imgAVTIndividual);
            tvNameIndividual = itemView.findViewById(R.id.tvNameIndividual);
         }

         void bind(){
             Glide.with(inflater.getContext())
                     .load(info.getAvatar())
                     .apply(RequestOptions.circleCropTransform())
                     .into(imgAVTIndividual);
             tvNameIndividual.setText(info.getFullname());
         }
    }

    class HolderSecondIndividual extends RecyclerView.ViewHolder{
        TextView tvNameSchool,tvNameLiveCountry;
         HolderSecondIndividual(@NonNull View itemView) {
            super(itemView);
            tvNameSchool = itemView.findViewById(R.id.tvNameSchool);
            tvNameLiveCountry = itemView.findViewById(R.id.tvNameLiveCountry);
         }

         void bind(){
             if (info.getSchool() == null){
                 String text = "<font color=#0a0909>No Infomation</font>";
                 tvNameSchool.setText(Html.fromHtml(String.valueOf("School: "+text)));
             } else {
                 String text = String.valueOf("<font color=#0a0909> "+info.getSchool()+" </font>");
                 tvNameSchool.setText(String.valueOf("School: "+text));
             }

             if (info.getLive() == null){
                 String text = "<font color=#0a0909>No Infomation</font>";
                 tvNameLiveCountry.setText(Html.fromHtml(String.valueOf("Live: "+text)));
             } else {
                 String text = String.valueOf("<font color=#0a0909> "+info.getLive()+" </font>");
                 tvNameLiveCountry.setText(String.valueOf("Live: "+text));
             }
         }
    }

    class HolderThreeIndividual extends RecyclerView.ViewHolder{
        ImageView imgIconInformationIndividual;
        TextView tvNameCourseIndividual,tvPointIndividual,tvNoInformationIndividual;
         HolderThreeIndividual(@NonNull View itemView) {
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
