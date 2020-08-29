package com.sundram.urbanclapclone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sundram.urbanclapclone.fagments.ProfileFragment;

public class About extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
   TextView aboutUs_tv, shareUrban_tv, privacyPolicy_tv, termsConditions_tv, textView_projectname, tx_arror_back;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        toolbar = findViewById(R.id.custom_toolbar_wedget);
        setSupportActionBar(toolbar);

        textView_projectname = findViewById(R.id.textView_projectname);
        textView_projectname.setText("About");
        shareUrban_tv = findViewById(R.id.shareUrban);
        privacyPolicy_tv = findViewById(R.id.privacyPolicy);
        termsConditions_tv = findViewById(R.id.termsConditions);
        tx_arror_back = findViewById(R.id.tx_arror_back);
        aboutUs_tv = findViewById(R.id.aboutUss);
        shareUrban_tv.setOnClickListener(this);
        privacyPolicy_tv.setOnClickListener(this);
        termsConditions_tv.setOnClickListener(this);
        tx_arror_back.setOnClickListener(this);
        aboutUs_tv.setOnClickListener(this);

    }

    //share urban clap method
    public void shareUrbanMethod() {
        //making app to share with other app
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String shareBody = "Your Message Here !";
        String shareSub = "Your subject here !";
        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
        myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
        startActivity(Intent.createChooser(myIntent, "Share Using"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aboutUss:
                Intent i = new Intent(About.this, AboutUs.class);
                startActivity(i);
                finish();
                break;
            case R.id.shareUrban:
                shareUrbanMethod();
                break;
            case R.id.privacyPolicy:
               browserMethod();
                break;
            case R.id.termsConditions:
               browserMethod();
                break;
            case R.id.tx_arror_back:
                onBackPressed();
                break;
        }
    }
    public void browserMethod(){
        Uri uri = Uri.parse("https://www.google.com/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(About.this, DashBoard.class);
        startActivity(back);
        finish();
        super.onBackPressed();
    }
}
