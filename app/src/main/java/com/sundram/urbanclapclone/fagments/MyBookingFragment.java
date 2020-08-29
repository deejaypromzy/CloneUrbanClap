package com.sundram.urbanclapclone.fagments;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sundram.urbanclapclone.R;

public class MyBookingFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    private Toolbar toolbar;
    private Button bookASerice_btn;
    private View myBookingView;

    public MyBookingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myBookingView = LayoutInflater.from(getActivity()).inflate(R.layout.my_booking_layout,null);

        //setting up the toolbar
        toolbar = myBookingView.findViewById(R.id.custom_toolbar_wedget);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
       // ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // toolbar.setTitle(getString(R.string.my_booking));
        toolbar.setTitle("View Cart");
        //end

        bookASerice_btn= myBookingView.findViewById(R.id.bookASerice_btn);
        bookASerice_btn.setOnClickListener(this);
        return myBookingView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bookASerice_btn:
               //getFragmentManager().beginTransaction().add(R.id.nav_host_fragment,new HomeFragment()).commit();
                loadFragment(new HomeFragment());
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
