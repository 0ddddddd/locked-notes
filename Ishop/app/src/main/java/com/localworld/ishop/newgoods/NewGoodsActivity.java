package com.localworld.ishop.newgoods;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportActivity;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.common.view.ScrollControllerViewPager;
import com.localworld.ishop.model.DefaultResponse;
import com.localworld.ishop.model.goods.Comment;
import com.localworld.ishop.model.goods.GoodsDetailModel;
import com.localworld.ishop.newgoods.bean.GoodsCommendBean;
import com.localworld.ishop.newgoods.bean.GoodsHeadBean;
import com.localworld.ishop.newgoods.util.GoodsCommendMockUtils;
import com.localworld.ishop.shop.ShopDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class NewGoodsActivity extends BaseSupportActivity implements ViewPager.OnPageChangeListener{
    private ScrollControllerViewPager goodsvp;
    private int[] imageResIds; //存放图片资源id的数组
    private ArrayList<ImageView> imageViews; //存放图片的集合
    private int lastPosition;
    private boolean isRunning = false; //viewpager是否在自动轮询
    private ImageView imagedown,btn_collect;
    private ISImageView authorimage;
    private LinearLayout commendLinearLayout,meunLinearLayout,commendmeun,ll_point,btn_back,btn_bag,btn_collect_click;
    private TextView btn_buy,btn_publish,goodsname,goodsprice,authorname,goodsdesc;
    private NewGoodsAdapter newGoodsAdapter;
    private RecyclerView rcvcommend;
    private List<GoodsCommendBean> mDataList = new ArrayList<>();
    private List<Comment> commentList = new ArrayList<>();
    private boolean flag=false, temp = true,collect=false;
    private List<GoodsHeadBean> goodsHeadBeanList = new ArrayList<>();
    private List<GoodsDetailModel.GoodsBean> goodsDetailModelList = new ArrayList<>();
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);
    private String goodsId;
    private GoodsDetailModel.GoodsBean mGoodsBean;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_goods);

        initViews();
        requestData();
        initOnClick();
        //loadData();


        //开启图片的自动轮询
        new Thread(){
            @Override
            public void run() {
                isRunning = true;
                while(isRunning){
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() { //在子线程中开启子线程
                            //往下翻一页（setCurrentItem方法用来设置ViewPager的当前页）
                            goodsvp.setCurrentItem(goodsvp.getCurrentItem()+1);
                        }
                    });
                }
            }
        }.start();
    }
    private void initViews() {
        //初始化放小圆点的控件
        ll_point = (LinearLayout) findViewById(R.id.ll_point);
        //初始化ViewPager控件
        goodsvp = (ScrollControllerViewPager) findViewById(R.id.vp_newgoods);
        //设置ViewPager的滚动监听
        goodsvp.setOnPageChangeListener(this);
        rcvcommend = (RecyclerView)findViewById(R.id.recycler_view_goods_commend);
        imagedown = (ImageView)findViewById(R.id.new_goods_commend_down);
        commendmeun = (LinearLayout)findViewById(R.id.btn_goods_commend_menu);
        commendLinearLayout = (LinearLayout)findViewById(R.id.new_goods_commend);
        meunLinearLayout = (LinearLayout)findViewById(R.id.goods_commend_menu);
        meunLinearLayout.bringToFront();
        btn_back = (LinearLayout)findViewById(R.id.goods_toolbar_back);
        btn_bag = (LinearLayout) findViewById(R.id.goods_toolbar_bag);
        btn_collect_click = (LinearLayout)findViewById(R.id.good_collect_click);
        btn_publish =(TextView)findViewById(R.id.btn_publish);
        btn_collect =(ImageView)findViewById(R.id.good_collect);
        btn_buy = (TextView)findViewById(R.id.btn_goods_buy);
        goodsname = (TextView)findViewById(R.id.new_goods_name);
        goodsprice = (TextView)findViewById(R.id.new_goods_price);
        goodsdesc = (TextView)findViewById(R.id.goods_desc);
        authorname = (TextView)findViewById(R.id.goods_author_name);
        authorimage = (ISImageView)findViewById(R.id.goods_author_image);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcvcommend.setLayoutManager(layoutManager);
        newGoodsAdapter = new NewGoodsAdapter(commentList);
        rcvcommend.setAdapter(newGoodsAdapter);


    }
    private void initOnClick(){
        imagedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag){
                    goodsdesc.setVisibility(View.VISIBLE);
                    imagedown.setBackgroundResource(R.drawable.ic_up);
                    flag = false;
                }
                else{
                    goodsdesc.setVisibility(View.GONE);
                    imagedown.setBackgroundResource(R.drawable.ic_down);
                    flag = true;
                }
            }
        });
        commendmeun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(temp){
                    meunLinearLayout.setVisibility(View.VISIBLE);
                    temp = false;
                }
                else {
                    meunLinearLayout.setVisibility(View.GONE);
                    temp = true;
                }
            }
        });
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final GoodsBuyVip goodsBuyVip = new GoodsBuyVip(NewGoodsActivity.this);
                goodsBuyVip.setGoodsData(mGoodsBean);
                goodsBuyVip.show();
            }
        });
        btn_collect_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(collect){
                    btn_collect.setBackgroundResource(R.drawable.ipole_icon_39);
                    deleteCollect();
                    collect = false;
                }else{
                    btn_collect.setBackgroundResource(R.drawable.ipole_icon_40);
                    collectGoods();
                    collect = true;
                }
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShopDetailsActivity.class);
                view.getContext().startActivity(intent);
            }
        });



    }


    private void loadData() {

        List<GoodsCommendBean> data = GoodsCommendMockUtils.getList();
        newGoodsAdapter.setDataList(data);
        newGoodsAdapter.notifyDataSetChanged();
    }

    public void refreshMainData(GoodsDetailModel.GoodsBean bean) {
        goodsname.setText(bean.title);
        goodsprice.setText(String.format("￥ %s", String.valueOf(bean.price)));


     /*
      初始化数据
     */
        View pointView;
        GoodsHeadBean item1=new GoodsHeadBean();
        item1.headpic = bean.headPics;
        goodsHeadBeanList.add(item1);
        for (int i = 0; i <goodsHeadBeanList.size(); i++){
            //加小白点，指示器（这里的小圆点定义在了drawable下的选择器中了，也可以用小图片代替）
            pointView = new View(this);
            pointView.setBackgroundResource(R.drawable.goods_point_select); //使用选择器设置背景
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);
            if (i != 0){
                //如果不是第一个点，则设置点的左边距
                layoutParams.leftMargin = 10;
            }
            pointView.setEnabled(false); //默认都是暗色的
            ll_point.addView(pointView, layoutParams);
        }


        String contentPics = bean.contentPics;
        if (!TextUtils.isEmpty(contentPics)) {
            String[] pics = contentPics.split(",");
            if (pics.length > 0) {

            }
        }
        authorname.setText("大师");
        authorimage.setActualImageResource(R.drawable.ig_app_icon);
        if (TextUtils.isEmpty(bean.desc)) {
            goodsdesc.setText("大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买\n大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买\n大师作品 欢迎购买 大师作品 欢迎购买 大师作品 欢迎购买\n大师作品 欢迎购买");
        } else {
            goodsdesc.setText(bean.desc);
        }

     /*
      初始化适配器
     */
        final NewGoodsDetailAdapter adapter =new NewGoodsDetailAdapter(goodsHeadBeanList);
        ll_point.getChildAt(0).setEnabled(true); //初始化控件时，设置第一个小圆点为亮色
        lastPosition = 0; //设置之前的位置为第一个
        goodsvp.setAdapter(adapter);
        //设置默认显示中间的某个位置（这样可以左右滑动），这个数只有在整数范围内，可以随便设置
        goodsvp.setCurrentItem(5000000); //显示5000000这个位置的图片

    }
    public void refreshGoodsComments(List<Comment> commentList) {
        newGoodsAdapter.setCommentData(commentList);
        newGoodsAdapter.notifyDataSetChanged();
    }

    public void requestData() {

            goodsId = "66";


        service.getGoodsDetail(goodsId).enqueue(new HdlRawCallback<GoodsDetailModel>() {
            @Override
            protected void onSuccess(GoodsDetailModel goodsDetailModel) {
                if (goodsDetailModel == null) {
                    return;
                }
                if (goodsDetailModel.goods != null) {
                    mGoodsBean = goodsDetailModel.goods;
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
    private void collectGoods() {
        service.postCollection("66").enqueue(new HdlRawCallback<DefaultResponse>() {
            @Override
            protected void onSuccess(DefaultResponse defaultResponse) {
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void deleteCollect() {
        service.deleteCollection("66").enqueue(new HdlRawCallback<DefaultResponse>() {
            @Override
            protected void onSuccess(DefaultResponse defaultResponse) {
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }



    //界面销毁时，停止viewpager的轮询
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //新的页面被选中
    @Override
    public void onPageSelected(int position) {
        //当前的位置可能很大，为了防止下标越界，对要显示的图片的总数进行取余
        int newPosition = position % goodsHeadBeanList.size();

        //设置小圆点为高亮或暗色
        ll_point.getChildAt(lastPosition).setEnabled(false);
        ll_point.getChildAt(newPosition).setEnabled(true);
        lastPosition = newPosition; //记录之前的点
    }

    //页面滑动状态发生改变
    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public class NewGoodsDetailAdapter extends PagerAdapter {
        private List<GoodsHeadBean> mgoodsbeanlist=new ArrayList<>();


        //返回显示数据的总条数，为了实现无限循环，把返回的值设置为最大整数
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }


        public NewGoodsDetailAdapter(List<GoodsHeadBean> list){
            mgoodsbeanlist = list;
        }

        public int getItemCount(){
            return mgoodsbeanlist.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            //当创建新的条目，又反回来，判断view是否可以被复用(即是否存在)
            return view == object;
        }

        //返回要显示的条目内容
        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            View view=View.inflate(container.getContext(),R.layout.item_goods_head_image,null);
            GoodsHeadBean goodsHeadBean = mgoodsbeanlist.get(position % mgoodsbeanlist.size());
            ISImageView ISImageView = (ISImageView)view.findViewById(R.id.goods_head_image);
            ISImageView.showImage(goodsHeadBean.headpic);
            container.addView(ISImageView);
            return ISImageView;


        }

        //销毁条目
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //object:刚才创建的对象，即要销毁的对象
            container.removeView((View) object);
        }

    }

}
