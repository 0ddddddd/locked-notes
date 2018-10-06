package com.localworld.ishop.setting.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 文件描述
 *
 * @author chenmiyang
 * @since 2018-08-07 16:49
 */
public class MyHomePageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public MyHomePageAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
