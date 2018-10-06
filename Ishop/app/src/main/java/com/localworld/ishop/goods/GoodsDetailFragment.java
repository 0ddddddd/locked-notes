package com.localworld.ishop.goods;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.image.ISImageView;



public class GoodsDetailFragment extends BaseSupportFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_goods, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String url = getArguments().getString("url");
        ((ISImageView) view.findViewById(R.id.iv_goods_head_pic)).showImage(url);
    }

    public static GoodsDetailFragment newInstance(String url) {
        GoodsDetailFragment fragment = new GoodsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        fragment.setArguments(bundle);
        return fragment;
    }
}
