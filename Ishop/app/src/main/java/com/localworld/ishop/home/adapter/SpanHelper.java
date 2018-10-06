package com.localworld.ishop.home.adapter;

import android.support.v7.widget.GridLayoutManager;


public class SpanHelper extends GridLayoutManager.SpanSizeLookup {

    private IFullSpanPosition fullSpanPosition;
    private int commonSpanCount;

    public SpanHelper(IFullSpanPosition fullSpanPosition, int commonSpanCount) {
        this.fullSpanPosition = fullSpanPosition;
        this.commonSpanCount = commonSpanCount;
    }

    @Override
    public int getSpanSize(int position) {
        if (fullSpanPosition.isFullSpan(position)) {
            return commonSpanCount;
        } else {
            return 1;
        }
    }
}
