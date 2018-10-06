package com.localworld.ishop.shopcart.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.goods.GoodsDetailActivity;
import com.localworld.ishop.model.Order;
import com.localworld.ishop.shop.ShopDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Order> mShopList = new ArrayList<>();
    private static final int GOODS_TYPE = 4002;//商品信息显示
    private static final int MORE_TYPE = 4003;//更多推荐
    //private boolean isTitleItemSelected=false;//保存商店栏勾选框的状态（true为勾选，false为未勾选）
    /*********修改***************/
    private String titleName;//保存当前选中商店的商店名
    public double selectPrice = 0;

    public ShopAdapter(){

    }

    public ShopAdapter(List<Order> orderList){
        mShopList=orderList;
    }

    @Override
    public int getItemViewType(int position) {
        return mShopList.get(position).getViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case GOODS_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_shop_list, parent, false);
                return new GoodsViewHolder(view);
            case MORE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_shopimage_list, parent, false);
                return new MoreViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_shop_list, parent, false);
                return new GoodsViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        switch (getItemViewType(position)) {
            case MORE_TYPE:
                MoreViewHolder moreViewHolder = (MoreViewHolder) holder;
                displayImage(holder.itemView.getContext(), mShopList.get(position).getGoodsPic(), moreViewHolder.moreImage);
                break;

            case GOODS_TYPE:
                final GoodsViewHolder goodsViewHolder = (GoodsViewHolder) holder;
                goodsViewHolder.goodsName.setText(mShopList.get(position).getGoodsTitle());
               // goodsViewHolder.shopName.setText(mShopList.get(position).getAuthorTitle());
                goodsViewHolder.goodsNum.setText(String.valueOf(mShopList.get(position).getNum()));
                goodsViewHolder.number = mShopList.get(position).getNum();
                goodsViewHolder.totalPrice = goodsViewHolder.number * mShopList.get(position).getPrice();
                goodsViewHolder.goodsPrice.setText(String.valueOf(goodsViewHolder.totalPrice));
                displayImage(holder.itemView.getContext(), mShopList.get(position).getGoodsPic(), goodsViewHolder.goodsImage);


                //判断商店项是否显示
                if (mShopList.get(position).isShowShop() == true) {
                    goodsViewHolder.shopTitleLinearLayout.setVisibility(View.VISIBLE);
                }
                //判断商店项是否选中
                if (mShopList.get(position).isSelectShop() == true) {
                    goodsViewHolder.shopImageSelect.setImageResource(R.drawable.ipole_icon_checkbox_dark);
                } else {
                    goodsViewHolder.shopImageSelect.setImageResource(R.drawable.ipole_icon_38);
                }
                //判断商品项是否选中
                if (mShopList.get(position).isSelectGoods() == true) {
                    goodsViewHolder.goodsSelect.setImageResource(R.drawable.ipole_icon_checkbox_dark);
                } else {
                    goodsViewHolder.goodsSelect.setImageResource(R.drawable.ipole_icon_38);
                }

                //左划收藏与删除点击事件
                goodsViewHolder.likeSlide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "收藏成功o(^_^)o", Toast.LENGTH_SHORT).show();
                    }
                });

                goodsViewHolder.deleteSlide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (null != mOnSwipeListener) {
                            mOnSwipeListener.onDel(goodsViewHolder.getAdapterPosition());

                            for (int i = 0; i < mShopList.size(); i++) {
                                if (mShopList.get(i).getAuthorTitle() == titleName && mShopList.get(i).isShowShop() == false) {
                                    mShopList.get(i).setShowShop(true);
                                    break;
                                }
                            }
                            notifyDataSetChanged();
                            Toast.makeText(v.getContext(), "删除成功(≧▽≦)", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                //商店项的点击事件
                goodsViewHolder.shopImageSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mShopList.get(position).isSelectShop() == false && mShopList.get(position).isShowShop() == true) {
                            mShopList.get(position).setSelectShop(true);
                            titleName = mShopList.get(position).getAuthorTitle();
                            goodsViewHolder.shopImageSelect.setImageResource(R.drawable.icon_selected_blue);
                            for (int i = 0; i < mShopList.size(); i++) {
                                if (mShopList.get(i).getAuthorTitle() == titleName) {
                                    mShopList.get(i).setSelectGoods(true);
                                    mShopList.get(i).setSelectShop(true);
                                }
                            }
                            notifyDataSetChanged();
                        } else {
                            mShopList.get(position).setSelectShop(false);
                            titleName = mShopList.get(position).getAuthorTitle();
                            goodsViewHolder.shopImageSelect.setImageResource(R.drawable.ic_circle);
                            for (int i = 0; i < mShopList.size(); i++) {
                                if (mShopList.get(i).getAuthorTitle() == titleName) {
                                    mShopList.get(i).setSelectGoods(false);
                                    mShopList.get(i).setSelectShop(false);
                                }
                            }
                            notifyDataSetChanged();
                        }
                        mOnSwipeListener.shopList(mShopList);
                        /*selectPrice=0;
                        for (int i=0;i<mShopList.size();i++){
                            if (mShopList.get(i).isSelectGoods()==true){
                                selectPrice+=goodsViewHolder.totalPrice;
                            }
                        }
                        mOnSwipeListener.selectPrice(selectPrice);*/
                    }
                });
                //商品项的点击事件
                goodsViewHolder.goodsSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean judge = true;
                        if (mShopList.get(position).isSelectGoods() == false) {
                            mShopList.get(position).setSelectGoods(true);
                            titleName = mShopList.get(position).getAuthorTitle();
                            goodsViewHolder.goodsSelect.setImageResource(R.drawable.icon_selected_blue);
                            for (int i = 0; i < mShopList.size(); i++) {
                                if (mShopList.get(i).getAuthorTitle() == titleName) {
                                    if (mShopList.get(i).isSelectGoods() == false) {
                                        judge = false;
                                    }
                                }
                            }
                            if (judge == true) {
                                for (int i = 0; i < mShopList.size(); i++) {
                                    if (mShopList.get(i).getAuthorTitle() == titleName && mShopList.get(i).isShowShop() == true) {
                                        mShopList.get(i).setSelectShop(true);
                                    }
                                }
                            }
                            notifyDataSetChanged();
                        } else {
                            mShopList.get(position).setSelectGoods(false);
                            mShopList.get(position).setSelectShop(false);
                            titleName = mShopList.get(position).getAuthorTitle();
                            goodsViewHolder.goodsSelect.setImageResource(R.drawable.ic_circle);
                            for (int i = 0; i < mShopList.size(); i++) {
                                if (mShopList.get(i).getAuthorTitle() == titleName && mShopList.get(i).isShowShop() == true) {
                                    mShopList.get(i).setSelectShop(false);
                                }
                            }
                            notifyDataSetChanged();
                        }
                        mOnSwipeListener.shopList(mShopList);
                    }
                });

                goodsViewHolder.shopName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "跳转到商品所在店铺主页...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(v.getContext(),ShopDetailsActivity.class);
                        v.getContext().startActivity(intent);
                    }
                });


                //商品栏的点击事件
                goodsViewHolder.goodsImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*Intent intent=new Intent(v.getContext(), xxxxxx.class);
                        startActivity(intent);*/
                        Toast.makeText(v.getContext(), "跳转到商品详情界面...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(v.getContext(), GoodsDetailActivity.class);
                        intent.putExtra("url", mShopList.get(position).getGoodsPic());
                        v.getContext().startActivity(intent);
                    }
                });
                goodsViewHolder.subGoodsNumber.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (goodsViewHolder.goodsNum.getText().equals("1")) {
                            Toast.makeText(v.getContext(), "再减少就没了 (＞_＜)", Toast.LENGTH_SHORT).show();
                        } else {
                            goodsViewHolder.number--;
                            mShopList.get(position).setNum(goodsViewHolder.number);
                            goodsViewHolder.goodsNum.setText(String.valueOf(goodsViewHolder.number));
                            goodsViewHolder.totalPrice =  goodsViewHolder.number * mShopList.get(position).getPrice();
                            goodsViewHolder.goodsPrice.setText(String.valueOf(goodsViewHolder.totalPrice));

                        }
                        mOnSwipeListener.shopList(mShopList);

                    }
                });
                goodsViewHolder.addGoodsNumber.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (goodsViewHolder.goodsNum.getText().equals("20")) {
                            Toast.makeText(v.getContext(), "购买上限了 (＞_＜)", Toast.LENGTH_SHORT).show();
                        } else {
                            goodsViewHolder.number++;
                            mShopList.get(position).setNum(goodsViewHolder.number);
                            goodsViewHolder.goodsNum.setText(String.valueOf(goodsViewHolder.number));
                            goodsViewHolder.totalPrice =  goodsViewHolder.number * mShopList.get(position).getPrice();
                            goodsViewHolder.goodsPrice.setText(String.valueOf(goodsViewHolder.totalPrice));
                        }
                        mOnSwipeListener.shopList(mShopList);
                    }
                });
                break;
                default:
                    MoreViewHolder moreViewHolder2 = (MoreViewHolder) holder;
                    displayImage(holder.itemView.getContext(), mShopList.get(position).getGoodsPic(), moreViewHolder2.moreImage);
                    break;
        }

    }

    public void setMockShopList(List<Order> newShopList) {
        mShopList.clear();
        mShopList.addAll(newShopList);
        for(int i=0;i<newShopList.size();i++){
            newShopList.get(i).setViewType(4002);
        }
    }

    public void setMoreShopList(List<Order> newShopList) {
        mShopList.clear();
        mShopList.addAll(newShopList);
        for(int i=0;i<newShopList.size();i++){
            newShopList.get(i).setViewType(4003);
        }
    }


    /*public void setNewShopListWithAnnimation(List<Order> newShopList,int position) {
        notifyItemRangeRemoved(position, 1);
        mShopList.clear();
        mShopList.addAll(newShopList);
        notifyDataSetChanged();
    }*/

    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos);

        void onTop(int pos);

        void shopList(List<Order> ShopList);

    }

    private onSwipeListener mOnSwipeListener;

    public onSwipeListener getOnDelListener() {
        return mOnSwipeListener;
    }

    public void setOnDelListener(onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }


    /**
     * 第一种ViewHolder
     */
    public class GoodsViewHolder extends RecyclerView.ViewHolder {
        TextView shopName, goodsName, goodsPrice, goodsNum, likeSlide, deleteSlide;
        ISImageView goodsImage;
        ImageView shopImageSelect, goodsSelect;
        Button subGoodsNumber, addGoodsNumber;
        LinearLayout shopTitleLinearLayout;
        public int number = 1;
        public int totalPrice = 0;

        public GoodsViewHolder(View itemView) {
            super(itemView);
            shopTitleLinearLayout = (LinearLayout) itemView.findViewById(R.id.ll_home_shop_name_item);
            shopImageSelect = itemView.findViewById(R.id.iv_home_shop_imageSelect_item);
            goodsSelect = itemView.findViewById(R.id.iv_home_goods_select_item);
            shopName = (TextView) itemView.findViewById(R.id.tv_home_shop_name_item);
            goodsName = (TextView) itemView.findViewById(R.id.tv_home_goodsName_item);
            goodsPrice = (TextView) itemView.findViewById(R.id.tv_home_shopprice_item);
            goodsNum = (TextView) itemView.findViewById(R.id.tv_home_goodsNum_item);
            goodsImage = (ISImageView) itemView.findViewById(R.id.iv_home_shop_item);
            subGoodsNumber = (Button) itemView.findViewById(R.id.btn_home_sub_item);
            addGoodsNumber = (Button) itemView.findViewById(R.id.btn_home_add_item);
            likeSlide = (TextView) itemView.findViewById(R.id.tv_home_shop_slidelike_item);
            deleteSlide = (TextView) itemView.findViewById(R.id.tv_home_shop_slidedelete_item);

        }

    }

    /**
     * 第二种ViewHolder
     */
    public class MoreViewHolder extends RecyclerView.ViewHolder {
        ISImageView moreImage;

        public MoreViewHolder(View itemView) {
            super(itemView);
            moreImage = itemView.findViewById(R.id.iv_home_shop_image_item);
        }

    }

    @Override
    public int getItemCount() {
        return mShopList.size();
    }

    public void displayImage(Context context, String path, ISImageView imageView) {
        imageView.showImage(path);
    }
}
