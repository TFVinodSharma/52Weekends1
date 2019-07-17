package com.android.weekends.modules.destination.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.modules.destination.model.DestinationModel;
import com.android.weekends.modules.destination.view.ActivityDetailDestination;

import java.util.ArrayList;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.MyViewHolder> {

    private ArrayList<DestinationModel> destinationArrayList;

    public DestinationAdapter(ArrayList<DestinationModel> destinationArrayList) {
        this.destinationArrayList = destinationArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_destination_full, viewGroup, false);
        return new DestinationAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int index) {
        DestinationModel destinationModel = destinationArrayList.get(index);
        myViewHolder.Name.setText(destinationModel.getName());

    }

    @Override
    public int getItemCount() {
        return destinationArrayList == null ? 0 : destinationArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Loc;
          private Context context;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            Name = itemView.findViewById(R.id.txt_name);
            Loc = itemView.findViewById(R.id.txt_location);
            imageView=itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, ActivityDetailDestination.class);
                    i.putExtra(ActivityDetailDestination.DESTINATION_DETAILS, destinationArrayList.get(getAdapterPosition()));
                    context.startActivity(i);
                }
            });
        }
    }
}
