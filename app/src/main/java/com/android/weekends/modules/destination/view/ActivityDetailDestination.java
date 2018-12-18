package com.android.weekends.modules.destination.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.databinding.ActivityDestinationDetailsBinding;
import com.android.weekends.modules.destination.model.DestinationModel;


public class ActivityDetailDestination extends BaseActivity {

    ActivityDestinationDetailsBinding activityDestinationBinding;

    public static final String DESTINATION_DETAILS = "DESTINATION_DETAILS";

    private DestinationModel destinationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDestinationBinding = DataBindingUtil.setContentView(this, R.layout.activity_destination_details);

        Toolbar DetailsDestinationToolbar = (Toolbar) findViewById(R.id.toolbardestination);
        setSupportActionBar(DetailsDestinationToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra(DESTINATION_DETAILS))
            destinationModel = (DestinationModel) getIntent().getSerializableExtra(DESTINATION_DETAILS);

        initDestinationDetails();

    }

    private void initDestinationDetails() {
        getSupportActionBar().setTitle(destinationModel.getName());

        activityDestinationBinding.txtPlace.setText(destinationModel.getName());
        activityDestinationBinding.impactDescription.setText(destinationModel.getDescription());
        activityDestinationBinding.gettingthere.setText(destinationModel.getGettingThere());
        activityDestinationBinding.train.setText(destinationModel.getTrain());
        activityDestinationBinding.roadimage.setText(destinationModel.getRoad());
        activityDestinationBinding.airplaneimage.setText(destinationModel.getAir());
        activityDestinationBinding.dosimage.setText(destinationModel.getVisit_do());
        activityDestinationBinding.accomodations.setText(destinationModel.getAcco());
        activityDestinationBinding.foodtext.setText(destinationModel.getFood());
       //activityDestinationBinding.impactImage.setImageResource(Integer.parseInt(destinationModel.getMain_image()));


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}


