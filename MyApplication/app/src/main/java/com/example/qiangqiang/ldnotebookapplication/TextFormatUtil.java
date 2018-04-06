package com.example.qiangqiang.ldnotebookapplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qiangqiang on 2017/12/6.
 */

public class TextFormatUtil {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date){
        return dateFormat.format(date);
    }

    public static Date parseText(String text) throws ParseException {
        return dateFormat.parse(text);
    }

    public static String getNoteSummary(String content){
        if(content.length() > 10){
            StringBuilder stringBuilder = new StringBuilder(content.substring(0,10));
            stringBuilder.append("...");
            return stringBuilder.toString();
        }
        return content;
    }
}
