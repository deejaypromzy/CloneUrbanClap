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
public class CarpetCleaning extends Fragment{

    private  View carpetCleaningFragment;
    private TextView view_section_heading;

    private RecyclerView fragment_tab_one_recycler;
    private SectionViewAllServiceListAdapter adapterList;
    ArrayList<SectionViewAllServiceListModel> list ;
    
    public CarpetCleaning() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        carpetCleaningFragment = inflater.inflate(R.layout.fragment_fragment_view_all_tab1,container,false);
        view_section_heading = carpetCleaningFragment.findViewById(R.id.view_section_heading);
        view_section_heading.setText("Carpet Cleaning");

        fragment_tab_one_recycler = carpetCleaningFragment.findViewById(R.id.fragment_tab_one_recycler);

        list = new ArrayList<>();
        fragment_tab_one_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterList = new SectionViewAllServiceListAdapter(getActivity(),list);
        fragment_tab_one_recycler.setAdapter(adapterList);
        setDataToRecycler();
        return carpetCleaningFragment;
    }
    
    public void setDataToRecycler(){
        list.add(new SectionViewAllServiceListModel("25-50sq. ft.","899","300","Carpet Cleaning","60 min",0,0,R.drawable.carpet_cleaning));
        list.add(new SectionViewAllServiceListModel("50-100sq. ft.","1299","200","Carpet Cleaning","60 min",0,0,R.drawable.carpet_cleaning));
        list.add(new SectionViewAllServiceListModel("100-150sq. ft.","1499","300","Carpet Cleaning","60 min",0,0,R.drawable.carpet_cleaning));
        list.add(new SectionViewAllServiceListModel("150-200 sq. ft.","1699","200","Carpet Cleaning","60 min",0,0,R.drawable.carpet_cleaning));
       }


}
