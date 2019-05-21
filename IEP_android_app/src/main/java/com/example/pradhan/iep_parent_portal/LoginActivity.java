package com.example.pradhan.iep_parent_portal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText emailTV, passwordTV;
    private Button loginBtn;
    private ProgressBar progressBar;
    public static String TAG = "MY_APP";

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        initializeUI();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });
    }

    private void loginUserAccount() {

        Intent i = new Intent(this,GoalActivity.class);
        startActivity(i);
        finish();
//        progressBar.setVisibility(View.VISIBLE);
//
//        String email, password;
//        email = emailTV.getText().toString();
//        password = passwordTV.getText().toString();
//
//        if (TextUtils.isEmpty(email)) {
//            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
//            return;
//        }
//        if (TextUtils.isEmpty(password)) {
//            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        Log.d("LOGIN ACTIVITY",email);
//
////        mAuth.signInWithEmailAndPassword(email, password)
////                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
////                    @Override
////                    public void onComplete(@NonNull TaskDto<AuthResult> task) {
////                        if (task.isSuccessful()) {
////                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
////                            progressBar.setVisibility(View.GONE);
////
////                            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
////                            startActivity(intent);
////                        }
////                        else {
////                            Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
////                            progressBar.setVisibility(View.GONE);
////                        }
////                    }
////                });
//
//
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            progressBar.setVisibility(View.GONE);
////
//                            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
//                            startActivity(intent);
////                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
//                            Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            progressBar.setVisibility(View.GONE);
////                            updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });
    }

    private void initializeUI() {
        emailTV = findViewById(R.id.email);
        passwordTV = findViewById(R.id.password);

        loginBtn = findViewById(R.id.login);
        progressBar = findViewById(R.id.progressBar);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//
//        Log.d("abc",currentUser.getDisplayName());
////        updateUI(currentUser);
//    }
}
