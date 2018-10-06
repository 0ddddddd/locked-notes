package com.localworld.ishop.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.view.ScrollControllerViewPager;
import com.localworld.ishop.home.adapter.IndexPageAdapter;
import com.localworld.ishop.home.adapter.IndexTopNavigatorAdapter;
import com.localworld.ishop.model.util.MockUtils;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;



public class IndexFragment extends BaseSupportFragment implements IndexTopNavigatorAdapter.IndexCategoryClickListener {
    private ScrollControllerViewPager contentViewPager;
    private IndexTopNavigatorAdapter navigatorAdapter;

    public static IndexFragment newInstance() {
        Bundle args = new Bundle();
        IndexFragment fragment = new IndexFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_index, container, false);
        initView(rootView);
        refreshTopView();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).showToolbar();
    }

    private void initView(View rootView) {
        contentViewPager = rootView.findViewById(R.id.vp_index_content);
        contentViewPager.setCanScroll(false);
        MagicIndicator magicIndicator = rootView.findViewById(R.id.indicator_index_top);
        magicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdjustMode(true);
        navigatorAdapter = new IndexTopNavigatorAdapter();
        navigatorAdapter.setCategoryClickListener(this);
        commonNavigator.setAdapter(navigatorAdapter);
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, contentViewPager);
    }

    /**
     * 请求头部分类数据接口（顶部栏首页等等tab）
     */
    private void refreshTopView() {
        navigatorAdapter.setCategoryList(MockUtils.getMockIndexCategoryList());
    }

    @Override
    public void onCategoryClick(int position) {
        contentViewPager.setCurrentItem(position);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        contentViewPager.setAdapter(new IndexPageAdapter(getChildFragmentManager(), "主题", "主页", "其他"));
        contentViewPager.setCurrentItem(1);
    }

}
