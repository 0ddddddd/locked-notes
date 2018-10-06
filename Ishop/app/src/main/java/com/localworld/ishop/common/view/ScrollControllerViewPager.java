package com.localworld.ishop.common.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;



public class ScrollControllerViewPager extends ViewPager {

    private boolean canScroll;

    public ScrollControllerViewPager(Context context) {
        this(context, null);
    }

    public ScrollControllerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCanScroll(boolean enable) {
        this.canScroll = enable;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!canScroll) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, false);
    }
}
