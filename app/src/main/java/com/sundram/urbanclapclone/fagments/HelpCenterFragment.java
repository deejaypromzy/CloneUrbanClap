package com.sundram.urbanclapclone.fagments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sundram.urbanclapclone.R;

public class HelpCenterFragment extends Fragment implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView bookSerice1, payingService, urban_guide,tx_arror_back,textView_projectname;
    private View helpCenterFragment;

    public HelpCenterFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        helpCenterFragment = LayoutInflater.from(getActivity()).inflate(R.layout.customer_support, null);
        //setting up the toolbar in the fragment
        toolbar = helpCenterFragment.findViewById(R.id.custom_toolbar_wedget);
        toolbar.setTitle(getString(R.string.customer_support));
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        //end
        bookSerice1 = helpCenterFragment.findViewById(R.id.bookSerice);
        payingService = helpCenterFragment.findViewById(R.id.payingService);
        urban_guide = helpCenterFragment.findViewById(R.id.urban_guide);
        bookSerice1.setOnClickListener(this);
        payingService.setOnClickListener(this);
        urban_guide.setOnClickListener(this);

        return helpCenterFragment;
    }

    //getting all method in this onClick method
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bookSerice:
                loadFragment(new FrameBookFragment());
                break;
            case R.id.payingService:
                loadFragment(new FramePayingFragment());
                break;
            case R.id.urban_guide:
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
