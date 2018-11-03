package com.android.weekends.modules.buses.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;

public class SeatSelectionActivity extends BaseActivity {
    public  String[] SeatSelection={"","","","",""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat__selection);

        Toolbar SeatSelectionToolbar=(Toolbar)findViewById(R.id.seatselectiontoolbar);
        setSupportActionBar(SeatSelectionToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Seat Selection");


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
