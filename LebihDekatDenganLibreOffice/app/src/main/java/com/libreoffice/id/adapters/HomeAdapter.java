package com.libreoffice.id.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.libreoffice.id.fragments.BaseFragment;

import java.util.List;

/**
 * Created by rhony on 11/27/16.
 */

public class HomeAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragments;

    public HomeAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).fragmentTitle;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
