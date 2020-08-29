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
public class KitchenDeepCleaning extends Fragment{

    private  View kitchenDeepCleaningFragment;
    private TextView view_section_heading;
    private RecyclerView fragment_tab_one_recycler;
    private SectionViewAllServiceListAdapter adapterList;
    ArrayList<SectionViewAllServiceListModel> list ;

    public KitchenDeepCleaning() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        kitchenDeepCleaningFragment = inflater.inflate(R.layout.fragment_fragment_view_all_tab1,container,false);
        view_section_heading = kitchenDeepCleaningFragment.findViewById(R.id.view_section_heading);
        view_section_heading.setText("Kitchen Deep Cleaning");
        implementRecyclerView();
        return kitchenDeepCleaningFragment;
    }
    public void implementRecyclerView(){
        fragment_tab_one_recycler = kitchenDeepCleaningFragment.findViewById(R.id.fragment_tab_one_recycler);

        list = new ArrayList<>();
        fragment_tab_one_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterList = new SectionViewAllServiceListAdapter(getActivity(),list);
        fragment_tab_one_recycler.setAdapter(adapterList);
        setDataToRecycler();
    }

    public void setDataToRecycler(){
        list.add(new SectionViewAllServiceListModel("Chimney Deep Cleaning","120","40","Kitchen Cleaning","60 min",0,0,R.drawable.kitchen_cleaning));
        list.add(new SectionViewAllServiceListModel("Kitchen Cleaning(Without Chimney)","180","40","Kitchen Cleaning","60 min",0,0,R.drawable.kitchen_cleaning));
        list.add(new SectionViewAllServiceListModel("Kitchen Cleaning(With Chimney)","190","40","Kitchen Cleaning","60 min",0,0,R.drawable.kitchen_cleaning));
        list.add(new SectionViewAllServiceListModel("Trolley and Shelf Cleaning","200","40","Kitchen Cleaning","60 min",0,0,R.drawable.kitchen_cleaning));
      }

}
