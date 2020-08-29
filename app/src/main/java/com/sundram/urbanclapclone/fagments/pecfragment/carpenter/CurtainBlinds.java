package com.sundram.urbanclapclone.fagments.pecfragment.carpenter;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.adapter.PECAdapter;
import com.sundram.urbanclapclone.datamodel.CarpenterDataModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurtainBlinds extends Fragment implements PECAdapter.OnServiceItemClick {

    private View carpenterFragment;
    private TextView view_section_heading;
    private RecyclerView recyclerView;
    private PECAdapter adapter;
    private ArrayList<CarpenterDataModel> mList;

    public CurtainBlinds() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        carpenterFragment = inflater.inflate(R.layout.fragment_fragment_view_all_tab1, container, false);
        implementRecyclerview();
        return carpenterFragment;
    }
    public void implementRecyclerview() {
        view_section_heading = carpenterFragment.findViewById(R.id.view_section_heading);
        view_section_heading.setText("Curtains And Blinds");
        recyclerView = carpenterFragment.findViewById(R.id.fragment_tab_one_recycler);
        mList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PECAdapter(getActivity(), mList, this);
        setDataToRecycler();
        recyclerView.setAdapter(adapter);
    }
    public void setDataToRecycler() {
        mList.add(new CarpenterDataModel("Blinds Measurement(upto 10 units)","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Non Motorized Blinds Fitting","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Motorized Blinds Fitting","", "1254", "20",0));
     //   mList.add(new CarpenterDataModel("Curtain", "1254", "20"));
       // mList.add(new CarpenterDataModel("Curtain", "1254", "20"));
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void OnClick(int position) {

    }

    @Override
    public void OnClick(String value) {

    }
}
