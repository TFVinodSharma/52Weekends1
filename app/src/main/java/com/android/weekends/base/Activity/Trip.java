package com.android.weekends.base.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.android.weekends.R;
import com.android.weekends.base.Activity.Destination;
import com.android.weekends.base.BaseActivity;

public class Trip extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        Toolbar TripToolBar=(Toolbar)findViewById(R.id.triptoolbar);
        setSupportActionBar(TripToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setTitle("Hotel Search");



        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout Tab=(TabLayout)findViewById(R.id.tab);
        Tab.addTab(Tab.newTab().setText("UPCOMING"));
        Tab.addTab(Tab.newTab().setText("COMPLETED"));
        Tab.addTab(Tab.newTab().setText("CANCELLED"));
        Tab.setTabGravity(TabLayout.GRAVITY_CENTER);



        LinearLayout DestinationLayout=(LinearLayout)findViewById(R.id.desination);
        DestinationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Destination.class);
                startActivity(i);
            }
        });

        LinearLayout HomeLayout=(LinearLayout)findViewById(R.id.homeP);
        HomeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Destination.class);
                startActivity(i);
            }
        });

        LinearLayout ProfileLayout=(LinearLayout)findViewById(R.id.response);
        ProfileLayout.setOnClickListener(new View.OnClickListener() {
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
