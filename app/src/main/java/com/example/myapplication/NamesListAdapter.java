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


    //Variable reference to a list to hold the names from the database
    protected List<Name> nameList;

    //Constructor for the adapter
    public NamesListAdapter(List<Name> nameList) {

        this.nameList = nameList;
    }

    //Creates the viewholder for the adapter
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creates a View object that inflates the item layout that was created into the viewgroup for the view and DOES NOT attach to the root
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);

        //Returns a ViewHolder object using the itemView we created above
        return new ViewHolder(itemView);
    }

    //Allows each viewHolder object to be bound to the view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    //Returns the size of the list so the view knows how many itemView's it will need to create
    @Override
    public int getItemCount() {

        return nameList.size();
    }

    //When there is an update to the list this will
    public void updateList(List<Name> list) {
        nameList = list;
        notifyDataSetChanged();
    }

    //This inner class tells the ViewHolder how to set up each itemView
    public class ViewHolder extends RecyclerView.ViewHolder {

        //Variable reference for the Textview item
        protected TextView nameTextview;


        //Constructor for the viewHolder
        public ViewHolder (View itemView) {
            super(itemView);
            //Binds the textview variable to the view using the ID
            nameTextview = itemView.findViewById(R.id.name_text_view);
        }

        //Binds each item in the list to a viewHolder object
        public void bind (int position) {
            nameTextview.setText(nameList.get(position).getName());

        }

    }



}

