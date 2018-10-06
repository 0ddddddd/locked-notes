package com.localworld.ishop.shop;


import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.localworld.ishop.R;


public class ShopUserBottomMenu {
    AlertDialog.Builder builder;
    View view;
    Button button1;
    Button button2;
    Button buttonCancel;
    Context context;


    /**
     * 初始化 菜单布局以及按钮
     *
     * @param context
     */
    public ShopUserBottomMenu(Context context) {
        this.context = context;
        builder = new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(R.layout.item_shopuser_menu, null);

        button2 = (Button) view.findViewById(R.id.btn2_bottom_menu);
        buttonCancel = (Button) view.findViewById(R.id.btn_bottom_menu_cancel);

    }

    /**
     * 设置第一个按钮的 文字内容和监听器
     *
     * @param title
     * @param listener
     */
    public void setButton1(String title, View.OnClickListener listener) {
        button1.setText(title);
        button1.setOnClickListener(listener);
    }

    /**
     * 设置第二个按钮的 文字内容和监听器
     *
     * @param title
     * @param listener
     */
    public void setButton2(String title, View.OnClickListener listener) {
        button2.setText(title);
        button2.setOnClickListener(listener);
    }

    /**
     * 初始化完毕后，调用该方法 显示菜单
     */

    public void show() {
        final AlertDialog dialog = new AlertDialog.Builder(context).create();//生成一个AlertDialog对象
        dialog.show();//调用AlertDialog的show()方法显示


        buttonCancel.setOnClickListener(new View.OnClickListener() {//取消按钮点击后撤销dialog
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        Window window = dialog.getWindow();//获取当前的Window对象，然后下面进行窗口属性的设置
        window.setContentView(view);//加载布局，view是填充自定义菜单布局xml 得到的
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.y = 40;
        window.setBackgroundDrawableResource(android.R.color.transparent);//这个很重要，将背景设为透明
        // 这样子 第二和第三个按钮的空隙才会显示出来
        window.setGravity(Gravity.BOTTOM);//这个也很重要，将弹出菜单的位置设置为底部
        window.setWindowAnimations(R.style.shopuser_bottom_mune_style);//菜单进入和退出屏幕的动画，实现了上下滑动的动画效果
        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置菜单的尺寸

    }

}
