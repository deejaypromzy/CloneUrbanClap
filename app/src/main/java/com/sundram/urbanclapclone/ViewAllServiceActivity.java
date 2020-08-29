package com.sundram.urbanclapclone;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.adapter.AdapterHorrizontalButton;
import com.sundram.urbanclapclone.adapter.SectionViewAllServiceListAdapter;
import com.sundram.urbanclapclone.datamodel.DataModel;
import com.sundram.urbanclapclone.datamodel.SectionViewAllServiceListModel;
import com.sundram.urbanclapclone.methodscroll.Scroll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewAllServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbarViewAll;
    private TextView login_button_text;
    private RecyclerView btnRecyclerView;
    private DataModel horrizontalbtnDataModel;
    private ArrayList<DataModel> btnList;
    private AdapterHorrizontalButton btnAdapter;
    private NestedScrollView nestedScrollView;

    private ArrayList<SectionViewAllServiceListModel> hardWaxList, ricaWaxList, honeyWaxList, facialWaxList, manicureList, haircareList, threadingList;
    private RecyclerView hardWaxRecycler, ricaWaxRecycler, honeyWaxRecyclerview, facialRecyclerView, manicureRecyclerView, hairCareRecyclerView, threadingRecyclerView;
    private TextView view_hardWax_heading, view_heading_rica_wax, view_honeyWaxHeading, facilaHeading, manicureHeading, haircareHeading, threadingHeading;
    private SectionViewAllServiceListAdapter hardWaxAdapter, ricaWaxAdapter, honeyWaxAdapter, facialAdapter, manicureAdapter, haircareAdapter, threadingAdapter;


    TextView nextBtn, prevBtn;

    LinearLayout hardwax_Linearlayout;
    int totalQuantity = 0;
    Scroll scroll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_new);
        toolbarViewAll = findViewById(R.id.toolbarViewAll);
        setSupportActionBar(toolbarViewAll);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("View All Service");
        scroll = new Scroll(ViewAllServiceActivity.this);

//
//        prevBtn = findViewById(R.id.previoushorizontalBtn);
//
//        nextBtn = findViewById(R.id.nexthorizontalBtn);
        hardwax_Linearlayout = findViewById(R.id.hardwaxLinearlayout);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        btnRecyclerView = findViewById(R.id.horizontal_scrolling_btn_recyclerView);
//        prevBtn.setOnClickListener(this);
//        nextBtn.setOnClickListener(this);
        login_button_text = findViewById(R.id.login_button_text);
        login_button_text.setText("Check Out");
        setHorrizontalBtn();
        settingUpTheHardWaxingSection();

        //snippets for getting the current tab
        final Intent intent = getIntent();
        ///String hey = getIntent().getStringExtra("TabNumber");
        if (intent.hasExtra("TabNumber")) {
            String tab = intent.getExtras().getString("TabNumber");
            Log.e("TabNumberServiceList", tab);
            switchToTab(tab);
        }
    }

    //snippets for switching the tab
    public void switchToTab(String tab) {
        if (tab.equals("0")) {
            scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, view_hardWax_heading);
        } else if (tab.equals("1")) {
            scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, view_heading_rica_wax);
        } else if (tab.equals("2")) {
            scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, view_honeyWaxHeading);
        } else if (tab.equals("3")) {
            scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, facilaHeading);
        } else if (tab.equals("4")) {
            scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, manicureHeading);
        } else if (tab.equals("5")) {
            scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, haircareHeading);
        } else if (tab.equals("6")) {
            scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, threadingHeading);
        }
    }

    public void setHorrizontalBtn() {
        btnList = new ArrayList<>();
        btnRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        btnList.add(new DataModel("Hard Waxing Service"));
        btnList.add(new DataModel("Fruit Waxing Service"));
        btnList.add(new DataModel("Honey/Soft Waxing Service"));
        btnList.add(new DataModel("Facial, Bleach and Detan Service"));
        btnList.add(new DataModel("Manicure & Pedicure Care"));
        btnList.add(new DataModel("Hair Care"));
        btnList.add(new DataModel("Threading Care"));

        btnAdapter = new AdapterHorrizontalButton(btnList, this, new AdapterHorrizontalButton.onRecyclerViewItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                switch (position) {
                    case 0:
                        scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, view_hardWax_heading);
                        //    horizontalScrollToRow(btnRecyclerView,(Button)view);
                        break;
                    case 1:
                        scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, view_heading_rica_wax);
                        //   horizontalScrollToRow(btnRecyclerView,(Button)view);
                        break;
                    case 2:
                        scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, view_honeyWaxHeading);
                        break;
                    case 3:
                        scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, facilaHeading);
                        break;
                    case 4:
                        scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, manicureHeading);
                        break;
                    case 5:
                        scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, haircareHeading);
                        break;
                    case 6:
                        scroll.scrollToRow(nestedScrollView, hardwax_Linearlayout, threadingHeading);
                        break;
                }
            }
        });

        btnRecyclerView.setAdapter(btnAdapter);
        btnAdapter.notifyDataSetChanged();
    }


