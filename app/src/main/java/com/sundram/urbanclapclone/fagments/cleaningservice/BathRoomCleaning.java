package com.sundram.urbanclapclone.fagments.cleaningservice;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class BathRoomCleaning extends Fragment{

    private  View bathRoomCleaningFragment;
    private TextView view_section_heading;
    private RecyclerView fragment_tab_one_recycler;
    private SectionViewAllServiceListAdapter adapterList;
    ArrayList<SectionViewAllServiceListModel> list ;
    public BathRoomCleaning() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bathRoomCleaningFragment = inflater.inflate(R.layout.fragment_fragment_view_all_tab1,container,false);
        view_section_heading = bathRoomCleaningFragment.findViewById(R.id.view_section_heading);
        view_section_heading.setText("Bathroom Deep Cleaning");
        fragment_tab_one_recycler = bathRoomCleaningFragment.findViewById(R.id.fragment_tab_one_recycler);
        
        list = new ArrayList<>();
        fragment_tab_one_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterList = new SectionViewAllServiceListAdapter(getActivity(),list);
        fragment_tab_one_recycler.setAdapter(adapterList);
        setDataToRecycler();
      
        return bathRoomCleaningFragment;
    }
    public void setDataToRecycler(){
        list.add(new SectionViewAllServiceListModel("One Bathroom Cleaning","120","40","Bathroom Cleaning","60 min",0,0,R.drawable.bathroom));
        list.add(new SectionViewAllServiceListModel("Two Bathroom Cleaning","180","40","Bathroom Cleaning","60 min",0,0,R.drawable.bathroom));
        list.add(new SectionViewAllServiceListModel("Three Bathroom Cleaning","190","40","Bathroom Cleaning","60 min",0,0,R.drawable.bathroom));
        list.add(new SectionViewAllServiceListModel("Four Bathroom Cleaning","200","40","Bathroom Cleaning","60 min",0,0,R.drawable.bathroom));
    }

}
