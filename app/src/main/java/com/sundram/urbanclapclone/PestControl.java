package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.sundram.urbanclapclone.viewallserviceactivity.pestcontrol.ViewAllPestControl;

public class PestControl extends AppCompatActivity implements View.OnClickListener {

    TextView login_tv, back_tv;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pest_control);
        login_tv = findViewById(R.id.login_button_text);
        login_tv.setText("View all Pest Control Services");
        login_tv.setOnClickListener(this);
        back_tv = findViewById(R.id.back_tv);
        back_tv.setOnClickListener(this);
        collapsingToolbarLayout = findViewById(R.id.collpasableToolbarLayout);
        collapsingToolbarLayout.setTitle("Pest Control");
        //       collapsingToolbarLayout.setCollapsedTitleTextColor(ColorStateList.valueOf(R.color.white));
    }
    @Override
    public void onBackPressed() {
        Intent back = new Intent(PestControl.this,DashBoard.class);
        startActivity(back);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_tv:
                onBackPressed();
                break;
            case R.id.login_button_text:
                Intent ii = new Intent(PestControl.this, ViewAllPestControl.class);
                startActivity(ii);
                finish();
                break;
        }
    }
}
