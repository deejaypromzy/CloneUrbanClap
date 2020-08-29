package com.sundram.urbanclapclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.datamodel.AddTOCartDataModel;

import java.util.ArrayList;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.CartViewHolder> {

    private Context mContext;
    private View addToCartView;
    private ArrayList<AddTOCartDataModel> data;

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        addToCartView = LayoutInflater.from(mContext).inflate(R.layout.secton_view_all_plumber_carpenter,parent,false);

        return new CartViewHolder(addToCartView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{



        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
