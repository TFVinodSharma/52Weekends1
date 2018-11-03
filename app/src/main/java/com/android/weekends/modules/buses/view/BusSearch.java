package com.android.weekends.modules.buses.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.weekends.R;
import com.android.weekends.base.BaseActivity;
import com.android.weekends.modules.buses.view.BusList;

public class BusSearch extends BaseActivity {
Spinner spin1,spin2;


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


        Button BusSearch=(Button)findViewById(R.id.button_bus_search);
        BusSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),BusList.class);
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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
