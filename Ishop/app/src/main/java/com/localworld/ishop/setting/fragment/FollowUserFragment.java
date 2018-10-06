package com.localworld.ishop.setting.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.setting.adapter.FollowUserAdapter;
import com.localworld.ishop.setting.bean.FollowFollowedUserBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FollowUserFragment extends BaseSupportFragment {
    private RecyclerView recyclerView;
    private FollowUserAdapter adapter;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);


    public static FollowUserFragment newInstance(){
        Bundle bundle = new Bundle();
        FollowUserFragment followUserFragment = new FollowUserFragment();
        followUserFragment.setArguments(bundle);
        return followUserFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_follow_user,container,false);
        initUserView(view);
        return view;
    }

    private void initUserView(View view) {
        recyclerView = view .findViewById(R.id.recycler_setting_follow_user);
        adapter = new FollowUserAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        getFollowList();
    //    loadData();
    }
    private void getFollowList() {
        Map<String, String> map = new HashMap<>();
        map.put("keyword", "");
        map.put("pageNo", "");
        map.put("pageSize", "");
        map.put("userId", "1");
        map.put("targetType", "user");
        service.getFollowFollowedList(map).enqueue(new HdlRawCallback<List<FollowFollowedUserBean>>() {
            //todo followList读取数据失败
            @Override
            protected void onSuccess(List<FollowFollowedUserBean> followFollowedUserBeans) {
                List<FollowFollowedUserBean> list = followFollowedUserBeans;
                adapter.setmDataList(list);
                adapter.notifyDataSetChanged();
            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getContext(), "网络似乎有点问题", Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*
    private void loadData() {
        List<BaseSettingBean> data = FollowTest.getUserTestList();
        adapter.setmDataList(data);
        adapter.notifyDataSetChanged();
    }*/
}
