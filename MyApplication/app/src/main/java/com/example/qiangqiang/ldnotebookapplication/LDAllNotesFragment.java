package com.example.qiangqiang.ldnotebookapplication;


import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;


/**
 * A simple {@link Fragment} subclass.
 */
public class LDAllNotesFragment extends Fragment implements AdapterView.OnItemClickListener,LoaderManager.LoaderCallbacks<Cursor> {

    private NoteDAO mNoteDAO;
    private ListView mLvNotes;
    private ShowNoteAdapter mAdapter;
    private Cursor mCursor;
    private Toolbar mToolbar;
    // private Toolbar mToolbar;
    private final static int CONTEXT_UPDATE_ORDER = 0;
    private final static int CONTEXT_DELETE_ORDER = 1;
    private View root;
    private boolean isSet = false;
    private SharedPreferences sp = null;
    private String pass = null;
    private EditText checkPass;

    public LDAllNotesFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNoteDAO = new NoteDAO(getActivity());
        // 查询所有行
        mCursor = mNoteDAO.queryNote(null, null);
        mToolbar = (Toolbar)getActivity().findViewById(R.id.id_toolbar);
        mToolbar.setTitle("All Notes");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 为碎片增加布局
        root = inflater.inflate(R.layout.fragment_ldall_notes, container, false);


        mLvNotes = (ListView) root.findViewById(R.id.id_listview_all_note);
        mAdapter = new ShowNoteAdapter(getActivity(), mCursor);
        //初始化loader
        getLoaderManager().initLoader(0, null, this);
        mLvNotes.setAdapter(mAdapter);
        mLvNotes.setOnItemClickListener(this);
        registerForContextMenu(mLvNotes);
        return root;
    }

    /**
     * 此时重启Loader机制更新数据
     */
    @Override
    public void onResume() {
        super.onResume();
        mCursor = mNoteDAO.queryNote(null, null);
        getLoaderManager().restartLoader(0, null, this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mCursor.close();
    }

    /**
     * 上下文菜单的回调函数
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //int position = mAdapter.getItem(info.position);
        int position = info.position; // list中的位置
        Cursor c = (Cursor) mAdapter.getItem(position); // CursorAdapter中getItem()返回特定的cursor对象
        int itemID = c.getInt(c.getColumnIndex("_id"));
        switch (item.getOrder()) {
            case CONTEXT_UPDATE_ORDER: // 更新操作
                //Toast.makeText(getActivity(),"UPDATE",Toast.LENGTH_SHORT).show();
                break;
            case CONTEXT_DELETE_ORDER: // 删除操作
                //Toast.makeText(getActivity(),"DELETE",Toast.LENGTH_SHORT).show();
                mNoteDAO.deleteNote("_id=?", new String[]{itemID + ""});
                // 使用新的Loader(清空旧的数据)
                getLoaderManager().restartLoader(0, null, this);
                break;
        }
        return super.onContextItemSelected(item);
    }

    /**
     * 创建上下文菜单
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Enter your choice:");
        menu.add(0, v.getId(), CONTEXT_UPDATE_ORDER, "UPDATE");
        menu.add(0, v.getId(), CONTEXT_DELETE_ORDER, "DELETE");
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri uri = Uri.parse("content://com.example.qiangqiang.ldnotebookapplication.provider");

        return new CursorLoader(getActivity(), uri, null, null, null, null);//创建loader对象，开始异步加载数据
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        //得到异步加载数据，更新adapter
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        //移除adapter使用的Loader，系统会释放不再使用的Loader
        mAdapter.swapCursor(null);
    }

    // 跳转到详情页
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Cursor c = (Cursor) mAdapter.getItem(position); // CursorAdapter中getItem()返回特定的cursor对象
        int itemID = c.getInt(c.getColumnIndex("_id"));
//        Log.v("LOG", "AllNoteFragment itemID: " + itemID);
        //CheckPass();
        Intent intent = new Intent(getActivity(), LDNoteDetailActivity.class);
        intent.putExtra(LDNoteDetailActivity.SENDED_NOTE_ID, itemID);
        startActivity(intent);
    }


}
