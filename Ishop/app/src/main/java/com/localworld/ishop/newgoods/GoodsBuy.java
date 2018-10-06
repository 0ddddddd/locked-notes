package com.localworld.ishop.newgoods;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.cart.PaymentActivity;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.common.view.ScrollControllerViewPager;
import com.localworld.ishop.model.goods.GoodsDetailModel;
import com.localworld.ishop.newgoods.bean.GoodsHeadBean;
import com.localworld.ishop.newgoods.util.GoodsHeadMockUtils;

import java.util.ArrayList;
import java.util.List;


public class GoodsBuy {
    AlertDialog.Builder builder;
    View view;
    Context context;
    private GoodsDetailModel.GoodsBean mGoodsBean;

    private ScrollControllerViewPager goods_vp;
    private LinearLayout lll_point;
    private ArrayList<View> pageViews;
    private ImageView[] imageViews;
    private TextView confirmbtn;
    private List<GoodsHeadBean> goodsHeadBeanList = new ArrayList<>();
    private ISImageView ISImageView;

    /**
     * 初始化 菜单布局以及按钮
     *
     * @param context
     */
    public GoodsBuy(Context context) {
        this.context = context;
        builder = new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialog_goods_buy, null);
        confirmbtn = (TextView) view.findViewById(R.id.btn_confirm);

    }


    public void setGoodsData(GoodsDetailModel.GoodsBean bean) {
        this.mGoodsBean = bean;
    }

    /**
     * 初始化完毕后，调用该方法 显示菜单
     */

    public void show() {
        final AlertDialog dialog = new AlertDialog.Builder(context).create();//生成一个AlertDialog对象
        dialog.show();//调用AlertDialog的show()方法显示

        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

                if (dialog.getOwnerActivity() != null) {
                    Intent intent = new Intent(dialog.getOwnerActivity(), PaymentActivity.class);
                    intent.putExtra("data", mGoodsBean);
                    dialog.getOwnerActivity().startActivity(intent);
                }
            }
        });

        Window window = dialog.getWindow();//获取当前的Window对象，然后下面进行窗口属性的设置
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.y = 40;
        window.setContentView(view);//加载布局，view是填充自定义菜单布局xml 得到的
        window.setGravity(Gravity.BOTTOM);//这个也很重要，将弹出菜单的位置设置为底部
        window.setBackgroundDrawableResource(R.drawable.shape_shopuser_follow_button3);
        window.setWindowAnimations(R.style.shopuser_bottom_mune_style);//菜单进入和退出屏幕的动画，实现了上下滑动的动画效果
        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置菜单的尺寸


        goodsHeadBeanList = GoodsHeadMockUtils.getList();

//        imageResIds = new int[]{R.drawable.image_01,R.drawable.timg1,R.drawable.timg2};
        pageViews = new ArrayList<View>();
        for (int i = 0; i < goodsHeadBeanList.size(); i++) {
            LinearLayout layout = new LinearLayout(context);

            final ISImageView ISImageView = new ISImageView(context);
//        imageView.setBackgroundResource(imageResIds[i]);

            layout.addView(ISImageView);
            pageViews.add(layout);
        }


        imageViews = new ImageView[pageViews.size()];
        lll_point = (LinearLayout) view.findViewById(R.id.lll_point);
        goods_vp = (ScrollControllerViewPager) view.findViewById(R.id.vp_new_goods);

        /**
         * 有几张图片 下面就显示几个小圆点
         */

        for (int i = 0; i < pageViews.size(); i++) {
            LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(10, 10);
            // 设置每个小圆点距离左边的间距
            margin.setMargins(8, 0, 0, 0);
            ISImageView = new ISImageView(context);

            imageViews[i] = ISImageView;
            if (i == 0) {
                // 默认选中第一张图片
                imageViews[i].setBackgroundResource(R.drawable.goods_point_able);
            } else {
                // 其他图片都设置未选中状态
                imageViews[i].setBackgroundResource(R.drawable.goods_point_disable);
            }
            lll_point.addView(imageViews[i], margin);
        }

        // 给viewpager设置适配器
        goods_vp.setAdapter(new GuidePageAdapter(goodsHeadBeanList));
        // 给viewpager设置监听事件
        goods_vp.setOnPageChangeListener(new GuidePageChangeListener());
    }

    // 指引页面数据适配器
    class GuidePageAdapter extends PagerAdapter {
        private List<GoodsHeadBean> mgoodsbeanlist = new ArrayList<>();

        @Override
        public int getCount() {
            return pageViews.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getItemPosition(Object object) {
            // TODO Auto-generated method stub
            return super.getItemPosition(object);
        }

        public GuidePageAdapter(List<GoodsHeadBean> list) {
            mgoodsbeanlist = list;
        }

        public int getItemCount() {
            return mgoodsbeanlist.size();
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            // TODO Auto-generated method stub
            ((ViewPager) arg0).removeView(pageViews.get(arg1));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
//            View view1 = View.inflate(container.getContext(),R.layout.item_goods_buy_image,null);
//            IGImageView igImageView = (IGImageView)view1.findViewById(R.id.goods_igimageview);
//            igImageView.setBackgroundResource(imageResIds[position]);
//            container.addView(view1);
//            return view1;
            View view = View.inflate(container.getContext(), R.layout.item_goods_image_dialog, null);
            GoodsHeadBean goodsHeadBean = mgoodsbeanlist.get(position % mgoodsbeanlist.size());
            ISImageView ISImageView = (ISImageView) view.findViewById(R.id.goods_head_image_dialog);
            ISImageView.showImage(goodsHeadBean.headpic);
            container.addView(ISImageView);
            return ISImageView;
        }


    }

    // 指引页面更改事件监听器
    class GuidePageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int arg0) {
            // 遍历数组让当前选中图片下的小圆点设置颜色
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[arg0].setBackgroundResource(R.drawable.goods_point_able);

                if (arg0 != i) {
                    imageViews[i].setBackgroundResource(R.drawable.goods_point_disable);
                }
            }
        }
    }

}

