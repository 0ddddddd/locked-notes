package com.localworld.ishop.newgoods;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.model.goods.GoodsDetailModel;

public class GoodsBuyVip {
    AlertDialog.Builder builder;
    View view;
    TextView btn1,btn2;
    Context context;
    private GoodsDetailModel.GoodsBean mGoodsBean;

    /**
     * 初始化 菜单布局以及按钮
     *
     * @param context
     */
    public GoodsBuyVip(Context context) {
        this.context = context;
        builder = new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialog_goods_buy_vip, null);

        btn1 = (TextView) view.findViewById(R.id.goods_buy_vip_btn1);
        btn2 = (TextView) view.findViewById(R.id.goods_buy_vip_btn2);

    }

    public void setGoodsData(GoodsDetailModel.GoodsBean bean){
        this.mGoodsBean = bean;
    }

    /**
     * 设置第一个按钮的 文字内容和监听器
     *
     * @param title
     * @param listener
     */
    public void setBtn1(String title, View.OnClickListener listener) {
        btn1.setText(title);
        btn1.setOnClickListener(listener);
    }

    /**
     * 设置第二个按钮的 文字内容和监听器
     *
     * @param title
     * @param listener
     */
    public void setBtn2(String title, View.OnClickListener listener) {
        btn2.setText(title);
        btn2.setOnClickListener(listener);
    }

    /**
     * 初始化完毕后，调用该方法 显示菜单
     */

    public void show() {
        final AlertDialog dialog = new AlertDialog.Builder(context).create();//生成一个AlertDialog对象
        dialog.show();//调用AlertDialog的show()方法显示

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final GoodsBuy goodsBuy = new GoodsBuy(dialog.getContext());
                goodsBuy.setGoodsData(mGoodsBean);
                goodsBuy.show();
                dialog.dismiss();
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

    }

}
