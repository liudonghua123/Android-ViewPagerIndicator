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

        String[] titles = getActivity().getResources().getStringArray(R.array.sub_one_texts);
        int[] icons = Utils.getResourceIdArray(getActivity(), R.array.sub_one_icons);
        String[] contents = getActivity().getResources().getStringArray(R.array.sub_one_contents);
        FragmentPagerAdapter adapter = new SubOneFragmentPagerAdapter(getChildFragmentManager(), titles, icons, contents);

        ViewPager pager = (ViewPager)rootView.findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)rootView.findViewById(R.id.indicator);
        indicator.setViewPager(pager);

        return rootView;
    }

}
