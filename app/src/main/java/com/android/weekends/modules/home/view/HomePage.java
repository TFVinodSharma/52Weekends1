package com.android.weekends.modules.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.android.weekends.base.Activity.Destination;
import com.android.weekends.modules.profile.view.Profile;
import com.android.weekends.base.Activity.SelectPacakge;
import com.android.weekends.base.Activity.Trip;
import com.android.weekends.base.adapter.HomeDesitinationAdapter;
import com.android.weekends.base.adapter.InternationalPakageAdapter;
import com.android.weekends.base.adapter.MyPakageAdapter;
import com.android.weekends.R;
import com.android.weekends.base.BaseActivity;
import com.android.weekends.modules.buses.view.BusSearch;
import com.android.weekends.modules.flights.view.Flight;
import com.android.weekends.modules.hotels.view.HotelSearch;


public class HomePage extends BaseActivity {
    int arr1[] = {com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple
            , com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple,
            com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple, com.android.weekends.R.drawable.temple};
    String arr2[] = {"Bihar", "Mahabaleswar", "Tripura", "Allahabad",
            "Almora","Kashmir","Manali","Karnataka","Darjaling","Haryana","Himachal","Puri"};
    String arr3[] = {"India", "India", "India",
            "India", "India","India", "India", "India", "India", "India","India","India"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.android.weekends.R.layout.activity_home__page1);

        HomeDesitinationAdapter adapter= new HomeDesitinationAdapter(arr1,arr2,arr3);
        RecyclerView recyclerView = findViewById(com.android.weekends.R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);


        MyPakageAdapter adapter1= new MyPakageAdapter(arr1,arr2,arr3);
        RecyclerView recyclerView1 = findViewById(com.android.weekends.R.id.recycler);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView1.setAdapter(adapter1);

        InternationalPakageAdapter adapter2= new InternationalPakageAdapter(arr1,arr2,arr3);
        RecyclerView recyclerView2 = findViewById(com.android.weekends.R.id.recycler_View);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setAdapter(adapter2);


        LinearLayout GotoFlightActivity=(LinearLayout)findViewById(com.android.weekends.R.id.gotoflightactivity);
        GotoFlightActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Flight.class);
                startActivity(i);
            }
        });

        LinearLayout GotoHotelActivity=(LinearLayout)findViewById(com.android.weekends.R.id.gotohotelacitivity);
        GotoHotelActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),HotelSearch.class);
                startActivity(i);
            }
        });
        LinearLayout GotoBusActivity=(LinearLayout)findViewById(com.android.weekends.R.id.gotobusactivity);
        GotoBusActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),BusSearch.class);
                startActivity(i);
            }
        });

        LinearLayout GotoDestination=(LinearLayout)findViewById(com.android.weekends.R.id.desination);
        GotoDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Destination.class);
                startActivity(i);
            }
        });

        LinearLayout GotoPackage=(LinearLayout)findViewById(R.id.flightpackage);
        GotoPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),SelectPacakge.class);
                startActivity(i);

            }
        });

        /*LinearLayout GotoHome=(LinearLayout)findViewById(R.id.homeP);
        GotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),HomePage.class);
                startActivity(i);

            }
        });*/
        LinearLayout GotoDestination1=(LinearLayout)findViewById(R.id.desination);
        GotoDestination1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Destination.class);
                startActivity(i);

            }
        });

        LinearLayout GotoTrip=(LinearLayout)findViewById(R.id.tripP);
        GotoTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Trip.class);
                startActivity(i);

            }
        });
        LinearLayout GotoProfile=(LinearLayout)findViewById(R.id.response);
        GotoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Profile.class);
                startActivity(i);

            }
        });
    }


}
