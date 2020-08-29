package com.sundram.urbanclapclone;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.adapter.AdapterHorrizontalButton;
import com.sundram.urbanclapclone.adapter.PECAdapter;
import com.sundram.urbanclapclone.datamodel.CarpenterDataModel;
import com.sundram.urbanclapclone.datamodel.DataModel;
import com.sundram.urbanclapclone.methodscroll.Scroll;

import java.util.ArrayList;

public class ViewAllElectricianServices extends AppCompatActivity {

    private Toolbar toolbarViewAll;
    private TextView login_button_text;
    private RecyclerView btnRecyclerView, switchAndSocketRecyclerView,fanRecyclerView,lightRecyclerView,MCBnadFuseRecyclerView,inverterAndStabilizerRecyclerView,wiringRecycler,doorbellRecyclerView,roomHeaterRecyclerView;
    private DataModel horrizontalbtnDataModel;
    private ArrayList<DataModel> btnList;
    private AdapterHorrizontalButton btnAdapter;
    private NestedScrollView nestedScrollView;
    private Scroll scroll;

    private RecyclerView recyclerView;
    private PECAdapter adapter;
    private ArrayList<CarpenterDataModel> switchList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_new);
        toolbarViewAll = findViewById(R.id.toolbarViewAll);
        setSupportActionBar(toolbarViewAll);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("View All Service");
        scroll = new Scroll(this);
        setHorrizontalBtn();
        settingUpTheSwitchAndSocket();
    }

    public void setHorrizontalBtn() {
        btnList = new ArrayList<>();
        btnRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        btnList.add(new DataModel("Switch and  Socket"));
        btnList.add(new DataModel("Fan"));
        btnList.add(new DataModel("Light"));
        btnList.add(new DataModel("MCB and Fuse"));
        btnList.add(new DataModel("Inverter and Stabilizer"));
        btnList.add(new DataModel("Wiring"));
        btnList.add(new DataModel("Door Bell"));
        btnList.add(new DataModel("Room Heater"));

        btnAdapter = new AdapterHorrizontalButton(btnList, this, new AdapterHorrizontalButton.onRecyclerViewItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                switch (position) {
                    case 0:
                    //    scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, view_hardWax_heading);
                        //    horizontalScrollToRow(btnRecyclerView,(Button)view);
                        break;
                    case 1:
                    //    scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, view_heading_rica_wax);
                        //   horizontalScrollToRow(btnRecyclerView,(Button)view);
                        break;
                    case 2:
                    //    scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, view_honeyWaxHeading);
                        break;
                    case 3:
                     //   scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, facilaHeading);
                        break;
                    case 4:
                     //   scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, manicureHeading);
                        break;
                    case 5:
                     //   scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, haircareHeading);
                        break;
                    case 6:
                    //    scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, threadingHeading);
                        break;
                }
            }
        });

        btnRecyclerView.setAdapter(btnAdapter);
        btnAdapter.notifyDataSetChanged();
    }


    public void settingUpTheSwitchAndSocket(){
        switchAndSocketRecyclerView = findViewById(R.id.hardWaxRecycler);
        switchList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        switchList.add(new CarpenterDataModel("AC Switchbox Installation","", "1254", "20",0));
        switchList.add(new CarpenterDataModel("Switchboard Installation(upto 6 switches)","", "1254", "20",0));
        switchList.add(new CarpenterDataModel("Switchboard Repair(upto 6 switches)","", "1254", "20",0));
        switchList.add(new CarpenterDataModel("Switch/Socket Replacement","", "1254", "20",0));

        adapter = new PECAdapter(this, switchList, new PECAdapter.OnServiceItemClick() {
            @Override
            public void OnClick(int position) {

            }

            @Override
            public void OnClick(String value) {

            }
        });
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void settingUpTheFan(){

    }

    public void settingUpTheMCBAndFuse(){

    }

    public void settingUpTheInverter(){

    }

    public void settingUpTheWiring(){

    }

    public void settingUpTheDoorBell(){

    }

    public void settingUpTheRoomHeater(){

    }

}
