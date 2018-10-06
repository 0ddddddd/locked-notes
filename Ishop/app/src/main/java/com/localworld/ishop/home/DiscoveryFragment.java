package com.localworld.ishop.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.view.ScrollControllerViewPager;
import com.localworld.ishop.home.adapter.DiscoveryPageAdapter;

public class DiscoveryFragment extends BaseSupportFragment implements View.OnClickListener {
    private ScrollControllerViewPager contentViewPager;
    private TextView mTopIndexLeftTv, mTopIndexMiddleTv, mTopIndexRightTv;
//    private DiscoveryTopNavigatorAdapter navigatorAdapter;

    public static DiscoveryFragment newInstance() {
        Bundle args = new Bundle();
        DiscoveryFragment fragment = new DiscoveryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_discovery_index, container, false);
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
        contentViewPager = rootView.findViewById(R.id.vp_discovery_content);
        contentViewPager.setCanScroll(false);

        mTopIndexLeftTv = rootView.findViewById(R.id.tv_discovery_top_index_left);
        mTopIndexLeftTv.setOnClickListener(this);
        mTopIndexMiddleTv = rootView.findViewById(R.id.tv_discovery_top_index_middle);
        mTopIndexMiddleTv.setOnClickListener(this);
        mTopIndexRightTv = rootView.findViewById(R.id.tv_discovery_top_index_right);
        mTopIndexRightTv.setOnClickListener(this);


//        MagicIndicator magicIndicator = rootView.findViewById(R.id.indicator_discovery_top);
//        magicIndicator.setBackgroundColor(Color.WHITE);
//        CommonNavigator commonNavigator = new CommonNavigator(getContext());
//        commonNavigator.setAdjustMode(true);
//        navigatorAdapter = new DiscoveryTopNavigatorAdapter();
//        navigatorAdapter.setDisCategoryClickListener(this);
//        commonNavigator.setAdapter(navigatorAdapter);
//        magicIndicator.setNavigator(commonNavigator);
//        ViewPagerHelper.bind(magicIndicator, contentViewPager);
    }

    /**
     * 请求头部分类数据接口（顶部栏首页等等tab）
     */
    private void refreshTopView() {
        mTopIndexLeftTv.setSelected(false);
        mTopIndexMiddleTv.setSelected(true);
        mTopIndexRightTv.setSelected(false);
        contentViewPager.setCurrentItem(1);
//        navigatorAdapter.setCategoryList(DiscoveryMockUtils.getMockIndexCategoryList());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_discovery_top_index_left:
                handleTopClick(0);
                break;

            case R.id.tv_discovery_top_index_middle:
                handleTopClick(1);
                break;

            case R.id.tv_discovery_top_index_right:
                handleTopClick(2);
                break;
            default:
                handleTopClick(0);
                break;
        }
    }

    private void handleTopClick(int index) {
        if (index == 0) {
            mTopIndexLeftTv.setSelected(true);
            mTopIndexMiddleTv.setSelected(false);
            mTopIndexRightTv.setSelected(false);
            contentViewPager.setCurrentItem(0);
        } else if (index == 1) {
            mTopIndexLeftTv.setSelected(false);
            mTopIndexMiddleTv.setSelected(true);
            mTopIndexRightTv.setSelected(false);
            contentViewPager.setCurrentItem(1);
        } else if (index == 2) {
            mTopIndexLeftTv.setSelected(false);
            mTopIndexMiddleTv.setSelected(false);
            mTopIndexRightTv.setSelected(true);
            contentViewPager.setCurrentItem(2);
        }
    }

   @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        contentViewPager.setAdapter(new DiscoveryPageAdapter(getChildFragmentManager(), "特辑", "流行", "好友"));
        contentViewPager.setCurrentItem(1);
    }
}
