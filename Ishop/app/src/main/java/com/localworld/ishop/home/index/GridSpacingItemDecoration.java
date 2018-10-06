package com.localworld.ishop.home.index;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.localworld.ishop.home.bean.BaseHomeBean;


public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public  GridSpacingItemDecoration(){

    }

    public GridSpacingItemDecoration(int space){
        this.space=space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        int position=parent.getChildAdapterPosition(view);
        if (parent.getAdapter().getItemViewType(position)== BaseHomeBean.DOUBLE_ROW_GOODS_TYPE&&position==0){
            outRect.left=12;
            outRect.right=6;
        }
        else if(parent.getAdapter().getItemViewType(position)== BaseHomeBean.DOUBLE_ROW_GOODS_TYPE&&position==1){
            outRect.left=6;
            outRect.right=12;
        }

    }
}
