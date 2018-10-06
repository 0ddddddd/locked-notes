package com.localworld.ishop.home.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
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
import com.localworld.ishop.home.adapter.SpanHelper;
import com.localworld.ishop.home.bean.DiscoveryPopularityBean;

import java.util.List;

public class DiscoveryPopularityFragment extends BaseSupportFragment {
    private NestedRecyclerView recyclerView;
    private DiscoveryPopularityAdapter adapter;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);

    public static DiscoveryPopularityFragment newInstance() {
        Bundle args = new Bundle();
        DiscoveryPopularityFragment discoveryFragmentPopular = new DiscoveryPopularityFragment();
        discoveryFragmentPopular.setArguments(args);
        return discoveryFragmentPopular;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_discovery_popularity, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.rcv_discovery_fragment_popularity);
        adapter = new DiscoveryPopularityAdapter();

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new SpanHelper(adapter, 2));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        getPopularList();
    }

    /*private void loadData() {

        List<BaseHomeBean> data = NewDiscoveryPopularityMockUtils.getList();

        adapter.setDataList(data);
        adapter.notifyDataSetChanged();
    }
*/
    private void getPopularList() {
        service.getPopularList().enqueue(new HdlRawCallback<DiscoveryPopularityBean>() {
            @Override
            protected void onSuccess(DiscoveryPopularityBean bean) {
                List<DiscoveryPopularityBean.PopularityBean> data=bean.list;
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
