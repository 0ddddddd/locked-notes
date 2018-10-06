package com.localworld.ishop.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * VH绑定数据
     * @param bean
     */
    public abstract void bind(T bean);

}
