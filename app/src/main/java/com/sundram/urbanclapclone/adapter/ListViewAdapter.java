package com.sundram.urbanclapclone.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sundram.urbanclapclone.AcServiceAndRepair;
import com.sundram.urbanclapclone.BathroomCleaning;
import com.sundram.urbanclapclone.CarpenterActivity;
import com.sundram.urbanclapclone.CarpetCleanigActivity;
import com.sundram.urbanclapclone.ElectricianActivity;
import com.sundram.urbanclapclone.FullHomeDeepCleaning;
import com.sundram.urbanclapclone.GyserServiceAndRepair;
import com.sundram.urbanclapclone.KitchenCleaningActivity;
import com.sundram.urbanclapclone.MicroWaveRepair;
import com.sundram.urbanclapclone.PestControl;
import com.sundram.urbanclapclone.PlumberActivity;
import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.RefrigeratorRepair;
import com.sundram.urbanclapclone.RoandWaterActivity;
import com.sundram.urbanclapclone.SalonAtHome;
import com.sundram.urbanclapclone.ServiceListItem;
import com.sundram.urbanclapclone.SofaCleaning;
import com.sundram.urbanclapclone.WashingmachineRepair;
import com.sundram.urbanclapclone.datamodel.ServiceName;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<ServiceName> serviceNameList = null;
    private ArrayList<ServiceName> arraylist;
    private ListView listView;

    public ListViewAdapter(Context context, List<ServiceName> serviceNameList) {
        mContext = context;
        this.serviceNameList = serviceNameList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<ServiceName>();
        this.arraylist.addAll(serviceNameList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return serviceNameList.size();
    }

    @Override
    public ServiceName getItem(int position) {
        return serviceNameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(serviceNameList.get(position).getServiceName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (serviceNameList.get(position).getServiceName().equals("Plumber")){
                    Intent plumber = new Intent(mContext,PlumberActivity.class);
                    mContext.startActivity(plumber);
                    ((Activity)mContext).finish();
                    //mContext.startActivity(mContext,PlumberActivity.class);
                }
                if (serviceNameList.get(position).getServiceName().equals("Carpenter")){
                    Intent carpenter = new Intent(mContext,CarpenterActivity.class);
                    mContext.startActivity(carpenter);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Electrician")){
                    Intent electrician = new Intent(mContext,ElectricianActivity.class);
                    mContext.startActivity(electrician);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Salon at home")){
                    Intent salonAtHome = new Intent(mContext,SalonAtHome.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Bathroom Cleaning")){
                    Intent salonAtHome = new Intent(mContext, BathroomCleaning.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Sofa Cleaning")){
                    Intent salonAtHome = new Intent(mContext, SofaCleaning.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Carpet Cleaning")){
                    Intent salonAtHome = new Intent(mContext, CarpetCleanigActivity.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Kitchen Cleaning")){
                    Intent salonAtHome = new Intent(mContext, KitchenCleaningActivity.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Full Home Cleaning")){
                    Intent salonAtHome = new Intent(mContext, FullHomeDeepCleaning.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Pest control service")){
                    Intent salonAtHome = new Intent(mContext, PestControl.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Refrigerator Repair")){
                    Intent salonAtHome = new Intent(mContext, RefrigeratorRepair.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Microwave Repair")){
                    Intent salonAtHome = new Intent(mContext, MicroWaveRepair.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Cleaning Service")){
                    Intent salonAtHome = new Intent(mContext, ServiceListItem.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                   if (serviceNameList.get(position).getServiceName().equals("AC Service and Repair")){
                    Intent salonAtHome = new Intent(mContext, AcServiceAndRepair.class);
                    mContext.startActivity(salonAtHome);
                       ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Geyser Service and Repair")){
                    Intent salonAtHome = new Intent(mContext, GyserServiceAndRepair.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("RO and Water Purifier Service and Repair")){
                    Intent salonAtHome = new Intent(mContext, RoandWaterActivity.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }
                if (serviceNameList.get(position).getServiceName().equals("Washing machine Service and Repair")){
                    Intent salonAtHome = new Intent(mContext, WashingmachineRepair.class);
                    mContext.startActivity(salonAtHome);
                    ((Activity)mContext).finish();
                }

            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        serviceNameList.clear();
        if (charText.length() == 0) {
            serviceNameList.addAll(arraylist);
        } else {
            for (ServiceName wp : arraylist) {
                if (wp.getServiceName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    serviceNameList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}