package com.liudonghua.android.demo.nestedtabdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

public class SubOneFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sub_one_fragment_view, null);

        FragmentPagerAdapter adapter = new SubOneFragmentPagerAdapter(getFragmentManager());

        ViewPager pager = (ViewPager)rootView.findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (CustomTabPageIndicator)rootView.findViewById(R.id.indicator);
        indicator.setViewPager(pager);

        return rootView;
    }

    class SubOneFragmentPagerAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

        private String[] CONTENT = new String[] {  "Telephone", "Train", "Airplane", "Call", };
        private int[] ICONS = new int[] {
                R.drawable.ic_telephone,
                R.drawable.ic_train,
                R.drawable.ic_airplane,
                R.drawable.ic_call,
        };

        public SubOneFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return SimpleContentFragment.newInstance(CONTENT[position % CONTENT.length]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override
        public int getIconResId(int index) {
            return ICONS[index];
        }

        @Override
        public int getCount() {
            return CONTENT.length;
        }
    }
}
