package com.android.weekends.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.android.weekends.base.adapter.DestinationAdapter;
import com.android.weekends.R;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.modules.profile.view.ProfileActivity;

public class Destination extends BaseActivity {

    String arr1[] = {"Bihar", "Mahabaleswar", "Tripura", "Allahabad",
            "Almora","Kashmir","Manali","Karnataka","Darjaling","Haryana","Himachal","Puri"};
    String arr2[] = {"India", "India", "India",
            "India", "India","India", "India", "India", "India", "India","India","India"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

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
                Intent i1=new Intent(getApplicationContext(),Trip.class);
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
