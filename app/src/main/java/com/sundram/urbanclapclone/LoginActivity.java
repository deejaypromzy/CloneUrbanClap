package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView login_button_text;
    ViewDialog viewDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup_activity_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login_button_text = findViewById(R.id.login_button_text);
        login_button_text.setOnClickListener(this);
        login_button_text.setText("Generate OTP");
        viewDialog = new ViewDialog(this);
    }

    //get the back button of the toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(this, DashBoard.class);
        startActivity(back);
        finish();
    }

    public void otpGenerator() {
        viewDialog.showDialog();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LoginActivity.this, OTPVerification.class);
                startActivity(i);
                finish();
            }
        }, 1000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button_text:
                otpGenerator();
                break;
        }
    }
}
