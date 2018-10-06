package com.localworld.ishop.setting.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

public class FollowPageAdapter extends FragmentPagerAdapter {
    private FragmentManager fragmentManager;
    private List<Fragment> mList;

    public FollowPageAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.fragmentManager = fm;
        this.mList = list;
    }


    @Override
    public Fragment getItem(int position) {

        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
