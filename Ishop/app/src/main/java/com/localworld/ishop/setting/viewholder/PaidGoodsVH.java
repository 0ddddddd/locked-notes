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
import com.localworld.ishop.setting.bean.PaidGoodsBean;

public class PaidGoodsVH extends BaseViewHolder<PaidGoodsBean> {

    private ISImageView mPaidGoodsPic;
    private TextView mPaidGoodsName;;
    private TextView mPaidGoodsPrice;
    private TextView mPaidGoodsNum;
    private TextView mPaidGoodsInfo;
    private TextView mPaidState;
    private TextView mCustomerService;
    private TextView mCommentary;

    public PaidGoodsVH(View itemView) {
        super(itemView);
        mPaidGoodsPic = itemView.findViewById(R.id.iv_setting_paid_goodpic);
        mPaidGoodsName = itemView.findViewById(R.id.tv_setting_paid_goodname);
        mPaidGoodsPrice = itemView.findViewById(R.id.tv_setting_paid_goodprice);
        mPaidGoodsNum = itemView.findViewById(R.id.tv_setting_paid_goodnum);
        mPaidGoodsInfo = itemView.findViewById(R.id.tv_setting_paid_goodinfo);
        mPaidState = itemView.findViewById(R.id.tv_setting_paid_state);
        mCustomerService = itemView.findViewById(R.id.tv_setting_customerservice);
        mCommentary = itemView.findViewById(R.id.tv_setting_paid_commentary);
    }

    @Override
    public void bind(final PaidGoodsBean bean) {
        mPaidGoodsPic.showImage(bean.paidGoodsPic);
        mPaidGoodsName.setText(bean.paidGoodsName);
        mPaidGoodsPrice.setText(bean.paidGoodsPrice);
        mPaidGoodsNum.setText(bean.paidGoodsNum);
        mPaidGoodsInfo.setText(bean.paidGoodsInfo);
        mPaidState.setText(bean.paidState);
        mCustomerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //联系客服
            }
        });
        mCommentary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到评论界面
                if(bean.paidState.equals("已签收")){
                    //跳转到评论界面
                }else{
                    final AlertDialog dialog=new AlertDialog.Builder(view.getContext(),R.style.dialog1).create();
                    dialog.show();
                    View view1=View.inflate(view.getContext(), R.layout.dialog_setting_paid_commentary, null);
                    TextView noCommentary=(TextView)view1.findViewById(R.id.tv_setting_paid_dialog_commentary_nocommentary);
                    TextView cancel=(TextView)view1.findViewById(R.id.tv_setting_paid_dialog_commentary_cancle);

                    Window window = dialog.getWindow();//获取当前的Window对象，然后下面进行窗口属性的设置
                    window.setContentView(view1);//加载布局，view是填充自定义菜单布局xml 得到的
                    window.setBackgroundDrawableResource(R.drawable.iple_allradius);
                    window.setGravity(Gravity.BOTTOM);//这个也很重要，将弹出菜单的位置设置为底部
                    window.setWindowAnimations(R.style.shopuser_bottom_mune_style);//菜单进入和退出屏幕的动画，实现了上下滑动的动画效果
                    window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置菜单的尺寸
                    cancel.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            dialog.dismiss();
                        }
                    });
                }
            }
        });
    }
}
