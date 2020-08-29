package com.sundram.urbanclapclone.Details;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.adapter.DetailsAdapter;
import com.sundram.urbanclapclone.datamodel.DataModel;
import com.sundram.urbanclapclone.viewallserviceactivity.salonathome.ViewAllServiceActivity;

import java.util.ArrayList;

public class SofaCleaningDetails extends AppCompatActivity {

    private RecyclerView benefitsrecyclerView, whatWeUseRecyclerView, pleaseNoteRecyclerview;
    private DataModel data;

    private DetailsAdapter benefitAdapter;
    private DetailsAdapter whatWeUseAdapter;
    private DetailsAdapter pleaseNoteAdapter;

    private ArrayList<DataModel> benefitsList;
    private ArrayList<DataModel> whatWeUseList;
    private ArrayList<DataModel> plaseNoteList;

    Toolbar toolbar;
    TextView login_btn_txt;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_common);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sofa Cleaning");

        login_btn_txt = findViewById(R.id.login_button_text);
        login_btn_txt.setText("Add To Cart");
        login_btn_txt.setBackgroundColor(R.color.light_royal_blue);

        setWhatWeUse();
        setBenefits();
        setPleaseNote();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ViewAllServiceActivity.class));
        finish();
    }

    public void setBenefits(){
        benefitsrecyclerView = findViewById(R.id.recyclerVew1);
        benefitsList = new ArrayList<>();
        benefitsrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        benefitsList.add(new DataModel("Removal of embedded dust mites, food particle etc"));
        benefitsList.add(new DataModel("Removal of embedded dust mites, food particle etc"));
        benefitsList.add(new DataModel("Removal of embedded dust mites, food particle etc"));
        benefitsList.add(new DataModel("Removal of embedded dust mites, food particle etc"));
        benefitAdapter = new DetailsAdapter(SofaCleaningDetails.this,benefitsList);
        benefitsrecyclerView.setAdapter(benefitAdapter);
        benefitAdapter.notifyDataSetChanged();
    }
    public void setWhatWeUse(){
        whatWeUseRecyclerView = findViewById(R.id.recyclerVew);
        whatWeUseList = new ArrayList<>();
        whatWeUseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        whatWeUseList.add(new DataModel("Disinfectant Chemicals."));
        whatWeUseList.add(new DataModel("Disinfectant Chemicals."));
        whatWeUseList.add(new DataModel("Disinfectant Chemicals."));
        whatWeUseList.add(new DataModel("Disinfectant Chemicals."));
        whatWeUseList.add(new DataModel("Disinfectant Chemicals."));
        whatWeUseAdapter = new DetailsAdapter(SofaCleaningDetails.this,whatWeUseList);
        whatWeUseRecyclerView.setAdapter(whatWeUseAdapter);
        whatWeUseAdapter.notifyDataSetChanged();
    }
    public void setPleaseNote(){
        pleaseNoteRecyclerview = findViewById(R.id.recyclerVew2);
        plaseNoteList = new ArrayList<>();
        pleaseNoteRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        plaseNoteList.add(new DataModel("We need your stool and ladder"));
        plaseNoteList.add(new DataModel("This process is take upto 60 min."));
        pleaseNoteAdapter = new DetailsAdapter(SofaCleaningDetails.this,plaseNoteList);
        pleaseNoteRecyclerview.setAdapter(pleaseNoteAdapter);
        pleaseNoteAdapter.notifyDataSetChanged();
    }
}
