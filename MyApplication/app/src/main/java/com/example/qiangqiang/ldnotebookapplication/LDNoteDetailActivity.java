package com.example.qiangqiang.ldnotebookapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Date;

public class LDNoteDetailActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, View.OnClickListener{

    private String isSet ="no";
    public static final String SENDED_NOTE_ID = "note_id";
    private EditText mEtTitle;
    private EditText mEtContent;
    private Button mBtnModify;
    private Toolbar mToolbar;
    private NoteDAO mNoteDAO;
    private Cursor mCursor;
    private Note mNote;
    private int mNoteID = -1;
    private EditText setPass;
    private EditText confirmPass;
    private EditText checkPass;
    private SharedPreferences preferences;
    private SharedPreferences sp;
    private String pass;
    private String pwdStr = "", isSetStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ldnote_detail);
        //isSet = false;
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar_detail);
        mToolbar.setTitle("Node Detail");
        // 显示返回按钮
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // 监听Back键,必须放在设置back键后面
        mToolbar.setNavigationOnClickListener(this);
        initData();
        initView();
        CheckPass();
    }


    /**
     * 添加menu_clock
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    /**
     * 设置添加clock事件
     */
    public boolean onMenuItemClick(MenuItem item) {
        LayoutInflater factory = LayoutInflater.from(LDNoteDetailActivity.this);
        final View textEntry = factory.inflate(R.layout.ldsetpwd,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(LDNoteDetailActivity.this)
                .setTitle("set password")
                .setView(textEntry)
                .setPositiveButton("set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setPass = (EditText) textEntry.findViewById(R.id.set_pass);
                        confirmPass = (EditText) textEntry.findViewById(R.id.confirm_pass);
                        if (!confirmPass.getText().toString().trim().equals("") &&
                                confirmPass.getText().toString().trim().equals(setPass.getText().toString().trim())) {
                                ContentValues values = new ContentValues();
                                values.put("pwd", setPass.getText().toString());
                                values.put("isSet", "yes");
                                int rowID = -1;
                                 // 向数据库添加或者更新已有记录
                                if (mNoteID == -1) {
                                    rowID = (int) mNoteDAO.insertNote(values);
                                } else {
                                    rowID = mNoteDAO.updateNote(values, "_id=?", new String[]{mNoteID + ""});
                                }
                                if (rowID != -1) {
                                    Toast.makeText(LDNoteDetailActivity.this, "lock success", Toast.LENGTH_SHORT).show();
                                    getContentResolver().notifyChange(Uri.parse("content://com.example.qiangqiang.ldnotebook"), null);
                                    finish();
                            }
                        dialog.dismiss();
                        }
                        else {
                            Toast.makeText(LDNoteDetailActivity.this,"different password", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                });
                builder.create().show();
        return false;
    }


    private void CheckPass(){
        try{
            if (mNoteID != -1) {
                // 进行查询必须使用?匹配参数
                mCursor = mNoteDAO.queryNote("_id=?", new String[]{mNoteID + ""});
                if (mCursor.moveToNext()) {
                    isSetStr = mCursor.getString(mCursor.getColumnIndex("isSet"));
                    pwdStr = mCursor.getString(mCursor.getColumnIndex("pwd"));
                }
            }
            if (isSetStr.equals("yes")) {
                LayoutInflater factory=LayoutInflater.from(LDNoteDetailActivity.this);
                final View textEntry=factory.inflate(R.layout.ld_confirm_pwd, null);
                AlertDialog.Builder builder=new AlertDialog.Builder(this)
                        .setTitle("check pwd")
                        // .setIcon(getResources().getDrawable(android.R.drawable.ic_lock_lock))
                        .setView(textEntry)
                        .setCancelable(false)
                        .setPositiveButton("check", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                checkPass=(EditText)textEntry.findViewById(R.id.check_pass);
                                if (checkPass.getText().toString().trim().equals(pwdStr)) {
                                    try {
                                        Field field = dialog.getClass().getSuperclass().getDeclaredField("mShowing");
                                        field.setAccessible(true);
                                        field.set(dialog, true);        //dialog disapper
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    dialog.dismiss();
                                }
                                else {
                                    Intent intent = new Intent(LDNoteDetailActivity.this,MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(LDNoteDetailActivity.this, "wrong pwd", Toast.LENGTH_LONG).show();
                                    checkPass.setText("");
                                }
                            }
                        });
                builder.create().show();
            }
        } catch (Exception e) {
            Log.e("LDNoteDetailActivity", e.toString());
        }
//        try {
//            isSet = mNote.isSet();
//            if(isSet){
//                LayoutInflater factory = LayoutInflater.from(LDNoteDetailActivity.this);
//                final View textEntry = factory.inflate(R.layout.ld_confirm_pwd,null);
//                AlertDialog.Builder builder=new AlertDialog.Builder(LDNoteDetailActivity.this)
//                        .setTitle("check")
//                        .setView(textEntry)
//                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                checkPass=(EditText)textEntry.findViewById(R.id.check_pass);
//                                if (checkPass.getText().toString().trim().equals(mNote.getPwd())) {
//                                    try {
//                                        Field field = dialog.getClass().getSuperclass().getDeclaredField("mShowing");
//                                        field.setAccessible(true);
//                                        field.set(dialog, true);        //dialog disapper
//                                        Toast.makeText(LDNoteDetailActivity.this,"success", Toast.LENGTH_LONG).show();
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                    }
//                                    dialog.dismiss();
//                                }else{
//                                    Intent intent = new Intent(LDNoteDetailActivity.this,MainActivity.class);
//                                    startActivity(intent);
//                                    Toast.makeText(LDNoteDetailActivity.this, "wrong pwd", Toast.LENGTH_LONG).show();
//                                    //checkPass.setText("");
//                                }
//
//                            }
//                        })
//                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//
//                            public void onClick(DialogInterface dialog, int which) {
//                                // TODO Auto-generated method stub
//                                Intent intent = new Intent(LDNoteDetailActivity.this,MainActivity.class);
//                                startActivity(intent);
//                            }
//                        });
//                builder.create().show();
//
//            }
//
//        } catch (Exception e){
//            Log.e("LDNoteDetailActivity",e.toString());
//        }

    }





    private void initData() {
        Intent intent = getIntent();
        mNote = new Note("", "", TextFormatUtil.formatDate(new Date()));
        mNoteID = intent.getIntExtra(SENDED_NOTE_ID, -1);
        // 如果有ID参数,从数据库之中获取信息
        mNoteDAO = new NoteDAO(this);
        if (mNoteID != -1) {
            // 进行查询必须使用?匹配参数
            mCursor = mNoteDAO.queryNote("_id=?", new String[]{mNoteID + ""});
            if (mCursor.moveToNext()) {
                mNote.setTitle(mCursor.getString(mCursor.getColumnIndex("title")));
                mNote.setContent(mCursor.getString(mCursor.getColumnIndex("content")));
                mNote.setCreate_time(mCursor.getString(mCursor.getColumnIndex("create_time")));
            }
        }
    }

    protected void onResume() {
        super.onResume();

    }

    private void initView() {
        mEtTitle = (EditText) findViewById(R.id.id_edittext_title);
        mEtContent = (EditText) findViewById(R.id.id_edittext_content);
        mBtnModify = (Button) findViewById(R.id.id_btn_modify);
        mEtTitle.setText(mNote.getTitle());
        mEtContent.setText(mNote.getContent());
        mBtnModify.setOnClickListener(this);
    }

    protected void onPause() {
        super.onPause();
        if (mCursor != null) {
            mCursor.close();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.id_btn_modify) {
            String title = mEtTitle.getText().toString();
            String content = mEtContent.getText().toString();
            ContentValues values = new ContentValues();
            values.put("title", title);
            values.put("content", content);
            values.put("create_time", mNote.getCreate_time());
            int rowID = -1;
            // 向数据库添加或者更新已有记录
            if (mNoteID == -1) {
                rowID = (int) mNoteDAO.insertNote(values);
            } else {
                rowID = mNoteDAO.updateNote(values, "_id=?", new String[]{mNoteID + ""});
            }
            if (rowID != -1) {
                Toast.makeText(this, "修改或添加成功", Toast.LENGTH_SHORT).show();
                getContentResolver().notifyChange(Uri.parse("content://com.example.qiangqiang.ldnotebook"), null);
                finish();
            }
        } else {
            onBackPressed();
        }
    }
    }

