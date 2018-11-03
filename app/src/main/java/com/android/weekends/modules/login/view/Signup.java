package com.android.weekends.modules.login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.modules.login.view.Login;

public class Signup extends AppCompatActivity {
    String[] LArray = {"Select","Mr.","Mrs.","Miss",
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TextView GotoLogin=(TextView)findViewById(R.id.txt_login);
        GotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });


        /*Imageview back button*/
        ImageView backtosignin=(ImageView)findViewById(R.id.img_back) ;
        backtosignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getApplicationContext(),Login.class);
                startActivity(it);
            }
        });
/*Spinner*/
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, LArray);

        spinner.setAdapter(adapter);

    }
}
