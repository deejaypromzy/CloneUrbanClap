package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.sundram.urbanclapclone.adapter.RecyclerViewAdapter;
import com.sundram.urbanclapclone.datamodel.DataModel;
import com.sundram.urbanclapclone.methodscroll.Scroll;

import java.util.ArrayList;

public class SalonAtHome extends AppCompatActivity implements View.OnClickListener, RecyclerViewAdapter.OnServiceItemClick {

    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;
    RecyclerViewAdapter recyclerViewAdapter;
    TextView login_tv, grid_heading_tv, back_tv;
    CollapsingToolbarLayout collapsingToolbarLayout;
    String tabNumber;
    Context context;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_at_home);
        //getting ids of all the views
        login_tv = findViewById(R.id.login_button_text);
        grid_heading_tv = findViewById(R.id.grid_heading);
        back_tv = findViewById(R.id.back_tv);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        collapsingToolbarLayout = findViewById(R.id.collpasableToolbarLayout);
        login_tv.setText("View all Salon Service");
        //setting up the heading of grid view
        //grid_heading_tv.setText("Salon At Home");
        //end
        //setting up the title of collapsableToolbarLayout
        collapsingToolbarLayout.setTitle("Salon at Home");
        //collapsingToolbarLayout.setCollapsedTitleTextColor(ColorStateList.valueOf(R.color.white));

        //setting collapsetoolbar bg
        //      collapseImage_bg = findViewById(R.id.collapse_iv);
        //collapseImage_bg.setBackgroundResource(R.drawable.homesalon);

        //setting up the listners
        back_tv.setOnClickListener(this);
        login_tv.setOnClickListener(this);
        //end
        arrayList = new ArrayList<>();


/**
 Simple GridLayoutManager that spans    two columns
 **/
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerViewAdapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        setGridSectionDetails();

    }

    public void setGridSectionDetails() {
        arrayList.add(new DataModel("Hard Waxing", R.drawable.waxing));
        arrayList.add(new DataModel("Fruit Waxing", R.drawable.rica_waxing));
        arrayList.add(new DataModel("Honey/Soft Waxing", R.drawable.waxing));
        arrayList.add(new DataModel("Facial, Bleach and Detan", R.drawable.facial));
        arrayList.add(new DataModel("Manicure & Pedicure", R.drawable.medicure));
        arrayList.add(new DataModel("Hair Care", R.drawable.hair));
        arrayList.add(new DataModel("Threading", R.drawable.threading));
        recyclerViewAdapter.notifyDataSetChanged();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_tv:
                onBackPressed();
                break;
            case R.id.login_button_text:
                startActivity(new Intent(SalonAtHome.this, ViewAllServiceActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent ii = new Intent(SalonAtHome.this, DashBoard.class);
        startActivity(ii);
        finish();
    }

    @Override
    public void onClick(int position) {
        switch (position) {
            case 0:
               jumpIntent("0");
                break;
            case 1:
                jumpIntent("1");
                break;
            case 2:
                jumpIntent("2");
                break;
            case 3:
                jumpIntent("3");
                break;
            case 4:
                jumpIntent("4");
                break;
            case 5:
                jumpIntent("5");
                break;
            case 6:
                jumpIntent("6");
                break;
        }
    }

    public Intent jumpIntent(String position){
        Intent jumpIntent = new Intent(SalonAtHome.this, ViewAllServiceActivity.class);
        jumpIntent.putExtra("TabNumber",position);
        startActivity(jumpIntent);
        finish();
        return jumpIntent;
    }
}
