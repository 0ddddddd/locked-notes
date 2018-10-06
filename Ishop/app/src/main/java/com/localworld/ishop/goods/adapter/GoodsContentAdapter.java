package com.localworld.ishop.goods.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.model.goods.Comment;

import java.util.ArrayList;
import java.util.List;


public class GoodsContentAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int IMAGE_TYPE = 2001; //商品详情图片类型
    private static final int EVALUATION_TYPE = 2002; //商品评价类型

    private List<String> dataList = new ArrayList<>();
    private List<Comment> commentList = new ArrayList<>();

    public GoodsContentAdapter() {
        dataList = new ArrayList<>();
    }

    public void setData(@NonNull List<String> list) {
        dataList.clear();
        dataList.addAll(list);
    }

    public void setCommentData(List<Comment> list) {
        commentList.clear();
        commentList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_image_list, parent, false);
                return new ImageItemVH(view);
            case EVALUATION_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_evaluation_list, parent, false);
                return new CommentItemVH(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_image_list, parent, false);
                return new ImageItemVH(view);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder instanceof ImageItemVH) {
            ((ImageItemVH) holder).bind(dataList.get(position));
        } else if (holder instanceof CommentItemVH) {
            int commentPos = position - dataList.size();
            int type;
            if (commentPos == 0) {
                type = CommentItemVH.COMMENT_TYPE_TOP;
            } else if (commentPos == commentList.size() - 1) {
                type = CommentItemVH.COMMENT_TYPE_BOTTOM;
            } else {
                type = CommentItemVH.COMMENT_TYPE_CONTENT;
            }
            ((CommentItemVH) holder).wrapBind(commentList.get(commentPos), type);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= 0 && position < dataList.size()) {
            return IMAGE_TYPE;
        } else {
            return EVALUATION_TYPE;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size() + commentList.size();
    }

    public class ImageItemVH extends BaseViewHolder<String> {
        private ISImageView itemImageView;

        public ImageItemVH(View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.iv_goods_image_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }

        @Override
        public void bind(String response) {
            itemImageView.showImage(response);
        }

    }

    public class CommentItemVH extends BaseViewHolder<Comment> {
        public static final int COMMENT_TYPE_TOP = 0x001;
        public static final int COMMENT_TYPE_CONTENT = 0x002;
        public static final int COMMENT_TYPE_BOTTOM = 0x003;
        private ISImageView itemImageView;
        private TextView userNameTV;
        private TextView goodsNameTV;
        private TextView goodsTypeTV;
        private TextView goodsCommentTV;

        private View commentTitleTv;
        private View commentBottomTv;

        public CommentItemVH(View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.iv_goods_comment_image_item);
            userNameTV = itemView.findViewById(R.id.tv_goods_user_item);
            goodsNameTV = itemView.findViewById(R.id.tv_goods_name_item);
            goodsCommentTV = itemView.findViewById(R.id.tv_goods_evaluation_tiem);
            goodsTypeTV = itemView.findViewById(R.id.tv_goods_type_tiem);

            commentTitleTv = itemView.findViewById(R.id.tv_goods_comment_title);
            commentBottomTv = itemView.findViewById(R.id.btn_goods_more_comment);
        }

        @Override
        public void bind(Comment response) {
            itemImageView.setActualImageResource(R.drawable.ig_app_icon);
            userNameTV.setText(response.userName);
            goodsCommentTV.setText(response.content);
        }

        void wrapBind(Comment response, int type) {
            switch (type) {
                case COMMENT_TYPE_TOP:
                    commentTitleTv.setVisibility(View.VISIBLE);
                    commentBottomTv.setVisibility(View.GONE);
                    break;
                case COMMENT_TYPE_CONTENT:
                    commentTitleTv.setVisibility(View.GONE);
                    commentBottomTv.setVisibility(View.GONE);
                    break;
                case COMMENT_TYPE_BOTTOM:
                    commentTitleTv.setVisibility(View.GONE);
                    commentBottomTv.setVisibility(View.VISIBLE);
                    break;
            }
            bind(response);
        }
    }
}
