package com.localworld.ishop.message.adapter;

import android.annotation.TargetApi;
import android.content.Context;

import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;


import com.localworld.ishop.R;


public class TipsView extends LinearLayout {
    public TipsView(Context context) {
        super(context);
        init();
    }

    public TipsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public TipsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.item_message_report, this);
    }
}