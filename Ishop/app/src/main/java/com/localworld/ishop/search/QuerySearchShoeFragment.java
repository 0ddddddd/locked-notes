package com.localworld.ishop.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.search.adapter.SearchShoeRecycleAdapter;

public class QuerySearchShoeFragment extends Fragment {

    private View view;

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment_search_type_list,null);

        initView();

        return view;
    }

    private void initView() {
        recyclerView= view.findViewById(R.id.rv_search_types);
        SearchShoeRecycleAdapter adapter = new SearchShoeRecycleAdapter(getActivity());
        recyclerView.setLayoutManager(new  LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
            adapter.setClickListener(new SearchShoeRecycleAdapter.ItemClickListener(){
            @Override
            public void OnItemClick(View view, int position) {
               // Log.e("-----Item clicked-----",String.valueOf(position));

                String tstring = ((TextView) view.findViewById(R.id.tv_search_types)).getText().toString();
                Toast.makeText(getActivity(), "搜索 " + tstring , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SearchGoodsFragment.class);
                intent.putExtra("title",tstring);
                getActivity().startActivity(intent);

                }
             });
    }
}