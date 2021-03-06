package com.android.weekends.modules.flights.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.modules.flights.view.FlightDetailsActivity;

public class FlightListAdapter extends RecyclerView.Adapter<FlightListAdapter.Versionview> {
    private String [] data1;
    private String [] data2;
    private String [] data3;
    private String [] data4;
    private String [] data5;

    public FlightListAdapter(String[]data1, String[]data2, String[]data3, String[]data4, String[]data5){
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;
        this.data4=data4;
        this.data5=data5;

    }
    @NonNull
    @Override
    public Versionview onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.row_flight_details,parent,false);

        return new FlightListAdapter.Versionview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Versionview holder, int position) {
        String pnd=data1[position];
        holder.tv.setText(pnd);
        String rnk=data2[position];
        holder.tv1.setText(rnk);
        String wrk=data3[position];
        holder.tv2.setText(wrk);
        String rtg=data4[position];
        holder.tv3.setText(rtg);
        String rev=data5[position];
        holder.tv4.setText(rev);
        }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class Versionview extends RecyclerView.ViewHolder {
        TextView tv,tv1,tv2,tv3,tv4;
        private final Context context;
        public Versionview(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tv=itemView.findViewById(R.id.txt_flight_name);
            tv1=itemView.findViewById(R.id.txt_start_time);
            tv2=itemView.findViewById(R.id.txt_time);
            tv3=itemView.findViewById(R.id.txt_end_time);
            tv4=itemView.findViewById(R.id.txt_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(context,FlightDetailsActivity.class);
                    context.startActivity(i);

                }
            });


        }
    }
}
