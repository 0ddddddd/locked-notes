package com.localworld.ishop.util;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;


public class AppUtil {

    public static class DensityUtil {
        /**
         * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
         */
        public static int dip2px(Context context, float dpValue) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        }

        /**
         * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
         */
        public static int px2dip(Context context, float pxValue) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (pxValue / scale + 0.5f);
        }

        public static int sp2px(Context context, float spValue) {
            final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
            return (int) (spValue * fontScale + 0.5f);
        }
    }

    public static <T> T JsonToObject(String json, Class<T> clazz) {
        if (!TextUtils.isEmpty(json) && clazz != null) {
            try {
                return JSON.parseObject(json, clazz);
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String ObjectToJsonString(Object object) {
        if (null != object) {
            try {
                return JSON.toJSONString(object);
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

}
