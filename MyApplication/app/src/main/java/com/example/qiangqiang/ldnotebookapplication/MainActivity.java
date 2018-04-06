package com.example.qiangqiang.ldnotebookapplication;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,LDSettingFragment.FragmentInteraction{


    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    private FrameLayout mFlContent;
    private ListView mlvNavi;
    private DrawerLayout mDlLayout;
    private String BACK_GROUND;
    private LinearLayout linearLayout;

   // private Resources resources;
  //  private Drawable drawable;
   private RelativeLayout relativeLayout;

    private String[] mlabels = new String[]{
            "AllNotes","SearchByTitle","Setting"
    };
    private Fragment fragments[] = new Fragment[mlabels.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        relativeLayout = (RelativeLayout)findViewById(R.id.activity_main) ;



   //     Intent intent = getIntent();
//        BACK_GROUND = intent.getStringExtra("back");
//        if(BACK_GROUND.equals("first")){
//            relativeLayout.setBackgroundResource(R.drawable.background_main1);
//        } else if(BACK_GROUND.equals("second")){
//            relativeLayout.setBackgroundResource(R.drawable.background_main2);
//        }

        //set bacgground color
        //relativeLayout = (RelativeLayout)findViewById(R.id.activity_main) ;
       // relativeLayout.setBackgroundResource(R.drawable.background_main1);
       // relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorMain));

        fragments[0] = new LDAllNotesFragment();
        fragments[1] = new LDSearchNoteFragment();
        fragments[2] = new LDSettingFragment();
        initView();
        showFragment();
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LDNoteDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 设置添加事件
     */
//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        new AlertDialog.Builder(MainActivity.this)
//                .setTitle("Enter Password")
//                .setView(new EditText(MainActivity.this))
//                .setPositiveButton("确定", null)
//                .setNegativeButton("取消", null)
//                .show();
//        return false;
//    }

    /**
     * 切换到相应的Fragment
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        getFragmentManager().beginTransaction()
                .replace(R.id.id_framelayout_main, fragments[position]).commit();
        mDlLayout.closeDrawers();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mToolbar.setTitle("LDNoteBook");
        setSupportActionBar(mToolbar);
        //mToolbar.setOnMenuItemClickListener(this);
        mDlLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout_main);
        mFlContent = (FrameLayout) findViewById(R.id.id_framelayout_main);
        mlvNavi = (ListView) findViewById(R.id.id_listview_navi);
        NaviListAdapter adapter = new NaviListAdapter(this, Arrays.asList(mlabels));
        //open or close drawerlayout
        mToggle = new ActionBarDrawerToggle(
                this,                //host activity
                mDlLayout,          //drawerlayout object
                mToolbar,           //nav drawer image to replace 'Up' caret
                R.string.app_name,  //"open drawer" description for accessibility
                R.string.app_name); //"close drawer" description for accessibility
        mToggle.syncState();  //Sync the toggle state after onRestoreInstanceState has occurred
        mDlLayout.setDrawerListener(mToggle);
        mlvNavi.setAdapter(adapter);
        // 为每个ListItem添加点击事件,即启动相应的Fragment
        mlvNavi.setOnItemClickListener(this);
    }

    private void showFragment() {
        LDAllNotesFragment notesFragment = new LDAllNotesFragment();
        getFragmentManager().beginTransaction().replace(R.id.id_framelayout_main, notesFragment).commit();
    }

    /**
     * 添加菜单
     */
    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    // 3.2 +实现接口，实现回调
    public void process(String theme){
        relativeLayout = (RelativeLayout)findViewById(R.id.activity_main);

        switch (theme){
            case "one":
                relativeLayout.setBackgroundResource(R.drawable.background_main1);
                mToolbar.setBackgroundColor(getResources().getColor(R.color.theme_color1));
                break;
            case "two":
                relativeLayout.setBackgroundResource(R.drawable.background_main2);
                mToolbar.setBackgroundColor(getResources().getColor(R.color.theme_color2));
                break;
            case "three":
                relativeLayout.setBackgroundResource(R.drawable.background_main3);
                mToolbar.setBackgroundColor(getResources().getColor(R.color.theme_color3));
                break;
            case "four":
                relativeLayout.setBackgroundResource(R.drawable.background_main4);
                mToolbar.setBackgroundColor(getResources().getColor(R.color.theme_color4));
                break;
        }


    }

}
