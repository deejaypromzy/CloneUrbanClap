package com.sundram.urbanclapclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.sundram.urbanclapclone.viewallserviceactivity.salonathome.ViewAllServiceActivity;

public class ViewCartActivity extends AppCompatActivity implements View.OnClickListener {


    RecyclerView addCartRecyclerview;
    Toolbar viewCartToolbar;
    TextView goBack, cartText;
    TextInputLayout textInputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);
        init();
        setToolbar();
    }

    public void init(){
        viewCartToolbar = findViewById(R.id.viewCartToolbar);
        goBack = findViewById(R.id.goBack);
        textInputLayout = findViewById(R.id.textInputLayout);
        goBack.setOnClickListener(this);
        cartText = findViewById(R.id.cartText);

    }

    public void setToolbar() {
        setSupportActionBar(viewCartToolbar);
        getSupportActionBar().setTitle("View Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(ViewCartActivity.this, DashBoard.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goBack:
                if (cartText.getText().toString().equals("Cart is Empty")){
                    startActivity(new Intent(ViewCartActivity.this,DashBoard.class));
                }else{
                    //jump to checkout activity
                }
        }
    }
}
