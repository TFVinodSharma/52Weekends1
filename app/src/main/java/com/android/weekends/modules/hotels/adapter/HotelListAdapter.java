package com.android.weekends.modules.hotels.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.database.AppState;
import com.android.weekends.modules.buses.view.SeatSelectionActivity;
import com.android.weekends.modules.hotels.view.HotelDetailsActivity;
import com.android.weekends.modules.login.view.LoginActivity;
import com.android.weekends.modules.payments.view.InitialScreenActivity;
import com.android.weekends.modules.payments.view.PaymentMethodActivity;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.Versionview> {
    private String [] data1;
    private String [] data2;
    private String [] data3;


    public HotelListAdapter(String[]data1, String[]data2, String[]data3){
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;



    }
    @NonNull
    @Override
    public Versionview onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.row_hotel_list,parent,false);

        return new HotelListAdapter.Versionview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Versionview holder, int position) {
        String pnd=data1[position];
        holder.tv.setText(pnd);
        String rnk=data2[position];
        holder.tv1.setText(rnk);
        String wrk=data3[position];
        holder.tv2.setText(wrk);



    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class Versionview extends RecyclerView.ViewHolder {

        TextView tv,tv1,tv2;
        Button tv3;
        private final Context context;
        public Versionview(@NonNull View itemView) {
            super(itemView);
           context = itemView.getContext();
            tv=itemView.findViewById(R.id.img_name);
            tv1=itemView.findViewById(R.id.txt_add);
            tv2=itemView.findViewById(R.id.txt_amount);
            tv3=itemView.findViewById(R.id.btn_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    if (AppState.getInstance(context).getUserToken() == null) {
                        intent = new Intent(context, LoginActivity.class);
                    } else {
                        intent = new Intent(context, InitialScreenActivity.class);
                    }
                    context.startActivity(intent);

                }
            });
            tv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(context,HotelDetailsActivity.class);
                    context.startActivity(i);

                }
            });

        }
    }
}
