package com.android.weekends.base.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.modules.buses.view.SeatSelection;

public class Bus_List_Adapter extends RecyclerView.Adapter<Bus_List_Adapter.Versionview> {

    private String [] data1;
    private String [] data2;
    private String [] data3;
    private String [] data4;
    private String [] data5;
    private String [] data6;
    private String[] data7;

    public Bus_List_Adapter(String[]data1,String[]data2,String[]data3,String[]data4,String[]data5,String[]data6,String[] data7){
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;
        this.data4=data4;
        this.data5=data5;
        this.data6=data6;
        this.data7=data7;

    }
    @NonNull
    @Override
    public Versionview onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.row_bus_list,parent,false);

        return new Versionview(view);
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
        String fee=data6[position];
        holder.tv5.setText(fee);
        String fare=data6[position];
        holder.tv6.setText(fare);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class Versionview extends RecyclerView.ViewHolder {
        TextView tv,tv1,tv2,tv3,tv4,tv5,tv6;
        private final Context context;

        public Versionview(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tv=itemView.findViewById(R.id.bus_state);
            tv1=itemView.findViewById(R.id.bus_cmpny);
            tv2=itemView.findViewById(R.id.txt_start_time);
            tv3=itemView.findViewById(R.id.txt_time);
            tv4=itemView.findViewById(R.id.txt_end_time);
            tv5=itemView.findViewById(R.id.bus_type);
            tv6=itemView.findViewById(R.id.txt_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(context,SeatSelection.class);
                    context.startActivity(i);

                }
            });

        }
    }
}
