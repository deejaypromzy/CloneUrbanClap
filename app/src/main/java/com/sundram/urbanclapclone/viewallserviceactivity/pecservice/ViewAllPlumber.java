package com.sundram.urbanclapclone.viewallserviceactivity.pecservice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sundram.urbanclapclone.ElectricianActivity;
import com.sundram.urbanclapclone.PlumberActivity;
import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.adapter.ViewPagerAdapter;
import com.sundram.urbanclapclone.fagments.pecfragment.electrician.DoorBell;
import com.sundram.urbanclapclone.fagments.pecfragment.electrician.Fan;
import com.sundram.urbanclapclone.fagments.pecfragment.electrician.InverterAndStabilizer;
import com.sundram.urbanclapclone.fagments.pecfragment.electrician.Light;
import com.sundram.urbanclapclone.fagments.pecfragment.electrician.MCBAndFuse;
import com.sundram.urbanclapclone.fagments.pecfragment.electrician.RoomHeater;
import com.sundram.urbanclapclone.fagments.pecfragment.electrician.SwitchAndSocket;
import com.sundram.urbanclapclone.fagments.pecfragment.electrician.Wiring;
import com.sundram.urbanclapclone.fagments.pecfragment.plumber.BathFitting;
import com.sundram.urbanclapclone.fagments.pecfragment.plumber.Blockage;
import com.sundram.urbanclapclone.fagments.pecfragment.plumber.Motor;
import com.sundram.urbanclapclone.fagments.pecfragment.plumber.TapAndMixers;
import com.sundram.urbanclapclone.fagments.pecfragment.plumber.Toilet;
import com.sundram.urbanclapclone.fagments.pecfragment.plumber.WaterTank;

public class ViewAllPlumber extends AppCompatActivity {

    //This is our tablayout
    private TabLayout tabLayout;
    private Toolbar toolbarViewAll;
    //This is our viewPager
    private ViewPager viewPager;

    //Fragments
    TapAndMixers tapAndMixers;
    Blockage blockage;
    BathFitting bathFitting;
    Toilet toilet;
    WaterTank waterTank;
    Motor motor;

    String[] tabTitle = {
            "Tap & Mixers",
            "Blockage",
            "Bath Fitings",
            "Toilet",
            "Water Tank",
            "Motor"};
    int[] unreadCount = {0, 0, 0, 0, 0, 0,};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_service);
        toolbarViewAll = findViewById(R.id.toolbarViewAll);
        setSupportActionBar(toolbarViewAll);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Plumber");
        setTabLayout();
    }
    public void setTabLayout(){
        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        try {
            setupTabIcons();
        } catch (Exception e) {
            e.printStackTrace();
        }


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position, false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //snippets for getting the current tab
        final Intent intent = getIntent();
        ///String hey = getIntent().getStringExtra("TabNumber");
        if (intent.hasExtra("TabNumber")) {
            String tab = intent.getExtras().getString("TabNumber");
            Log.e("TabNumberFriendList", tab);
            switchToTab(tab);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(ViewAllPlumber.this, PlumberActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //snippets for switching the tab
    public void switchToTab(String tab) {
        if (tab.equals("0")) {
            viewPager.setCurrentItem(0);
        } else if (tab.equals("1")) {
            viewPager.setCurrentItem(1);
        } else if (tab.equals("2")) {
            viewPager.setCurrentItem(2);
        } else if (tab.equals("3")) {
            viewPager.setCurrentItem(3);
        } else if (tab.equals("4")) {
            viewPager.setCurrentItem(4);
        } else if (tab.equals("5")) {
            viewPager.setCurrentItem(5);
        }
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        tapAndMixers = new TapAndMixers();
        blockage = new Blockage();
        bathFitting = new BathFitting();
        toilet = new Toilet();
        waterTank = new WaterTank();
        motor = new Motor();

       adapter.addFragment(tapAndMixers, "Tap And Mixers");
       adapter.addFragment(blockage, "Tap And Mixers");
       adapter.addFragment(bathFitting, "Tap And Mixers");
       adapter.addFragment(toilet, "Tap And Mixers");
       adapter.addFragment(waterTank, "Tap And Mixers");
       adapter.addFragment(motor, "Tap And Mixers");
        viewPager.setAdapter(adapter);
    }

    private View prepareTabView(int pos) {
        View view = getLayoutInflater().inflate(R.layout.custom_tab, null);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        TextView tv_count = (TextView) view.findViewById(R.id.tv_count);
        tv_title.setText(tabTitle[pos]);
        if (unreadCount[pos] > 0) {
            tv_count.setVisibility(View.VISIBLE);
            tv_count.setText("" + unreadCount[pos]);
        } else
            tv_count.setVisibility(View.GONE);

        return view;
    }

    private void setupTabIcons() {

        for (int i = 0; i < tabTitle.length; i++) {
            /*TabLayout.Tab tabitem = tabLayout.newTab();
            tabitem.setCustomView(prepareTabView(i));
            tabLayout.addTab(tabitem);*/

            tabLayout.getTabAt(i).setCustomView(prepareTabView(i));
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ViewAllPlumber.this,PlumberActivity.class));
        finish();
    }
}
