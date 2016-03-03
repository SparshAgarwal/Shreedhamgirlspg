package com.sparsh.sparsh.shreedhamgirlspg.gallery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by spars on 20-12-2015.
 */
public class galleryhandler extends FragmentPagerAdapter {
    List<Fragment> listfragments;

    public galleryhandler(FragmentManager fm,List<Fragment> listfragments) {
        super(fm);
        this.listfragments=listfragments;

    }

    @Override
    public Fragment getItem(int position) {
        return listfragments.get(position);
    }

    @Override
    public int getCount() {
        return listfragments.size();
    }
}
