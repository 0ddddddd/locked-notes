package com.localworld.ishop.shop.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.model.DefaultResponse;
import com.localworld.ishop.shop.bean.ShopAuthor;

import java.util.ArrayList;
import java.util.List;

public class ShopDetailAdapter2 extends RecyclerView.Adapter<ShopDetailAdapter2.ViewHolder> {
//    private List<ShopGoods2Bean> mShopGoods2BeanList = new ArrayList<>();
    private List<ShopAuthor> authorDataList = new ArrayList<>();
    private boolean []flags = new boolean[1000];
    private boolean []collects = new boolean[1000];
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);
    private Context context;

    class ViewHolder extends RecyclerView.ViewHolder{
         ISImageView shopgoodsImage,userimage;
         ImageView btn_collect;
         TextView tv_show,tv_content,tv_name,tv_time;
         LinearLayout btn_collect_click;

        public ViewHolder(View view){
            super(view);
            shopgoodsImage = (ISImageView)view.findViewById(R.id.iv_shopdetail_good2_item);
            userimage = (ISImageView)view.findViewById(R.id.shopgoods2_user_image);
            tv_show = (TextView)view.findViewById(R.id.item_text_show);
            tv_content = (TextView)view.findViewById(R.id.item_text_content);
            tv_name = (TextView)view.findViewById(R.id.shop_username);
            tv_time = (TextView)view.findViewById(R.id.shop_publish_time);
            btn_collect_click = (LinearLayout)view.findViewById(R.id.good_collect_click);
            btn_collect =(ImageView)view.findViewById(R.id.good_collect);

        }
    }

    public ShopDetailAdapter2(List<ShopAuthor> list){
        authorDataList = list;
    }


    public void setDataList(List<ShopAuthor> list) {
        authorDataList.clear();
        authorDataList.addAll(list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopdetail_goods2,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        context = parent.getContext();
        return holder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
//        ShopGoods2Bean shopgoods = mShopGoods2BeanList.get(position);
        ShopAuthor shopAuthor = authorDataList.get(position);
        holder.shopgoodsImage.showImage(shopAuthor.contentPic);
        holder.tv_name.setText(shopAuthor.username);


        holder.tv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flags[position]){
                    flags[position] = false;
                    holder.tv_content.setSingleLine(flags[position]);// 展开
                    holder.tv_show.setText("收起");

                }else{
                    flags[position] = true;
                    holder.tv_content.setSingleLine(flags[position]); // 收起
                    holder.tv_show.setText("展开");
                }
            }
        });
        holder.btn_collect_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(collects[position]){
                    holder.btn_collect.setBackgroundResource(R.drawable.ipole_icon_39);
                    deleteCollect();
                    collects[position] = false;
                }else{
                    holder.btn_collect.setBackgroundResource(R.drawable.ipole_icon_40);
                    collectGoods();
                    collects[position] = true;
                }
            }
        });
    }
    private void collectGoods() {
        service.postCollection("66").enqueue(new HdlRawCallback<DefaultResponse>() {
            @Override
            protected void onSuccess(DefaultResponse defaultResponse) {
                Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();

            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void deleteCollect() {
        service.deleteCollection("66").enqueue(new HdlRawCallback<DefaultResponse>() {
            @Override
            protected void onSuccess(DefaultResponse defaultResponse) {
                Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();

            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public int getItemCount(){
        return authorDataList.size();
    }

}
