package com.android.weekends.modules.buses.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.flights.view.FlightActivity;

import java.util.Calendar;

public class BusSearchActivity extends BaseActivity {



    private TextView mDisplayBusDateDepart, mDisplayBusDateReturn;

    private static String TAG = "FlightActivity";

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    String[] fromArray = {"Select city","Ahemdabad","Delhi.","Jaipur.","Sri Nagar",};

    String[] toArray = {"Select city","Ahemdabad","Delhi.","Jaipur.","Sri Nagar",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus__search);

        Toolbar BusSearchToolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(BusSearchToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Bus Search");


        mDisplayBusDateDepart = findViewById(R.id.txt_depart_bus_date);
        mDisplayBusDateReturn = findViewById(R.id.txt_retrun_bus_date);

        mDisplayBusDateDepart.setOnClickListener(view -> {
            ChooseDate(view.getId());
        });

        mDisplayBusDateReturn.setOnClickListener(view -> ChooseDate(view.getId()));

        mDateSetListener = (datePicker, year, month, day) -> {
            int tagId = (int) datePicker.getTag();
            String date = month + 1 + "/" + day + "/" + year;
            switch (tagId) {
                case R.id.txt_depart_bus_date:
                    mDisplayBusDateDepart.setText(date);
                    break;

                case R.id.txt_retrun_bus_date:
                    mDisplayBusDateReturn.setText(date);
                    break;
            }

        };



        Button BusSearch=(Button)findViewById(R.id.button_bus_search);
        BusSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),BusListActivity.class);
                startActivity(i);
            }
        });


        /*Spinner*/
        Spinner FromSelectCity= (Spinner) findViewById(R.id.fromselectcity);
        ArrayAdapter adapter1 = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, fromArray);

        FromSelectCity.setAdapter(adapter1);

        /*Spinner*/
        Spinner ToSelectCity = (Spinner) findViewById(R.id.toselectcity);
        ArrayAdapter adapter2 = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, toArray);

        ToSelectCity.setAdapter(adapter2);



    }


    public void ChooseDate(int id) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog;
        dialog = new DatePickerDialog(BusSearchActivity.this,
                mDateSetListener,
                year, month, date);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FDD7E4")));
        dialog.show();

        DatePicker datePicker = dialog.getDatePicker();
        datePicker.setTag(id);
        datePicker.setMinDate(System.currentTimeMillis() - 1000);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
