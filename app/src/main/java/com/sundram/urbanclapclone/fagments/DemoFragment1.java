package com.sundram.urbanclapclone.fagments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sundram.urbanclapclone.R;

public class DemoFragment1 extends Fragment implements View.OnClickListener {
    private View demoFragment1;
    private Toolbar toolbar;
    TextView textView_projectname, tx_arror_back;
    private final static String tag = "TAG_FRAGMENT";
    public DemoFragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        demoFragment1 = inflater.inflate(R.layout.activity_frame_demo,container,false);
        toolbar = demoFragment1.findViewById(R.id.custom_toolbar_wedget);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        textView_projectname = demoFragment1.findViewById(R.id.textView_projectname);
        tx_arror_back = demoFragment1.findViewById(R.id.tx_arror_back);

        textView_projectname.setText("Demo Text");
        tx_arror_back.setOnClickListener(this);

        demoFragment1.setFocusableInTouchMode(true);
        demoFragment1.requestFocus();
        demoFragment1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i(tag, "keyCode: " + keyCode);
                if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    //  Log.i(tag, "onKey Back listener is working!!!");
                    loadFragment(new FramePayingFragment());
                    return true;
                }
                return false;
            }
        });
        return demoFragment1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.tx_arror_back:
                loadFragment(new FramePayingFragment());

                break;
        }
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
