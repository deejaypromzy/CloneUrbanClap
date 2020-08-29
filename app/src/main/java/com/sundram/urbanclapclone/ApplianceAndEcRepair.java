package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sundram.urbanclapclone.adapter.AdapterServiceList;
import com.sundram.urbanclapclone.adapter.RecyclerViewAdapter;
import com.sundram.urbanclapclone.datamodel.DataModel;

import java.util.ArrayList;

public class ApplianceAndEcRepair extends AppCompatActivity implements View.OnClickListener {

    TextView back_tv;
    Toolbar toolbar;
    LinearLayout ac_repair, geyser_repair, wm_repair, refrigetor_repair, ro_repair, microwave_repair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_and_ec_repair);
        toolbar = findViewById(R.id.service_list_toolbar);
        setSupportActionBar(toolbar);
        back_tv = toolbar.findViewById(R.id.back_tvs);
        back_tv.setOnClickListener(this);

        ac_repair = findViewById(R.id.ac_repair_ll);
        geyser_repair = findViewById(R.id.geyser_repair_ll);
        wm_repair = findViewById(R.id.wm_repair_ll);
        refrigetor_repair = findViewById(R.id.rerigerator_repair_ll);
        ro_repair = findViewById(R.id.ro_repair_ll);
        microwave_repair = findViewById(R.id.microwave_repair_ll);

        ac_repair.setOnClickListener(this);
        geyser_repair.setOnClickListener(this);
        wm_repair.setOnClickListener(this);
        refrigetor_repair.setOnClickListener(this);
        ro_repair.setOnClickListener(this);
        microwave_repair.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ApplianceAndEcRepair.this, DashBoard.class);
        startActivity(back);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_tvs:
                onBackPressed();
                break;
            case R.id.ac_repair_ll:
                Intent i = new Intent(ApplianceAndEcRepair.this, AcServiceAndRepair.class);
                startActivity(i);
                finish();
                break;
            case R.id.wm_repair_ll:
                Intent ii = new Intent(ApplianceAndEcRepair.this, WashingmachineRepair.class);
                startActivity(ii);
                finish();
                break;
            case R.id.rerigerator_repair_ll:
                Intent iii = new Intent(ApplianceAndEcRepair.this, RefrigeratorRepair.class);
                startActivity(iii);
                finish();
                break;
            case R.id.ro_repair_ll:
                Intent iiii = new Intent(ApplianceAndEcRepair.this,RoandWaterActivity.class);
                startActivity(iiii);
                finish();
                break;
            case R.id.microwave_repair_ll:
                Intent iiiii = new Intent(ApplianceAndEcRepair.this, MicroWaveRepair.class);
                startActivity(iiiii);
                finish();
                break;
            case R.id.geyser_repair_ll:
                Intent iiiiii = new Intent(ApplianceAndEcRepair.this, GyserServiceAndRepair.class);
                startActivity(iiiiii);
                finish();
                break;
        }
    }
}
