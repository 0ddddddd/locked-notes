package com.localworld.ishop.home.viewholder;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.home.bean.DiscoveryPopularityBean;
import com.localworld.ishop.model.AddCart;
import com.localworld.ishop.model.AddCartDetail;

public class DiscoveryPopularityAuthorVH extends BaseViewHolder<DiscoveryPopularityBean.PopularityBean> implements View.OnClickListener {
    private ISImageView authorIV,authorheadIV;
    private ImageView collectIV;
    private LinearLayout moreIV;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);
    private Context context;
    private boolean flag=true;

    public DiscoveryPopularityAuthorVH(View view) {
        super(view);
        context=view.getContext();
        authorIV = view.findViewById(R.id.iv_discovery_popularity);
        authorheadIV = view.findViewById(R.id.iv_discovery_popularity_author);
        collectIV = view.findViewById(R.id.iv_discovery_popularity_collect);
        moreIV = view.findViewById(R.id.iv_discovery_popularity_more);
    }

    @Override
    public void bind(DiscoveryPopularityBean.PopularityBean bean) {
        authorIV.showImage(bean.contentPic);
        authorheadIV.showImage(bean.headPics);
        authorIV.setOnClickListener(this);
        authorheadIV.setOnClickListener(this);
        collectIV.setOnClickListener(this);
        moreIV.setOnClickListener(this);
    }

    private void AddCart() {
        AddCartDetail request=new AddCartDetail();
        request.goodsid=64;
        request.num=2;
        service.AddCart(request).enqueue(new HdlRawCallback<AddCart>() {
            @Override
            protected void onSuccess(AddCart bean) {
                Toast.makeText(context, "成功添加到购物车！", Toast.LENGTH_SHORT).show();
            }
            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(context, "failed:" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void DeleteCart(){
        service.DeleteCart(64).enqueue(new HdlRawCallback<String>() {
            @Override
            protected void onSuccess(String deleteCart) {
                Toast.makeText(context, "成功删除购物车！", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(context, "failed:" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_discovery_popularity:

                break;
            case R.id.iv_discovery_popularity_author:
                DeleteCart();
                break;
            case R.id.iv_discovery_popularity_collect:
                if(flag){
                    collectIV.setImageResource(R.drawable.ipole_icon_40);
                    flag=false;
                    AddCart();
                }
                else {
                    collectIV.setImageResource(R.drawable.ipole_icon_39);
                    flag=true;
                }
                break;
            case R.id.iv_discovery_popularity_more:
                final AlertDialog dialog = new AlertDialog.Builder(view.getContext(), R.style.dialog1).create();
                dialog.show();
                View view1 = View.inflate(view.getContext(), R.layout.dialog_discovery_popularity_more, null);
                TextView shareTV = (TextView) view1.findViewById(R.id.home_discovery_more_share);
                TextView copylinkTV = (TextView) view1.findViewById(R.id.home_discovery_more_copylink);
                TextView reportTV = (TextView) view1.findViewById(R.id.home_discovery_more_report);
                TextView reduceTV = (TextView) view1.findViewById(R.id.home_discovery_more_reduce);
                TextView cancelTV = (TextView) view1.findViewById(R.id.home_discovery_more_cancel);

                Window window = dialog.getWindow();//获取当前的Window对象，然后下面进行窗口属性的设置
                window.setContentView(view1);//加载布局，view是填充自定义菜单布局xml 得到的
                window.setBackgroundDrawableResource(R.drawable.ipole_allradius);
                window.setGravity(Gravity.BOTTOM);//这个也很重要，将弹出菜单的位置设置为底部
                window.setWindowAnimations(R.style.shopuser_bottom_mune_style);//菜单进入和退出屏幕的动画，实现了上下滑动的动画效果
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置菜单的尺寸
                WindowManager.LayoutParams windowParams = window.getAttributes();
                windowParams.dimAmount = 0.5f;
                windowParams.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                window.setAttributes(windowParams);
                cancelTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }

                });
                break;
            default:
                break;
        }
    }
}
