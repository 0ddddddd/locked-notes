package com.example.qiangqiang.ldnotebookapplication;


import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LDSearchNoteFragment extends Fragment {

    private EditText medittextSearch;
    private ListView mlistviewResult;
    private Button mBtnQuery;
    private ShowNoteAdapter mAdapter;
    private NoteDAO mNoteDAO;
    private Cursor mCursor;
    private Toolbar mToolbar;
    private Menu menu;

    public LDSearchNoteFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNoteDAO = new NoteDAO(getActivity());
        mToolbar = (Toolbar)getActivity().findViewById(R.id.id_toolbar);
        mToolbar.setTitle("Search Note");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_ldsearch_note, container, false);


        medittextSearch = (EditText) root.findViewById(R.id.id_edittext_search_title);
        mlistviewResult = (ListView) root.findViewById(R.id.id_listview_found_note);
        mBtnQuery = (Button) root.findViewById(R.id.id_btn_search);
        //query
        mBtnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = medittextSearch.getText().toString();
                if (title.length() > 0 && title != null) {
                    mCursor = mNoteDAO.queryNote("title like ? ", new String[]{"%" + title + "%"});
                }
                if (!mCursor.moveToNext()) {
                    Toast.makeText(getActivity(), "没有这个结果", Toast.LENGTH_SHORT).show();
                }
                mAdapter = new ShowNoteAdapter(getActivity(), mCursor);
                mlistviewResult.setAdapter(mAdapter);
            }
        });
        mlistviewResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor c = (Cursor) mAdapter.getItem(position); // CursorAdapter中getItem()返回特定的cursor对象
                int itemID = c.getInt(c.getColumnIndex("_id"));
                Intent intent = new Intent(getActivity(), LDNoteDetailActivity.class);
                intent.putExtra(LDNoteDetailActivity.SENDED_NOTE_ID, itemID);
                startActivity(intent);
            }
        });
        return root;
    }

    public void onPause() {
        super.onPause();
        if (mCursor != null) {
            mCursor.close();
        }

    }
}
