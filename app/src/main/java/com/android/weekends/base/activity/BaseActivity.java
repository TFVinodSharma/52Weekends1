package com.android.weekends.base.activity;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.android.weekends.R;

public class BaseActivity extends AppCompatActivity {


    public void onBackPressedToolbar(Toolbar toolbar, final Activity activity) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

}


