package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GuranteeActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView tv_back_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gurantee);
        toolbar = findViewById(R.id.gurantee_collpasableToolbar);
        setSupportActionBar(toolbar);
        tv_back_tv = findViewById(R.id.tv_back);
        tv_back_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_back:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent ii = new Intent(GuranteeActivity.this,DashBoard.class);
        startActivity(ii);
        finish();
        super.onBackPressed();
    }
}
