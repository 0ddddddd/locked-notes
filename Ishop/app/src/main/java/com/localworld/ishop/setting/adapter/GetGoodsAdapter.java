package com.localworld.ishop.setting.adapter;

import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.GetGoodsBean;

import java.util.ArrayList;
import java.util.List;

public class GetGoodsAdapter extends RecyclerView.Adapter<GetGoodsAdapter.ViewHolder> {

    private List<GetGoodsBean> beanList = new ArrayList<>();

    public GetGoodsAdapter(List<GetGoodsBean> beanList) {
        this.beanList = beanList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ISImageView mGoodsPic;
        TextView mGoodsName;;
        TextView mGoodsPrice;
        TextView mGoodsNum;
        TextView mGoodsInfo;
        TextView mReject;
        TextView mCustomerService;
        TextView mCommentary;
        public ViewHolder(View itemView) {
            super(itemView);
            mGoodsPic = itemView.findViewById(R.id.iv_setting_getgoods_goodpic);
            mGoodsName = itemView.findViewById(R.id.tv_setting_getgoods_goodname);
            mGoodsPrice = itemView.findViewById(R.id.tv_setting_getgoods_goodprice);
            mGoodsInfo = itemView.findViewById(R.id.tv_setting_getgoods_goodinfo);
            mGoodsNum = itemView.findViewById(R.id.tv_setting_getgoods_goodnum);
            mReject = itemView.findViewById(R.id.tv_setting_getgoods_reject);
            mCustomerService = itemView.findViewById(R.id.tv_setting_getgoods_customerservice);
            mCommentary = itemView.findViewById(R.id.tv_setting_getgoods_commentary);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_getgoods_good,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GetGoodsBean getGoodsBean = beanList.get(position);
        holder. mGoodsPic.showImage(getGoodsBean.getGoodsPic);
        holder.mGoodsName.setText(getGoodsBean.getGoodsName);
        holder.mGoodsPrice.setText(getGoodsBean.getGoodsPrice);
        holder.mGoodsInfo.setText(getGoodsBean.getGoodsInfo);
        holder.mGoodsNum.setText(getGoodsBean.getGoodsNum);
        holder.mReject.setOnClickListener(new View.OnClickListener() {
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
        holder.mCustomerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.mCommentary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到评价界面
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }


}
