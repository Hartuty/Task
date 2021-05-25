package com.abachapp.hrmmobileapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Datum> datalist;
    private Context context;

    public CustomAdapter() {
    }

    public CustomAdapter(List<Datum> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.one_user,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        holder.textView.setText(datalist.get(position).getName());
        holder.textView1.setText(datalist.get(position).getDepartment());
        String uri="http://hrmtask.abachdev.com/storage/images/"+datalist.get(position).getFilePath();
        Picasso.get().load(uri).into(holder.imageView);
    }

    public void updateList(List<Datum> list){
        datalist = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView textView;
        TextView textView1;
        ImageView imageView;
        MaterialCardView materialCardView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            textView=mView.findViewById(R.id.name);
            textView1=mView.findViewById(R.id.department);
            imageView=mView.findViewById(R.id.imageview);
        }
    }
}
