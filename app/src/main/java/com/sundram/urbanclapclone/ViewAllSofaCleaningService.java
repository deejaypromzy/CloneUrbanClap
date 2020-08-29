package com.sundram.urbanclapclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.adapter.SectionViewAllServiceListAdapter;
import com.sundram.urbanclapclone.datamodel.SectionViewAllServiceListModel;

import java.util.ArrayList;

public class ViewAllSofaCleaningService extends AppCompatActivity {

    private Toolbar toolbarViewAll;
    private TextView login_button_text, section_heading;
    private RecyclerView sofaCleaningserviceRecycler;
    private RelativeLayout horrizontanBtnRelativelayouts;
    private ArrayList<SectionViewAllServiceListModel> data;
    private SectionViewAllServiceListAdapter adapter;
    private RecyclerView ricaWaxRecycler, honeyWaxRecyclerview, facialRecyclerView, manicureRecyclerView, hairCareRecyclerView, threadingRecyclerView;
    private TextView view_heading_rica_wax, view_honeyWaxHeading, facilaHeading, manicureHeading, haircareHeading, threadingHeading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_new);
        getint();
        toolbarViewAll = findViewById(R.id.toolbarViewAll);
        setSupportActionBar(toolbarViewAll);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sofa Cleaning Service");
    }

    private void getint() {
        toolbarViewAll = findViewById(R.id.toolbarViewAll);
        login_button_text = findViewById(R.id.login_button_text);
        horrizontanBtnRelativelayouts = findViewById(R.id.horrizontanBtnRelativelayout);
        horrizontanBtnRelativelayouts.setVisibility(View.GONE);
        login_button_text.setText("Check Out");
        section_heading = findViewById(R.id.hardWaxHeading);
        section_heading.setText("Sofa Cleaning Service");

        sofaCleaningserviceRecycler = findViewById(R.id.hardWaxRecycler);
        //hide the views
        ricaWaxRecycler = findViewById(R.id.ricaWaxRecycler);
        ricaWaxRecycler.setVisibility(View.GONE);

        view_heading_rica_wax = findViewById(R.id.fruitWaxHeading);
        view_heading_rica_wax.setVisibility(View.GONE);

        honeyWaxRecyclerview = findViewById(R.id.honeyWaxRecycler);
        view_honeyWaxHeading = findViewById(R.id.honeyWaxHeading);
        honeyWaxRecyclerview.setVisibility(View.GONE);
        view_honeyWaxHeading.setVisibility(View.GONE);


        facilaHeading = findViewById(R.id.facialHeading);
        facialRecyclerView = findViewById(R.id.facialRecyclerView);
        facilaHeading.setVisibility(View.GONE);
        facialRecyclerView.setVisibility(View.GONE);

        manicureHeading = findViewById(R.id.manicure_and_pedicure_heading);
        manicureRecyclerView = findViewById(R.id.manicureRecyclerView);
        manicureHeading.setVisibility(View.GONE);
        manicureHeading.setVisibility(View.GONE);

        haircareHeading = findViewById(R.id.hairecareHeading);
        hairCareRecyclerView = findViewById(R.id.hairCareRecyclerview);
        haircareHeading.setVisibility(View.GONE);
        hairCareRecyclerView.setVisibility(View.GONE);

        threadingHeading = findViewById(R.id.threadingHeading);
        threadingRecyclerView = findViewById(R.id.threadingRecyclerview);
        threadingHeading.setVisibility(View.GONE);
        threadingRecyclerView.setVisibility(View.GONE);
        //end
        settingupTheRecyclerView();
    }


    public void settingupTheRecyclerView() {
        data = new ArrayList<>();
        sofaCleaningserviceRecycler.setLayoutManager(new LinearLayoutManager(this));
        data.add(new SectionViewAllServiceListModel("2 Sofa Seat Cleaning", "120", "40", "Sofa Cleaning", "60 min", 0, 0, R.drawable.sofa_cleaning));
        data.add(new SectionViewAllServiceListModel("3 Sofa Seat Cleaning", "180", "40", "Sofa Cleaning", "60 min", 0, 0, R.drawable.sofa_cleaning));
        data.add(new SectionViewAllServiceListModel("4 Sofa Seat Cleaning", "190", "40", "Sofa Cleaning", "60 min", 0, 0, R.drawable.sofa_cleaning));
        data.add(new SectionViewAllServiceListModel("5 Sofa Seat Cleaning", "200", "40", "Sofa Cleaning", "60 min", 0, 0, R.drawable.sofa_cleaning));
        adapter = new SectionViewAllServiceListAdapter(this, data, new SectionViewAllServiceListAdapter.OnServiceItemClick() {
            @Override
            public void onClick(String position, int pos, View view) {
                if (!position.equals("0")) {// !position.equals("0") is use to show or hide the visibility of bottom button
                    login_button_text.setVisibility(View.VISIBLE);
                    Toast.makeText(ViewAllSofaCleaningService.this, "" + pos, Toast.LENGTH_SHORT).show();
                } else {
                    login_button_text.setVisibility(View.GONE);
                }
            }
        });
        sofaCleaningserviceRecycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ViewAllSofaCleaningService.this, SofaCleaning.class));
        finish();
    }
}
