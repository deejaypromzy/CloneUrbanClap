package com.sundram.urbanclapclone.methodscroll;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import com.sundram.urbanclapclone.ViewAllServiceActivity;


public class Scroll {

    private Context scrollContext;

    public Scroll(){}

    public Scroll(Context scrollContext) {
        this.scrollContext=scrollContext;
    }

    public void scrollToRow(final NestedScrollView scrollView, final LinearLayout linearLayout, final TextView textViewToShow) {
        long delay = 100; //delay to let finish with possible modifications to ScrollView
        scrollView.postDelayed(new Runnable() {
            public void run() {
                Rect textRect = new Rect(); //coordinates to scroll to
                textViewToShow.getHitRect(textRect); //fills textRect with coordinates of TextView relative to its parent (LinearLayout)
                scrollView.scrollTo(0, (int) textRect.top);
                //scrollView.requestChildRectangleOnScreen(linearLayout, textRect, false); //ScrollView will make sure, the given textRect is visible
            }
        }, delay);
    }


}
