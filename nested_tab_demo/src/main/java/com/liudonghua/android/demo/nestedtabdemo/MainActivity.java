package com.liudonghua.android.demo.nestedtabdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titles = getApplicationContext().getResources().getStringArray(R.array.main_tab_texts);
        int[] icons = Utils.getResourceIdArray(this, R.array.main_tab_icons);
        String[] contents = getApplicationContext().getResources().getStringArray(R.array.main_tab_contents);
        FragmentPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), titles, icons, contents);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }

}
