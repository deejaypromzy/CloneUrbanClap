package com.sundram.urbanclapclone.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.datamodel.SectionViewAllServiceListModel;
import com.sundram.urbanclapclone.viewallserviceactivity.salonathome.ViewAllServiceActivity;

import java.util.ArrayList;
import java.util.List;

public class SectionViewAllServiceListAdapter extends RecyclerView.Adapter<SectionViewAllServiceListAdapter.ListHolder> {

    private View section_view;
    private Context mContext;
    private ArrayList<SectionViewAllServiceListModel> mList;
    private OnServiceItemClick onServiceItemClick;
    // private ViewAllServiceActivity viewAllServiceActivity = new ViewAllServiceActivity();
    int x = 0;

    public SectionViewAllServiceListAdapter(Context mContext, OnServiceItemClick onServiceItemClick) {
        this.mContext = mContext;
        this.onServiceItemClick = onServiceItemClick;
    }
    public SectionViewAllServiceListAdapter(Context mContext, ArrayList<SectionViewAllServiceListModel> data) {
        this.mContext = mContext;
        this.mList=data;
    }
    public SectionViewAllServiceListAdapter(Context mContext, ArrayList<SectionViewAllServiceListModel> mList, OnServiceItemClick onServiceItemClick) {
        this.mContext = mContext;
        this.mList = mList;
        this.onServiceItemClick = onServiceItemClick;
    }


    @NonNull
    @Override
    public SectionViewAllServiceListAdapter.ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        section_view = LayoutInflater.from(mContext).inflate(R.layout.secton_view_all_service_list, parent, false);
        return new ListHolder(section_view, onServiceItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionViewAllServiceListAdapter.ListHolder holder, int position) {
        SectionViewAllServiceListModel datas = mList.get(position);
        holder.setData(datas);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView productImage;
        private TextView serviceName, rupee, rupeeOff, type_of_service, timeOfService, minus_tvs, add_txt_tvs, plus_tvs, totalPrice_tvs;
        private OnServiceItemClick onServiceItemClick;
        int totalQuantit=0;
        public ListHolder(@NonNull View itemView, OnServiceItemClick onServiceItemClick) {
            super(itemView);

            productImage = itemView.findViewById(R.id.view_all_service_list_item_image);

            totalPrice_tvs = itemView.findViewById(R.id.totalPrice_tv);
            minus_tvs = itemView.findViewById(R.id.minus_tv);
            add_txt_tvs = itemView.findViewById(R.id.add_tv);
            plus_tvs = itemView.findViewById(R.id.plus_tv);

            serviceName = itemView.findViewById(R.id.title_tv);
            rupee = itemView.findViewById(R.id.price_tv);
            rupeeOff = itemView.findViewById(R.id.offer_price);
            type_of_service = itemView.findViewById(R.id.type_of_service);
            timeOfService = itemView.findViewById(R.id.serviceTime);

            this.onServiceItemClick = onServiceItemClick;

            itemView.setOnClickListener(this);

            minus_tvs.setOnClickListener(this);
            //add_txt_tvs.setOnClickListener(this);
            plus_tvs.setOnClickListener(this);

        }

        void setData(SectionViewAllServiceListModel data) {

            productImage.setImageResource(data.getDrawable());
            serviceName.setText(data.getServiceName());
            rupee.setText(" \u20B9  " + data.getRupee());
            rupeeOff.setText("| \u20B9 " + data.getOffRupe() + " off");
            type_of_service.setText(data.getTypeOfService());
            timeOfService.setText(data.getServiceTime());

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == plus_tvs.getId()) {
                increment();
            } else if (v.getId() == minus_tvs.getId()) {
                decrement();
            }
      //      onServiceItemClick.onClick(getAdapterPosition(),v);
        }

        public void increment() {
            int currentNos = Integer.parseInt(add_txt_tvs.getText().toString());
            if (currentNos < 5) {
                add_txt_tvs.setText(String.valueOf(++currentNos));
                onServiceItemClick.onClick(add_txt_tvs.getText().toString(),getAdapterPosition(),itemView);
            }
        }

        public void decrement() {
            int currentNos = Integer.parseInt(add_txt_tvs.getText().toString());
            if (currentNos != 0) {
                add_txt_tvs.setText(String.valueOf(--currentNos));
                onServiceItemClick.onClick(add_txt_tvs.getText().toString(),getAdapterPosition(),itemView);
            }
        }
    }

    public interface OnServiceItemClick {
        void onClick(String position,int pos,View view);
    }

}
