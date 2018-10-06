package com.localworld.ishop.home.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.view.NestedRecyclerView;
import com.localworld.ishop.home.bean.DiscoverySpecialBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DiscoverySpecialFragment extends BaseSupportFragment{

    private NestedRecyclerView recyclerView;
    private DiscoverySpecialAdapter adapter;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);

    public static DiscoverySpecialFragment newInstance() {
        Bundle args = new Bundle();
        DiscoverySpecialFragment discoveryFragmentSpecial = new DiscoverySpecialFragment();
        discoveryFragmentSpecial.setArguments(args);
        return discoveryFragmentSpecial;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_discovery_special, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.rcv_discovery_fragment_special);
        adapter = new DiscoverySpecialAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        getBoards();
        //loadData();
    }

   /* private void loadData() {
        List<BaseHomeBean> data = NewDiscoverySpecialMockUtils.getList();
        adapter.setDataList(data);
        adapter.notifyDataSetChanged();

    }*/

    private void getBoards() {
        Map<String, String> map = new HashMap<>();
        map.put("keyword", "特辑");
        service.getBoards(map).enqueue(new HdlRawCallback<DiscoverySpecialBean>() {
            @Override
            protected void onSuccess(DiscoverySpecialBean bean) {
                List<DiscoverySpecialBean.SpecialBean> data=bean.list;
                adapter.setDataList(data);
                adapter.notifyDataSetChanged();
            }
            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getContext(), "failed:" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
