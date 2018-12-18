package com.android.weekends.modules.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.weekends.R;

public class DomesticPackageAdapter extends RecyclerView.Adapter<DomesticPackageAdapter.MyViewHolder> {

     private int[] ar1;
    private String[] ar2,ar3;

    public DomesticPackageAdapter(int[] ar1, String[] ar2, String[] ar3) {
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.ar3 = ar3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_domestic_package,viewGroup,false);

        return new DomesticPackageAdapter.MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.Des.setImageResource(ar1[i]);
        myViewHolder.Name.setText(ar2[i]);
        myViewHolder.Location.setText(ar3[i]);

    }

    @Override
    public int getItemCount() {
        return ar1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView Des;
        TextView Name,Location;
        private final Context context;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            Des=itemView.findViewById(R.id.image);
            Name=itemView.findViewById(R.id.txt_name);
            Location=itemView.findViewById(R.id.txt_location);

/*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(context,PackageDetailsActivity.class);
                    context.startActivity(i);
                }
            });
*/


        }
    }
}
