package com.sundram.urbanclapclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.adapter.AdapterHorrizontalButton;
import com.sundram.urbanclapclone.adapter.PECAdapter;
import com.sundram.urbanclapclone.datamodel.CarpenterDataModel;
import com.sundram.urbanclapclone.datamodel.DataModel;
import com.sundram.urbanclapclone.methodscroll.Scroll;

import java.util.ArrayList;

public class ViewAllFullHomeDeepCleaning extends AppCompatActivity {

    private Toolbar toolbarViewAll;
    private TextView login_button_text;
    private RecyclerView btnRecyclerView;
    private DataModel horrizontalbtnDataModel;
    private ArrayList<CarpenterDataModel> mLists;
    private AdapterHorrizontalButton btnAdapter;
    private NestedScrollView nestedScrollView;

    private ArrayList<DataModel> btnList;


    private ArrayList<CarpenterDataModel> one_bhkList, two_bhkList,  three_bhkList, fourWaxList, fiveList, haircareList, threadingList;
    private RecyclerView one_bhkRecycler,two_bhkRecycler, three_bhkRecyclerview, fourRecyclerView, fiveRecyclerView, hairCareRecyclerView, threadingRecyclerView;
    private TextView view_one_bhk_heading,view_two_bhk_heading, view_three_bhkHeading, fourHeading, fiveHeading, haircareHeading, threadingHeading;
    private PECAdapter one_bhkAdapter, two_bhkAdapter, three_bhkAdapter, fourAdapter, fiveAdapter, haircareAdapter, threadingAdapter;

