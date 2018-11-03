package com.android.weekends.base.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.weekends.R;

public class Seat_Item_Adapter extends RecyclerView.Adapter<Seat_Item_Adapter.Versionview> {
    private String [] data1;
    public Seat_Item_Adapter(String[]data1) {
        this.data1 = data1;
    }

    @NonNull
    @Override
    public Versionview onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_seat,parent,false);

        return new Seat_Item_Adapter.Versionview(view);
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
