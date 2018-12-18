package com.android.weekends.modules.login.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.databinding.ActivitySignupBinding;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.modules.login.model.SignupRequest;
import com.android.weekends.modules.login.viewmodels.SignupViewModel;
import com.android.weekends.modules.profile.view.ProfileActivity;

public class SignupActivity extends BaseActivity {
    String[] LArray = {"Select", "Mr.", "Mrs.", "Miss"};

    ActivitySignupBinding activitySignupBinding;
  //  private String SHARED_PREFS_NAME = "com.android.weekends";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignupBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        TextView GotoLogin = (TextView) findViewById(R.id.txt_login);
        GotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });


        /*Imageview back button*/
        ImageView backtosignin = (ImageView) findViewById(R.id.img_back);
        backtosignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(it);
            }
        });

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, LArray);

        activitySignupBinding.spinner.setAdapter(adapter);

    }


    public void registerUser(View view) {
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setFullName(activitySignupBinding.edtName.getText().toString());
        signupRequest.setEmail(activitySignupBinding.edtEmail.getText().toString());
        signupRequest.setAddress(activitySignupBinding.edtAddress.getText().toString());
        signupRequest.setCity(activitySignupBinding.edtCity.getText().toString());
        signupRequest.setTitle(activitySignupBinding.spinner.getSelectedItem().toString());
        signupRequest.setPincode(activitySignupBinding.edtPincode.getText().toString());
        signupRequest.setPassword(activitySignupBinding.edtPassword.getText().toString());
        signupRequest.setCountryId(activitySignupBinding.edtCode.getText().toString());
        signupRequest.setPhone(activitySignupBinding.edtMobile.getText().toString());

        SignupViewModel signupViewModel = ViewModelProviders.of(this).get(SignupViewModel.class);

        showProgressDialogue(getString(R.string.signup_progress_title), getString(R.string.please_wait_progress));

        signupViewModel.registerUser(signupRequest).observe(this, signupResponse -> {
            hideProgressDialgogue();
            if (signupResponse == null) {
                showErrorMessage(getString(R.string.not_valid_response));
            } else if (signupResponse.getStatus()) {

                Intent i=new Intent(this,ProfileActivity.class);
               /* SharedPreferences.Editor editor = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("name", activitySignupBinding.edtName.getText().toString());
                editor.putString("email", activitySignupBinding.edtEmail.getText().toString());
                editor.putString("address",activitySignupBinding.edtAddress.getText().toString());
                editor.putString("pincode",activitySignupBinding.edtPincode.getText().toString());
                editor.putString("phone",activitySignupBinding.edtMobile.getText().toString());
                editor.putString("city",activitySignupBinding.edtCity.getText().toString());
                editor.apply();*/
/*
                Bundle bundle=new Bundle();
                bundle.putString("name",activitySignupBinding.edtName.getText().toString());
                bundle.putString("email",activitySignupBinding.edtEmail.getText().toString());
                bundle.putString("address",activitySignupBinding.edtAddress.getText().toString());
                bundle.putString("city",activitySignupBinding.edtCity.getText().toString());
                bundle.putString("pincode",activitySignupBinding.edtPincode.getText().toString());
                bundle.putString("phone",activitySignupBinding.edtMobile.getText().toString());
                i.putExtras(bundle);
*/
                startActivity(i);



                //startActivity(new Intent(SignupActivity.this, ProfileActivity.class));
            } else {
                showErrorMessage(signupResponse.getMessage());
            }
        });
    }
}
