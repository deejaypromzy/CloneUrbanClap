package com.sundram.urbanclapclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.datamodel.DataModel;

import java.util.ArrayList;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailHolder> {

    private View detailsView;
    private Context mContext;
    private ArrayList<DataModel> detailsList;

    public DetailsAdapter(Context mContext, ArrayList<DataModel> detailsList) {
        this.mContext = mContext;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        detailsView = LayoutInflater.from(mContext).inflate(R.layout.details_single_item,parent,false);
        return new DetailHolder(detailsView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder holder, int position) {
        DataModel dataModel = detailsList.get(position);
        holder.details.setText(dataModel.getDetails());
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public class DetailHolder extends RecyclerView.ViewHolder{

        TextView details;

        public DetailHolder(@NonNull View itemView) {
            super(itemView);
            details = itemView.findViewById(R.id.details_tv);
        }
    }
}
