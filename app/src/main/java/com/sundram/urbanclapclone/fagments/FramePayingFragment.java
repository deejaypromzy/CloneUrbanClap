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
public class FramePayingFragment extends Fragment implements View.OnClickListener {


    private View payingFragment;
    private Toolbar toolbar;
    TextView bookSerice0_tv, bookSerice1_tv, bookSerice2_tv,textView_projectname, tx_arror_back;
    private final static String tag = "TAG_FRAGMENT";
    public FramePayingFragment() {
        // Required empty public constructor
    }
   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        payingFragment = inflater.inflate(R.layout.activity_frame_paying_serve,container,false);

        toolbar = payingFragment.findViewById(R.id.custom_toolbar_wedget);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        textView_projectname = payingFragment.findViewById(R.id.textView_projectname);
        tx_arror_back = payingFragment.findViewById(R.id.tx_arror_back);
        bookSerice0_tv = payingFragment.findViewById(R.id.bookSerice0);
        bookSerice1_tv = payingFragment.findViewById(R.id.bookSerice1);
        bookSerice2_tv = payingFragment.findViewById(R.id.bookSerice2);
        bookSerice0_tv.setOnClickListener(this);
        bookSerice1_tv.setOnClickListener(this);
        bookSerice2_tv.setOnClickListener(this);

        textView_projectname.setText("Paying Services");

        tx_arror_back.setOnClickListener(this);

        payingFragment.setFocusableInTouchMode(true);
        payingFragment.requestFocus();
        payingFragment.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i(tag, "keyCode: " + keyCode);
                if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    //  Log.i(tag, "onKey Back listener is working!!!");
                    loadFragment(new HelpCenterFragment());
                    return true;
                }
                return false;
            }
        });
        return payingFragment;
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
        switch (v.getId()){
            case R.id.bookSerice0:
                loadFragment(new DemoFragment1());
                break;
            case R.id.bookSerice1:
                loadFragment(new DemoFragment1());
                break;
            case R.id.bookSerice2:
                loadFragment(new DemoFragment1());
                break;
            case R.id.tx_arror_back:
                loadFragment(new HelpCenterFragment());
                break;
        }
    }
}
