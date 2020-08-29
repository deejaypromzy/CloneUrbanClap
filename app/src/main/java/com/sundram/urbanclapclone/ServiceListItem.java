package com.sundram.urbanclapclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ServiceListItem extends AppCompatActivity implements View.OnClickListener {

    Toolbar service_list_toolbar;
    TextView back_tv;
    LinearLayout sofa_ll, bathroom_ll, carpet_ll, kitchen_ll, fullHome_ll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list_item);
        service_list_toolbar = findViewById(R.id.service_list_toolbar);
        setSupportActionBar(service_list_toolbar);
        back_tv = service_list_toolbar.findViewById(R.id.back_tvs);
        back_tv.setOnClickListener(this);

        //getting the ids of the all cleaning servicecs and set OnClickListners
        sofa_ll = findViewById(R.id.sofa_linearLayout);
        bathroom_ll = findViewById(R.id.bathroomCleaning_linearLayout1);
        carpet_ll = findViewById(R.id.carpetCleaning_linearLayout2);
        kitchen_ll = findViewById(R.id.kitchenCleaning_linearLayout3);
        fullHome_ll = findViewById(R.id.fullHome_linearLayout4);

        sofa_ll.setOnClickListener(this);
        bathroom_ll.setOnClickListener(this);
        carpet_ll.setOnClickListener(this);
        kitchen_ll.setOnClickListener(this);
        fullHome_ll.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ServiceListItem.this, DashBoard.class);
        startActivity(back);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_tvs:
                onBackPressed();
                break;
            case R.id.sofa_linearLayout:
                Intent sofa = new Intent(ServiceListItem.this, SofaCleaning.class);
                startActivity(sofa);
                finish();
                break;
            case R.id.bathroomCleaning_linearLayout1:
                Intent bathroom = new Intent(ServiceListItem.this, BathroomCleaning.class);
                startActivity(bathroom);
                finish();
                break;
            case R.id.carpetCleaning_linearLayout2:
                Intent carpets = new Intent(ServiceListItem.this, CarpetCleanigActivity.class);
                startActivity(carpets);
                finish();
                break;
            case R.id.kitchenCleaning_linearLayout3:
                Intent kitchen = new Intent(ServiceListItem.this, KitchenCleaningActivity.class);
                startActivity(kitchen);
                finish();
                break;
            case R.id.fullHome_linearLayout4:
                Intent fullhome = new Intent(ServiceListItem.this, FullHomeDeepCleaning.class);
                startActivity(fullhome);
                finish();
                break;
        }
    }
}
