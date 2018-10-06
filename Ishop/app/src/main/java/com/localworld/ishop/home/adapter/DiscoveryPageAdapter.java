package com.localworld.ishop.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.localworld.ishop.home.discovery.DiscoveryFriendsFragment;
import com.localworld.ishop.home.discovery.DiscoveryPopularityFragment;
import com.localworld.ishop.home.discovery.DiscoverySpecialFragment;


public class DiscoveryPageAdapter extends FragmentPagerAdapter {
    private String[] mTitles;
    public DiscoveryPageAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return DiscoveryPopularityFragment.newInstance();
        }
        else if (position == 2) {
            return DiscoveryFriendsFragment.newInstance();
        }
        else
//            return SampleFragment.newInstance();
            return DiscoverySpecialFragment.newInstance();
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
}

