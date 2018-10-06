package com.localworld.ishop.common.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewConfiguration;


public class NestedRecyclerView extends RecyclerView {

    private int touchSlop;
    private Context mContext;
    private int INVALID_POINTER = -1;
    private int scrollPointerId = INVALID_POINTER;

    private int initialTouchX;
    private int initialTouchY;


    public NestedRecyclerView(Context context) {
        super(context);
        init(context);
    }

    public NestedRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NestedRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public void init(Context context) {
        ViewConfiguration vc = ViewConfiguration.get(context);
        touchSlop = vc.getScaledEdgeSlop();
        mContext = context;
    }

//    @Override
//    public void setScrollingTouchSlop(int slopConstant) {
//        super.setScrollingTouchSlop(slopConstant);
//        ViewConfiguration vc = ViewConfiguration.get(mContext);
//        switch (slopConstant) {
//            case TOUCH_SLOP_DEFAULT:
//                touchSlop = vc.getScaledTouchSlop();
//                break;
//            case TOUCH_SLOP_PAGING:
//                touchSlop = vc.getScaledPagingTouchSlop();
//                break;
//            default:
//                break;
//        }
//    }
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent e) {
//
//        if (e == null) {
//            return false;
//        }
//        int action = MotionEventCompat.getActionMasked(e);
//        int actionIndex = MotionEventCompat.getActionIndex(e);
//
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                scrollPointerId = MotionEventCompat.getPointerId(e, 0);
//                initialTouchX = Math.round(e.getX() + 0.5f);
//                initialTouchY = Math.round(e.getY() + 0.5f);
//
//                return super.onInterceptTouchEvent(e);
//
//            case MotionEvent.ACTION_POINTER_DOWN:
//
//                scrollPointerId = MotionEventCompat.getPointerId(e, actionIndex);
//                initialTouchX = Math.round(MotionEventCompat.getX(e, actionIndex) + 0.5f);
//                initialTouchY = Math.round(MotionEventCompat.getY(e, actionIndex) + 0.5f);
//
//                return super.onInterceptTouchEvent(e);
//            case MotionEvent.ACTION_MOVE:
//                final int index = e.findPointerIndex(scrollPointerId);
//
//
//                if (index < 0) {
//                    return false;
//                }
//
//                int x = Math.round(MotionEventCompat.getX(e, index) + 0.5f);
//                int y = Math.round(MotionEventCompat.getY(e, index) + 0.5f);
//
//                if (getScrollState() != SCROLL_STATE_DRAGGING) {
//
//                    int dx = x - initialTouchX;
//
//                    int dy = y - initialTouchY;
//                    boolean startScroll = false;
//                    if ((getLayoutManager().canScrollHorizontally() && Math.abs(dx) > touchSlop) && (getLayoutManager().canScrollVertically() || Math.abs(dx) > Math.abs((dy)))) {
//                        startScroll = true;
//                    }
//
//                    if ((getLayoutManager().canScrollHorizontally() && Math.abs(dy) > touchSlop) && (getLayoutManager().canScrollHorizontally() || Math.abs(dy) > Math.abs((dx)))) {
//
//                        startScroll = true;
//
//                    }
//                    return startScroll && super.onInterceptTouchEvent(e);
//                }
//                return super.onInterceptTouchEvent(e);
//            default:
//                return super.onInterceptTouchEvent(e);
//        }
//    }
}
