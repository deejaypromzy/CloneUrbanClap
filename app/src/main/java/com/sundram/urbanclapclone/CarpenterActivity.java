package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.sundram.urbanclapclone.adapter.RecyclerViewAdapter;
import com.sundram.urbanclapclone.datamodel.DataModel;
import com.sundram.urbanclapclone.viewallserviceactivity.pecservice.ViewAllCarpenter;
import com.sundram.urbanclapclone.viewallserviceactivity.salonathome.ViewAllServiceActivity;

import java.util.ArrayList;

public class CarpenterActivity extends AppCompatActivity implements View.OnClickListener, RecyclerViewAdapter.OnServiceItemClick {

    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;
    RecyclerViewAdapter recyclerViewAdapter;
    TextView login_tv, grid_heading_tv, back_tv;
    // ImageView collapseImage_bg;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpenter);
        login_tv = findViewById(R.id.login_button_text);
        login_tv.setText("View all Carpenter Services");

        back_tv = findViewById(R.id.back_tv);
        back_tv.setOnClickListener(this);

        collapsingToolbarLayout = findViewById(R.id.collpasableToolbarLayout);
        collapsingToolbarLayout.setTitle("Carpenter Services");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerViewAdapter = new RecyclerViewAdapter(this, arrayList,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        setGridSectionDetailss();
    }

    public void setGridSectionDetailss() {
        //arrayList.add(new DataModel("Quick Book", R.drawable.plumber));
        arrayList.add(new DataModel("Drill & Hang", R.drawable.drillandhang));
        arrayList.add(new DataModel("Door", R.drawable.door));
        arrayList.add(new DataModel("Drawer & Cupboard", R.drawable.drawer));
        arrayList.add(new DataModel("Window", R.drawable.window));
        arrayList.add(new DataModel("Bed", R.drawable.bed));
        arrayList.add(new DataModel("Curtain Blinds", R.drawable.curtain));
    //    arrayList.add(new DataModel("Furniture Repair", R.drawable.carpenter));
        arrayList.add(new DataModel("TV", R.drawable.tvframe));
       // arrayList.add(new DataModel("Furniture Assembly", R.drawable.plumber));
    //    arrayList.add(new DataModel("Miscellaneous", R.drawable.plumber));
     //   arrayList.add(new DataModel("Looking for something else ?", R.drawable.plumber));
        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_tv:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(CarpenterActivity.this,PECActivity.class);
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
            case 6:
                jumpToIntent("6");
                break;
        }
    }

    public Intent jumpToIntent(String tabNumber) {
        Intent jump = new Intent(CarpenterActivity.this, ViewAllCarpenter.class);
        jump.putExtra("TabNumber", tabNumber);
        startActivity(jump);
        finish();
        return jump;
    }

}
