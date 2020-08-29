package com.sundram.urbanclapclone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class OTPVerification extends AppCompatActivity implements View.OnClickListener {


    ViewDialog viewDialog;
    TextView login_button_text_tv,otp_verify_appbar_tv;

    @Override
    protected void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        login_button_text_tv = findViewById(R.id.login_button_text);
        otp_verify_appbar_tv = findViewById(R.id.otp_verify_appbar);
        login_button_text_tv.setText("Verify OTP");
        //setting up the onclick method
        otp_verify_appbar_tv.setOnClickListener(this);
        login_button_text_tv.setOnClickListener(this);
        viewDialog = new ViewDialog(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button_text:
                otpVerifyBTN();
                break;
            case R.id.otp_verify_appbar:
                onBackPressed();
                break;

        }
    }

    public void otpVerifyBTN(){
        viewDialog.showDialog();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(OTPVerification.this, DashBoard.class);
                startActivity(i);
                Toast.makeText(OTPVerification.this, "OTP verified..", Toast.LENGTH_LONG).show();
                finish();
                viewDialog.hideDialog();
            }
        }, 1000);
    }

    @Override
    public void onBackPressed() {
        Intent ii = new Intent(OTPVerification.this,OtpGeneratorActivity.class);
        startActivity(ii);
        finish();
    }
}
