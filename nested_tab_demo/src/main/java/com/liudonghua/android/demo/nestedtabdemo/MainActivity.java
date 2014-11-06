package com.liudonghua.android.demo.nestedtabdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titles = getApplicationContext().getResources().getStringArray(R.array.main_tab_texts);
        int[] icons = Utils.getResourceIdArray(this, R.array.main_tab_icons);
        String[] contents = getApplicationContext().getResources().getStringArray(R.array.main_tab_contents);
        FragmentPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), titles, icons, contents);

        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }

    public Fragment getFragment(int position) {
        String name = makeFragmentName(pager.getId(), position);
        return  getSupportFragmentManager().findFragmentByTag(name);
    }

    private static String makeFragmentName(int viewId, int index) {
        return "android:switcher:" + viewId + ":" + index;
    }

    class SimpleFragmentPagerAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

        private String[] CONTENT = new String[] { "Airplane", "Call", "Telephone", "Train" };
        private int[] ICONS = new int[] {
                R.drawable.ic_airplane,
                R.drawable.ic_call,
                R.drawable.ic_telephone,
                R.drawable.ic_train,
        };

        public SimpleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return new SubOneFragment();
            }
            if(position == 1) {
                return new SubTwoFragment();
            }
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
