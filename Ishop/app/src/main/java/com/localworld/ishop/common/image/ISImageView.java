package com.localworld.ishop.common.image;

import android.content.Context;
import android.util.AttributeSet;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;


public class ISImageView extends SimpleDraweeView {

    public ISImageView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
    }

    public ISImageView(Context context) {
        super(context);
    }

    public ISImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ISImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ISImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void showImage(String url) {
        setImageURI(url);
    }
}
