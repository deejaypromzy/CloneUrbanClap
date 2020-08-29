package com.sundram.urbanclapclone.fagments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sundram.urbanclapclone.About;
import com.sundram.urbanclapclone.LoginActivity;
import com.sundram.urbanclapclone.R;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private Toolbar toolbar;
    private TextView loginBtn;
    private TextView aboutUs_myProfile_tv, shareUrbanClap_tv, downloadUrbanClap_tv,custome_toolbar_loginbtn;

    private OnFragmentInteractionListener mListener;
    private View profileFragmentView;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActivity().setContentView(R.layout.my_profile);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        profileFragmentView = LayoutInflater.from(getActivity()).inflate(R.layout.my_profile, null);

        //setting up the toolbar in the fragment
        toolbar = profileFragmentView.findViewById(R.id.custom_toolbar_wedget);
        toolbar.setTitle(R.string.my_profile);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        loginBtn = profileFragmentView.findViewById(R.id.custome_toolbar_loginbtn);
        loginBtn.setVisibility(View.VISIBLE);
        //end
        //getting the id's of view and setting up th onClick
        aboutUs_myProfile_tv = profileFragmentView.findViewById(R.id.aboutUs_myProfile);
        shareUrbanClap_tv = profileFragmentView.findViewById(R.id.shareUrbanClap);
        downloadUrbanClap_tv = profileFragmentView.findViewById(R.id.downloadUrbanClap);
        custome_toolbar_loginbtn = profileFragmentView.findViewById(R.id.custome_toolbar_loginbtn);

        custome_toolbar_loginbtn.setOnClickListener(this);
        aboutUs_myProfile_tv.setOnClickListener(this);
        shareUrbanClap_tv.setOnClickListener(this);
        downloadUrbanClap_tv.setOnClickListener(this);
        //end

        return profileFragmentView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aboutUs_myProfile:
                Intent login = new Intent(getContext(), About.class);
                startActivity(login);
                getActivity().finish();
                break;
            case R.id.shareUrbanClap:
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Your Message Here !";
                String shareSub = "Your subject here !";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
                break;
            case R.id.downloadUrbanClap:
                Uri uri = Uri.parse("https://www.google.com/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.custome_toolbar_loginbtn:
                Intent loginbtn = new Intent(getContext(),LoginActivity.class);
                startActivity(loginbtn);
                getActivity().finish();
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
