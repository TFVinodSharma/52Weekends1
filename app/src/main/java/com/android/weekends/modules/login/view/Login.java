package com.android.weekends.modules.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.modules.home.view.HomePage;
import com.android.weekends.base.BaseActivity;

public class Login extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Signup = (TextView) findViewById(R.id.gotosignup);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), com.android.weekends.modules.login.view.Signup.class);
                startActivity(i);
            }
        });

        Button btn_Signin = (Button) findViewById(R.id.btn_signin);
        btn_Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(getApplicationContext(), HomePage.class);
                startActivity(ii);
            }
        });
    }
}
