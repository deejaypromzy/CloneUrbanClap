package com.sundram.urbanclapclone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.sundram.urbanclapclone.connectionchecker.NetworkChangeReceiver;

public class OtpGeneratorActivity extends AppCompatActivity implements View.OnClickListener {

    ViewDialog viewDialog;
    TextView otpDenerator_tv, tv_skip_now, client_details;
    static TextView tv_check_connection;
    private BroadcastReceiver mNetworkReceiver;

//    @Override
//    protected void onStart() {
//        super.onStart();
//        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_generator_activity);
        otpDenerator_tv = findViewById(R.id.login_button_text);
        tv_skip_now = findViewById(R.id.tv_skip_now);
        otpDenerator_tv.setText("Generate OTP");
        tv_check_connection = findViewById(R.id.tv_check_connection);
        viewDialog = new ViewDialog(this);
        otpDenerator_tv.setOnClickListener(this);
        tv_skip_now.setOnClickListener(this);
        client_details = findViewById(R.id.client_details);
        client_details.setOnClickListener(this);
        //receive the broadcatReceiver
        mNetworkReceiver = new NetworkChangeReceiver();
        registerNetworkBroadcastForNougat();
//        if(ConnectionChecker.checkConnection(OtpGeneratorActivity.this)){
//            Toast.makeText(OtpGeneratorActivity.this,"Connection Available",Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(OtpGeneratorActivity.this,"Connection Not Available",Toast.LENGTH_SHORT).show();
//        }

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_skip_now:
                Intent ii = new Intent(OtpGeneratorActivity.this, LocationOnBoarding.class);
                startActivity(ii);
                finishAffinity();
                break;
            case R.id.login_button_text:
                otpSentBTN();
                break;
            case R.id.client_details:
                startActivity(new Intent(OtpGeneratorActivity.this,ClientDetailsActivity.class));
                finishAffinity();
        }
    }
    public void otpSentBTN(){
        viewDialog.showDialog();

        new Handler().postDelayed(new Runnable() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void run() {
                Intent i = new Intent(OtpGeneratorActivity.this, OTPVerification.class);
                startActivity(i);
                Toast.makeText(OtpGeneratorActivity.this, "OTP sent on your mobile number", Toast.LENGTH_LONG).show();
                finishAffinity();
                viewDialog.hideDialog();
            }
        }, 1000);
    }

    public static void dialog(boolean value){

        if(value){
            tv_check_connection.setText("Network Connected !!!");
            tv_check_connection.setBackgroundColor(Color.GREEN);
            tv_check_connection.setTextColor(Color.WHITE);

            Handler handler = new Handler();
            Runnable delayrunnable = new Runnable() {
                @Override
                public void run() {
                    tv_check_connection.setVisibility(View.GONE);
                }
            };
            handler.postDelayed(delayrunnable, 3000);
        }else {
            tv_check_connection.setVisibility(View.VISIBLE);
            tv_check_connection.setText("Could not Connect to internet");
            tv_check_connection.setBackgroundColor(Color.RED);
            tv_check_connection.setTextColor(Color.WHITE);
        }
    }
    private void registerNetworkBroadcastForNougat() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected void unregisterNetworkChanges() {
        try {
            unregisterReceiver(mNetworkReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterNetworkChanges();
    }
}
