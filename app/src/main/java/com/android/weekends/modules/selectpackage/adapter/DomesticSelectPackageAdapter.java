package com.android.weekends.modules.selectpackage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.modules.selectpackage.model.PackageDetails;
import com.android.weekends.modules.tourdetails.view.PackageDetailsActivity;

import java.util.ArrayList;

public class DomesticSelectPackageAdapter extends RecyclerView.Adapter<DomesticSelectPackageAdapter.MyViewHolder> {

    private ArrayList<PackageDetails> domesticPackageRequestArrayList;

    public boolean isHorizontal = false;

    public int widthPixels;

    private Context context;

    public DomesticSelectPackageAdapter(ArrayList<PackageDetails> domesticPackageRequestArrayList) {
        this.domesticPackageRequestArrayList = domesticPackageRequestArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (context == null) {
            context = viewGroup.getContext();
        }

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_domestic_select_package, viewGroup, false);
        return new DomesticSelectPackageAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int index) {
        PackageDetails domesticPackageRequest = domesticPackageRequestArrayList.get(index);
        myViewHolder.DName.setText(domesticPackageRequest.getPack_name());
        myViewHolder.Price.setText(domesticPackageRequest.getPrice());
        myViewHolder.Day.setText(domesticPackageRequest.getDays());
        myViewHolder.Night.setText(domesticPackageRequest.getNights());

        if (isHorizontal) {
            myViewHolder.domesticCard.getLayoutParams().width = (int) (widthPixels * 0.8);
        }
    }

    @Override
    public int getItemCount() {
        return domesticPackageRequestArrayList == null ? 0 : domesticPackageRequestArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView Des;
        TextView DName, Location, Price, Day, Night;
        private final Context context;
        CardView domesticCard;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            domesticCard = itemView.findViewById(R.id.cd_domestic);
            Des = itemView.findViewById(R.id.image);
            DName = itemView.findViewById(R.id.txt_p_name);
            Location = itemView.findViewById(R.id.txt_location);
            Price = itemView.findViewById(R.id.txt_p_price);
            Day = itemView.findViewById(R.id.txt_d_time);
            Night = itemView.findViewById(R.id.txt__n_time);

            itemView.setOnClickListener(v -> {
                Intent i = new Intent(context, PackageDetailsActivity.class);
                i.putExtra(PackageDetailsActivity.PACKAGE_DETAILS, domesticPackageRequestArrayList.get(getAdapterPosition()));
               //i.putExtra(PackageDetailsActivity.PACKAGE_DETAILS,domesticPackageRequestArrayList.get(getPosition(Price)));
                context.startActivity(i);
            });

        }
    }
}
