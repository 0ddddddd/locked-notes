package com.localworld.ishop.home.viewholder;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.home.bean.HomeBannersBean;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;


public class HomeBannerVH extends BaseViewHolder<HomeBannersBean> {
    private ISImageView mBannerIv;
    private List<HomeBannersBean.BannerBean>list;
    private ViewPager viewPager;
    private List<ImageView> tips;
    private LinearLayout pointdetail;
    private Context context;
    private ImagePageAdapter mAdapter = new ImagePageAdapter();
    private int lastposition;

    //轮播计时设置
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(android.os.Message msg) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            handler.sendEmptyMessageDelayed(0, 4000);
        }
    };

    public HomeBannerVH(View itemView) {
        super(itemView);
        context=itemView.getContext();
        viewPager = itemView.findViewById(R.id.vp_home_banner_list);
        pointdetail=itemView.findViewById(R.id.home_banner_point);
    }

    @Override
    public void bind(HomeBannersBean bean) {
        list = bean.banners;
        mAdapter.setDataList(list);
        for(int i=0;i<list.size();i++){
            // 添加指示小点
            ImageView point = new ImageView(context);
            LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(30,30);
            point.setBackgroundResource(R.drawable.ipole_selector_home_index_pointchange);
            point.setLayoutParams(layoutparams);
            if(i==0){
                point.setSelected(true);
            }
            else {
                point.setSelected(false);
                layoutparams.leftMargin=20;;
            }
            pointdetail.addView(point);
        }
        lastposition=0;

        mAdapter.notifyDataSetChanged();
        viewPager.setAdapter(mAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                int newposition=position%list.size();
                pointdetail.getChildAt(newposition).setSelected(true);
                pointdetail.getChildAt(lastposition).setSelected(false);
                lastposition=newposition;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
            //覆写该方法实现轮播效果
        });
        int centerValue = Integer.MAX_VALUE / 2;
        int value = centerValue % list.size();
        //设置viewPager的第一页为最大整数的中间数，实现伪无限循环
        viewPager.setCurrentItem(centerValue - value);
        handler.sendEmptyMessageDelayed(0, 4000);
    }


    public class ImagePageAdapter extends PagerAdapter{
        private List<HomeBannersBean.BannerBean> mDataList = new ArrayList<>();
        public void setDataList(List<HomeBannersBean.BannerBean> list) {
            mDataList.clear();
            mDataList.addAll(list);
        }

        public ImagePageAdapter(){

        }

        @Override
        public int getCount() {
            //设置成最大，使无限循环
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //对Viewpager页号求模去除View列表中要显示的项
            View view = View.inflate(container.getContext(), R.layout.view_home_banner_item, null);
            ISImageView ISImageView = (ISImageView) view.findViewById(R.id.iv_home_banner_item);
            HomeBannersBean.BannerBean bannerBean =list .get(position%list.size());
            ISImageView.showImage(bannerBean.picPath);
            container.addView(view);
            return view;
        }


    }
}

    /*public class HomeBannerAdapter extends RecyclerView.Adapter<HomeBannerItemVH>{

        private List<HomeBannersBean.BannerBean> mDataList = new ArrayList<>();

        public void setDataList(List<HomeBannersBean.BannerBean> list) {
            mDataList.clear();
            mDataList.addAll(list);
        }

        @Override
        public HomeBannerItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_home_banner_item, parent, false);
            return new HomeBannerItemVH(view);
        }

        @Override
        public void onBindViewHolder(HomeBannerItemVH holder, int position) {
            holder.bind(mDataList.get(position));
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }
    }
}*/