    LinearLayout hardwax_Linearlayout;
    Scroll scroll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_new);
        toolbarViewAll = findViewById(R.id.toolbarViewAll);
        setSupportActionBar(toolbarViewAll);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Full Home Deep Cleaning");
        scroll = new Scroll(this);

        hardwax_Linearlayout = findViewById(R.id.hardwaxLinearlayout);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        btnRecyclerView = findViewById(R.id.horizontal_scrolling_btn_recyclerView);
        login_button_text = findViewById(R.id.login_button_text);
        login_button_text.setText("Check Out");
        setHorrizontalBtn();
        settingUpTheOneBHk();

        haircareHeading = findViewById(R.id.hairecareHeading);
        hairCareRecyclerView = findViewById(R.id.hairCareRecyclerview);
        haircareHeading.setVisibility(View.GONE);
        hairCareRecyclerView.setVisibility(View.GONE);

        threadingHeading = findViewById(R.id.threadingHeading);
        threadingRecyclerView = findViewById(R.id.threadingRecyclerview);
        threadingHeading.setVisibility(View.GONE);
        threadingRecyclerView.setVisibility(View.GONE);

    }

    public void setHorrizontalBtn() {
        btnList = new ArrayList<>();
        btnRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        btnList.add(new DataModel("1-BHK Home Cleaning"));
        btnList.add(new DataModel("2-BHK Home Cleaning"));
        btnList.add(new DataModel("3-BHK Home Cleaning"));
        btnList.add(new DataModel("4-BHK Home Cleaning"));
        btnList.add(new DataModel("5-BHK Home Cleaning"));

        btnAdapter = new AdapterHorrizontalButton(btnList, this, new AdapterHorrizontalButton.onRecyclerViewItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

            }
        });

        btnRecyclerView.setAdapter(btnAdapter);
        btnAdapter.notifyDataSetChanged();
    }


    public void settingUpTheOneBHk() {

        view_one_bhk_heading = findViewById(R.id.hardWaxHeading);
        view_one_bhk_heading.setText("One BHK Home Cleaning");
        one_bhkRecycler = findViewById(R.id.hardWaxRecycler);
        one_bhkList = new ArrayList<>();
        one_bhkRecycler.setLayoutManager(new LinearLayoutManager(this));
        one_bhkList.add(new CarpenterDataModel("Full Home Deep Cleaning","", "4499", "150",0));
        one_bhkList.add(new CarpenterDataModel("Full Deep Cleaning & Sofa Set Shampoo","", "1254", "20",0));
        one_bhkList.add(new CarpenterDataModel("Full Deep Cleaning & Ant Control","", "1254", "20",0));
        one_bhkList.add(new CarpenterDataModel("Full Deep Cleaning & Mosquito Control","", "1254", "20",0));
        one_bhkAdapter=new PECAdapter(this, one_bhkList, new PECAdapter.OnServiceItemClick() {
                    @Override
                    public void OnClick(int position) {

                    }

                    @Override
                    public void OnClick(String value) {

                    }
                });
        one_bhkRecycler.setAdapter(one_bhkAdapter);
        one_bhkAdapter.notifyDataSetChanged();
        settinguptheTwoBHK();
    }
    public void settinguptheTwoBHK(){
        view_two_bhk_heading = findViewById(R.id.fruitWaxHeading);
        view_two_bhk_heading.setText("Two BHK Home Cleaning Service");
        two_bhkRecycler = findViewById(R.id.ricaWaxRecycler);
        two_bhkList = new ArrayList<>();
        two_bhkRecycler.setLayoutManager(new LinearLayoutManager(this));
        two_bhkList.add(new CarpenterDataModel("Full Home Deep Cleaning","", "4499", "150",0));
        two_bhkList.add(new CarpenterDataModel("Full Deep Cleaning & Sofa Set Shampoo","", "1254", "20",0));
        two_bhkList.add(new CarpenterDataModel("Full Deep Cleaning & Ant Control","", "1254", "20",0));
        two_bhkList.add(new CarpenterDataModel("Full Deep Cleaning & Mosquito Control","", "1254", "20",0));
        two_bhkAdapter=new PECAdapter(this, two_bhkList, new PECAdapter.OnServiceItemClick() {
            @Override
            public void OnClick(int position) {

            }

            @Override
            public void OnClick(String value) {

            }
        });

        two_bhkRecycler.setAdapter(two_bhkAdapter);
        two_bhkAdapter.notifyDataSetChanged();
        settinguptheThreBHK();
    }
    public void settinguptheThreBHK(){
        view_three_bhkHeading = findViewById(R.id.honeyWaxHeading);
        view_three_bhkHeading.setText("3-BHK Home Cleaning Service");
        three_bhkRecyclerview = findViewById(R.id.honeyWaxRecycler);
        three_bhkList = new ArrayList<>();
        three_bhkRecyclerview.setLayoutManager(new LinearLayoutManager(ViewAllFullHomeDeepCleaning.this));
        three_bhkList.add(new CarpenterDataModel("Full Home Deep Cleaning","", "4499", "150",0));
        three_bhkList.add(new CarpenterDataModel("Full Deep Cleaning & Sofa Set Shampoo","", "1254", "20",0));
        three_bhkList.add(new CarpenterDataModel("Full Deep Cleaning & Ant Control","", "1254", "20",0));
        three_bhkList.add(new CarpenterDataModel("Full Deep Cleaning & Mosquito Control","", "1254", "20",0));
        three_bhkAdapter = new PECAdapter(this, three_bhkList, new PECAdapter.OnServiceItemClick() {
            @Override
            public void OnClick(int position) {

            }

            @Override
            public void OnClick(String value) {

            }
        });
        three_bhkRecyclerview.setAdapter(three_bhkAdapter);
        three_bhkAdapter.notifyDataSetChanged();
        settinguptheFourBHK();
    }
    public void settinguptheFourBHK(){
        fourHeading = findViewById(R.id.facialHeading);
        fourHeading.setText("4-BHK Home Cleaning Service");
        fourRecyclerView = findViewById(R.id.facialRecyclerView);
        fourWaxList = new ArrayList<>();
        fourRecyclerView.setLayoutManager(new LinearLayoutManager(ViewAllFullHomeDeepCleaning.this));
        fourWaxList.add(new CarpenterDataModel("Full Home Deep Cleaning","", "4499", "150",0));
        fourWaxList.add(new CarpenterDataModel("Full Deep Cleaning & Sofa Set Shampoo","", "1254", "20",0));
        fourWaxList.add(new CarpenterDataModel("Full Deep Cleaning & Ant Control","", "1254", "20",0));
        fourWaxList.add(new CarpenterDataModel("Full Deep Cleaning & Mosquito Control","", "1254", "20",0));
        fourAdapter = new PECAdapter(this, fourWaxList, new PECAdapter.OnServiceItemClick() {
            @Override
            public void OnClick(int position) {

            }

            @Override
            public void OnClick(String value) {

            }
        });
        fourRecyclerView.setAdapter(fourAdapter);
        fourAdapter.notifyDataSetChanged();
        settinguptheFiveBHK();
    }
    public void settinguptheFiveBHK(){
        fiveHeading = findViewById(R.id.manicure_and_pedicure_heading);
        fiveHeading.setText("5-=BHK Home Cleaning Service");
        fiveRecyclerView = findViewById(R.id.manicureRecyclerView);
        fiveList = new ArrayList<>();
        fiveRecyclerView.setLayoutManager(new LinearLayoutManager(ViewAllFullHomeDeepCleaning.this));
        fiveList.add(new CarpenterDataModel("Full Home Deep Cleaning","", "4499", "150",0));
        fiveList.add(new CarpenterDataModel("Full Deep Cleaning & Sofa Set Shampoo","", "1254", "20",0));
        fiveList.add(new CarpenterDataModel("Full Deep Cleaning & Ant Control","", "1254", "20",0));
        fiveList.add(new CarpenterDataModel("Full Deep Cleaning & Mosquito Control","", "1254", "20",0));

        fiveAdapter = new PECAdapter(this, fiveList, new PECAdapter.OnServiceItemClick() {
            @Override
            public void OnClick(int position) {

            }

            @Override
            public void OnClick(String value) {

            }
        });
        fiveRecyclerView.setAdapter(fiveAdapter);
        fiveAdapter.notifyDataSetChanged();

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
        startActivity(new Intent(ViewAllFullHomeDeepCleaning.this, FullHomeDeepCleaning.class));
        finish();
    }
}
