package com.localworld.ishop.shop;


import android.os.Bundle;


import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportActivity;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.common.view.NestedRecyclerView;
import com.localworld.ishop.common.view.ScrollControllerViewPager;
import com.localworld.ishop.shop.adapter.ShopGoodsAdapter;
import com.localworld.ishop.shop.adapter.ShopUserRecommendAdapter;
import com.localworld.ishop.shop.bean.AuthorData;
import com.localworld.ishop.shop.bean.ShopRecommendUserBean;
import com.localworld.ishop.shop.util.RecommendUserUtilMock;

import java.util.ArrayList;
import java.util.List;


public class ShopDetailsActivity extends BaseSupportActivity implements  View.OnClickListener {
    private ScrollControllerViewPager myviewpager;

    private NestedRecyclerView surrecyclerView;
    private ShopUserRecommendAdapter suradapter;
    private List<ShopRecommendUserBean> surList = new ArrayList<>();

    private List<Fragment> list;
    //选项卡中的按钮
    private LinearLayout btn_first,btn_second,btn_third;
    private TextView table1,table2,table3;
    private ShopGoodsAdapter adapter;
    boolean temp = true;

    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);
    private int authorId;

    private TextView followTextView,followfinishTextView,authorname,authorifollow,authorfollowme,authorproduce;
    private Button shopmoreButton,userfollowButton,msButton,suButton;
    private LinearLayout backButton,lyshopmore;
    private ISImageView authorheadimage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        backButton = (LinearLayout) findViewById(R.id.btn_shop_back);
        lyshopmore = (LinearLayout)findViewById(R.id.layout_shop_more);
        shopmoreButton = (Button)findViewById(R.id.btn_shop_more);
        userfollowButton = (Button)findViewById(R.id.btn_shop_user_follow);
        msButton = (Button)findViewById(R.id.btn_message_shop);
        suButton = (Button)findViewById(R.id.btn_shop_user_follow);
        followTextView = (TextView) findViewById(R.id.btn_shop_follow);
        followfinishTextView = (TextView)findViewById(R.id.btn_shop_followfinish);
        authorname = (TextView)findViewById(R.id.author_name);
        authorfollowme = (TextView)findViewById(R.id.author_followme);
        authorifollow = (TextView)findViewById(R.id.author_ifollow);
        authorproduce = (TextView)findViewById(R.id.author_produce);
        authorheadimage = (ISImageView)findViewById(R.id.author_head_image);


        surrecyclerView = (NestedRecyclerView)findViewById(R.id.rcv_shopuser_recommend);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        surrecyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        suradapter = new ShopUserRecommendAdapter(surList);
        surrecyclerView.setAdapter(suradapter);

        initView();
        initOnclick();


        btn_first.setOnClickListener(this);
        btn_second.setOnClickListener(this);
        btn_third.setOnClickListener(this);
        myviewpager.setOnPageChangeListener(new MyPagerChangeListener());

        list = new ArrayList<>();
        list.add(new ShopGoods1Fragment());
        list.add(new ShopGoods2Fragment());
        list.add(new ShopGoods3Fragment());
        adapter = new ShopGoodsAdapter(getSupportFragmentManager(), list);
        myviewpager.setAdapter(adapter);
        myviewpager.setCurrentItem(0);  //初始化显示第一个页面
        table1.setBackgroundResource(R.drawable.icon_98);

        initDatas();
        requestData();
    }



    public void initView(){

        btn_first = (LinearLayout)findViewById(R.id.btn_first);
        btn_second = (LinearLayout)findViewById(R.id.btn_second);
        btn_third = (LinearLayout)findViewById(R.id.btn_third);
        table1 = (TextView)findViewById(R.id.shop_detail_table1);
        table2 = (TextView)findViewById(R.id.shop_detail_table2);
        table3 = (TextView)findViewById(R.id.shop_detail_table3);

        myviewpager = (ScrollControllerViewPager) findViewById(R.id.vp_shopdetail_content);

    }
    public void initOnclick(){
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        followTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                followTextView.setVisibility(View.GONE);
                followfinishTextView.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        followfinishTextView.performClick();
                    }
                }, 1000);
            }

        });
        followfinishTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                followfinishTextView.setVisibility(View.GONE);
                msButton.setVisibility(View.VISIBLE);
                suButton.setVisibility(View.VISIBLE);
                lyshopmore.setVisibility(View.VISIBLE);
                temp = false;
            }
        });

        shopmoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(temp){
                    lyshopmore.setVisibility(View.VISIBLE);
                    temp = false;}
                else{
                    lyshopmore.setVisibility(View.GONE);
                    temp = true;}
            }
        });
        userfollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ShopUserBottomMenu menu=new ShopUserBottomMenu(ShopDetailsActivity.this);
                menu.show();
                menu.button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        msButton.setVisibility(View.GONE);
                        suButton.setVisibility(View.GONE);
                        lyshopmore.setVisibility(View.GONE);
                        followTextView.setVisibility(View.VISIBLE);
                        temp = true;
                        menu.buttonCancel.performClick();
                    }
                });
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_first:
                myviewpager.setCurrentItem(0);
                table1.setBackgroundResource(R.drawable.icon_98);
                table2.setBackgroundResource(R.drawable.icon_77_2);
                table3.setBackgroundResource(R.drawable.icon_69);
                break;
            case R.id.btn_second:
                myviewpager.setCurrentItem(1);
                table1.setBackgroundResource(R.drawable.icon_80_2);
                table2.setBackgroundResource(R.drawable.icon_95);
                table3.setBackgroundResource(R.drawable.icon_69);
                break;
            case R.id.btn_third:
                myviewpager.setCurrentItem(2);
                table1.setBackgroundResource(R.drawable.icon_80_2);
                table2.setBackgroundResource(R.drawable.icon_77_2);
                table3.setBackgroundResource(R.drawable.icon_92);
                break;
        }


    }
    public class MyPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            switch (arg0) {
                case 0:
                    table1.setBackgroundResource(R.drawable.icon_98);
                    table2.setBackgroundResource(R.drawable.icon_77_2);
                    table3.setBackgroundResource(R.drawable.icon_69);
                    break;
                case 1:
                    table1.setBackgroundResource(R.drawable.icon_80_2);
                    table2.setBackgroundResource(R.drawable.icon_95);
                    table3.setBackgroundResource(R.drawable.icon_69);
                    break;
                case 2:
                    table1.setBackgroundResource(R.drawable.icon_80_2);
                    table2.setBackgroundResource(R.drawable.icon_77_2);
                    table3.setBackgroundResource(R.drawable.icon_92);
                    break;
            }
        }
    }

    private void initDatas() {
        List<ShopRecommendUserBean> data = RecommendUserUtilMock.getList();
        suradapter.setDataList(data);
        suradapter.notifyDataSetChanged();

    }

    private void refreshAuthorData(AuthorData bean){

        authorheadimage.showImage(bean.headPic);
        authorproduce.setText(bean.productNum);
        authorifollow.setText(bean.iFollowNum);
        authorfollowme.setText(bean.followMeNum);
        authorname.setText(bean.name);

    }

    private void requestData(){

//        authorId = 15;
        service.getAuthorDataDetail(15).enqueue(new HdlRawCallback<List<AuthorData>>() {
            @Override
            protected void onSuccess(List<AuthorData> authorData) {
                AuthorData list = (AuthorData) authorData;
                refreshAuthorData(list);
            }

            @Override
            protected void onFailed(String msg, int status) {
                String toastString;
                if (TextUtils.isEmpty(msg)) {
                    toastString = "网络似乎有点问题！";
                } else {
                    toastString = msg;
                }
                Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_SHORT).show();
            }
        });
    }

}




