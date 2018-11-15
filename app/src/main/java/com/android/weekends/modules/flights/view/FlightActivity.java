package com.android.weekends.modules.flights.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;

import java.util.Calendar;

public class FlightActivity extends BaseActivity {

    private TextView mDisplayDateDepart, mDisplayDateReturn;

    private static String TAG = "FlightActivity";

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filght);

        Toolbar Flightsearchtoolbar = findViewById(R.id.toolbarflight);
        setSupportActionBar(Flightsearchtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //TODO put this string in strings.xml
        setTitle("FlightActivity Search");


        mDisplayDateDepart = findViewById(R.id.txt_depart_date);
        mDisplayDateReturn = findViewById(R.id.txt_return_date);

        mDisplayDateDepart.setOnClickListener(view -> {
            ChooseDate(view.getId());
        });

        mDisplayDateReturn.setOnClickListener(view -> ChooseDate(view.getId()));

        mDateSetListener = (datePicker, year, month, day) -> {
            int tagId = (int) datePicker.getTag();
            String date = month + 1 + "/" + day + "/" + year;
            switch (tagId) {
                case R.id.txt_depart_date:
                    mDisplayDateDepart.setText(date);
                    break;

                case R.id.txt_return_date:
                    mDisplayDateReturn.setText(date);
                    break;
            }

        };



        Button SearchFlight = (Button) findViewById(R.id.button_search);
        SearchFlight.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), FlightListActivity.class);
            startActivity(i);
        });


    }

    public void ChooseDate(int id) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog;
        dialog = new DatePickerDialog(FlightActivity.this,/*R.style.Datepicker,*/
                mDateSetListener,
                year, month, date);
        dialog.getWindow();
               // .setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4a148c")));
        dialog.show();

        DatePicker datePicker = dialog.getDatePicker();
        datePicker.setTag(id);
        datePicker.setMinDate(System.currentTimeMillis() - 1000);
    }


    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
