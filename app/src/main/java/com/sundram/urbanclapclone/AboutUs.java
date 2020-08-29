package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    Toolbar aboutUsToolbar;
    TextView tx_arror_back,textView_projectname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        aboutUsToolbar = findViewById(R.id.custom_toolbar_wedget);
        setSupportActionBar(aboutUsToolbar);
        if(getSupportActionBar()!=null) {
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        textView_projectname = findViewById(R.id.textView_projectname);
        textView_projectname.setText("About Us");
        tx_arror_back = findViewById(R.id.tx_arror_back);
        tx_arror_back.setVisibility(View.GONE);
    }
    //get the back button of the toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(this,About.class);
        startActivity(back);
        super.onBackPressed();
        finish();
    }
}
