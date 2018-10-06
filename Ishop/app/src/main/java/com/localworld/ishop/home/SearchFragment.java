package com.localworld.ishop.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.igerm.android.lib.net.core.HdlCore;
import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.search.SearchTypeFragment;
import com.localworld.ishop.search.SearchTestImageBean;
import com.localworld.ishop.search.SlidSpic;
import com.localworld.ishop.search.adapter.SlidSampicAdapter;
import com.localworld.ishop.search.adapter.SlidSpicAdapter;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends BaseSupportFragment {

    private List<SlidSpic> spicList = new ArrayList<>();
    private List<SearchTestImageBean> mTestList = new ArrayList<>();
    private ImageButton mSearchTypes;
    private EditText mSearhKey;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);

    public static SearchFragment newInstance() {
        Bundle args = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home_search, container, false);
        initSlidSpic();
        initSildSampic();
        //特色图片
        RecyclerView recyclerView01 = (RecyclerView) rootView.findViewById(R.id.rv_search_spic);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView01.setLayoutManager(layoutManager1);
        SlidSpicAdapter adapter1 = new SlidSpicAdapter(spicList);
        recyclerView01.setAdapter(adapter1);
        //推荐图片
        RecyclerView recyclerView02 = (RecyclerView) rootView.findViewById(R.id.rv_search_samplepic);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.HORIZONTAL, false);
        recyclerView02.setLayoutManager(gridLayoutManager);
        SlidSampicAdapter adapter2 = new SlidSampicAdapter(mTestList);
        recyclerView02.setAdapter(adapter2);
        //分类搜索
        mSearchTypes = rootView.findViewById(R.id.ibt_search_types);
        mSearchTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SearchTypeFragment.class);
                view.getContext().startActivity(intent);

            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getActivity() != null) {
            ((HomeActivity) getActivity()).hideToolbar();
        }
        super.onViewCreated(view, savedInstanceState);
    }

    private void initSlidSpic() {
        for (int i = 0; i < 2; i++) {
            SlidSpic spic1 = new SlidSpic(R.drawable.img_search_samp04);
            spicList.add(spic1);
            spicList.add(spic1);
            spicList.add(spic1);
        }
    }

    private void initSildSampic() {
        for (int i = 0; i < 5; i++) {

            SearchTestImageBean test = new SearchTestImageBean();
            test.imageId = R.drawable.img_search_samp01;
            mTestList.add(test);

            SearchTestImageBean test1= new SearchTestImageBean();
            test1.imageId = R.drawable.img_search_samp02;
            mTestList.add(test1);

        }
    }
}
