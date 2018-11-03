package com.android.weekends.base.activity;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.weekends.R;

public class BaseActivity extends AppCompatActivity {

    private MaterialDialog materialDialog;

    public void onBackPressedToolbar(Toolbar toolbar, final Activity activity) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                activity.finish();
            }
        });
    }


    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }


    public void showProgressDialogue(String title, String message) {
        materialDialog = new MaterialDialog.Builder(this)
                .title(title)
                .content(message)
                .progress(true, 0).show();
    }

    public void hideProgressDialgogue() {
        materialDialog.hide();
    }

}


