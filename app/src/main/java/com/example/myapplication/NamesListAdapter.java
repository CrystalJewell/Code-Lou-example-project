package com.example.myapplication;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.room.Models.Name;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NamesListAdapter extends RecyclerView.Adapter<NamesListAdapter.ViewHolder> {


    List<Name> nameList;

    public NamesListAdapter(List<Name> nameList) {

        this.nameList = nameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {

        return nameList.size();
    }

    public void updateList(List<Name> list) {
        nameList = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView nameTextview;


        public ViewHolder (View itemView) {
            super(itemView);

            nameTextview = itemView.findViewById(R.id.name_text_view);
        }

        public void bind (int position) {
            nameTextview.setText(nameList.get(position).getName());

        }

    }



}

