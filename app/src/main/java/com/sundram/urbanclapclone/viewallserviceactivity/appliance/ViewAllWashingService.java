package com.sundram.urbanclapclone.viewallserviceactivity.appliance;

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
import com.sundram.urbanclapclone.GyserServiceAndRepair;
import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.WashingmachineRepair;
import com.sundram.urbanclapclone.adapter.ViewPagerAdapter;
import com.sundram.urbanclapclone.fagments.appliance.washingService.InstallAndUninstall;
import com.sundram.urbanclapclone.fagments.appliance.washingService.Repair;
import com.sundram.urbanclapclone.fagments.appliance.washingService.Service;

public class ViewAllWashingService extends AppCompatActivity {

    //This is our tablayout
    private TabLayout tabLayout;
    private Toolbar toolbarViewAll;
    //This is our viewPager
    private ViewPager viewPager;

    String[] tabTitle = {
            "Service",
            "Repair",
            "Install & Uninstall"};

    int[] unreadCount = {0, 0, 0};

    //fragments
    Service service;
    Repair repair;
    InstallAndUninstall installAndUninstall;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_service);
        toolbarViewAll = findViewById(R.id.toolbarViewAll);
        setSupportActionBar(toolbarViewAll);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Washing Machine Services");
        setUpTabLayout();
    }

    public void setUpTabLayout(){
        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        tabLayout =findViewById(R.id.tablayout);
        setUpViewPager(viewPager);
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
                viewPager.setCurrentItem(position,true);
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

    //snippets for switching the tab
    public void switchToTab(String tab) {
        if (tab.equals("0")) {
            viewPager.setCurrentItem(0);
        } else if (tab.equals("1")) {
            viewPager.setCurrentItem(1);
        } else if (tab.equals("2")) {
            viewPager.setCurrentItem(2);
        }
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
    public void setUpViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        service = new Service();
        repair = new Repair();
        installAndUninstall = new InstallAndUninstall();

        viewPagerAdapter.addFragment(service,"Washing Machine Service");
        viewPagerAdapter.addFragment(repair,"Washing Machine Service");
        viewPagerAdapter.addFragment(installAndUninstall,"Washing Machine Service");
        viewPager.setAdapter(viewPagerAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ViewAllWashingService.this, WashingmachineRepair.class));
        finish();
    }
}
