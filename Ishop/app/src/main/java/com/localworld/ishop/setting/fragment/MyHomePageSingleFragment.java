package com.localworld.ishop.setting.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.setting.adapter.MyHomePageSingleAdapter;
import com.localworld.ishop.setting.bean.MyHomePageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 个人主页单列布局
 *
 * @author chenmiyang
 * @since 2018-08-07 15:31
 */
public class MyHomePageSingleFragment extends BaseSupportFragment {
    private List<MyHomePageBean> myHomePageBeanList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyHomePageSingleAdapter adapter;

    public static MyHomePageSingleFragment newInstance() {

        Bundle args = new Bundle();

        MyHomePageSingleFragment fragment = new MyHomePageSingleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_myhomepage_single,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_setting_myhomepage_single);
        adapter = new MyHomePageSingleAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        loadData();
    }

    private void loadData() {
        myHomePageBeanList.clear();
        MyHomePageBean bean;
        for (int i = 0; i <= 9; i++) {
            bean = new MyHomePageBean();
            bean.img = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            myHomePageBeanList.add(bean);
        }
        adapter.setmDataList(myHomePageBeanList);
        adapter.notifyDataSetChanged();
    }

    public List<MyHomePageBean> getSingleShopList(){
        return myHomePageBeanList;
    }
    public void setSingleMyHomePageBeanList(List<MyHomePageBean> beanList){
        myHomePageBeanList=(beanList);
        adapter.setmDataList(myHomePageBeanList);
        adapter.notifyDataSetChanged();
    }
}
