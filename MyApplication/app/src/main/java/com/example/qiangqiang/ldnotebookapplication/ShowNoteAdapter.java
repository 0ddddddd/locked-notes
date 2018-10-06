package com.example.qiangqiang.ldnotebookapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by qiangqiang on 2017/12/6.
 */

public class ShowNoteAdapter extends CursorAdapter {
    private Context context;
    private Cursor cursor;

    public ShowNoteAdapter(Context context,Cursor cursor){
        super(context,cursor);
        this.context = context;
        this.cursor = cursor;
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_note,null,false);
        ViewHolder holder = new ViewHolder();
        holder.mtextViewContent = (TextView)view.findViewById(R.id.id_textview_summary);
        holder.mtextViewTitle = (TextView)view.findViewById(R.id.id_textview_title);
        holder.mtextViewTime = (TextView)view.findViewById(R.id.id_textview_create_time);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder)view.getTag();
        String title = cursor.getString(cursor.getColumnIndex("title"));
        holder.mtextViewTitle.setText(title);
        holder.mtextViewContent.setText(TextFormatUtil.getNoteSummary(cursor.getString(cursor.getColumnIndex("content"))));
        holder.mtextViewTime.setText("creation:"+cursor.getString(cursor.getColumnIndex("create_time")));
    }

    final class ViewHolder{
        TextView mtextViewTitle;
        TextView mtextViewContent;
        TextView mtextViewTime;
    }
}
