package com.sundram.urbanclapclone.fagments.appliance.refrigeratorService;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.sundram.urbanclapclone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstallAndUninstall extends Fragment {


    public InstallAndUninstall() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
