package com.localworld.ishop.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;
import java.util.Map;


public class SharedPreferencesUtil implements Serializable{
    /**
     * 保存键值对
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      key
     * @param value    value
     */
    public static void put(Context context, String fileName, String key,
                           String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }


    /**
     * 获取键对应的值
     *
     * @param context      上下文
     * @param fileName     文件名
     * @param key          key
     * @param defaultValue 默认值，无对应value时返回
     * @return value
     */
    public static String get(Context context, String fileName, String key,
                             String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key, defaultValue);// 第二个参数为默认值

        return value;
    }

    /**
     * 保存键值对(boolean)
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      key
     * @param value    value
     */
    public static void putBoolean(Context context, String fileName, String key,
                           boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }


    /**
     * 获取键对应的值(boolean)
     *
     * @param context      上下文
     * @param fileName     文件名
     * @param key          key
     * @param defaultValue 默认值，无对应value时返回
     * @return value
     */
    public boolean getBoolean(Context context, String fileName, String key,
                             boolean defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);
        boolean value = sharedPreferences.getBoolean(key, defaultValue);// 第二个参数为默认值

        return value;
    }


    /**
     * 获取键对应的值，找不到则返回""
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      key
     * @return value
     */
    public static String get(Context context, String fileName, String key) {
        return get(context, fileName, key, "");
    }


    /**
     * 移除key对应的项
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      key
     */
    public static void remove(Context context, String fileName, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }


    /**
     * 清除所有数据
     *
     * @param context  上下文
     * @param fileName 文件名
     */
    public static void clear(Context context, String fileName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


    /**
     * 查询某个key对应的项是否存在
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      key
     * @return 是否存在
     */
    public static boolean contatins(Context context, String fileName, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }


    /**
     * 返回所有键值对
     *
     * @param context  上下文
     * @param fileName 文件名
     * @return Map组成的键值对
     */
    public static Map<String, ?> getAll(Context context, String fileName) {
        SharedPreferences sp = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return sp.getAll();
    }

}
