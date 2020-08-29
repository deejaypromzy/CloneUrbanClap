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

public class DemoFragment2 extends Fragment implements View.OnClickListener {
    private View demoFragment2;
    private Toolbar toolbar;
    TextView textView_projectname, tx_arror_back;
    private final static String tag = "TAG_FRAGMENT";
    public DemoFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        demoFragment2 = inflater.inflate(R.layout.activity_frame_demo,container,false);
        toolbar = demoFragment2.findViewById(R.id.custom_toolbar_wedget);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        textView_projectname = demoFragment2.findViewById(R.id.textView_projectname);
        tx_arror_back = demoFragment2.findViewById(R.id.tx_arror_back);

        textView_projectname.setText("Demo Text");
        tx_arror_back.setOnClickListener(this);

        demoFragment2.setFocusableInTouchMode(true);
        demoFragment2.requestFocus();
        demoFragment2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i(tag, "keyCode: " + keyCode);
                if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    //  Log.i(tag, "onKey Back listener is working!!!");
                    loadFragment(new FrameGuideFragment());
                    return true;
                }
                return false;
            }
        });
        return demoFragment2;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tx_arror_back:
                loadFragment(new FrameGuideFragment());

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
