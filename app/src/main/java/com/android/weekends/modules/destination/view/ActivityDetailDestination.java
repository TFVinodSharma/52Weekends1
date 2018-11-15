package com.android.weekends.modules.destination.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.databinding.ActivityDestinationDetailsBinding;
import com.android.weekends.modules.destination.model.DestinationRequest;
import com.android.weekends.modules.destination.viewmodel.DestinationViewModel;
import com.android.weekends.modules.home.view.HomePageActivity;



public class ActivityDetailDestination extends BaseActivity {

    ActivityDestinationDetailsBinding activityDestinationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_destination_details);
        activityDestinationBinding = DataBindingUtil.setContentView(this, R.layout.activity_destination_details);

        Toolbar DetailsDestinationToolbar=(Toolbar)findViewById(R.id.toolbardestination);
        setSupportActionBar(DetailsDestinationToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Agra");


        }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

/*
    public void setdata(View v)
    {
        DestinationRequest destinationRequest = new DestinationRequest();
        destinationRequest.setMain_image(activityDestinationBinding.impact_image);
        destinationRequest.setName(activityDestinationBinding.txt_place);
        destinationRequest.setGetting_there(activityDestinationBinding.gettingthere);
        destinationRequest.setTrain(activityDestinationBinding.train);
        destinationRequest.setRoad(activityDestinationBinding.roadimage);
        destinationRequest.setAir(activityDestinationBinding.airplaneimage);
        destinationRequest.setVisit_do(activityDestinationBinding.dosimage);
        destinationRequest.setAcco(activityDestinationBinding.accomodations);
        destinationRequest.setFood(activityDestinationBinding.foodtext);

        */
/*DestinationViewModel destinationViewModel = ViewModelProviders.of(this).get(DestinationViewModel.class);
        showProgressDialogue(getString(R.string.destination_progress_title), getString(R.string.please_wait_progress));
*//*

*/
/*
        destinationViewModel.setdata(destinationRequest).observe(this, destinationRequest -> {
            hideProgressDialgogue();
            if (signupResponse == null) {
                showErrorMessage(getString(R.string.not_valid_response));
            } else if (signupResponse.getStatus()) {
                startActivity(new Intent(SignupActivity.this, HomePageActivity.class));
            } else {
                showErrorMessage(signupResponse.getMessage());
            }
        });
*//*




    }
*/

}
