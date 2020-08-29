package com.sundram.urbanclapclone.adapter;

import android.content.Context;
import android.graphics.Color;
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
import java.util.Locale;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DataModelHolder> {

    private Context context;
    private ArrayList<DataModel> arrayList;
    private OnServiceItemClick onServiceItemClick;

    public RecyclerViewAdapter(Context context, ArrayList<DataModel> arrayList, OnServiceItemClick onServiceItemClick) {
        this.context = context;
        this.arrayList = arrayList;
        this.onServiceItemClick = onServiceItemClick;
    }

    @NonNull
    @Override
    public DataModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_single_item, parent, false);
        return new DataModelHolder(view, onServiceItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull DataModelHolder holder, int position) {
        DataModel DataModel = arrayList.get(position);
        holder.setDetails(DataModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class DataModelHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnServiceItemClick onServiceItemClick;
        private TextView txtName;
        private ImageView imageView;

        DataModelHolder(View itemView, OnServiceItemClick onServiceItemClick) {
            super(itemView);

            txtName = itemView.findViewById(R.id.tv_grid_section);
            imageView = itemView.findViewById(R.id.imageView_grid_section);
            this.onServiceItemClick = onServiceItemClick;
            itemView.setOnClickListener(this);
        }

        void setDetails(DataModel DataModel) {
            txtName.setText(DataModel.getServiceName());
            imageView.setImageResource(DataModel.getDrawable());
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