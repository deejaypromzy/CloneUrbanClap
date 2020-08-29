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

import com.sundram.urbanclapclone.R;

public class FrameGuideFragment extends Fragment implements View.OnClickListener {

    private View frameguideFragment;
    private Toolbar toolbar;
    TextView  bookSerice0_tv, bookSerice1_tv, textView_projectname, tx_arror_back;
    private final static String tag = "TAG_FRAGMENT";

    public FrameGuideFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frameguideFragment = inflater.inflate(R.layout.activity_frame_guide_urban_clap, container, false);
        toolbar = frameguideFragment.findViewById(R.id.custom_toolbar_wedget);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        textView_projectname = frameguideFragment.findViewById(R.id.textView_projectname);
        tx_arror_back = frameguideFragment.findViewById(R.id.tx_arror_back);

        textView_projectname.setText("App Name Guide");
        bookSerice0_tv = frameguideFragment.findViewById(R.id.bookSerice0);
        bookSerice1_tv = frameguideFragment.findViewById(R.id.bookSerice1);
        tx_arror_back.setOnClickListener(this);
        bookSerice0_tv.setOnClickListener(this);
        bookSerice1_tv.setOnClickListener(this);

        frameguideFragment.setFocusableInTouchMode(true);
        frameguideFragment.requestFocus();
        frameguideFragment.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i(tag, "keyCode: " + keyCode);
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    //  Log.i(tag, "onKey Back listener is working!!!");
                    loadFragment(new HelpCenterFragment());
                    return true;
                }
                return false;
            }
        });
        return frameguideFragment;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bookSerice0:
                loadFragment(new DemoFragment2());
                break;
            case R.id.bookSerice1:
                loadFragment(new DemoFragment2());
                break;
            case R.id.tx_arror_back:
                loadFragment(new HelpCenterFragment());
                break;
        }
    }
}
