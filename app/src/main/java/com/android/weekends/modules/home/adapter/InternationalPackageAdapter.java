package com.android.weekends.modules.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.weekends.modules.tourdetails.view.PackageDetails;
import com.android.weekends.R;

public class InternationalPackageAdapter extends RecyclerView.Adapter<InternationalPackageAdapter.InternationalViewHolder> {
    private int[] ar1;
    private String[] ar2,ar3;

    public InternationalPackageAdapter(int[] ar1, String[] ar2, String[] ar3) {
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.ar3 = ar3;
    }

    @NonNull
    @Override
    public InternationalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_domestic_package,viewGroup,false);

        return new InternationalPackageAdapter.InternationalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InternationalViewHolder internationalViewHolder, int i) {
        internationalViewHolder.Des.setImageResource(ar1[i]);
        internationalViewHolder.Name.setText(ar2[i]);
        internationalViewHolder.Location.setText(ar3[i]);
    }

    @Override
    public int getItemCount() {
        return ar1.length;
    }


    public class InternationalViewHolder extends RecyclerView.ViewHolder{
        ImageView Des;
        TextView Name,Location;
        private final Context context;
        public InternationalViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            Des=itemView.findViewById(R.id.image);
            Name=itemView.findViewById(R.id.txt_name);
            Location=itemView.findViewById(R.id.txt_location);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(context,PackageDetails.class);
                    context.startActivity(i);
                }
            });
        }
    }
}
