package com.android.weekends.modules.buses.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.weekends.R;

public class SeatItemAdapter extends RecyclerView.Adapter<SeatItemAdapter.Versionview> {
    private String [] data1;
    public SeatItemAdapter(String[]data1) {
        this.data1 = data1;
    }

    @NonNull
    @Override
    public Versionview onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_seat,parent,false);

        return new SeatItemAdapter.Versionview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Versionview holder, int position) {
        String pnd=data1[position];
        holder.iv.setImageResource(Integer.parseInt(pnd));
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class Versionview extends RecyclerView.ViewHolder {
ImageView iv;
        private final Context context;

        public Versionview(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            iv=itemView.findViewById(R.id.img_seat);
        }
    }
}
