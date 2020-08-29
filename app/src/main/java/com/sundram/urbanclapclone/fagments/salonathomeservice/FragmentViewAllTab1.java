package com.sundram.urbanclapclone.fagments.salonathomeservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.adapter.SectionViewAllServiceListAdapter;
import com.sundram.urbanclapclone.datamodel.SectionViewAllServiceListModel;
import com.sundram.urbanclapclone.viewallserviceactivity.salonathome.ViewAllServiceActivity;

import java.util.ArrayList;

public class FragmentViewAllTab1 extends Fragment implements View.OnClickListener {
    int count = 0;

    private View tab_one_fragment;
    private TextView view_section_heading;
    private RecyclerView fragment_tab_one_recycler;
    private SectionViewAllServiceListAdapter adapterList;
    ArrayList<SectionViewAllServiceListModel> list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        tab_one_fragment = inflater.inflate(R.layout.fragment_fragment_view_all_tab1, container, false);
        view_section_heading = tab_one_fragment.findViewById(R.id.view_section_heading);
        view_section_heading.setText("Waxing");

        fragment_tab_one_recycler = tab_one_fragment.findViewById(R.id.fragment_tab_one_recycler);
        list = new ArrayList<>();
        fragment_tab_one_recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        adapterList = new SectionViewAllServiceListAdapter(getContext(), list);

        fragment_tab_one_recycler.setAdapter(adapterList);
        setDataToRecycler();
        return tab_one_fragment;
    }

    public void setDataToRecycler() {
        list.add(new SectionViewAllServiceListModel("Full Face Waxing", "120", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Full-arm Waxing", "180", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Half-arm Waxing", "190", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Underarms Waxing", "200", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Eyebrows Waxing", "300", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Chest  Waxing", "100", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Half-leg (lower)", "100", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Half-leg (upper)", "100", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Full-leg", "100", "40", "Wax", "60 min",0,0, R.drawable.waxing));
    }

    @Override
    public void onClick(View v) {
    }
}
