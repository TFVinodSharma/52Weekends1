package com.android.weekends.modules.tourdetails.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;

public class ActivityDetailDestination extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_details);

        Toolbar DetailsDestinationToolbar=(Toolbar)findViewById(R.id.toolbardestination);
        setSupportActionBar(DetailsDestinationToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Delhi");


        /*Toolbar Hotelsearchtoolbar=(Toolbar)findViewById(R.id.toolbardestination);
        setSupportActionBar(Hotelsearchtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hotel Search");*/
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
