package com.sundram.urbanclapclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Max;
import com.mobsandgeeks.saripaar.annotation.Min;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;
import com.sundram.urbanclapclone.connectionchecker.NetworkChangeReceiver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDetailsActivity extends AppCompatActivity implements View.OnClickListener, Validator.ValidationListener {

    private Toolbar toolbar;
    private TextView login_txt;

    @NotEmpty
    @Length(min = 0, max = 50)
    private EditText full_name;

    @NotEmpty
    @Pattern(regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$")
    private EditText mobile_number;
//
//    @NotEmpty
//    @Password
//    @Pattern(regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
//    private EditText editTextPassword
//

    @Min(18)
    @Max(120)
    private EditText age;

    @NotEmpty
    @Email
    private EditText email_address;

    @NotEmpty
    private EditText requirement;

    private String name, mobileNumber, email, requirements, ages, gender;
    ProgressDialog progressDialog;
    RadioGroup radioGroup;
    RadioButton radioButton;
    private Validator validator;

    StringRequest stringRequest;
    RequestQueue requestQueue;
    String url = "https://testing-321.000webhostapp.com/vendorinsertdetails.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_details);
        init();
        setToolbar();
        login_txt.setText("Submit Details");
        progressDialog = new ProgressDialog(this);
        validator = new Validator(this);
        requestQueue = Volley.newRequestQueue(ClientDetailsActivity.this);
        validator.setValidationListener(this);
    }

    public void init() {
        toolbar = findViewById(R.id.toolbar);
        login_txt = findViewById(R.id.login_button_text);
        full_name = findViewById(R.id.full_name);
        mobile_number = findViewById(R.id.mobile_number);
        email_address = findViewById(R.id.email_address);
        requirement = findViewById(R.id.requirement);
        radioGroup = findViewById(R.id.radioGroup);
        age = findViewById(R.id.age);
        login_txt.setOnClickListener(this);
    }

    public void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Vendor Details Form");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        startActivity(new Intent(ClientDetailsActivity.this, OtpGeneratorActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button_text:
                submitDetails();
                break;
        }
    }

//    public boolean validateForm() {
//        validator.validate();
//
//        if (full_name.getText().toString().equals("") || full_name.getText().toString() == null) {
//            full_name.setError(getText(R.string.name_error));
//            return false;
//        }
//        if (mobile_number.getText().toString().equals("") || mobile_number.getText().toString() == null) {
//            mobile_number.setError(getText(R.string.mobile_number_already_exists));
//            return false;
//        }
//        if (email_address.getText().toString().equals("") || email_address.getText().toString() == null) {
//            email_address.setError(getText(R.string.email_id_already_exists));
//            return false;
//        }
//        if (age.equals("") || age == null) {
//            age.setError(getText(R.string.age_error));
//            return false;
//        }
//        if (requirement.getText().toString().equals("") || requirement.getText().toString() == null) {
//            requirement.setError(getText(R.string.name_error));
//            return false;
//        }
//
//        return true;
//    }

    public void submitDetails() {

        progressDialog.setMessage("please wait ...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        name = full_name.getText().toString();
        mobileNumber = mobile_number.getText().toString();
        email = email_address.getText().toString();
        ages = age.getText().toString();
        requirements = requirement.getText().toString();

        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
        } else {
            // get selected radio button from radioGroup
            int selectedId = radioGroup.getCheckedRadioButtonId();
            // find the radiobutton by returned id
            radioButton = (RadioButton) findViewById(selectedId);
            if (radioButton.getId() == R.id.male) {
                gender = radioButton.getText().toString();
                //       Toast.makeText(getApplicationContext(), radioButton.getText().toString()+" is selected", Toast.LENGTH_SHORT).show();
            } else {
                gender = radioButton.getText().toString();
                //      Toast.makeText(getApplicationContext(), radioButton.getText().toString()+" is selected", Toast.LENGTH_SHORT).show();

            }Toast.makeText(ClientDetailsActivity.this,name+"\n"+mobileNumber+"\n"+gender+"\n"+email+"\n"+ages+"\n"+requirements,Toast.LENGTH_SHORT).show();

        }
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Toast.makeText(ClientDetailsActivity.this,"Response"+response,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof NetworkError) {
                } else if (error instanceof ServerError) {
                } else if (error instanceof AuthFailureError) {
                } else if (error instanceof ParseError) {
                } else if (error instanceof NoConnectionError) {
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(ClientDetailsActivity.this,
                            "Oops. Timeout error!",
                            Toast.LENGTH_LONG).show();
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("vendor_id","");
                params.put("vendor_name",name);
                params.put("vendor_gender",gender);
                params.put("vendor_mobile_no",mobileNumber);
                params.put("vendor_email",email);
                params.put("vendor_age",ages);
                params.put("vender_speciality",requirements);
                return params;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 10000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 10000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {
                Toast.makeText(ClientDetailsActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onValidationSucceeded() {
        //     Toast.makeText(this, "Registration sucessfull!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            // Display error messages
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }

}
