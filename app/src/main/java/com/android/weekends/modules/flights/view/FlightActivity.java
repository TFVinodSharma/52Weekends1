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

   private TextView mDisplayDateDepart,mDisplayDateReturn;
    private static  String TAG="Search_Nanny";
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    //static final int DIALOG_ID = 0;

    // Get Current time
    final Calendar calender = Calendar.getInstance();
    int hour = calender.get(Calendar.HOUR_OF_DAY);
    int minute = calender.get(Calendar.MINUTE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filght);

        Toolbar Flightsearchtoolbar=(Toolbar)findViewById(R.id.toolbarflight);
        setSupportActionBar(Flightsearchtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("FlightActivity Search");

        // ShowTimePicker();

        mDisplayDateDepart=(TextView)findViewById(R.id.txt_depart_date);
        mDisplayDateDepart.setOnClickListener(view -> {

            ChooseDate();
            /*Calendar cal=Calendar.getInstance();
            int year=cal.get(Calendar.YEAR);
            int month =cal.get(Calendar.MONTH);
            int date=cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog;
            dialog = new DatePickerDialog(FlightActivity.this,
                    mDateSetListener,
                    year,month,date);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FDD7E4")));
            dialog.show();
            dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);  // Disable past dates .
*/
        });
        mDateSetListener = (datePicker, year, month, day) -> {
            Log.d(TAG, "onDateSet:mm/dd/yy:" + month + "/" + day + "/" + year);
            String date = month+1 + "/" + day + "/" + year;
            mDisplayDateDepart.setText(date);
        };


        mDisplayDateReturn=(TextView)findViewById(R.id.txt_return_date);
        mDisplayDateReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDate();
            }
        });

       /* mDateSetListener = (datePicker, year, month, day) -> {
            Log.d(TAG, "onDateSet:mm/dd/yy:" + month + "/" + day + "/" + year);
            String date = month+1 + "/" + day + "/" + year;
            mDisplayDateReturn.setText(date);
        };
*/

        Button SearchFlight=(Button)findViewById(R.id.button_search);
        SearchFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),FlightListActivity.class);
                startActivity(i);
            }
        });


    }

    public void ChooseDate()
    {
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month =cal.get(Calendar.MONTH);
        int date=cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog;
        dialog = new DatePickerDialog(FlightActivity.this,
                mDateSetListener,
                year,month,date);
       dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FDD7E4")));
        dialog.show();
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);  // Disable past dates .
    }


    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
