package com.liudonghua.android.demo.nestedtabdemo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viewpagerindicator.TabPageIndicator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * Created by Liu.D.H on 2014-10-16.
 */
public class CustomTabPageIndicator extends TabPageIndicator {
    Activity mContext;
    public CustomTabPageIndicator(Context context) {
        super(context);
    }

    public CustomTabPageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = (Activity)context;
    }

    @Override
    protected void addTab(int index, CharSequence text, int iconResId) {
        View tabView = mContext.getLayoutInflater().inflate(R.layout.icon_text_tab_view, null);
        TextView textView = (TextView)tabView.findViewById(R.id.icon_text_tab_view_text);
        ImageView image = (ImageView) tabView.findViewById(R.id.icon_text_tab_view_image);
        textView.setText(text);
        image.setImageResource(iconResId);
        ((ViewGroup)mTabLayout).addView(tabView, new LinearLayout.LayoutParams(0, MATCH_PARENT, 1));
        // 使用反射调用
//        Method method = null;
//        try {
//            method = ((Object)mTabLayout).getClass().getMethod("addView", View.class, LayoutParams.class);
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        try {
//            method.invoke(mTabLayout, tabView, new LinearLayout.LayoutParams(0, MATCH_PARENT, 1));
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

    }
}
