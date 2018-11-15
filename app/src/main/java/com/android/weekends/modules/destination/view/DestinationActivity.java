package com.android.weekends.modules.destination.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.databinding.ActivityDestinationBinding;
import com.android.weekends.modules.trip.view.TripActivity;
import com.android.weekends.modules.destination.adapter.DestinationAdapter;
import com.android.weekends.R;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.modules.profile.view.ProfileActivity;

public class DestinationActivity extends BaseActivity {
    ActivityDestinationBinding activityDestinationBinding;
    String arr1[] = {"Agra", "Delhi", "Udaipur", "Varnasi",
            "Mizoram","Assam","Rajashthan","Kerla","Jammu","Kaling","Lucknow","Trivantampuram"};
    String arr2[] = {"India", "India", "India",
            "India", "India","India", "India", "India", "India", "India","India","India"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_destination);
        activityDestinationBinding=DataBindingUtil.setContentView(this,R.layout.activity_destination);


        Toolbar DesToolBar=(Toolbar)findViewById(R.id.destoolbar);
        setSupportActionBar(DesToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Destnation");




        LinearLayout ProfileDestination =(LinearLayout)findViewById(R.id.response);
        ProfileDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(i);
            }
        });


        LinearLayout img=findViewById(R.id.homeP);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),HomePageActivity.class);
                startActivity(i1);
            }
        });
        LinearLayout img1=findViewById(R.id.tripP);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),TripActivity.class);
                startActivity(i1);
            }
        });

        LinearLayout img3=findViewById(R.id.response);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(i1);
            }
        });


        DestinationAdapter adapter111= new DestinationAdapter(arr1,arr2);
        RecyclerView recyclerView111 = findViewById(R.id.recycler_top_destination);
        recyclerView111.setHasFixedSize(true);
        recyclerView111.setLayoutManager(new LinearLayoutManager(this));
        recyclerView111.setAdapter(adapter111);
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
