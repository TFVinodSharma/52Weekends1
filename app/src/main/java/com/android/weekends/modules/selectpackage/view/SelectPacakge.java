package com.android.weekends.modules.selectpackage.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;

public class SelectPacakge extends BaseActivity {
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pacakge);


        Toolbar Selectpacakagetoolbar = (Toolbar) findViewById(R.id.selectpacakgetoolbar);
        setSupportActionBar(Selectpacakagetoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Select Packages");

        t1 = findViewById(R.id.domestic);
        t2 = findViewById(R.id.international);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DomesticPacakgeAcivity.class);
                startActivity(i);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), InternationalPackageActivity.class);
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
