package com.localworld.ishop.home.viewholder;

import android.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.home.bean.DiscoveryFriendsBean;

public class DiscoveryFriendsVH extends BaseViewHolder<DiscoveryFriendsBean> implements View.OnClickListener{
    private ISImageView firendsiv;
    private ImageView collectiv;
    private LinearLayout ivmore;

    public DiscoveryFriendsVH(View view){
        super(view);
        firendsiv=view.findViewById(R.id.iv_discovery_friends);
        ivmore=view.findViewById(R.id.iv_discovery_friends_more);
        collectiv=view.findViewById(R.id.iv_discovery_friends_collect);
        collectiv.setOnClickListener(this);
        ivmore.setOnClickListener(this);
    }

    @Override
    public void bind(DiscoveryFriendsBean bean){

        firendsiv.showImage(bean.picPath);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_discovery_friends_more:
                final AlertDialog dialog=new AlertDialog.Builder(view.getContext(),R.style.dialog1).create();
                dialog.show();
                View view1=View.inflate(view.getContext(), R.layout.dialog_discovery_popularity_more, null);
                TextView shareTV=(TextView)view1.findViewById(R.id.home_discovery_more_share);
                TextView copylinkTV=(TextView)view1.findViewById(R.id.home_discovery_more_copylink);
                TextView reportTV=(TextView)view1.findViewById(R.id.home_discovery_more_report);
                TextView reduceTV=(TextView)view1.findViewById(R.id.home_discovery_more_reduce);
                TextView cancelTV=(TextView)view1.findViewById(R.id.home_discovery_more_cancel);

                Window window = dialog.getWindow();//获取当前的Window对象，然后下面进行窗口属性的设置
                window.setContentView(view1);//加载布局，view是填充自定义菜单布局xml 得到的
                window.setBackgroundDrawableResource(R.drawable.ipole_allradius);
                window.setGravity(Gravity.BOTTOM);//这个也很重要，将弹出菜单的位置设置为底部
                window.setWindowAnimations(R.style.shopuser_bottom_mune_style);//菜单进入和退出屏幕的动画，实现了上下滑动的动画效果
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置菜单的尺寸
                cancelTV.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        dialog.dismiss();
                    }

                });
                break;

            case R.id.iv_discovery_friends_collect:
                collectiv.setImageResource(R.drawable.ipole_icon_40);
                break;
        }
    }

}
