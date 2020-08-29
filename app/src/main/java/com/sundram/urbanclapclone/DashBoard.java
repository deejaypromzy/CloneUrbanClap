package com.sundram.urbanclapclone;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.sundram.urbanclapclone.connectionchecker.NetworkChangeReceiver;
import com.sundram.urbanclapclone.fagments.HelpCenterFragment;
import com.sundram.urbanclapclone.fagments.HomeFragment;
import com.sundram.urbanclapclone.fagments.MyBookingFragment;
import com.sundram.urbanclapclone.fagments.ProfileFragment;

public class DashBoard extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottom_nav_view;
    Fragment fragment;
    HomeFragment homeFragment;
    public static TextView tv_check_connection;
    private BroadcastReceiver mNetworkReceiver;
  //  @Override
//    protected void onStart() {
//        super.onStart();
//        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        homeFragment = new HomeFragment();
        bottom_nav_view = findViewById(R.id.bottom_nav_view);
        bottom_nav_view.setOnNavigationItemSelectedListener(this);
        tv_check_connection = findViewById(R.id.tv_check_connection);
      //  String address = getIntent().getStringExtra("address");
        //Toast.makeText(DashBoard.this,address,Toast.LENGTH_LONG).show();
        // it makes default fragment
        mNetworkReceiver = new NetworkChangeReceiver();
        registerNetworkBroadcastForNougat();
        loadFragment(new HomeFragment());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int menuItemId = menuItem.getItemId();
        int id[] = new int[]{R.id.action_home, R.id.action_my_booking, R.id.action_help_center, R.id.action_profile};
        fragment = null;
        if (menuItemId == id[0]) {
            fragment = new HomeFragment();
        } else if (menuItemId == id[1]) {
            fragment = new MyBookingFragment();
        } else if (menuItemId == id[2]) {
            fragment = new HelpCenterFragment();
        } else if (menuItemId == id[3]) {
            fragment = new ProfileFragment();
        }

        return loadFragment(fragment);
    }

    // use to load and switch the fragments
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to exit !")

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static void dialog(boolean value){

        if(value){
            tv_check_connection.setText("Network Connected !!!");
            tv_check_connection.setBackgroundColor(Color.GREEN);
            tv_check_connection.setTextColor(Color.WHITE);

            Handler handler = new Handler();
            Runnable delayrunnable = new Runnable() {
                @Override
                public void run() {
                    tv_check_connection.setVisibility(View.GONE);
                }
            };
            handler.postDelayed(delayrunnable, 3000);
        }else {
            tv_check_connection.setVisibility(View.VISIBLE);
            tv_check_connection.setText("Could not Connect to internet");
            tv_check_connection.setBackgroundColor(Color.RED);
            tv_check_connection.setTextColor(Color.WHITE);
        }
    }
    private void registerNetworkBroadcastForNougat() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected void unregisterNetworkChanges() {
        try {
            unregisterReceiver(mNetworkReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterNetworkChanges();
    }
}
