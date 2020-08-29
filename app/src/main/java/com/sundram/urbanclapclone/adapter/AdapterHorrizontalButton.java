package com.sundram.urbanclapclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.datamodel.DataModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterHorrizontalButton extends RecyclerView.Adapter<AdapterHorrizontalButton.ButtonViewHolder> {

    private ArrayList<DataModel> btnList;
    private Context mContext;
    private View btnView;
    private onRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public AdapterHorrizontalButton(ArrayList<DataModel> btnList, Context mContext, onRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.mContext = mContext;
        this.btnList = btnList;
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        btnView = LayoutInflater.from(mContext).inflate(R.layout.single_view_all_service_button_scrolling_btn, parent, false);
        return new ButtonViewHolder(btnView, onRecyclerViewItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        DataModel data = btnList.get(position);
        holder.btn.setText(data.getDetails());
    }

    @Override
    public int getItemCount() {
        return btnList.size();
    }

    public class ButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Button btn;
        onRecyclerViewItemClickListener onRecyclerViewItemClickListener;

        public ButtonViewHolder(@NonNull View itemView,onRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
            super(itemView);
            this.onRecyclerViewItemClickListener=onRecyclerViewItemClickListener;
            btn = itemView.findViewById(R.id.horizontalBtn);
            btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onRecyclerViewItemClickListener != null) {
                onRecyclerViewItemClickListener.onItemClickListener(v, getAdapterPosition());
            }
        }
    }

    public void setOnItemClickListener(onRecyclerViewItemClickListener mItemClickListener) {
        this.onRecyclerViewItemClickListener = mItemClickListener;
    }

    public interface onRecyclerViewItemClickListener {
        void onItemClickListener(View view, int position);
    }
}
