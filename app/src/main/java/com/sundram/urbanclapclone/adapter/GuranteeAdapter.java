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
import com.sundram.urbanclapclone.datamodel.dataModelGuranteeSection;

import java.util.ArrayList;

public class GuranteeAdapter extends RecyclerView.Adapter<GuranteeAdapter.GuranteeViewHolder> {

   private Context mContext;
   private ArrayList<dataModelGuranteeSection> arrayList;

    public GuranteeAdapter(Context mContext, ArrayList<dataModelGuranteeSection> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public GuranteeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.gurantee_section_single_item,parent,false);
        GuranteeViewHolder view = new GuranteeViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull GuranteeViewHolder holder, int position) {
        dataModelGuranteeSection data1 = arrayList.get(position);
        holder.setGuranteeDetails(data1);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class GuranteeViewHolder extends RecyclerView.ViewHolder {

        TextView txt,subtitle_txt;
        ImageView imageView;
        public GuranteeViewHolder(@NonNull View itemView) {
            super(itemView);


       //     txt = itemView.findViewById(R.id.gurantee_iv);
      //      subtitle_txt = itemView.findViewById(R.id.gurantee_tv_subtitle);
        }

        void setGuranteeDetails(dataModelGuranteeSection data){

       //     txt.setText(data.getGurantee_tv1());
       //     subtitle_txt.setText(data.getGurantee_subtile_tv());
        }
    }
}
