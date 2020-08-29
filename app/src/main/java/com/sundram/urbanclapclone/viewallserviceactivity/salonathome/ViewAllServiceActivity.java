package com.sundram.urbanclapclone.viewallserviceactivity.salonathome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.SalonAtHome;
import com.sundram.urbanclapclone.ViewCartActivity;
import com.sundram.urbanclapclone.adapter.SectionViewAllServiceListAdapter;
import com.sundram.urbanclapclone.adapter.ViewPagerAdapter;
import com.sundram.urbanclapclone.fagments.salonathomeservice.FragmentViewAllTab1;
import com.sundram.urbanclapclone.fagments.salonathomeservice.FragmentViewAllTab2;
import com.sundram.urbanclapclone.fagments.salonathomeservice.FragmentViewAllTab3;
import com.sundram.urbanclapclone.fagments.salonathomeservice.FragmentViewAllTab4;
import com.sundram.urbanclapclone.fagments.salonathomeservice.FragmentViewAllTab5;
import com.sundram.urbanclapclone.fagments.salonathomeservice.FragmentViewAllTab6;
import com.sundram.urbanclapclone.fagments.salonathomeservice.FragmentViewAllTab7;

import java.util.List;

public class ViewAllServiceActivity extends AppCompatActivity implements View.OnClickListener, SectionViewAllServiceListAdapter.OnServiceItemClick {

    //This is our tablayout
    private TabLayout tabLayout;
    private Toolbar toolbarViewAll;
    //This is our viewPager
    private ViewPager viewPager;
    //Fragments
    FragmentViewAllTab1 fragmentViewAllTab1;
    FragmentViewAllTab2 fragmentViewAllTab2;
    FragmentViewAllTab3 fragmentViewAllTab3;
    FragmentViewAllTab4 fragmentViewAllTab4;
    FragmentViewAllTab5 fragmentViewAllTab5;
    FragmentViewAllTab6 fragmentViewAllTab6;
    FragmentViewAllTab7 fragmentViewAllTab7;
    SectionViewAllServiceListAdapter adapter;

    String[] tabTitle = {
            "Hard Waxing",
            "Fruit Waxing",
            "Honey/Soft Waxing",
            "Facial, Bleach and Detan",
            "Manicure & Pedicure",
            "Hair Care",
            "Threading"};
    int[] unreadCount = {0, 0, 0, 0, 0, 0, 0};

    TextView view_cart,login_button_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_service);
        toolbarViewAll = findViewById(R.id.toolbarViewAll);
        setSupportActionBar(toolbarViewAll);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getSupportActionBar().setTitle("Salon At Home");

        adapter = new SectionViewAllServiceListAdapter(ViewAllServiceActivity.this,this);
        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);
        login_button_text = findViewById(R.id.login_button_text);
        login_button_text.setText("Check Out");
        login_button_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ViewAllServiceActivity.this,"Not Working....",Toast.LENGTH_LONG).show();

            }
        });
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
            Log.e("TabNumberServiceList", tab);
            switchToTab(tab);
        }


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
        } else if (tab.equals("6")) {
            viewPager.setCurrentItem(6);
        }
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragmentViewAllTab1 = new FragmentViewAllTab1();
        fragmentViewAllTab2 = new FragmentViewAllTab2();
        fragmentViewAllTab3 = new FragmentViewAllTab3();
        fragmentViewAllTab4 = new FragmentViewAllTab4();
        fragmentViewAllTab5 = new FragmentViewAllTab5();
        fragmentViewAllTab6 = new FragmentViewAllTab6();
        fragmentViewAllTab7 = new FragmentViewAllTab7();

        adapter.addFragment(fragmentViewAllTab1, "Monthly Essentials");
        adapter.addFragment(fragmentViewAllTab2, "Waxing &  Packages");
        adapter.addFragment(fragmentViewAllTab3, "RICA Waxing");
        adapter.addFragment(fragmentViewAllTab4, "Honey Waxing");
        adapter.addFragment(fragmentViewAllTab5, "Packages");
        adapter.addFragment(fragmentViewAllTab6, "Medicure and Pedicure");
        adapter.addFragment(fragmentViewAllTab7, "Hair Care");
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
        startActivity(new Intent(ViewAllServiceActivity.this, SalonAtHome.class));
        finish();
    }


    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//        }
    }

    @Override
    public void onClick(String position,int pos,View view) {
        String text = position;
        Toast.makeText(ViewAllServiceActivity.this," "+text,Toast.LENGTH_SHORT).show();
    }
}
