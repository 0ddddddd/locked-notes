package com.localworld.ishop.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.adapter.MainDiscountAdapter;
import com.localworld.ishop.setting.adapter.NewSettingMockUtils;
import com.localworld.ishop.setting.bean.MainDiscountBean;
import com.localworld.ishop.setting.bean.SettingFriendsBean;
import com.localworld.ishop.setting.bean.SettingIndexBean;
import com.localworld.ishop.setting.bean.SettingMottoBean;
import com.localworld.ishop.setting.bean.SettingTransitBean;
import com.localworld.ishop.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

public class SettingMainActivity extends AppCompatActivity {
    private MainDiscountAdapter adapter;
    private LinearLayout mLayoutTransitInfor;
    private RecyclerView mDiscount;
    private ISImageView headPic;
    private TextView userName;
    private TextView followNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_main);
        //设置RecyclerView的布局方式为LinearLayout,排列方向为垂直
        RecyclerView mRecy = (RecyclerView) findViewById(R.id.recycler_setting_discount);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecy.setLayoutManager(linearLayoutManager);
        adapter = new MainDiscountAdapter();
        mRecy.setAdapter(adapter);
        loadData();
        initIndexInfo();
        initMotto();
        initOrder();
        initTransit();
        initDiscount();
        initFriends();
        initCreditBtn();
  //      initItemState();
    }

    private void initIndexInfo(){

        SettingIndexBean bean = NewSettingMockUtils.getIndexData();

        userName = findViewById(R.id.tv_setting_username);
        TextView collectionNum;
        LinearLayout collection;
        TextView trackNum ;
        LinearLayout track;
        LinearLayout follow;
        Button personInfoBtn;
        ImageView settingBtn;

        headPic = findViewById(R.id.iv_setting_headpic);
        headPic.showImage(bean.headPic);

        collectionNum = findViewById(R.id.tv_setting_collectionnum);
        collectionNum.setText(bean.collectionNum);

        collection = findViewById(R.id.layout_setting_collection);
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent();
                startActivity(intent);*/
            }
        });

        trackNum = findViewById(R.id.tv_setting_tracknum);
        trackNum.setText(bean.trackNum);

        track = findViewById(R.id.layout_setting_track);
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"该功能暂未开放！",Toast.LENGTH_LONG);
            }
        });
        followNum = findViewById(R.id.tv_setting_follownum);
        followNum.setText(bean.followNum);

        follow = findViewById(R.id.layout_setting_follow);
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingMainActivity.this,FollowActivity.class);
                startActivity(intent);
            }
        });

        personInfoBtn = findViewById(R.id.btn_setting_personinfo);
        personInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingMainActivity.this,PersonInfoActivity.class);
                startActivity(intent);
            }
        });

        settingBtn = findViewById(R.id.iv_setting_setting);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingMainActivity.this,SettingBtnActivity.class);
                startActivity(intent);
            }
        });

        headPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingMainActivity.this,MainMyHomePageActivity.class);
                intent.putExtra("headPic",headPic.toString());
                intent.putExtra("userName",userName.getText());
                intent.putExtra("followNum",followNum.getText());
                startActivity(intent);
            }
        });
    }

    private void initFriends() {
        SettingFriendsBean bean = new SettingFriendsBean();
        bean.friendsName = "朱一龙";
        bean.friendsPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";

        TextView mOpenAll;
        ISImageView friendsPic1;
        ISImageView friendsPic2;
        ISImageView friendsPic3;
        ISImageView friendsPic4;
        TextView friengsName1;
        TextView friengsName2;
        TextView friengsName3;
        TextView friengsName4;
        Button callBtn1;
        Button callBtn2;
        Button callBtn3;
        Button callBtn4;
        mOpenAll = findViewById(R.id.tv_setting_openall);
        friendsPic1 = findViewById(R.id.iv_setting_friendspic1);
        friendsPic2 = findViewById(R.id.iv_setting_friendspic2);
        friendsPic3 = findViewById(R.id.iv_setting_friendspic3);
        friendsPic4 = findViewById(R.id.iv_setting_friendspic4);

        friengsName1 = findViewById(R.id.tv_setting_friendsname1);
        friengsName2 = findViewById(R.id.tv_setting_friendsname2);
        friengsName3 = findViewById(R.id.tv_setting_friendsname3);
        friengsName4 = findViewById(R.id.tv_setting_friendsname4);

        callBtn1 = findViewById(R.id.btn_setting_call1);
        callBtn2 = findViewById(R.id.btn_setting_call2);
        callBtn3 = findViewById(R.id.btn_setting_call3);
        callBtn4 = findViewById(R.id.btn_setting_call4);
        mOpenAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //展开所有朋友列表
                Intent intent = new Intent(view.getContext(), OpenAllFriendsActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        friendsPic1.showImage(bean.friendsPic);
        friendsPic2.showImage(bean.friendsPic);
        friendsPic3.showImage(bean.friendsPic);
        friendsPic4.showImage(bean.friendsPic);

        friengsName1.setText(bean.friendsName);
        friengsName2.setText(bean.friendsName);
        friengsName3.setText(bean.friendsName);
        friengsName4.setText(bean.friendsName);
    }

    private void initDiscount() {
        MainDiscountBean bean = new MainDiscountBean();
        bean.points = "250";
        TextView mPoints;
        TextView mOpen;
        ImageView mImageP;
        userName = findViewById(R.id.tv_setting_username);
        mPoints = (TextView)findViewById(R.id.tv_setting_points);
        mOpen = findViewById(R.id.tv_setting_open);
        mImageP = findViewById(R.id.iv_setting_discount_imagep);
        mPoints.setText(bean.points);
        mDiscount = findViewById(R.id.recycler_setting_discount);
        mOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDiscount.getVisibility()==View.GONE){
                    mDiscount.setVisibility(View.VISIBLE);
                }else{
                    mDiscount.setVisibility(View.GONE);
                }
            }
        });
        mImageP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingMainActivity.this, VipActivity.class);
                intent.putExtra("vipName",userName.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void initTransit() {
        SettingTransitBean bean = new SettingTransitBean();
        bean.goodsPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        bean.startPlace = "天津";
        bean.transitTime = "3";
        bean.endPlace = "上海";

        ImageView mImageTransit;
        LinearLayout mUnDeliver;
        LinearLayout mDelivered;
        LinearLayout mGet;
        ISImageView mGoodPic;
        TextView mStartPlace;
        TextView mTransitTime;
        TextView mEndPlace;

        mImageTransit = findViewById(R.id.iv_setting_transit);
        mUnDeliver = findViewById(R.id.layout_setting_transit_undeliver);
        mDelivered = findViewById(R.id.layout_setting_transit_delivered);
        mGet = findViewById(R.id.layout_setting_transit_get);
        mLayoutTransitInfor = findViewById(R.id.layout_setting_transitinfor);
        mGoodPic = findViewById(R.id.iv_setting_transit_goodpic);
        mStartPlace = findViewById(R.id.tv_setting_startplace);
        mTransitTime = findViewById(R.id.tv_setting_transittime);
        mEndPlace = findViewById(R.id.tv_setting_endplace);

        mGoodPic.showImage(bean.goodsPic);
        mStartPlace.setText(bean.startPlace);
        mTransitTime.setText(bean.transitTime);
        mEndPlace.setText(bean.endPlace);
        mUnDeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),UnDeliverActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        mDelivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DeliveredActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        mGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),GetGoodsActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        mImageTransit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mLayoutTransitInfor.getVisibility() == view.GONE) {
                    mLayoutTransitInfor.setVisibility(view.VISIBLE);
                }else{
                    mLayoutTransitInfor.setVisibility(view.GONE);
                }
            }
        });
    }

    private void initOrder() {
     //   getItemState();
        LinearLayout mLayoutUnpay = (LinearLayout)findViewById(R.id.layout_setting_unpay);
        LinearLayout mLayoutPaid = (LinearLayout)findViewById(R.id.layout_setting_paid);
        //待支付
        mLayoutUnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingMainActivity.this, UnpayActivity.class);
                startActivity(intent);
            }
        });
        //已支付
        mLayoutPaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*主界面跳转到已支付界面*/
                Intent intent = new Intent(SettingMainActivity.this, PaidActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initMotto() {
        SettingMottoBean bean = new SettingMottoBean();
        bean.userName = "泼猴哪里走";
        bean.userMotto="lallaalalalalllllllllllllllllllllllllllllllllllllaallaaalalalaallaal";
        TextView mUserName = (TextView)findViewById(R.id.tv_setting_username);
        TextView mUserMotto = (TextView)findViewById(R.id.tv_setting_usermotto);
        mUserName.setText(bean.userName);
        mUserMotto.setText(bean.userMotto);
    }

    private void initItemState() {
        SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil();
        sharedPreferencesUtil.putBoolean(this,"setting","order",true);
    }

    private void getItemState(){
      /*  Intent intent = getIntent();
        List<SharedPreferencesUtil> utilList = (List<SharedPreferencesUtil>)intent.getSerializableExtra("sharedList");
        */

    }
    private void initCreditBtn() {
        Button mCreditBtn = findViewById(R.id.btn_setting_creditbtn);
        mCreditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingMainActivity.this, CreditItemActivity.class);
                //设置requestCode为1001
                startActivityForResult(intent,1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        List<SharedPreferencesUtil> utilList = (ArrayList<SharedPreferencesUtil>)data.getSerializableExtra("sharedList");
        LinearLayout order = findViewById(R.id.layout_setting_main_order);
        LinearLayout transit = findViewById(R.id.layout_setting_main_transit);
        LinearLayout discount = findViewById(R.id.layout_setting_main_discount);
        LinearLayout friends = findViewById(R.id.layout_setting_main_friends);

        if(utilList.size() != 0) {
            for (int i = 0; i < utilList.size(); i++) {
                if (!utilList.get(i).getBoolean(SettingMainActivity.this, "setting", "order", true)) {
                    order.setVisibility(View.GONE);
                }else if(utilList.get(i).getBoolean(SettingMainActivity.this, "setting", "order",true)){
                    order.setVisibility(View.VISIBLE);
                }if (!utilList.get(i).getBoolean(SettingMainActivity.this, "setting", "transit", true)) {
                    transit.setVisibility(View.GONE);
                }else if(utilList.get(i).getBoolean(SettingMainActivity.this, "setting", "transit",true)){
                    transit.setVisibility(View.VISIBLE);
                }if (!utilList.get(i).getBoolean(SettingMainActivity.this, "setting", "discount", true)) {
                    discount.setVisibility(View.GONE);
                }else if(utilList.get(i).getBoolean(SettingMainActivity.this, "setting", "discount",true)){
                    discount.setVisibility(View.VISIBLE);
                }if (!utilList.get(i).getBoolean(SettingMainActivity.this, "setting", "friends", true)) {
                    friends.setVisibility(View.GONE);
                }else if(utilList.get(i).getBoolean(SettingMainActivity.this, "setting", "friends",true)){
                    friends.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    private void loadData() {
        List<MainDiscountBean> data = NewSettingMockUtils.getDiscountBeanList();
        adapter.setDiscountBeanList(data);
        adapter.notifyDataSetChanged();
    }
}
