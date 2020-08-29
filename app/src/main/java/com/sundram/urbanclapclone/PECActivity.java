package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PECActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar pec_toolbar;
    TextView back_tv;
    LinearLayout ec_ll,plumber_ll,carpenter_ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pec);
        pec_toolbar = findViewById(R.id.service_list_toolbar);
        setSupportActionBar(pec_toolbar);

        back_tv = pec_toolbar.findViewById(R.id.back_tvs);
        ec_ll = findViewById(R.id.electronic_ll);
        plumber_ll = findViewById(R.id.plumber_ll);
        carpenter_ll = findViewById(R.id.carpenter_ll);

        back_tv.setOnClickListener(this);
        ec_ll.setOnClickListener(this);
        plumber_ll.setOnClickListener(this);
        carpenter_ll.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(PECActivity.this,DashBoard.class);
        startActivity(back);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_tvs:
                onBackPressed();
                break;
            case R.id.electronic_ll:
                Intent ec_intent = new Intent(PECActivity.this,ElectricianActivity.class);
                startActivity(ec_intent);
                finish();
                break;
            case R.id.plumber_ll:
                Intent plumber_intent = new Intent(PECActivity.this,PlumberActivity.class);
                startActivity(plumber_intent);
                finish();
                break;
            case R.id.carpenter_ll:
               Intent carpenter_intent = new Intent(PECActivity.this,CarpenterActivity.class);
               startActivity(carpenter_intent);
               finish();
        }
    }
}
