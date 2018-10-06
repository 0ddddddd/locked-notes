package com.localworld.ishop.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.search.adapter.SearchGoodsRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchGoodsFragment extends AppCompatActivity{
    private Button mbackbtn;
    private TextView title;
    private List<SlidSpic> mlist = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_goods_list);

        initData();
        initView();

    }
    public void initView(){

        RecyclerView recyclerView = findViewById(R.id.rv_search_goods_list);
        mbackbtn = findViewById(R.id.btn_search_back);
        title = findViewById(R.id.tv_title_search_result);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        SearchGoodsRecycleAdapter adapter = new SearchGoodsRecycleAdapter(mlist);
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(new SearchGoodsRecycleAdapter.ItemClickListener(){
            @Override
            public void OnItemClick(View view, int position) {
                // Log.e("-----Item clicked-----",String.valueOf(position));
                Toast.makeText(view.getContext(), "Item " + position + " clicked:", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(view.getContext(), SearchGoodsFragment.class);
//                view.getContext().startActivity(intent);
            }
        });
        mbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        String mTitle = intent.getStringExtra("title");
        title.setText(mTitle);
    }

    public void initData(){
        for(int i =0 ;i<8 ;i++){
            SlidSpic goods0 = new SlidSpic(R.drawable.img_search_samp01);
            SlidSpic goods1 = new SlidSpic(R.drawable.img_search_samp03);
            SlidSpic goods2 = new SlidSpic(R.drawable.img_search_samp02);
            mlist.add(goods0);
            mlist.add(goods1);
            mlist.add(goods2);
            mlist.add(goods1);
        }

    }
}
