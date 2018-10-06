package com.localworld.ishop.home.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.home.bean.BaseHomeBean;
import com.localworld.ishop.home.bean.HomeAuthorRecommendBean;

import java.util.List;


public class HomeRecommendAuthorItemVH extends BaseViewHolder<HomeAuthorRecommendBean.AuthorBean> {
    private ISImageView mAuthorHeadIv;
    private TextView mAuthorNameTv;
    public ImageView deleteIv;
    private List<BaseHomeBean> list;

    public HomeRecommendAuthorItemVH(View itemView) {
        super(itemView);

        mAuthorHeadIv = itemView.findViewById(R.id.iv_author_head);
        mAuthorNameTv = itemView.findViewById(R.id.tv_author_name);
        deleteIv=itemView.findViewById(R.id.iv_author_delete);
    }

    @Override
    public void bind(HomeAuthorRecommendBean.AuthorBean bean) {
        mAuthorNameTv.setText(bean.name);
        mAuthorHeadIv.showImage(bean.authorPic);
    }
}
