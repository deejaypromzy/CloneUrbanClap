package com.sundram.urbanclapclone;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.material.snackbar.Snackbar;
import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.widget.IconTextView;
import com.sundram.urbanclapclone.LocationUtil.LocationHelper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.sundram.urbanclapclone.LocationUtil.PermissionUtils;
import com.sundram.urbanclapclone.fagments.HomeFragment;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocationOnBoarding extends AppCompatActivity implements ConnectionCallbacks,
        OnConnectionFailedListener, ActivityCompat.OnRequestPermissionsResultCallback, PermissionUtils.PermissionResultCallback {

    IconTextView iconTextView;
    RelativeLayout location_onboarding_select_city, location_onboarding_auto_detect_view;
    String currentLocation;
    TextView textView2, search_location;
    LocationHelper locationHelper;
    // LogCat tag
    private static final String TAG = MyLocationUsingHelper.class.getSimpleName();

    private final static int PLAY_SERVICES_REQUEST = 1000;
    private final static int REQUEST_CHECK_SETTINGS = 2000;

    private Location mLastLocation;

    // Google client to interact with Google API

    private GoogleApiClient mGoogleApiClient;

    double latitude;
    double longitude;

    DecimalFormat decimalFormat;
    // list of permissions

    ArrayList<String> permissions = new ArrayList<>();
    PermissionUtils permissionUtils;
    ProgressDialog pd;

    boolean isPermissionGranted;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_onboarding);
        iconTextView = findViewById(R.id.location_onboarding_back_back_btn);
        location_onboarding_select_city = findViewById(R.id.location_onboarding_select_city);
        location_onboarding_auto_detect_view = findViewById(R.id.location_onboarding_auto_detect_view);
        //setting up the limit of the decimal
        //decimalFormat = new DecimalFormat();
        /// decimalFormat.setMaximumFractionDigits(3);
        pd = new ProgressDialog(LocationOnBoarding.this);
        textView2 = findViewById(R.id.textView2);
        locationHelper = new LocationHelper(this);
        locationHelper.checkpermission();

        permissionUtils = new PermissionUtils(LocationOnBoarding.this);

        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);

        permissionUtils.check_permission(permissions, "Need GPS permission for getting your location", 1);

        progressDialog = new ProgressDialog(this);
        location_onboarding_auto_detect_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // pd.requestWindowFeature(Window.FEATURE_NO_TITLE);
               // pd.setMessage("Please wait");
                //getLocation();

                if (mLastLocation != null) {
                   gettingLongitudeAndLatitude();
                    getAddress();
                    //  Toast.makeText(LocationOnBoarding.this,currentLocation,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LocationOnBoarding.this, DashBoard.class));
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(LocationOnBoarding.this);
                    sp.edit().putString("address", currentLocation).apply();
                    finish();
                } else {
                    Toast.makeText(LocationOnBoarding.this,
                            "Couldn't get the location. Make sure location is enabled on the device for this application",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
//when press back button
        iconTextView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent back = new Intent(LocationOnBoarding.this, OtpGeneratorActivity.class);
                startActivity(back);
                finish();
            }
        });

//        location_onboarding_select_city.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(LocationOnBoarding.this,"Not Working",Toast.LENGTH_LONG).show();
//            }
//        });
        // check availability of play services
        if (checkPlayServices()) {
            // Building the GoogleApi client
            buildGoogleApiClient();
        }

        search_location = findViewById(R.id.search_location);
        search_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LocationOnBoarding.this, GoogleMapWithSearchView.class));
                finish();
            }
        });

    }

    public void gettingLongitudeAndLatitude(){
        latitude = mLastLocation.getLatitude();
        longitude = mLastLocation.getLongitude();
    }
    private void getLocation() {

        if (isPermissionGranted) {

            try {
                mLastLocation = LocationServices.FusedLocationApi
                        .getLastLocation(mGoogleApiClient);
            } catch (SecurityException e) {
                e.printStackTrace();
            }

        }

    }

    public Address getAddress(double latitude, double longitude) {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            return addresses.get(0);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void getAddress() {

        Address locationAddress = getAddress(latitude, longitude);

        if (locationAddress != null) {
            String address = locationAddress.getAddressLine(0);
            String address1 = locationAddress.getAddressLine(1);
            String city = locationAddress.getLocality();
            String state = locationAddress.getAdminArea();
            String country = locationAddress.getCountryName();
            String postalCode = locationAddress.getPostalCode();


            if (!TextUtils.isEmpty(address)) {
                currentLocation = address;

                if (!TextUtils.isEmpty(address1))
                    currentLocation += "\n" + address1;

                if (!TextUtils.isEmpty(city)) {
                    currentLocation += "\n" + city;

                    if (!TextUtils.isEmpty(postalCode))
                        currentLocation += " - " + postalCode;
                } else {
                    if (!TextUtils.isEmpty(postalCode))
                        currentLocation += "\n" + postalCode;
                }

                if (!TextUtils.isEmpty(state))
                    currentLocation += "\n" + state;

                if (!TextUtils.isEmpty(country))
                    currentLocation += "\n" + country;

                //textView2.setText(currentLocation);

            }

        }

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();

        mGoogleApiClient.connect();

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);

        PendingResult<LocationSettingsResult> result =
                LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());

        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult locationSettingsResult) {

                final Status status = locationSettingsResult.getStatus();

                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        // All location settings are satisfied. The client can initialize location requests here
                        getLocation();
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            // Show the dialog by calling startResolutionForResult(),
                            // and check the result in onActivityResult().
                            status.startResolutionForResult(LocationOnBoarding.this, REQUEST_CHECK_SETTINGS);

                        } catch (IntentSender.SendIntentException e) {
                            // Ignore the error.
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        break;
                }
            }
        });

    }

    private boolean checkPlayServices() {

        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();

        int resultCode = googleApiAvailability.isGooglePlayServicesAvailable(this);

        if (resultCode != ConnectionResult.SUCCESS) {
            if (googleApiAvailability.isUserResolvableError(resultCode)) {
                googleApiAvailability.getErrorDialog(this, resultCode,
                        PLAY_SERVICES_REQUEST).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final LocationSettingsStates states = LocationSettingsStates.fromIntent(data);
        switch (requestCode) {
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        // All required changes were successfully made
                        getLocation();
                        break;
                    case Activity.RESULT_CANCELED:
                        // The user was asked to change settings, but chose not to
                        break;
                    default:
                        break;
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPlayServices();
    }

    /**
     * Google api callback methods
     */
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = "
                + result.getErrorCode());
    }

    @Override
    public void onConnected(Bundle arg0) {

        // Once connected with google api, get the location
        getLocation();
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        mGoogleApiClient.connect();
    }


    // Permission check functions


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        // redirects to utils
        permissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }


    @Override
    public void PermissionGranted(int request_code) {
        Log.i("PERMISSION", "GRANTED");
        isPermissionGranted = true;
    }

    @Override
    public void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions) {
        Log.i("PERMISSION PARTIALLY", "GRANTED");
    }

    @Override
    public void PermissionDenied(int request_code) {
        Log.i("PERMISSION", "DENIED");
    }

    @Override
    public void NeverAskAgain(int request_code) {
        Log.i("PERMISSION", "NEVER ASK AGAIN");
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(LocationOnBoarding.this,OtpGeneratorActivity.class);
        startActivity(back);
        finish();
    }
}
