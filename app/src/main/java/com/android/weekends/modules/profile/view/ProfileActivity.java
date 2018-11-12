package com.android.weekends.modules.profile.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.android.weekends.R;
import com.android.weekends.base.activity.Destination;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.home.view.HomePageActivity;

public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar ProfileToolBar=(Toolbar)findViewById(R.id.profiletoolbar);
        setSupportActionBar(ProfileToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Profile");





        LinearLayout DestinationLayout1=(LinearLayout)findViewById(R.id.desination);
        DestinationLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Destination.class);
                startActivity(i);
            }
        });

        LinearLayout HomeLayout1=(LinearLayout)findViewById(R.id.homeP);
        HomeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),HomePageActivity.class);
                startActivity(i);
            }
        });

        LinearLayout TripLayout1=(LinearLayout)findViewById(R.id.tripP);
        TripLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Destination.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
