package com.android.weekends.base.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.weekends.R;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.MyViewHolder> {

    private String[] ar1,ar2;

    public DestinationAdapter(String[] ar1, String[] ar2) {
        this.ar1 = ar1;
        this.ar2 = ar2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_destination_full,viewGroup,false);
        return new DestinationAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
         myViewHolder.Name.setText(ar1[i]);
         myViewHolder.Loc.setText(ar2[i]);
    }

    @Override
    public int getItemCount() {
        return ar1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView Name,Loc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.txt_name);
            Loc=itemView.findViewById(R.id.txt_location);
        }
    }
}
