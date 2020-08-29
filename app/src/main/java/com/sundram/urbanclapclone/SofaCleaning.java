package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class SofaCleaning extends AppCompatActivity implements View.OnClickListener {

    TextView login_button_text_tv, back_tv;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView collapseImage_bg;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofa_cleaning);
        login_button_text_tv = findViewById(R.id.login_button_text);
        login_button_text_tv.setText("View all Sofa services");
        login_button_text_tv.setOnClickListener(this);
        //setting up the title of collapsableToolbarLayout
        collapsingToolbarLayout = findViewById(R.id.collpasableToolbarLayout);
        collapsingToolbarLayout.setTitle("Sofa Cleaning Services");
      //  collapsingToolbarLayout.setBackgroundResource(R.drawable.sofa_cleaning);
        back_tv = findViewById(R.id.back_tv);
        back_tv.setOnClickListener(this);
        login_button_text_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_tv:
                onBackPressed();
                break;
            case R.id.login_button_text:
                startActivity(new Intent(this, ViewAllSofaCleaningService.class));
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(SofaCleaning.this, ServiceListItem.class);
        startActivity(back);
        finish();
    }
}
