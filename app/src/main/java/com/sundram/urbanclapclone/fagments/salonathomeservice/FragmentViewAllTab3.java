package com.sundram.urbanclapclone.fagments.salonathomeservice;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.adapter.SectionViewAllServiceListAdapter;
import com.sundram.urbanclapclone.datamodel.SectionViewAllServiceListModel;

import java.util.ArrayList;


public class FragmentViewAllTab3 extends Fragment  {

    private View tab_three_fragment;
    private TextView view_section_heading;
    private RecyclerView fragment_tab_one_recycler;
    private SectionViewAllServiceListAdapter adapterList;
    ArrayList<SectionViewAllServiceListModel> list ;
     public FragmentViewAllTab3() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tab_three_fragment = inflater.inflate(R.layout.fragment_fragment_view_all_tab1, container, false);
        view_section_heading = tab_three_fragment.findViewById(R.id.view_section_heading);
        view_section_heading.setText("Honey Waxing");

        fragment_tab_one_recycler = tab_three_fragment.findViewById(R.id.fragment_tab_one_recycler);
        list = new ArrayList<>();
        fragment_tab_one_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterList = new SectionViewAllServiceListAdapter(getActivity(),list);
        fragment_tab_one_recycler.setAdapter(adapterList);
        setDataToRecycler();
        return tab_three_fragment;
    }
    public void setDataToRecycler(){
        list.add(new SectionViewAllServiceListModel("Full Face Honey Waxing", "120", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Full-arm Honey Waxing", "180", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Half-arm Honey Waxing", "190", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Underarms Honey Waxing", "200", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Eyebrows Honey Waxing", "300", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Chest Honey Waxing", "100", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Half-leg Honey Waxing(lower)", "100", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Half-leg Honey Waxing(upper)", "100", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Full-leg Honey Waxing", "100", "40", "Wax", "60 min",0,0, R.drawable.waxing));
        list.add(new SectionViewAllServiceListModel("Stomach Honey Waxing", "100", "40", "Wax", "60 min",0,0, R.drawable.waxing));
    }
}
