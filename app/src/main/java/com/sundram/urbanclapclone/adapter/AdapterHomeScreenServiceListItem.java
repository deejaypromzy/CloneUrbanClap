package com.sundram.urbanclapclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.datamodel.ServiceName;

import java.util.ArrayList;

public class AdapterHomeScreenServiceListItem extends RecyclerView.Adapter<AdapterHomeScreenServiceListItem.ItemViewHolder> {

    private Context mContext;
    protected ArrayList<ServiceName> mListServiceName;
    private OnServiceItemClick onServiceItemClick;

    public AdapterHomeScreenServiceListItem(Context mContext, ArrayList<ServiceName> mListServiceName, OnServiceItemClick onServiceItemClick) {
        this.mContext = mContext;
        this.mListServiceName = mListServiceName;
        this.onServiceItemClick=onServiceItemClick;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.new_single_service_element_home_screen, parent, false);

        return new ItemViewHolder(v,onServiceItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            ServiceName data =mListServiceName.get(position);
            holder.setDetailsToItem(data);
    }

    @Override
    public int getItemCount() {
        return mListServiceName.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView service_name_tV, service_name_one_tv, service_name_two_tv, service_name_three_tv;
        CardView home_screen_item_single_card_ui;
        OnServiceItemClick onServiceItemClick;
        ImageView home_screen_service_image;

        public ItemViewHolder(@NonNull View itemView,OnServiceItemClick onServiceItemClick) {
            super(itemView);
            home_screen_service_image = itemView.findViewById(R.id.home_screen_service_image);
            service_name_tV = itemView.findViewById(R.id.service_name_tv);
            service_name_one_tv = itemView.findViewById(R.id.service_name_tv_one);
            service_name_two_tv = itemView.findViewById(R.id.service_name_tv_two);
            service_name_three_tv = itemView.findViewById(R.id.service_name_tv_three);
            home_screen_item_single_card_ui = itemView.findViewById(R.id.home_screen_item_single_card_ui);
            this.onServiceItemClick =onServiceItemClick;
            itemView.setOnClickListener(this);
        }

        void setDetailsToItem(ServiceName serviceName) {
            service_name_tV.setText(serviceName.getServiceName());
            service_name_one_tv.setText(serviceName.getService_txt_one());
            service_name_two_tv.setText(serviceName.getService_txt_two());
            service_name_three_tv.setText(serviceName.getService_txt_three());
            home_screen_service_image.setImageResource(serviceName.getDrawable());
        }

        @Override
        public void onClick(View v) {
            onServiceItemClick.onClick(getAdapterPosition());
        }
    }

    public static interface OnServiceItemClick {
        public void onClick(int position);
    }
}
