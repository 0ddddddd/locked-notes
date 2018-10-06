package com.localworld.ishop.route;

import android.text.TextUtils;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;


public class RouteUtils {

    public static String getRouteUrl(String path) {
        return getRouteUrl(RouteConstants.ROUTE_SCHEME_LOCAL_WORLD, RouteConstants.ROUTE_HOST_IPOLE, path, null);
    }

    public static String getRouteUrl(String path, Map<String, String> params) {
        return getRouteUrl(RouteConstants.ROUTE_SCHEME_LOCAL_WORLD, RouteConstants.ROUTE_HOST_IPOLE, path, params);
    }

    public static String getRouteUrl(String scheme, String host, String path, Map<String, String> params) {
        String url = scheme + "://" + host + "/" + path;
        if (params != null && params.size() > 0) {
            url += "?" + map2Pair(params);
        }
        return url;
    }

    public static String map2Pair(Map<String, String> maps) {
        if (maps == null || maps.size() == 0) {
            return null;
        }
        String result = "";

        Iterator<Map.Entry<String, String>> iterator = maps.entrySet().iterator();
        while (iterator.hasNext()) {
            if (!TextUtils.isEmpty(result)) {
                result += "&";
            }
            Map.Entry<String, String> entry = iterator.next();
            try {
                result += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
