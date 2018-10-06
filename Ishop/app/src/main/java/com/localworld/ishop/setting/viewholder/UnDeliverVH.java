package com.localworld.ishop.setting.viewholder;

import android.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.UnDeliverBean;

public class UnDeliverVH extends BaseViewHolder<UnDeliverBean>{
    private ISImageView mGoodsPic;
    private TextView mGoodsName;;
    private TextView mGoodsPrice;
    private TextView mGoodsNum;
    private TextView mGoodsInfo;
    private TextView mReject;
    private TextView mCustomerService;
    private TextView mPush;
    public UnDeliverVH(View itemView) {
        super(itemView);
        mGoodsPic = itemView.findViewById(R.id.iv_setting_undeliver_goodpic);
        mGoodsName = itemView.findViewById(R.id.tv_setting_undeliver_goodname);
        mGoodsPrice = itemView.findViewById(R.id.tv_setting_undeliver_goodprice);
        mGoodsInfo = itemView.findViewById(R.id.tv_setting_undeliver_goodinfo);
        mGoodsNum = itemView.findViewById(R.id.tv_setting_undeliver_goodnum);
        mReject = itemView.findViewById(R.id.tv_setting_undeliver_reject);
        mCustomerService = itemView.findViewById(R.id.tv_setting_customerservice);
        mPush = itemView.findViewById(R.id.tv_setting_undeliver_push);
    }

    @Override
    public void bind(UnDeliverBean bean) {
        /*mGoodsPic.showImage(bean.goodPic);
        mGoodsName.setText(bean.goodName);
        mGoodsPrice.setText(bean.goodsPrice);
        mGoodsInfo.setText(bean.goodsInfo);
        mGoodsNum.setText(bean.goodsNum);*/
        mReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog dialog=new AlertDialog.Builder(view.getContext(),R.style.dialog1).create();
                dialog.show();
                View dialogView=View.inflate(view.getContext(), R.layout.dialog_setting_deliver_reject, null);

                Window window = dialog.getWindow();//获取当前的Window对象，然后下面进行窗口属性的设置
                window.setContentView(dialogView);//加载布局，view是填充自定义菜单布局xml 得到的
                window.setBackgroundDrawableResource(R.drawable.iple_allradius);
                window.setGravity(Gravity.BOTTOM);//这个也很重要，将弹出菜单的位置设置为底部
                window.setWindowAnimations(R.style.shopuser_bottom_mune_style);//菜单进入和退出屏幕的动画，实现了上下滑动的动画效果
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置菜单的尺寸

                TextView mReject = dialogView.findViewById(R.id.tv_setting_deliver_dialog_reject_commitreject);
                mReject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                TextView mCancle = dialogView.findViewById(R.id.tv_setting_deliver_dialog_reject_cancle);
                mCancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        mCustomerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
