package com.sundram.urbanclapclone.prefermanager;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferManager {
    Context context;

    public PreferManager(Context context) {
        this.context = context;
    }

    public void setAddress(String address){
        SharedPreferences sharedPreferences = context.getSharedPreferences("address",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Address", address);
        editor.commit();
    }
    public String getAddress(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("address",Context.MODE_PRIVATE);
        return sharedPreferences.getString("Address","");
    }
}
