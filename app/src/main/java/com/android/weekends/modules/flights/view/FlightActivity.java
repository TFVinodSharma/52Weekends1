package com.android.weekends.modules.flights.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;

public class FlightActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filght);

        Toolbar Flightsearchtoolbar=(Toolbar)findViewById(R.id.toolbarflight);
        setSupportActionBar(Flightsearchtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("FlightActivity Search");


        Button SearchFlight=(Button)findViewById(R.id.button_search);
        SearchFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),FlightListActivity.class);
                startActivity(i);
            }
        });


    }
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
