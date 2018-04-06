package com.example.qiangqiang.ldnotebookapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by qiangqiang on 2017/12/6.
 */

public class DBHelper extends SQLiteOpenHelper {
    public final static String DB_NAME = "notes";
    public final static int DB_VERSION = 1;
    public DBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table "+DB_NAME+"(_id integer primary key autoincrement"+
                ",title text,content text,create_time text,pwd text,isSet text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists"+DB_NAME);
    }
}
