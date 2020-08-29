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
public class Door extends Fragment implements PECAdapter.OnServiceItemClick {

    private View carpenterFragment;
    private TextView view_section_heading;
    private RecyclerView recyclerView;
    private PECAdapter adapter;
    private ArrayList<CarpenterDataModel> mList;

    public Door() {
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
        view_section_heading.setText("Door");
        recyclerView = carpenterFragment.findViewById(R.id.fragment_tab_one_recycler);
        mList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PECAdapter(getActivity(), mList, this);
        setDataToRecycler();
        recyclerView.setAdapter(adapter);
    }

    public void setDataToRecycler() {
        mList.add(new CarpenterDataModel("Accessory Installation","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Door Latch(Aldrop Installation)","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Hinge Installation(upto 4 hinges)","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Hinge Installation(Including door dismantling)","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Lock Installation","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Lock Replacement","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Lock Repair","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Electronic / Digital Lock Installation","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Mesh Grill Door Installation","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Mesh Grill Door(Mesh Replacement)", "","1254", "20",0));
        mList.add(new CarpenterDataModel("Overhead Door Closer Installation","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Overhead Door Closer Uninstallation","", "1254", "20",0));
        mList.add(new CarpenterDataModel("Sliding Door Repair", "1254","", "20",0));
        mList.add(new CarpenterDataModel("Surface Mounted Door Closer Installation","", "1254", "20",0));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnClick(int position) {

    }

    @Override
    public void OnClick(String value) {

    }
}
