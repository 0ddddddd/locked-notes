package com.localworld.ishop.setting.viewholder;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.cart.PaymentActivity;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.EditAddressActivity2;
import com.localworld.ishop.setting.bean.UnpayGoodsBean;

public class UnpayGoodsVH extends BaseViewHolder<UnpayGoodsBean> {

    private ISImageView mUnpayGoodsPic;
    private TextView mUnpayGoodsName;;
    private TextView mUnpayGoodsPrice;
    private TextView mUnpayGoodsNum;
    private TextView mUnpayGoodsInfo;
    private TextView mUnpayTotalPrice;
    private TextView mCanclePay;
    private TextView mMore;
    private TextView mPay;

    public UnpayGoodsVH(View itemView) {
        super(itemView);
        mUnpayGoodsPic = (ISImageView) itemView.findViewById(R.id.iv_setting_unpay_goodpic);
        mUnpayGoodsName = itemView.findViewById(R.id.tv_setting_unpay_goodname);
        mUnpayGoodsPrice = itemView.findViewById(R.id.tv_setting_unpay_goodprice);
        mUnpayGoodsNum = itemView.findViewById(R.id.tv_setting_unpay_goodnum);
        mUnpayGoodsInfo = itemView.findViewById(R.id.tv_setting_unpay_goodinfo);
        mUnpayTotalPrice = itemView.findViewById(R.id.tv_setting_unpay_totalprice);
        mMore = itemView.findViewById(R.id.tv_setting_unpay_more);
        mCanclePay = itemView.findViewById(R.id.tv_setting_unpay_canclepay);
        mPay = itemView.findViewById(R.id.tv_setting_unpay_pay);
    }

    @Override
    public void bind(final UnpayGoodsBean bean) {
        mUnpayGoodsPic.showImage(bean.unpayGoodsPic);
        mUnpayGoodsName.setText(bean.unpayGoodsName);
        mUnpayGoodsPrice.setText(bean.unpayGoodsPrice);
        mUnpayGoodsNum.setText(bean.unpayGoodsNum);
        mUnpayGoodsInfo.setText(bean.unpayGoodsInfo);
        mUnpayTotalPrice.setText(bean.unpayTotalPrice);

        mMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog dialog=new AlertDialog.Builder(view.getContext(),R.style.dialog1).create();
                dialog.show();
                View view1=View.inflate(view.getContext(), R.layout.dialog_setting_unpay_more, null);

                Window window = dialog.getWindow();//获取当前的Window对象，然后下面进行窗口属性的设置
                window.setContentView(view1);//加载布局，view是填充自定义菜单布局xml 得到的
                window.setBackgroundDrawableResource(R.drawable.iple_allradius);
                window.setGravity(Gravity.BOTTOM);//这个也很重要，将弹出菜单的位置设置为底部
                window.setWindowAnimations(R.style.shopuser_bottom_mune_style);//菜单进入和退出屏幕的动画，实现了上下滑动的动画效果
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置菜单的尺寸

                TextView changeAddress=(TextView)view1.findViewById(R.id.tv_setting_unpay_dialog_changeaddress);
                TextView customerService=(TextView)view1.findViewById(R.id.tv_setting_unpay_dialog_customerservice);
                TextView cancel=(TextView)view1.findViewById(R.id.tv_setting_unpay_dialog_cancle);
                changeAddress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), EditAddressActivity2.class);
                        view.getContext().startActivity(intent);
                    }
                });
                customerService.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(),"客服休息中",Toast.LENGTH_LONG);
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        dialog.dismiss();
                    }

                });
            }
        });
        mCanclePay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog dialog=new AlertDialog.Builder(view.getContext(),R.style.dialog1).create();
                dialog.show();
                View view1=View.inflate(view.getContext(), R.layout.dialog_setting_unpay_canclepay, null);
                Window window = dialog.getWindow();//获取当前的Window对象，然后下面进行窗口属性的设置
                window.setContentView(view1);//加载布局，view是填充自定义菜单布局xml 得到的
                window.setBackgroundDrawableResource(R.drawable.iple_allradius);
                window.setGravity(Gravity.BOTTOM);//这个也很重要，将弹出菜单的位置设置为底部
                window.setWindowAnimations(R.style.shopuser_bottom_mune_style);//菜单进入和退出屏幕的动画，实现了上下滑动的动画效果
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置菜单的尺寸

                TextView mCommitCancle = view1.findViewById(R.id.tv_setting_unpay_dialog_canclepay_commitcancle);
                mCommitCancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                TextView mCancle = view1.findViewById(R.id.tv_setting_unpay_dialog_canclepay_cancle);
                mCancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        mPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentActivity.class);
                //todo 传输数据给PaymentAdapter界面
               /* intent.putExtra("goodImg",);
                intent.putExtra("unPayGoodName",mUnpayGoodsName.getText());
                intent.putExtra("unPayGoodNum",mUnpayGoodsNum.getText());
                intent.putExtra("unPayGoodInfo",mUnpayGoodsInfo.getText());
                intent.putExtra("unPayTotalPrice",mUnpayTotalPrice.getText());*/
                view.getContext().startActivity(intent);
            }
        });
    }
}
