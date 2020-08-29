package com.sundram.urbanclapclone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoogleMapWithSearchView extends AppCompatActivity implements OnMapReadyCallback{


    GoogleMap map;
    SearchView searchView;
    SupportMapFragment supportMapFragment;
    LatLng latLng;
    String location;
    TextView login_button_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map_with_search_view);

        searchView = findViewById(R.id.sv_location);
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                gettingMapLocation();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                map.clear();
                return false;
            }
        });
        supportMapFragment.getMapAsync(this);

        login_button_text = findViewById(R.id.login_button_text);
        login_button_text.setText("Add Address");
        login_button_text.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Toast.makeText(GoogleMapWithSearchView.this,"Location : "+location,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(GoogleMapWithSearchView.this,DashBoard.class);
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GoogleMapWithSearchView.this);
                sp.edit().putString("address", location).apply();
                startActivity(intent);
                finishAffinity();
            }
        });
    }


    public void gettingMapLocation(){

        location = searchView.getQuery().toString();
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(GoogleMapWithSearchView.this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            latLng = new LatLng(address.getLatitude(), address.getLongitude());
            map.addMarker(new MarkerOptions().position(latLng).title(location));
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(GoogleMapWithSearchView.this,LocationOnBoarding.class);
        startActivity(back);
        finish();
    }
}
