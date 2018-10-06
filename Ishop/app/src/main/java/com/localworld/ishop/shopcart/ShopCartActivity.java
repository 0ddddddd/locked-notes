package com.localworld.ishop.shopcart;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportActivity;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.model.Order;
import com.localworld.ishop.model.util.MoreUtils;
import com.localworld.ishop.shopcart.adapter.ShopAdapter;

import java.util.ArrayList;
import java.util.List;



public class ShopCartActivity extends BaseSupportActivity implements View.OnClickListener{

    private List<Order> mockDataList = new ArrayList<>();
    private List<Order> moreDataList;
    private ImageView selectAllImg;
    private TextView totalPrice,purchase,openvip,continuebuy;
    private ShopAdapter shopAdapter;
    private RecyclerView recyclerView;
    private double allPrice=0;
    private Toolbar mToolbar;
    private View back,edit;
    private ISNetService service= HdlCore.getInstance().getService(ISNetService.class);

    private boolean selectAll=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);
        initView();
        initToolbar();

        shopAdapter.setOnDelListener(new ShopAdapter.onSwipeListener() {
            @Override
            public void onDel(int pos) {
                if (pos >= 0 && pos < mockDataList.size()) {
                    //Toast.makeText(getContext(), "删除:" + pos, Toast.LENGTH_SHORT).show();
                    mockDataList.remove(pos);
                    allPrice = 0;
                    for (int i = 0; i < mockDataList.size(); i++) {
                        if (mockDataList.get(i).isSelectGoods() == true) {
                            allPrice += mockDataList.get(i).getPrice() * mockDataList.get(i).getNum();
                        }
                    }
                    totalPrice.setText(String.valueOf(allPrice));
                    shopAdapter.setMockShopList(mockDataList);
                    //shopAdapter.notifyItemRemoved(pos);//推荐用这个
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
                    //mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTop(int pos) {

            }

            public void shopList(List<Order> shopList){
                mockDataList.clear();
                mockDataList.addAll(shopList);
                boolean chooseAll=true;
                allPrice=0;
                for (int i=0;i<mockDataList.size();i++){
                    if (mockDataList.get(i).isSelectGoods()==true){
                        allPrice+=mockDataList.get(i).getPrice()*mockDataList.get(i).getNum();
                    }else if (mockDataList.get(i).isSelectGoods()==false){
                        chooseAll=false;
                    }
                }
                if (chooseAll==true){
                    selectAllImg.setImageResource(R.drawable.ipole_icon_checkbox_dark);
                }else{
                    selectAllImg.setImageResource(R.drawable.ipole_icon_38);
                }
                totalPrice.setText(String.valueOf(allPrice));
            }

        });
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar_shopcart);
        setSupportActionBar(mToolbar);

        //自定义顶部栏
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.ime_base_toolbar_shoppingcart, null, false);
            supportActionBar.setCustomView(layout);
            supportActionBar.setDisplayShowCustomEnabled(true);
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.setDisplayShowTitleEnabled(false);
            //自定义view完全填充toolbar
            Toolbar parent = (Toolbar) layout.getParent();
            parent.setContentInsetsAbsolute(0, 0);

            back=findViewById(R.id.iv_toolbar_shoppingcart_back);
            edit=findViewById(R.id.iv_toolbar_shoppingcart_edit);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }


    public void initView(){
        //mockDataList=ShopMockUtils.getMockHomeDataList();
        recyclerView=(RecyclerView)findViewById(R.id.rv_shop);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        shopAdapter=new ShopAdapter();
        recyclerView.setAdapter(shopAdapter);
        getCartList();


        moreDataList= MoreUtils.getMockHomeDataList();
        ShopAdapter moreAdapter=new ShopAdapter();
        RecyclerView gridRecyclerView=(RecyclerView)findViewById(R.id.rv_shop_image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridRecyclerView.setLayoutManager(gridLayoutManager);
        gridRecyclerView.setAdapter(moreAdapter);
        moreAdapter.setMoreShopList(moreDataList);

        totalPrice=(TextView)findViewById(R.id.fragment_home_shop_totalprice);
        selectAllImg=findViewById(R.id.fragment_home_shop_selectall);
        purchase=findViewById(R.id.tv_home_purchase_item);
        selectAllImg.setOnClickListener(this);
        purchase.setOnClickListener(this);
    }

    private void getCartList() {
        service.getCartList().enqueue(new HdlRawCallback<List<Order>>() {
            @Override
            protected void onSuccess(List<Order> bean) {
                mockDataList.addAll(bean);
                shopAdapter.setMockShopList(mockDataList);
                shopAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "succeed", Toast.LENGTH_SHORT).show();
            }
            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getApplicationContext(), "failed:" + msg, Toast.LENGTH_SHORT).show();

            }
        });
    }



    @Override
    public void onClick(View view) {
        allPrice=0;
        switch(view.getId()) {
            //跳转购买界面
            case R.id.tv_home_purchase_item:
                final AlertDialog dialog = new AlertDialog.Builder(view.getContext()).create();
                dialog.show();
                View view1=View.inflate(view.getContext(), R.layout.dialog_shoppingcart_buy_vip, null);
                openvip=view1.findViewById(R.id.goods_buy_vip_open);
                continuebuy=view1.findViewById(R.id.goods_buy_vip_continue);
                Window window = dialog.getWindow();//获取当前的Window对象，然后下面进行窗口属性的设置
                window.setContentView(view1);//加载布局，view是填充自定义菜单布局xml 得到的
                window.setBackgroundDrawableResource(R.drawable.ipole_allradius);
                window.setGravity(Gravity.BOTTOM);//这个也很重要，将弹出菜单的位置设置为底部
                window.setWindowAnimations(R.style.shopuser_bottom_mune_style);//菜单进入和退出屏幕的动画，实现了上下滑动的动画效果
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置菜单的尺寸
                continuebuy.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
//                        Intent intent=new Intent(v.getContext(),PaymentActivity.class);
//                        startActivity(intent);
                    }

                });
                break;
            case R.id.fragment_home_shop_selectall:
                if (selectAll==false) {
                    selectAll=true;
                    allPrice=0;
                    for (int i=0;i<mockDataList.size();i++){
                        mockDataList.get(i).setSelectShop(true);
                        mockDataList.get(i).setSelectGoods(true);
                        allPrice+=mockDataList.get(i).getPrice()*mockDataList.get(i).getNum();
                    }
                    shopAdapter.setMockShopList(mockDataList);
                    totalPrice.setText(String.valueOf(allPrice));
                    selectAllImg.setImageResource(R.drawable.ipole_icon_checkbox_dark);
                }else {
                    selectAll=false;
                    for (int i=0;i<mockDataList.size();i++){
                        mockDataList.get(i).setSelectShop(false);
                        mockDataList.get(i).setSelectGoods(false);
                    }
                    shopAdapter.setMockShopList(mockDataList);
                    totalPrice.setText(String.valueOf(0.0));
                    selectAllImg.setImageResource(R.drawable.ipole_icon_38);
                }
                break;
            default:
                break;
        }
    }
}