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


public class FragmentViewAllTab7 extends Fragment {

    private View tab_seven_fragment;
    private TextView view_section_heading;
    private RecyclerView fragment_tab_one_recycler;
    private SectionViewAllServiceListAdapter adapterList;
    ArrayList<SectionViewAllServiceListModel> list ;

    public FragmentViewAllTab7() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tab_seven_fragment = inflater.inflate(R.layout.fragment_fragment_view_all_tab1, container, false);
        view_section_heading = tab_seven_fragment.findViewById(R.id.view_section_heading);
        view_section_heading.setText("Threading");

        fragment_tab_one_recycler = tab_seven_fragment.findViewById(R.id.fragment_tab_one_recycler);
        list = new ArrayList<>();
        fragment_tab_one_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterList = new SectionViewAllServiceListAdapter(getActivity(),list);
        fragment_tab_one_recycler.setAdapter(adapterList);
        setDataToRecycler();
        return tab_seven_fragment;
    }

    public void setDataToRecycler(){
        list.add(new SectionViewAllServiceListModel("Lower Lips Threading","120","40","Threading","60 min",R.drawable.threading));
        list.add(new SectionViewAllServiceListModel("Upper Lips Threading","180","40","Threading","60 min",R.drawable.threading));
        list.add(new SectionViewAllServiceListModel("Eye Brow Threading","190","40","Threading","60 min",R.drawable.threading));
        list.add(new SectionViewAllServiceListModel("Chin Threading","200","40","Threading","60 min",R.drawable.threading));
        list.add(new SectionViewAllServiceListModel("Fore Head Threading","300","40","Threading","60 min",R.drawable.threading));
        list.add(new SectionViewAllServiceListModel("Full Face Threading","100","40","Threading","60 min",R.drawable.threading));
    }
}
