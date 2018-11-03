package com.android.weekends.base.activity;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.modules.tourdetails.view.PackageDetails;

public class SelectPacakge extends BaseActivity {
TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pacakge);


        Toolbar Selectpacakagetoolbar=(Toolbar)findViewById(R.id.selectpacakgetoolbar);
        setSupportActionBar(Selectpacakagetoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Select Pacakge");


        t1=findViewById(R.id.domestic);
    t2=findViewById(R.id.international);

    t1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i= new Intent(getApplicationContext(),PackageDetails.class);
        startActivity(i);
        }
});

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),PackageDetails.class);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
