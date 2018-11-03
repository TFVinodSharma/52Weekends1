package com.android.weekends.modules.flights.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.weekends.modules.flights.adapter.FlightListAdapter;
import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;

public class FlightListActivity extends BaseActivity {

    public  String[] FlightName={"Indigo","Go Air","SpiceJet","Indigo","King Fisher","SpiceJet","Indigo","King Fisher"};
    public  String[] FlightStartTime={"5:15","8:00","8:30","9:00","10:00","11:10","12:00","14:00"};
    public String[] FlightTotalTime={"2:10","3:00","1:30","2:10","2:00","3:00","2:30","2:00"};
    public  String[] FlightEndTime={"7:05","11:00","10:00","11;10","12:00","14:10","14:30","16:00"};
    public  String[] FlightPrice={"4200","5553","7140","7200","7550","3000","2500","2800"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight__list);

        Toolbar FlightListToolbar=(Toolbar)findViewById(R.id.flightlisttoolbar);
        setSupportActionBar(FlightListToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   setTitle("Hotel Search");




        RecyclerView RecyclerFlightList=(RecyclerView)findViewById(R.id.recycler_flight_list);
        RecyclerFlightList.setLayoutManager(new LinearLayoutManager(this));
        RecyclerFlightList.setAdapter(new FlightListAdapter(FlightName,FlightStartTime,FlightTotalTime,FlightEndTime,FlightPrice));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
