package com.example.qiangqiang.ldnotebookapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by qiangqiang on 2017/12/6.
 */

public class NoteDAO {
    private DBHelper mHelper;
    private Context context;

    public NoteDAO(Context context){
        mHelper = new DBHelper(context);
    }

    public long insertNote(ContentValues contentValues){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        long id = db.insert(DBHelper.DB_NAME,null,contentValues);
        db.close();
        return id;
    }

    public int updateNote(ContentValues values,String whereUpdate,String[] whereArgs){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        int count;
        count = db.update(DBHelper.DB_NAME,values,whereUpdate,whereArgs);
        return count;
    }

    public int deleteNote(String whereDelete,String[] whereArgs){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        int count = db.delete(DBHelper.DB_NAME,whereDelete,whereArgs);
        return count;
    }

    public Cursor queryNote(String selection, String[] selectionArgs){
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.DB_NAME,null,selection,selectionArgs,null,null,null);
        return cursor;
    }
}
