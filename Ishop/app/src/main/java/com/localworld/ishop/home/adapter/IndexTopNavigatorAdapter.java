package com.localworld.ishop.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.localworld.ishop.model.home.HomeCategoryBean;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;



public class IndexTopNavigatorAdapter extends CommonNavigatorAdapter {

    private List<HomeCategoryBean> categoryList = new ArrayList<>();
    private IndexCategoryClickListener categoryClickListener;

    public void setCategoryList(List<HomeCategoryBean> list) {
        categoryList.clear();
        categoryList.addAll(list);
        notifyDataSetChanged();
    }

    public void setCategoryClickListener(IndexCategoryClickListener listener) {
        categoryClickListener = listener;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
        simplePagerTitleView.setNormalColor(Color.GRAY);
        simplePagerTitleView.setSelectedColor(Color.BLACK);
        simplePagerTitleView.setText(categoryList.get(index).name);
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (categoryClickListener != null) {
                    categoryClickListener.onCategoryClick(index);
                }
            }
        });
        return simplePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
        linePagerIndicator.setColors(Color.RED);
        return linePagerIndicator;
    }

    /**
     * 分类点击监听
     */
    public interface IndexCategoryClickListener {
        void onCategoryClick(int position);
    }
}
