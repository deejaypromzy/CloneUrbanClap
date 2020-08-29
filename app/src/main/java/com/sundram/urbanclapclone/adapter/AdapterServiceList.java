package com.sundram.urbanclapclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.datamodel.DataModel;

import java.util.ArrayList;

public class AdapterServiceList extends RecyclerView.Adapter<AdapterServiceList.ViewHolders> {

    protected Context mContext;
    protected ArrayList<DataModel> mList;

    public AdapterServiceList(Context mContext, ArrayList<DataModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_service_list_single_item,parent,false);
        ViewHolders viewHolders = new ViewHolders(view);
        return viewHolders;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolders holder, int position) {
        DataModel data = mList.get(position);
        holder.setDetails(data);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder {

        TextView serviceName;
        ImageView serviceImage;

        public ViewHolders(@NonNull View itemView) {
            super(itemView);

            serviceImage = itemView.findViewById(R.id.service_item_image);
            serviceName = itemView.findViewById(R.id.servicename_tv);

        }

        void setDetails(DataModel dataModel){
            serviceName.setText(dataModel.getServiceName());
        }
    }
}
