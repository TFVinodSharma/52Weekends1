package com.android.weekends.base.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.weekends.R;

public class FragStayInfoAdapter extends RecyclerView.Adapter<FragStayInfoAdapter.StayInfoViewHolder> {
  private String[] ar1,ar2,ar3,ar4,ar5;

    public FragStayInfoAdapter(String[] ar1, String[] ar2, String[] ar3, String[] ar4, String[] ar5) {
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.ar3 = ar3;
        this.ar4 = ar4;
        this.ar5 = ar5;
    }

    @NonNull
    @Override
    public StayInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_stay_info,viewGroup,false);
        return new FragStayInfoAdapter.StayInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StayInfoViewHolder stayInfoViewHolder, int i) {

        stayInfoViewHolder.Hotel.setText(ar1[i]);
        stayInfoViewHolder.City.setText(ar2[i]);
        stayInfoViewHolder.State.setText(ar3[i]);
        stayInfoViewHolder.No_Days.setText(ar4[i]);
        stayInfoViewHolder.Des.setText(ar5[i]);

    }

    @Override
    public int getItemCount() {
        return ar1.length;
    }

    public class StayInfoViewHolder extends RecyclerView.ViewHolder{
          private TextView Hotel,City,State,No_Days,Des;
        public StayInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            Hotel=itemView.findViewById(R.id.txt_hotel);
            City=itemView.findViewById(R.id.txt_city);
            State=itemView.findViewById(R.id.txt_state);
            No_Days=itemView.findViewById(R.id.no_day);
            Des=itemView.findViewById(R.id.txt_description);

        }
    }
}
