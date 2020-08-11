package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "MainActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // if(ParseUser.getCurrentUser() != null){
        //    goMainActivity();
        //  }
//        etUsername = findViewById(R.id.etUsername);
//        etPassword = findViewById(R.id.etPassword);
//        btnLogin = findViewById(R.id.btnLogin);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "OnClick login button ");
//                String username = etUsername.getText().toString();
//                String password = etPassword.getText().toString();
//                loginUser(username,password);
//            }
//        });
    }

    private void loginUser(String username, String password) {
        Log.i(TAG, " Attempting to login user" + username);

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e !=null) {
                    //TODO better error handling
                    Log.e(TAG, "Issue with login",e);
                    Toast.makeText(MainActivity.this, "Issue with login", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Todo:navigate to the main activity if the user has signed in properly
                goMainActivity();
                Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent( this, MainActivity.class);
        startActivity(i);
    }
}
