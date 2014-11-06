package com.liudonghua.android.demo.nestedtabdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;

/**
 * Created by liudonghua on 14/10/16.
 */
public class MainPagerAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

    private String[] titles;
    private int[] icons;
    private String[] contents;

    public MainPagerAdapter(FragmentManager fm, String[] titles, int[] icons, String[] contents) {
        super(fm);
        this.titles = titles;
        this.icons = icons;
        this.contents = contents;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new SubOneFragment();
        }
        return SimpleContentFragment.newInstance(contents[position % contents.length]);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position % titles.length].toUpperCase();
    }

    @Override
    public int getIconResId(int index) {
        return icons[index];
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}