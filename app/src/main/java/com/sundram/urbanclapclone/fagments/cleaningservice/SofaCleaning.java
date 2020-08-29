package com.sundram.urbanclapclone.fagments.cleaningservice;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sundram.urbanclapclone.Details.SofaCleaningDetails;
import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.adapter.SectionViewAllServiceListAdapter;
import com.sundram.urbanclapclone.datamodel.SectionViewAllServiceListModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SofaCleaning extends Fragment implements SectionViewAllServiceListAdapter.OnServiceItemClick {


    private  View sofaCleaningFragment;
    private TextView view_section_heading;
    private RecyclerView fragment_tab_one_recycler;
    private SectionViewAllServiceListAdapter adapterList;
    ArrayList<SectionViewAllServiceListModel> list ;
    public SofaCleaning() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sofaCleaningFragment = inflater.inflate(R.layout.fragment_fragment_view_all_tab1,container,false);
        view_section_heading = sofaCleaningFragment.findViewById(R.id.view_section_heading);
        view_section_heading.setText("Sofa Cleaning");
        implementRecyclerView();
        return sofaCleaningFragment;
    }
    public void implementRecyclerView(){
        fragment_tab_one_recycler = sofaCleaningFragment.findViewById(R.id.fragment_tab_one_recycler);

        list = new ArrayList<>();
        fragment_tab_one_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterList = new SectionViewAllServiceListAdapter(getActivity(),list,this);
        setDataToRecycler();
        fragment_tab_one_recycler.setAdapter(adapterList);
    }

    public void setDataToRecycler(){
        list.add(new SectionViewAllServiceListModel("2 Sofa Seat Cleaning","120","40","Sofa Cleaning","60 min",0,0,R.drawable.sofa_cleaning));
        list.add(new SectionViewAllServiceListModel("3 Sofa Seat Cleaning","180","40","Sofa Cleaning","60 min",0,0,R.drawable.sofa_cleaning));
        list.add(new SectionViewAllServiceListModel("4 Sofa Seat Cleaning","190","40","Sofa Cleaning","60 min",0,0,R.drawable.sofa_cleaning));
        list.add(new SectionViewAllServiceListModel("5 Sofa Seat Cleaning","200","40","Sofa Cleaning","60 min",0,0,R.drawable.sofa_cleaning));
    }

    @Override
    public void onClick(String position,int pos,View view) {
        switch (position){
            case "0":
                jumpIntent();
                break;
            case "1":
                jumpIntent();
                break;
            case "2":
                jumpIntent();
                break;
            case "3":
                jumpIntent();
                break;
        }
    }
    public Intent jumpIntent(){

        Intent jump = new Intent(getActivity(), SofaCleaningDetails.class);
        startActivity(jump);
        getActivity().finish();
        return jump;
    }
}
