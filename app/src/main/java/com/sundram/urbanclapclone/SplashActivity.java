package com.sundram.urbanclapclone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.sundram.urbanclapclone.Details.SofaCleaningDetails;

public class SplashActivity extends AppCompatActivity {

    private static final int timeOut = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, OtpGeneratorActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                finish();
            }
        },timeOut);
    }
}
