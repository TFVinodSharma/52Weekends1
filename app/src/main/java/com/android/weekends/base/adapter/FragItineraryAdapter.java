package com.android.weekends.base.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.weekends.R;

public class FragItineraryAdapter extends RecyclerView.Adapter<FragItineraryAdapter.ItineraryViewHolder> {

    private String[] ar1,ar2,ar3;

    public FragItineraryAdapter(String[] ar1, String[] ar2, String[] ar3) {
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.ar3 = ar3;
    }

    @NonNull
    @Override
    public ItineraryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_itnitary,viewGroup,false);
        return new FragItineraryAdapter.ItineraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItineraryViewHolder itineraryViewHolder, int i) {


        itineraryViewHolder.Days.setText(ar1[i]);
       itineraryViewHolder.Title.setText(ar2[i]);
       itineraryViewHolder.Des.setText(ar3[i]);
    }

    @Override
    public int getItemCount() {
        return ar1.length;
    }

    public class ItineraryViewHolder extends RecyclerView.ViewHolder{

        private  TextView Days,Title,Des;
        public ItineraryViewHolder(@NonNull View itemView) {
            super(itemView);
            Days=itemView.findViewById(R.id.txt_days);
            Title=itemView.findViewById(R.id.txt_title);
            Des=itemView.findViewById(R.id.txt_description);
        }
    }
}
