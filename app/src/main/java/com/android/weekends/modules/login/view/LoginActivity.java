package com.android.weekends.modules.login.view;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.weekends.R;
import com.android.weekends.database.AppState;
import com.android.weekends.databinding.ActivityMainBinding;
import com.android.weekends.databinding.ActivitySignupBinding;
import com.android.weekends.modules.home.view.HomePageActivity;
import com.android.weekends.base.activity.BaseActivity;
import com.android.weekends.modules.login.model.LoginRequest;
import com.android.weekends.modules.login.viewmodels.LoginViewModel;
import com.android.weekends.modules.login.viewmodels.SignupViewModel;
import com.android.weekends.modules.profile.view.ProfileActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;

public class LoginActivity extends BaseActivity {

    ActivityMainBinding activityMainBinding;


    private static final String EMAIL = "email";
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN=2;
    private String TAG="LoginActivity";


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        SignInButton signInButton = findViewById(R.id.signinwithgoogle);
        signInButton.setOnClickListener(v -> signIn());

        mAuth = FirebaseAuth.getInstance();


        // facebook


        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        callbackManager = CallbackManager.Factory.create();
        loginButton=findViewById(R.id.login_button);

        loginButton.setReadPermissions(Arrays.asList(EMAIL));

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code

                String  accessToken = loginResult.getAccessToken().getToken();
               //boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });







        TextView Signup = (TextView) findViewById(R.id.gotosignup);
        Signup.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), SignupActivity.class);
            startActivity(i);
        });

    }



/*    Simple Login */
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
            } else if (loginResponse.getToken() != null) {
                AppState.getInstance(this).setUserToken(loginResponse.getToken());
                startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
            } else {
                showErrorMessage(loginResponse.getMessage());
            }
        });

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
            startActivity( new Intent(this,HomePageActivity.class));
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            updateUI(null);
                        }

                        // ...
                    }
                });
   }


    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private  void updateUI(FirebaseUser v)
    {

    }


}
