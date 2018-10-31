package com.rzn.uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class WelcomeActivity extends AppCompatActivity {

    SessionManagement sessionManagement;
    Button buttonLogout,buttonDatabase;
    TextView showUsername;
    HashMap<String,String> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        sessionManagement = new SessionManagement(getApplicationContext());
        showUsername = findViewById(R.id.showUsername);
        buttonLogout = findViewById(R.id.btnLogout);
        buttonDatabase = findViewById(R.id.btnDb);
        user = sessionManagement.getUserInformation();
        showUsername.setText(user.get(sessionManagement.KEY_USER));

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.logoutUser();
            }
        });

        buttonDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity();
            }
        });
    }

    private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(),InputActivity.class);
        startActivity(mIntent);
    }
}
