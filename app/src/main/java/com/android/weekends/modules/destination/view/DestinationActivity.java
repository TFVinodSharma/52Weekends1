package com.android.weekends.modules.destination.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.databinding.ActivityDestinationBinding;
import com.android.weekends.modules.destination.adapter.DestinationAdapter;
import com.android.weekends.modules.destination.viewmodel.DestinationViewModel;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.modules.profile.view.ProfileActivity;
import com.android.weekends.modules.trip.view.TripActivity;

public class DestinationActivity extends BaseActivity implements View.OnClickListener {
    ActivityDestinationBinding activityDestinationBinding;

LinearLayout ProfileDestination,img,img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDestinationBinding = DataBindingUtil.setContentView(this, R.layout.activity_destination);

        Toolbar DesToolBar = (Toolbar) findViewById(R.id.destoolbar);
        setSupportActionBar(DesToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Destination");


        ProfileDestination=findViewById(R.id.response);
        img=findViewById(R.id.homeP);
        img1=findViewById(R.id.tripP);
        ProfileDestination.setOnClickListener(this);
        img.setOnClickListener(this);
        img1.setOnClickListener(this);


        showProgressDialogue("Fetching Destinations", "Please Wait ...");
        getDestinations();
    }


    private void getDestinations() {

        DestinationViewModel destinationViewModel = ViewModelProviders.of(this).get(DestinationViewModel.class);

        destinationViewModel.getDestinations().observe(this, destinationResponse -> {

            hideProgressDialgogue();

            if (destinationResponse.getDestinations() != null) {
                DestinationAdapter adapter111 = new DestinationAdapter(destinationResponse.getDestinations());
                RecyclerView recyclerView111 = findViewById(R.id.recycler_top_destination);
                recyclerView111.setHasFixedSize(true);
                recyclerView111.setLayoutManager(new LinearLayoutManager(this));
                recyclerView111.setAdapter(adapter111);
            } else {
                showErrorMessage(destinationResponse.getMessage());
            }

        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.response:
                Intent intent = new Intent(this, ProfileActivity.class);
                this.startActivity(intent);
                break;

            case R.id.homeP:
                Intent intent1 = new Intent(this, HomePageActivity.class);
                this.startActivity(intent1);
                break;
            case R.id.tripP:
                Intent intent2 = new Intent(this, TripActivity.class);
                this.startActivity(intent2);
                break;

        }


    }
}
