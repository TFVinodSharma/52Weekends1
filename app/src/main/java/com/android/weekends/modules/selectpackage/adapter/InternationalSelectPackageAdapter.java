package com.android.weekends.modules.selectpackage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.base.listener.OnItemSelectionListener;
import com.android.weekends.modules.selectpackage.model.PackageDetails;

import java.util.ArrayList;

public class InternationalSelectPackageAdapter extends RecyclerView.Adapter<InternationalSelectPackageAdapter.VersionViewHolder> {

    private ArrayList<PackageDetails> internationalPackageRequestArrayList;

    private OnItemSelectionListener<PackageDetails> onItemSelectionListener;


    public InternationalSelectPackageAdapter(ArrayList<PackageDetails> internationalPackageRequestArrayList) {
        this.internationalPackageRequestArrayList = internationalPackageRequestArrayList;
    }

    public OnItemSelectionListener<PackageDetails> getOnItemSelectionListener() {
        return onItemSelectionListener;
    }

    public void setOnItemSelectionListener(OnItemSelectionListener<PackageDetails> onItemSelectionListener) {
        this.onItemSelectionListener = onItemSelectionListener;
    }

    @NonNull
    @Override
    public VersionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_domestic_select_package,viewGroup,false);
        return new InternationalSelectPackageAdapter.VersionViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VersionViewHolder versionViewHolder, int index) {
        PackageDetails internationalPackageRequest = internationalPackageRequestArrayList.get(index);
        versionViewHolder.DName.setText(internationalPackageRequest.getPack_name());
        versionViewHolder.Price.setText(internationalPackageRequest.getPrice());
        versionViewHolder.Day.setText(internationalPackageRequest.getDays());
        versionViewHolder.Night.setText(internationalPackageRequest.getNights());
    }

    @Override
    public int getItemCount() {
        return internationalPackageRequestArrayList == null ? 0 : internationalPackageRequestArrayList.size();
    }

    public class VersionViewHolder extends RecyclerView.ViewHolder {
        ImageView Des;
        TextView DName,Location,Price,Day,Night;
        private final Context context;

        public VersionViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            Des=itemView.findViewById(R.id.image);
            DName=itemView.findViewById(R.id.txt_p_name);
            Location=itemView.findViewById(R.id.txt_location);
            Price=itemView.findViewById(R.id.txt_p_price);
            Day=itemView.findViewById(R.id.txt_d_time);
            Night=itemView.findViewById(R.id.txt__n_time);



           /* itemView.setOnClickListener(v -> {
                onItemSelectionListener.onItemSelected(internationalPackageRequestArrayList.get(getAdapterPosition()));
            });
*/

        }
    }
}