//    public void horizontalScrollToRow(final RecyclerView recyclerView,Button textView){
//        long delay =100;
//        recyclerView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Rect textViewtRect = new Rect();
//                textView.getHitRect(textViewtRect);
//                recyclerView.scrollTo(0,(int)textViewtRect.top);
//            }
//        },delay);
//    }

    public void settingUpTheHardWaxingSection() {
        view_hardWax_heading = findViewById(R.id.hardWaxHeading);
        view_hardWax_heading.setText("Hard Waxing");
        hardWaxRecycler = findViewById(R.id.hardWaxRecycler);
        hardWaxList = new ArrayList<>();
        hardWaxRecycler.setLayoutManager(new LinearLayoutManager(ViewAllServiceActivity.this));
        hardWaxList.add(new SectionViewAllServiceListModel("Full Face Waxing", "120", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        hardWaxList.add(new SectionViewAllServiceListModel("Full-arm Waxing", "180", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        hardWaxList.add(new SectionViewAllServiceListModel("Half-arm Waxing", "190", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        hardWaxList.add(new SectionViewAllServiceListModel("Underarms Waxing", "200", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        hardWaxList.add(new SectionViewAllServiceListModel("Eyebrows Waxing", "300", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        hardWaxList.add(new SectionViewAllServiceListModel("Chest  Waxing", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        hardWaxList.add(new SectionViewAllServiceListModel("Half-leg (lower)", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        hardWaxList.add(new SectionViewAllServiceListModel("Half-leg (upper)", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        hardWaxList.add(new SectionViewAllServiceListModel("Full-leg", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        hardWaxAdapter = new SectionViewAllServiceListAdapter(this, hardWaxList, new SectionViewAllServiceListAdapter.OnServiceItemClick() {
            @Override
            public void onClick(String position, int pos,View itemView) {
                Toast.makeText(ViewAllServiceActivity.this,"totalQuantity = "+position,Toast.LENGTH_LONG).show();
                if (!position.equals("0")) {// !position.equals("0") is use to show or hide the visibility of bottom button
                    login_button_text.setVisibility(View.VISIBLE);
                    Toast.makeText(ViewAllServiceActivity.this,""+pos,Toast.LENGTH_SHORT).show();
                } else {
                    login_button_text.setVisibility(View.GONE);
                }
            }
        });
        hardWaxRecycler.setAdapter(hardWaxAdapter);
        hardWaxAdapter.notifyDataSetChanged();
        settingUpTheRicaWaxingSection();
    }

    public void settingUpTheRicaWaxingSection() {
        view_heading_rica_wax = findViewById(R.id.fruitWaxHeading);
        view_heading_rica_wax.setText("Fruit Waxing");
        ricaWaxRecycler = findViewById(R.id.ricaWaxRecycler);
        ricaWaxList = new ArrayList<>();
        ricaWaxRecycler.setLayoutManager(new LinearLayoutManager(ViewAllServiceActivity.this));
        ricaWaxList.add(new SectionViewAllServiceListModel("Full Face Waxing", "120", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        ricaWaxList.add(new SectionViewAllServiceListModel("Full-arm Waxing", "180", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        ricaWaxList.add(new SectionViewAllServiceListModel("Half-arm Waxing", "190", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        ricaWaxList.add(new SectionViewAllServiceListModel("Underarms Waxing", "200", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        ricaWaxList.add(new SectionViewAllServiceListModel("Eyebrows Waxing", "300", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        ricaWaxList.add(new SectionViewAllServiceListModel("Chest  Waxing", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        ricaWaxList.add(new SectionViewAllServiceListModel("Half-leg (lower)", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        ricaWaxList.add(new SectionViewAllServiceListModel("Half-leg (upper)", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        ricaWaxList.add(new SectionViewAllServiceListModel("Full-leg", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        ricaWaxAdapter = new SectionViewAllServiceListAdapter(this, ricaWaxList, new SectionViewAllServiceListAdapter.OnServiceItemClick() {
            @Override
            public void onClick(String position,int pos,View view) {
                if (!position.equals("0")) {

                    login_button_text.setVisibility(View.VISIBLE);
                    //    totalQuantity=totalQuantity+Integer.parseInt(position);
                    //    Toast.makeText(ViewAllServiceActivity.this,"Tottal Quantity = "+totalQuantity,Toast.LENGTH_LONG).show();
                } else {
                    login_button_text.setVisibility(View.GONE);
                }
            }
        });
        ricaWaxRecycler.setAdapter(ricaWaxAdapter);
        ricaWaxAdapter.notifyDataSetChanged();
        settingUpTheHoneyWaxingSection();
    }

    public void settingUpTheHoneyWaxingSection() {
        view_honeyWaxHeading = findViewById(R.id.honeyWaxHeading);
        view_honeyWaxHeading.setText("Honey Waxing");
        honeyWaxRecyclerview = findViewById(R.id.honeyWaxRecycler);
        honeyWaxList = new ArrayList<>();
        honeyWaxRecyclerview.setLayoutManager(new LinearLayoutManager(ViewAllServiceActivity.this));

        honeyWaxList.add(new SectionViewAllServiceListModel("Full Face Honey Waxing", "120", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        honeyWaxList.add(new SectionViewAllServiceListModel("Full-arm Honey Waxing", "180", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        honeyWaxList.add(new SectionViewAllServiceListModel("Half-arm Honey Waxing", "190", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        honeyWaxList.add(new SectionViewAllServiceListModel("Underarms Honey Waxing", "200", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        honeyWaxList.add(new SectionViewAllServiceListModel("Eyebrows Honey Waxing", "300", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        honeyWaxList.add(new SectionViewAllServiceListModel("Chest Honey Waxing", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        honeyWaxList.add(new SectionViewAllServiceListModel("Half-leg Honey Waxing(lower)", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        honeyWaxList.add(new SectionViewAllServiceListModel("Half-leg Honey Waxing(upper)", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        honeyWaxList.add(new SectionViewAllServiceListModel("Full-leg Honey Waxing", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        honeyWaxList.add(new SectionViewAllServiceListModel("Stomach Honey Waxing", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));

        honeyWaxAdapter = new SectionViewAllServiceListAdapter(this, honeyWaxList, new SectionViewAllServiceListAdapter.OnServiceItemClick() {
            @Override
            public void onClick(String position,int pos,View view) {
                if (!position.equals("0")) {
                    login_button_text.setVisibility(View.VISIBLE);
                } else {
                    login_button_text.setVisibility(View.GONE);
                }
            }
        });
        honeyWaxRecyclerview.setAdapter(honeyWaxAdapter);
        honeyWaxAdapter.notifyDataSetChanged();
        settingUpTheFacialSection();
    }

    public void settingUpTheFacialSection() {
        facilaHeading = findViewById(R.id.facialHeading);
        facilaHeading.setText("Facial, Bleach and Detan");
        facialRecyclerView = findViewById(R.id.facialRecyclerView);
        facialWaxList = new ArrayList<>();
        facialRecyclerView.setLayoutManager(new LinearLayoutManager(ViewAllServiceActivity.this));

        facialWaxList.add(new SectionViewAllServiceListModel("Detan Full Face", "120", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        facialWaxList.add(new SectionViewAllServiceListModel("O3+ Full Face", "120", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        facialWaxList.add(new SectionViewAllServiceListModel("Deatn Full-arm", "180", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        facialWaxList.add(new SectionViewAllServiceListModel("Detan Half-arm", "190", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        facialWaxList.add(new SectionViewAllServiceListModel("Detan Underarms", "200", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        facialWaxList.add(new SectionViewAllServiceListModel("Detan Chest", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        facialWaxList.add(new SectionViewAllServiceListModel("Detan Half-leg(lower)", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        facialWaxList.add(new SectionViewAllServiceListModel("Dertan Half-leg(upper)", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        facialWaxList.add(new SectionViewAllServiceListModel("Detan ull-leg", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));
        facialWaxList.add(new SectionViewAllServiceListModel("Detan Stomach", "100", "40", "Wax", "60 min", 0, 0, R.drawable.waxing));

        facialAdapter = new SectionViewAllServiceListAdapter(this, facialWaxList, new SectionViewAllServiceListAdapter.OnServiceItemClick() {
            @Override
            public void onClick(String position,int pos,View view) {
                if (!position.equals("0")) {
                    login_button_text.setVisibility(View.VISIBLE);
                } else {
                    login_button_text.setVisibility(View.GONE);
                }
            }
        });
        facialRecyclerView.setAdapter(facialAdapter);
        facialAdapter.notifyDataSetChanged();
        settingUpTheManicureSection();
    }

    public void settingUpTheManicureSection() {
        manicureHeading = findViewById(R.id.manicure_and_pedicure_heading);
        manicureHeading.setText("Manicure and Pedicure");
        manicureRecyclerView = findViewById(R.id.manicureRecyclerView);
        manicureList = new ArrayList<>();
        manicureRecyclerView.setLayoutManager(new LinearLayoutManager(ViewAllServiceActivity.this));

        manicureList.add(new SectionViewAllServiceListModel("Cut, File and Polish Hand", "120", "40", "Menicure/Pedicure", "60 min", R.drawable.medicure));
        manicureList.add(new SectionViewAllServiceListModel("Cut, File and Polish Feet", "120", "40", "Menicure", "60 min", R.drawable.medicure));
        manicureList.add(new SectionViewAllServiceListModel("Detan Pedicure", "120", "40", "Menicure/Pedicure", "60 min", R.drawable.medicure));
        manicureList.add(new SectionViewAllServiceListModel("Detan Manicure", "120", "40", "Menicure/Pedicure", "60 min", R.drawable.medicure));

        manicureAdapter = new SectionViewAllServiceListAdapter(this, facialWaxList, new SectionViewAllServiceListAdapter.OnServiceItemClick() {
            @Override
            public void onClick(String position,int pos,View view) {
                if (!position.equals("0")) {
                    login_button_text.setVisibility(View.VISIBLE);
                } else {
                    login_button_text.setVisibility(View.GONE);
                }
            }
        });
        manicureRecyclerView.setAdapter(manicureAdapter);
        manicureAdapter.notifyDataSetChanged();
        settingUpTheHairCareSection();
    }

    public void settingUpTheHairCareSection() {
        haircareHeading = findViewById(R.id.hairecareHeading);
        haircareHeading.setText("Hair Care");
        hairCareRecyclerView = findViewById(R.id.hairCareRecyclerview);
        haircareList = new ArrayList<>();
        hairCareRecyclerView.setLayoutManager(new LinearLayoutManager(ViewAllServiceActivity.this));

        haircareList.add(new SectionViewAllServiceListModel("L'Oreal Hair Spa Small Length Treatment", "1499", "500", "Hair Care", "45 min", 0, 0, R.drawable.hair));
        haircareList.add(new SectionViewAllServiceListModel("L'Oreal Hair Spa Medium Length Treatment", "749", "151", "Hair Care", "45 min", 0, 0, R.drawable.hair));
        haircareList.add(new SectionViewAllServiceListModel("L'Oreal Hair Spa Large Length Treatment", "899", "200", "Hair Care", "45 min", 0, 0, R.drawable.hair));
        haircareList.add(new SectionViewAllServiceListModel("Hair Colouring for Small Length", "200", "40", "Hair Care", "60 min", 0, 0, R.drawable.hair));
        haircareList.add(new SectionViewAllServiceListModel("Hair Colouring for Medium Length", "200", "40", "Hair Care", "60 min", 0, 0, R.drawable.hair));
        haircareList.add(new SectionViewAllServiceListModel("Hair Colouring for Large Length", "200", "40", "Hair Care", "60 min", 0, 0, R.drawable.hair));
        haircareList.add(new SectionViewAllServiceListModel("Hair Cut Simple", "400", "40", "Hair Care", "60 min", 0, 0, R.drawable.hair));
        haircareList.add(new SectionViewAllServiceListModel("Hair Cut Advance", "400", "40", "Hair Care", "60 min", 0, 0, R.drawable.hair));

        haircareAdapter = new SectionViewAllServiceListAdapter(this, haircareList, new SectionViewAllServiceListAdapter.OnServiceItemClick() {
            @Override
            public void onClick(String position,int pos,View view) {
                Toast.makeText(ViewAllServiceActivity.this, "" + position, Toast.LENGTH_LONG).show();
                if (!position.equals("0")) {
                    login_button_text.setVisibility(View.VISIBLE);
                } else {
                    login_button_text.setVisibility(View.GONE);
                }
            }
        });
        hairCareRecyclerView.setAdapter(haircareAdapter);
        haircareAdapter.notifyDataSetChanged();
        settingUpTheThreadingSection();
    }

    public void settingUpTheThreadingSection() {
        threadingHeading = findViewById(R.id.threadingHeading);
        threadingHeading.setText("Threading Care");
        threadingRecyclerView = findViewById(R.id.threadingRecyclerview);
        threadingList = new ArrayList<>();
        threadingRecyclerView.setLayoutManager(new LinearLayoutManager(ViewAllServiceActivity.this));

        threadingList.add(new SectionViewAllServiceListModel("Lower Lips Threading", "120", "40", "Threading", "60 min", R.drawable.threading));
        threadingList.add(new SectionViewAllServiceListModel("Upper Lips Threading", "180", "40", "Threading", "60 min", R.drawable.threading));
        threadingList.add(new SectionViewAllServiceListModel("Eye Brow Threading", "190", "40", "Threading", "60 min", R.drawable.threading));
        threadingList.add(new SectionViewAllServiceListModel("Chin Threading", "200", "40", "Threading", "60 min", R.drawable.threading));
        threadingList.add(new SectionViewAllServiceListModel("Fore Head Threading", "300", "40", "Threading", "60 min", R.drawable.threading));
        threadingList.add(new SectionViewAllServiceListModel("Full Face Threading", "100", "40", "Threading", "60 min", R.drawable.threading));

        threadingAdapter = new SectionViewAllServiceListAdapter(this, threadingList, new SectionViewAllServiceListAdapter.OnServiceItemClick() {
            @Override
            public void onClick(String position,int pos,View view) {
                if (!position.equals("0")) {
                    login_button_text.setVisibility(View.VISIBLE);
                } else {
                    login_button_text.setVisibility(View.GONE);
                }
            }
        });
        threadingRecyclerView.setAdapter(threadingAdapter);
        threadingAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ViewAllServiceActivity.this, SalonAtHome.class));
        finish();
    }

    @Override
    public void onClick(View v) {

    }
}
