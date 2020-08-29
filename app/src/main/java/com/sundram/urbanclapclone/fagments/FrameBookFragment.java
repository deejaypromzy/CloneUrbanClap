package com.sundram.urbanclapclone.fagments;

import android.annotation.SuppressLint;
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

public class FrameBookFragment extends Fragment implements View.OnClickListener {


    private View frameBookFragment;
    private Toolbar toolbar;
    TextView bookSerice0_tv, bookSerice1_tv, bookSerice2_tv,bookSerice3_tv,textView_projectname, tx_arror_back;
    private final static String tag = "TAG_FRAGMENT";
    public FrameBookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frameBookFragment = inflater.inflate(R.layout.activity_frame_booking_serve, container, false);

        toolbar = frameBookFragment.findViewById(R.id.custom_toolbar_wedget);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        textView_projectname = frameBookFragment.findViewById(R.id.textView_projectname);
        tx_arror_back = frameBookFragment.findViewById(R.id.tx_arror_back);

        textView_projectname.setText("Book Services");

        bookSerice0_tv = frameBookFragment.findViewById(R.id.bookSerice0);
        bookSerice1_tv = frameBookFragment.findViewById(R.id.bookSerice1);
        bookSerice2_tv = frameBookFragment.findViewById(R.id.bookSerice2);
        bookSerice3_tv = frameBookFragment.findViewById(R.id.bookSerice3);
        tx_arror_back.setOnClickListener(this);
        bookSerice0_tv.setOnClickListener(this);
        bookSerice1_tv.setOnClickListener(this);
        bookSerice2_tv.setOnClickListener(this);
        bookSerice3_tv.setOnClickListener(this);

        frameBookFragment.setFocusableInTouchMode(true);
        frameBookFragment.requestFocus();
        frameBookFragment.setOnKeyListener(new View.OnKeyListener() {
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
        return frameBookFragment;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bookSerice0:
                loadFragment(new DemoFragment());
                break;
            case R.id.bookSerice1:
                loadFragment(new DemoFragment());
                break;
            case R.id.bookSerice2:
                loadFragment(new DemoFragment());
                break;
            case R.id.bookSerice3:
                loadFragment(new DemoFragment());
                break;
            case R.id.tx_arror_back:
                loadFragment(new HelpCenterFragment());
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
