package com.android.weekends.modules.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.android.weekends.modules.destination.view.DestinationActivity;
import com.android.weekends.modules.hotels.view.HotelSearchActivity;
import com.android.weekends.modules.profile.view.ProfileActivity;
import com.android.weekends.base.activity.SelectPacakge;
import com.android.weekends.modules.trip.view.TripActivity;
import com.android.weekends.modules.home.adapter.TopDestinationAdapter;
import com.android.weekends.modules.home.adapter.InternationalPackageAdapter;
import com.android.weekends.modules.home.adapter.DomesticPackageAdapter;
import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.buses.view.BusSearchActivity;
import com.android.weekends.modules.flights.view.FlightActivity;


public class HomePageActivity extends BaseActivity {
    int arr1[] = {com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple
            , com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple,
            com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple};
    String arr2[] = {"Bihar", "Mahabaleswar", "Tripura", "Allahabad",
            "Almora","Kashmir","Manali","Karnataka","Darjaling","Haryana","Himachal","Puri"};
    String arr3[] = {"India", "India", "India",
            "India", "India","India", "India", "India", "India", "India","India","India"};



    /*private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.desination:
                    Intent i= new Intent(HomePageActivity.this,DestinationActivity.class);
                    startActivity(i);
                    return true;
                case R.id.trip:
                    Intent i1= new Intent(getApplicationContext(),TripActivity.class);
                    startActivity(i1);

                    return true;
                case R.id.profile:
                    Intent i2= new Intent(getApplicationContext(),ProfileActivity.class);
                    startActivity(i2);

                    return true;

            }
            return false;
        }
    };
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.android.weekends.R.layout.activity_home__page1);

        /*BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
*/

        TopDestinationAdapter adapter= new TopDestinationAdapter(arr1,arr2,arr3);
        RecyclerView recyclerView = findViewById(com.android.weekends.R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);


        DomesticPackageAdapter adapter1= new DomesticPackageAdapter(arr1,arr2,arr3);
        RecyclerView recyclerView1 = findViewById(com.android.weekends.R.id.recycler);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView1.setAdapter(adapter1);

        InternationalPackageAdapter adapter2= new InternationalPackageAdapter(arr1,arr2,arr3);
        RecyclerView recyclerView2 = findViewById(com.android.weekends.R.id.recycler_View);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setAdapter(adapter2);


        LinearLayout GotoFlightActivity=(LinearLayout)findViewById(com.android.weekends.R.id.gotoflightactivity);
        GotoFlightActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(HomePageActivity.this,FlightActivity.class);
                startActivity(i);
            }
        });

        LinearLayout GotoHotelActivity=(LinearLayout)findViewById(com.android.weekends.R.id.gotohotelacitivity);
        GotoHotelActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(HomePageActivity.this,HotelSearchActivity.class);
                startActivity(i);
            }
        });
        LinearLayout GotoBusActivity=(LinearLayout)findViewById(com.android.weekends.R.id.gotobusactivity);
        GotoBusActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(HomePageActivity.this,BusSearchActivity.class);
                startActivity(i);
            }
        });



        LinearLayout GotoDestination=(LinearLayout)findViewById(com.android.weekends.R.id.desination);
        GotoDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(HomePageActivity.this,DestinationActivity.class);
                startActivity(i);
            }
        });



        LinearLayout GotoPackage=(LinearLayout)findViewById(R.id.flightpackage);
        GotoPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(HomePageActivity.this,SelectPacakge.class);
                startActivity(i);

            }
        });




        // Bottom Layout work Start

        LinearLayout GotoDestination1=(LinearLayout)findViewById(R.id.desination);
        GotoDestination1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),DestinationActivity.class);
                startActivity(i);

            }
        });

        LinearLayout GotoTrip=(LinearLayout)findViewById(R.id.tripP);
        GotoTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),TripActivity.class);
                startActivity(i);

            }
        });
        LinearLayout GotoProfile=(LinearLayout)findViewById(R.id.response);
        GotoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(i);

            }
        });
    }


}
