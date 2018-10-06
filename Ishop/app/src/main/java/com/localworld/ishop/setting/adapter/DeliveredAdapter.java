package com.localworld.ishop.setting.adapter;

import android.app.AlertDialog;
import android.content.Intent;
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
import com.localworld.ishop.setting.TransitMessageActivity;
import com.localworld.ishop.setting.bean.DeliveredBean;

import java.util.ArrayList;
import java.util.List;

public class DeliveredAdapter extends RecyclerView.Adapter<DeliveredAdapter.ViewHolder> {
    private List<DeliveredBean> list = new ArrayList<>();

    public DeliveredAdapter(List<DeliveredBean> list) {
        this.list = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ISImageView goodPic;
        TextView goodName;
        TextView goodPrice;
        TextView goodNum;
        TextView goodInfo;
        TextView reject;
        TextView service;
        TextView transitMessage;
        public ViewHolder(View itemView) {
            super(itemView);
            goodPic = itemView.findViewById(R.id.iv_setting_delivered_goodpic);
            goodName = itemView.findViewById(R.id.tv_setting_delivered_goodname);
            goodPrice = itemView.findViewById(R.id.tv_setting_delivered_goodprice);
            goodNum = itemView.findViewById(R.id.tv_setting_delivered_goodnum);
            goodInfo = itemView.findViewById(R.id.tv_setting_delivered_goodinfo);
            reject = itemView.findViewById(R.id.tv_setting_delivered_reject);
            service = itemView.findViewById(R.id.tv_setting_delivered_customerservice);
            transitMessage = itemView.findViewById(R.id.tv_setting_delivered_transitmessage);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_delivered_good,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        DeliveredBean bean = list.get(position);
        holder.goodPic.showImage(bean.deliveredGoodHeadPic);
        holder.goodName.setText(bean.deliveredGoodName);
        holder.goodPrice.setText(bean.deliveredGoodPrice);
        holder.goodNum.setText(bean.deliveredGoodNum);
        holder.goodInfo.setText(bean.deliveredGoodInfo);
        holder.reject.setOnClickListener(new View.OnClickListener() {
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
        holder.transitMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String goodPic = holder.goodPic.toString();
                String goodName = holder.goodName.toString();

                Intent intent = new Intent(view.getContext(), TransitMessageActivity.class);
                intent.putExtra("goodPic",goodPic);
                intent.putExtra("goodName",goodName);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
