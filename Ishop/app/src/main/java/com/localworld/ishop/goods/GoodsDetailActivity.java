package com.localworld.ishop.goods;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.ISHOPBaseActivity;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.model.goods.Comment;
import com.localworld.ishop.model.goods.GoodsDetailModel;
import com.localworld.ishop.goods.adapter.GoodsContentAdapter;

import java.util.Arrays;
import java.util.List;



public class GoodsDetailActivity extends ISHOPBaseActivity {

    private ImageView favorImageView;  //加入收藏
    private ImageView customCareBtn;  //联系客服
    private Button addCartBtn;  //加入购物车按键

    private ImageView shareImageView;  //分享

    private Button showStoreBtn;  //详细介绍
    private TextView hiddenStoreTV;  //部分店铺介绍
    private TextView showStoreTV;    //完整店铺介绍

    private Button moreEvaBtn; //查看更多评价

    private ISImageView goodsHeadIv;
    private RelativeLayout relativeLayout;
    private ImageView backView;

    private RecyclerView recyclerView;
    private GoodsContentAdapter goodsContentAdapter;

    private boolean isCollected = false;  //判断是否收藏

    private String goodsId;

    private TextView mTitleTv;
    private TextView mPriceTv;
    private TextView mAuthorTv;
    private ISImageView mAuthorIv;
    private TextView mGoodsDescTv;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);

        initView();

        backView = findViewById(R.id.iv_goods_back);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //加入购物车
        addCartBtn = findViewById(R.id.btn_goods_add_to_cart);
        addCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GoodsDetailActivity.this, "成功加入购物车", Toast.LENGTH_SHORT).show();
            }
        });

        //加入收藏夹
        favorImageView = findViewById(R.id.iv_goods_favorite);
        favorImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isCollected) {
                    favorImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_favor_red));
                    Toast.makeText(GoodsDetailActivity.this, "成功加入收藏夹", Toast.LENGTH_SHORT).show();
                    isCollected = true;
                } else {
                    favorImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite));
                    Toast.makeText(GoodsDetailActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                    isCollected = false;
                }
            }
        });

        //联系客服
        customCareBtn = findViewById(R.id.iv_goods_custom_care);
        customCareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GoodsDetailActivity.this, "客服还没上班", Toast.LENGTH_SHORT).show();
            }
        });

        //分享
        shareImageView = findViewById(R.id.iv_goods_share);
        shareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShareDialog();
            }
        });


//        //查看更多评价
//        moreEvaBtn = findViewById(R.id.btn_goods_more_comment);
//        moreEvaBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(GoodsDetailActivity.this, "没有更多了", Toast.LENGTH_SHORT).show();
//            }
//        });

        requestData();
    }

    private void initView() {
        mAuthorIv = findViewById(R.id.iv_goods_author_head);
        mAuthorTv = findViewById(R.id.tv_goods_author_name);
        relativeLayout = findViewById(R.id.rl_goods);
        goodsHeadIv = findViewById(R.id.iv_goods_head_pic);
        mTitleTv = findViewById(R.id.tv_goods_name);
        mPriceTv = findViewById(R.id.tv_goods_price);
        mGoodsDescTv = findViewById(R.id.tv_goods_desc);

        recyclerView = findViewById(R.id.recycler_view_goods_image);
        goodsContentAdapter = new GoodsContentAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(goodsContentAdapter);
        recyclerView.setNestedScrollingEnabled(false);

    }

    private void showShareDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_goods_share, null);
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(view);
        dialog.show();

        //点击监听
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_goods_share:
                        break;
                }
                dialog.dismiss();
            }
        };

        //设置相关位置
        Window window = dialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.BOTTOM;
        window.setAttributes(params);
    }

    public void refreshMainData(GoodsDetailModel.GoodsBean bean) {
        mTitleTv.setText(bean.title);
        mPriceTv.setText(String.format("￥ %s", String.valueOf(bean.price)));
        //todo 处理头图
//        goodsHeadIv.showImage(bean.headPics);

        String contentPics = bean.contentPics;
        if (!TextUtils.isEmpty(contentPics)) {
            String[] pics = contentPics.split(",");
            if (pics.length > 0) {
                goodsHeadIv.showImage(pics[0]);
                goodsContentAdapter.setData(Arrays.asList(pics));
            }
        }
        mAuthorTv.setText("大师");
        mAuthorIv.setActualImageResource(R.drawable.ig_app_icon);
        if (TextUtils.isEmpty(bean.desc)) {
            mGoodsDescTv.setText("大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买");
        } else {
            mGoodsDescTv.setText(bean.desc);
        }

    }

    public void refreshGoodsComments(List<Comment> commentList) {
        goodsContentAdapter.setCommentData(commentList);
    }

    public void requestData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            goodsId = bundle.getString("id");
        }

        service.getGoodsDetail(goodsId).enqueue(new HdlRawCallback<GoodsDetailModel>() {
            @Override
            protected void onSuccess(GoodsDetailModel goodsDetailModel) {
                if (goodsDetailModel == null) {
                    return;
                }
                if (goodsDetailModel.goods != null) {
                    refreshMainData(goodsDetailModel.goods);
                }

                if (goodsDetailModel.goodsCommentList != null) {
                    refreshGoodsComments(goodsDetailModel.goodsCommentList);
                }
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
