package com.localworld.ishop.newgoods;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.model.goods.Comment;
import com.localworld.ishop.newgoods.bean.GoodsCommendBean;

import java.util.ArrayList;
import java.util.List;

public class NewGoodsAdapter extends RecyclerView.Adapter<NewGoodsAdapter.ViewHolder>{
    private List<GoodsCommendBean> mDataList = new ArrayList<>();
    private List<Comment> commentList = new ArrayList<>();
    private Boolean []flags=new Boolean[1000];


    class ViewHolder extends RecyclerView.ViewHolder{
        ISImageView goodsImage;
        TextView commendText,commendusername,commendtime;
        EditText editreply;
        ImageView replybtn;
        LinearLayout replycontent;
        public ViewHolder(View view){
            super(view);
            goodsImage = (ISImageView)view.findViewById(R.id.new_goods_commend_image);
            commendText = (TextView)view.findViewById(R.id.commend_text);
            commendusername = (TextView)view.findViewById(R.id.commend_username);
            commendtime = (TextView)view.findViewById(R.id.commend_time);
            replybtn = (ImageView)view.findViewById(R.id.btn_reply);
            replycontent = (LinearLayout)view.findViewById(R.id.reply_hole_text);
            editreply = (EditText)view.findViewById(R.id.edit_reply_content);

        }
    }
    public void setDataList(List<GoodsCommendBean> list) {
        mDataList.clear();
        mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void setCommentData(List<Comment> list) {
        commentList.clear();
        commentList.addAll(list);
        notifyDataSetChanged();
    }

//    public NewGoodsAdapter(List<GoodsCommendBean> list){
//        mDataList = list;
//    }
    public NewGoodsAdapter(List<Comment> list){
        commentList = list;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_goods_commend,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int psition){
        flags[psition] = true;
//        GoodsCommendBean goodsCommendBean = mDataList.get(psition);
//        holder.goodsImage.showImage(goodsCommendBean.cdpicPath);
        Comment comment = commentList.get(psition);
        holder.commendText.setText(comment.content);
        holder.commendtime.setText("发表自： "+comment.created);
        holder.editreply.setText("@"+holder.commendusername.getText());
        holder.replybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flags[psition]){
                    holder.replycontent.setVisibility(View.VISIBLE);
                    flags[psition] = false; }
                else {
                    holder.replycontent.setVisibility(View.GONE);
                    flags[psition] = true;
                }

            }
        });

    }

    @Override
    public int getItemCount(){
        return commentList.size();
    }

//    @Override
//    public int getItemCount(){
//        return mDataList.size();
//    }


}
