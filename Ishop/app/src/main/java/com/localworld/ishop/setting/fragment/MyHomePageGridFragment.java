package com.localworld.ishop.setting.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.setting.adapter.MyHomePageGridAdapter;
import com.localworld.ishop.setting.bean.MyHomePageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @author chenmiyang
 * @since 2018-08-07 15:31
 */
public class MyHomePageGridFragment extends BaseSupportFragment {
    private List<MyHomePageBean> myHomePageBeanList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyHomePageGridAdapter adapter;

    public static MyHomePageGridFragment newInstance() {

        Bundle args = new Bundle();
        MyHomePageGridFragment fragment = new MyHomePageGridFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_myhomepage_grid,container,false);
        initView(view);
        return view;
    }


    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_setting_myhomepage_grid);
        adapter = new MyHomePageGridAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(),3,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //添加动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();
    }

    private void loadData() {
        myHomePageBeanList.clear();
        MyHomePageBean bean;
        for(int i=0;i<=9;i++){
            bean = new MyHomePageBean();
            bean.img = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            myHomePageBeanList.add(bean);
        }
        adapter.setmDataList(myHomePageBeanList);
        adapter.notifyDataSetChanged();
    }

    public List<MyHomePageBean> getGridShopList(){
        return myHomePageBeanList;
    }

    public void setGridMyHomePageBeanList(List<MyHomePageBean> beanList){
        myHomePageBeanList = beanList;
        adapter.setmDataList(myHomePageBeanList);
        adapter.notifyDataSetChanged();
    }

}