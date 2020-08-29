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


public class FragmentViewAllTab6 extends Fragment  {

    private View tab_five_fragment;
    private TextView view_section_heading;
    private RecyclerView fragment_tab_one_recycler;
    private SectionViewAllServiceListAdapter adapterList;
    ArrayList<SectionViewAllServiceListModel> list ;

    public FragmentViewAllTab6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tab_five_fragment = inflater.inflate(R.layout.fragment_fragment_view_all_tab1, container, false);
        view_section_heading = tab_five_fragment.findViewById(R.id.view_section_heading);
        view_section_heading.setText("Hair Care");
        fragment_tab_one_recycler = tab_five_fragment.findViewById(R.id.fragment_tab_one_recycler);
        list = new ArrayList<>();
        fragment_tab_one_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterList = new SectionViewAllServiceListAdapter(getActivity(),list);
        fragment_tab_one_recycler.setAdapter(adapterList);
        setDataToRecycler();
        return tab_five_fragment;
    }

    public void setDataToRecycler(){
        list.add(new SectionViewAllServiceListModel("L'Oreal Hair Spa Small Length Treatment","1499","500","Hair Care","45 min",0,0,R.drawable.hair));
        list.add(new SectionViewAllServiceListModel("L'Oreal Hair Spa Medium Length Treatment","749","151","Hair Care","45 min",0,0,R.drawable.hair));
        list.add(new SectionViewAllServiceListModel("L'Oreal Hair Spa Large Length Treatment","899","200","Hair Care","45 min",0,0,R.drawable.hair));
        list.add(new SectionViewAllServiceListModel("Hair Colouring for Small Length","200","40","Hair Care","60 min",0,0,R.drawable.hair));
        list.add(new SectionViewAllServiceListModel("Hair Colouring for Medium Length","200","40","Hair Care","60 min",0,0,R.drawable.hair));
        list.add(new SectionViewAllServiceListModel("Hair Colouring for Large Length","200","40","Hair Care","60 min",0,0,R.drawable.hair));
        list.add(new SectionViewAllServiceListModel("Hair Cut Simple","400","40","Hair Care","60 min",0,0,R.drawable.hair));
        list.add(new SectionViewAllServiceListModel("Hair Cut Advance","400","40","Hair Care","60 min",0,0,R.drawable.hair));
    }
}
