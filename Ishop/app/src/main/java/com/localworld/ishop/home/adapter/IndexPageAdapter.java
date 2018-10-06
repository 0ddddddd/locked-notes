package com.localworld.ishop.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.localworld.ishop.home.index.MainFragment2;


public class IndexPageAdapter extends FragmentPagerAdapter {
    private String[] mTitles;
    public IndexPageAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return MainFragment2.newInstance();
        } else {
            return MainFragment2.newInstance();
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
}
