package com.rzn.uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button buttonLogin;
    SessionManagement sessionManagement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsername = findViewById(R.id.EditUsername);
        edtPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        sessionManagement = new SessionManagement(getApplicationContext());

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManagement.createLoginSession(edtUsername.getText().toString(), edtPassword.getText().toString());
                final String email = edtUsername.getText().toString().trim();
                final String pass = edtPassword.getText().toString().trim();

                if(!isValidEmail(email)){
                    edtUsername.setError("Username Tidak Boleh Kosong atau Kurang dari 6 Karakter");
                }else if(!isValidPassword(pass)){
                    edtPassword.setError("Password Tidak Boleh Kosong atau Kurang dari 6 Karakter");
                }else{
                    goToActivity();
                }
            }
        });
    }
    private boolean isValidEmail(String username){
        if(!TextUtils.isEmpty(username)&& username.length()>5){
            return true;
        }
        return false;
    }
    private boolean isValidPassword(String pass){
        if(!TextUtils.isEmpty(pass)&& pass.length()>5){
            return true;
        }
        return false;
    }
    private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(),WelcomeActivity.class);
        startActivity(mIntent);
    }
}
