package com.android.weekends.base.activity;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.weekends.R;
import com.android.weekends.modules.flights.view.FlightActivity;

import java.util.Calendar;

public class BaseActivity extends AppCompatActivity {

    //  private DatePickerDialog.OnDateSetListener mDateSetListener;
    private MaterialDialog materialDialog;


    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }


    public void showProgressDialogue(String title, String message) {
        materialDialog = new MaterialDialog.Builder(this)
                .title(title)
                .content(message)
                .progress(true, 0).show();
    }

    public void showProgressDialogue() {
        materialDialog = new MaterialDialog.Builder(this)
                .progress(true, 0).show();
    }

    public void hideProgressDialgogue() {
        materialDialog.hide();
    }


}


