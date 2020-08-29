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
import com.sundram.urbanclapclone.CarpenterActivity;
import com.sundram.urbanclapclone.ElectricianActivity;
import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.adapter.ViewPagerAdapter;
import com.sundram.urbanclapclone.fagments.pecfragment.carpenter.Bed;
import com.sundram.urbanclapclone.fagments.pecfragment.carpenter.CurtainBlinds;
import com.sundram.urbanclapclone.fagments.pecfragment.carpenter.Door;
import com.sundram.urbanclapclone.fagments.pecfragment.carpenter.DrawerAndCupboard;
import com.sundram.urbanclapclone.fagments.pecfragment.carpenter.DrillAndHang;
import com.sundram.urbanclapclone.fagments.pecfragment.carpenter.FurnitureRepair;
import com.sundram.urbanclapclone.fagments.pecfragment.carpenter.TV;
import com.sundram.urbanclapclone.fagments.pecfragment.carpenter.Window;

public class ViewAllCarpenter extends AppCompatActivity {

    private TabLayout tabLayout;
    private Toolbar toolbarViewAll;
    //This is our viewPager
    private ViewPager viewPager;


    String[] tabTitle = {
            "Drill & Hang",
            "Door",
            "Drawer & Cupboard",
            "Window",
            "Bed",
            "Curtain Blinds",
            "Furniture Repair",
            "TV Frame and Install/Uninstall"};
    int[] unreadCount = {0, 0, 0, 0, 0, 0, 0, 0};

    //fragments
    DrillAndHang drillAndHang;
    Door door;
    DrawerAndCupboard drawerAndCupboard;
    Window window;
    Bed bed;
    CurtainBlinds curtainBlinds;
    FurnitureRepair furnitureRepair;
    TV tv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_service);
        toolbarViewAll = findViewById(R.id.toolbarViewAll);
        setSupportActionBar(toolbarViewAll);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Carpenter");
        //tabLayout
        setUpTheTablayout();
    }

    public void setUpTheTablayout() {
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

    //snippets for switching the tab
    public void switchToTab(String tab) {
        if (tab.equals("0")) {
            viewPager.setCurrentItem(0);
        } else if (tab.equals("1")) {
            viewPager.setCurrentItem(1);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        drillAndHang = new DrillAndHang();
        door = new Door();
        drawerAndCupboard = new DrawerAndCupboard();
        window = new Window();
        bed = new Bed();
        curtainBlinds = new CurtainBlinds();
        furnitureRepair = new FurnitureRepair();
        tv = new TV();

        adapter.addFragment(drillAndHang, "Drill And Hang");
        adapter.addFragment(door, "Door");
        adapter.addFragment(drawerAndCupboard, "Door");
        adapter.addFragment(window, "Door");
        adapter.addFragment(bed, "Door");
        adapter.addFragment(curtainBlinds, "Door");
        adapter.addFragment(furnitureRepair, "Door");
        adapter.addFragment(tv, "Door");

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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(ViewAllCarpenter.this, CarpenterActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ViewAllCarpenter.this, CarpenterActivity.class));
        finish();
    }
}
