package com.android.weekends.modules.hotels.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.flights.view.FlightActivity;

import java.util.Calendar;

public class HotelSearchActivity extends BaseActivity {
    /*private TextView mDisplayCheckInDate,mDisplayOutDate;
    private static  String TAG="Search_Nanny";
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    //static final int DIALOG_ID = 0;

    // Get Current time
    final Calendar calender = Calendar.getInstance();
    int hour = calender.get(Calendar.HOUR_OF_DAY);
    int minute = calender.get(Calendar.MINUTE);
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);

        Toolbar Hotelsearchtoolbar=(Toolbar)findViewById(R.id.hotlesearchtoolbar);
        setSupportActionBar(Hotelsearchtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hotel Search");


       /* mDisplayCheckInDate=(TextView)findViewById(R.id.txt_checkin_date);
        mDisplayCheckInDate.setOnClickListener(view -> {

            ChooseDate1();

        });
        mDateSetListener1 = (datePicker, year, month, day) -> {
            Log.d(TAG, "onDateSet:mm/dd/yy:" + month + "/" + day + "/" + year);
            String date = month+1 + "/" + day + "/" + year;
            mDisplayCheckInDate.setText(date);
        };
*/

      /*  mDisplayOutDate=(TextView)findViewById(R.id.txt_checkout_date);
        mDisplayOutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDate1();
            }
        });
*/
       /* mDateSetListener = (datePicker, year, month, day) -> {
            Log.d(TAG, "onDateSet:mm/dd/yy:" + month + "/" + day + "/" + year);
            String date = month+1 + "/" + day + "/" + year;
            mDisplayDateReturn.setText(date);
        };
*/



        TextView setguest=(TextView)findViewById(R.id.txt_no_guest);
       // TextView setroom=(TextView)findViewById(R.id.txt_no_room);

        Bundle b1 = getIntent().getExtras();

        if (b1 != null)
        {
            setguest.setText(" "+b1.getString("Key"));
        }

        Button Hotelsearch=(Button)findViewById(R.id.button_search);
        Hotelsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),HotelListActivity.class);
                startActivity(i);
            }
        });

        final LinearLayout Hotelguestselection=(LinearLayout)findViewById(R.id.selectguest);
        Hotelguestselection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),HotelGuestSlectionActivity.class);
                startActivity(i);

            }
        });

        LinearLayout HotelRoomSearch=(LinearLayout)findViewById(R.id.roomssearch);
        HotelRoomSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),HotelGuestSlectionActivity.class);
                startActivity(i);

            }
        });


    }


   /* public void ChooseDate1()
    {
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month =cal.get(Calendar.MONTH);
        int date=cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog1;
        dialog1 = new DatePickerDialog(getApplicationContext(),
                mDateSetListener1,
                year,month,date);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FDD7E4")));
        dialog1.show();
        dialog1.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);  // Disable past dates .
    }

*/

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
