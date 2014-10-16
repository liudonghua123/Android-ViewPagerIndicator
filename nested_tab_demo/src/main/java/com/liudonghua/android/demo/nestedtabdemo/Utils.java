package com.liudonghua.android.demo.nestedtabdemo;

import android.content.Context;
import android.content.res.TypedArray;

/**
 * Created by liudonghua on 14/10/16.
 */
public class Utils {
    public static int[] getResourceIdArray(Context context, int arrayResourceId) {
        TypedArray typedArray = context.getResources().obtainTypedArray(arrayResourceId);
        int len = typedArray.length();
        int[] resIds = new int[len];
        for (int i = 0; i < len; i++) {
            resIds[i] = typedArray.getResourceId(i, -1);
        }
        typedArray.recycle();
        return resIds;
    }
}
