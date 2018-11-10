package com.android.weekends.modules.login.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.databinding.ActivityMainBinding;
import com.android.weekends.databinding.ActivitySignupBinding;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.login.model.LoginRequest;
import com.android.weekends.modules.login.viewmodels.LoginViewModel;
import com.android.weekends.modules.login.viewmodels.SignupViewModel;

public class LoginActivity extends BaseActivity {

ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  setContentView(R.layout.activity_main);*/
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        TextView Signup = (TextView) findViewById(R.id.gotosignup);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(i);
            }
        });

/*
        Button btn_Signin = (Button) findViewById(R.id.btn_signin);
        btn_Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(ii);
            }
        });
*/
    }

    public void loginuser(View view) {
        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setEmail(activityMainBinding.email.getText().toString());
        loginRequest.setPassword(activityMainBinding.password.getText().toString());

        LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        showProgressDialogue(getString(R.string.login_progress_title), getString(R.string.please_wait_progress));

        loginViewModel.loginUser(loginRequest).observe(this, loginResponse -> {
            hideProgressDialgogue();
            if (loginResponse == null) {
                showErrorMessage(getString(R.string.not_valid_response));
            } else if (loginResponse.getToken()!=null) {
                startActivity(new Intent(LoginActivity.this, HomePageActivity.class));
            } else {
                showErrorMessage(loginResponse.getMessage());
            }
        });

    }
}
