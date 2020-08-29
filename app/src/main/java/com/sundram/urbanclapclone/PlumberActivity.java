package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.sundram.urbanclapclone.adapter.RecyclerViewAdapter;
import com.sundram.urbanclapclone.datamodel.DataModel;
import com.sundram.urbanclapclone.viewallserviceactivity.pecservice.ViewAllPlumber;
import com.sundram.urbanclapclone.viewallserviceactivity.salonathome.ViewAllServiceActivity;

import java.util.ArrayList;

public class PlumberActivity extends AppCompatActivity implements View.OnClickListener, RecyclerViewAdapter.OnServiceItemClick {

    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;
    RecyclerViewAdapter recyclerViewAdapter;
    TextView login_tv, grid_heading_tv, back_tv;
    // ImageView collapseImage_bg;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber);
        login_tv = findViewById(R.id.login_button_text);
        login_tv.setText("View all Plumber Services");
        login_tv.setOnClickListener(this);
        back_tv = findViewById(R.id.back_tv);
        back_tv.setOnClickListener(this);
        //end
        //setting up the title of collapsableToolbarLayout
        collapsingToolbarLayout = findViewById(R.id.collpasableToolbarLayout);
        collapsingToolbarLayout.setTitle("Plumber");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();


/**
 Simple GridLayoutManager that spans    two columns
 **/
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerViewAdapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        setGridSectionDetailss();
    }

    public void setGridSectionDetailss() {
        // arrayList.add(new DataModel("Quick Book", R.drawable.plumber));
        arrayList.add(new DataModel("Tap & Mixers", R.drawable.tap));
        arrayList.add(new DataModel("Blockage", R.drawable.blokage));
        arrayList.add(new DataModel("Bath Fitings", R.drawable.bathfitting));
        arrayList.add(new DataModel("Toilet", R.drawable.toilet));
        arrayList.add(new DataModel("Water Tank", R.drawable.watertank));
        arrayList.add(new DataModel("Motor", R.drawable.motor));
        //   arrayList.add(new DataModel("Altered Nozzle", R.drawable.plumber));
        //    arrayList.add(new DataModel("Looking For Something else ?", R.drawable.plumber));
        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_tv:
                onBackPressed();
                break;
            case R.id.login_button_text:
                Intent jump = new Intent(PlumberActivity.this, ViewAllPlumber.class);
                startActivity(jump);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(PlumberActivity.this, PECActivity.class);
        startActivity(back);
        finish();
    }

    @Override
    public void onClick(int position) {
        switch (position) {
            case 0:
                jumpToIntent("0");
                break;
            case 1:
                jumpToIntent("1");
                break;
            case 2:
                jumpToIntent("2");
                break;
            case 3:
                jumpToIntent("3");
                break;
            case 4:
                jumpToIntent("4");
                break;
            case 5:
                jumpToIntent("5");
                break;
        }
    }

    public Intent jumpToIntent(String tabNumber) {
        Intent jump = new Intent(PlumberActivity.this, ViewAllPlumber.class);
        jump.putExtra("TabNumber", tabNumber);
        startActivity(jump);
        finish();
        return jump;
    }
}
