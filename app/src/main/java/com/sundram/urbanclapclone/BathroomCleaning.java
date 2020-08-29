package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class BathroomCleaning extends AppCompatActivity implements View.OnClickListener {

    TextView login_tv, back_tv;
    ImageView collapseImage_bg;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom_cleaning);
        login_tv = findViewById(R.id.login_button_text);
        login_tv.setText("View all Bathroom Services");
        back_tv = findViewById(R.id.back_tv);
        back_tv.setOnClickListener(this);
        login_tv.setOnClickListener(this);
        //setting up the title of collapsableToolbarLayout
        collapsingToolbarLayout = findViewById(R.id.collpasableToolbarLayout);
        collapsingToolbarLayout.setTitle("Bathroom Cleaning Services");
       // collapsingToolbarLayout.setCollapsedTitleTextColor(ColorStateList.valueOf(R.color.white));

        //setting collapsetoolbar bg
        //collapseImage_bg = findViewById(R.id.collapse_iv);
         //collapseImage_bg.setBackgroundResource(R.drawable.bathroom);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(BathroomCleaning.this,ServiceListItem.class);
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
                startActivity(new Intent(BathroomCleaning.this, ViewAllBathroomCleaningService.class));
                finish();
                break;
        }
    }
}
