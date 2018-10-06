package com.example.qiangqiang.ldnotebookapplication;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 */
public class LDSettingFragment extends Fragment implements View.OnClickListener {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private RelativeLayout relativeLayout;
    private Toolbar mToolbar;
    private String BACK;

    // 2.1 定义用来与外部activity交互，获取到宿主activity
    private FragmentInteraction listterner;


    // 1 定义了所有activity必须实现的接口方法
    public interface FragmentInteraction {
        void process(String str);
    }

    // 当FRagmen被加载到activity的时候会被回调
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof FragmentInteraction) {
            listterner = (FragmentInteraction) activity; // 2.2 获取到宿主activity并赋值
        } else {
            throw new IllegalArgumentException("activity must implements FragmentInteraction");
        }
    }


    public LDSettingFragment() {
        // Required empty public constructor
    }


    //use Glide load images
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mToolbar = (Toolbar)getActivity().findViewById(R.id.id_toolbar);
        mToolbar.setTitle("Setting");
        View root = inflater.inflate(R.layout.fragment_ld_setting, container, false);
        imageView1 = (ImageView) root.findViewById(R.id.back1);
        imageView2 = (ImageView) root.findViewById(R.id.back2);
        imageView3 = (ImageView) root.findViewById(R.id.back3);
        imageView4 = (ImageView) root.findViewById(R.id.back4);
        //use glide load image
        Glide.with(this).load(R.drawable.background_main1).into(imageView1);
        Glide.with(this).load(R.drawable.background_main2).into(imageView2);
        Glide.with(this).load(R.drawable.background_main3).into(imageView3);
        Glide.with(this).load(R.drawable.background_main4).into(imageView4);
        mToolbar = (Toolbar) root.findViewById(R.id.id_toolbar);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        //relativeLayout = (RelativeLayout)root.findViewById(R.id.activity_main);
//        imageView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                relativeLayout = (RelativeLayout)v.findViewById(R.id.activity_main);
//                relativeLayout.setBackgroundResource(R.drawable.background_main1);
//                Intent intent = new Intent(getActivity(),MainActivity.class);
//                BACK = "first";
//                intent.putExtra("back",BACK);
//                startActivity(intent);
//                getActivity()
//            }
//        });
//        imageView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),MainActivity.class);
//                BACK = "second";
//                intent.putExtra("back",BACK);
//                startActivity(intent);
//            }
//        });

        return root;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.back1:
                listterner.process("one"); // 3.1 执行回调
                break;
            case R.id.back2:
                listterner.process("two");
                break;
            case R.id.back3:
                listterner.process("three");
                break;
            case R.id.back4:
                listterner.process("four");
                break;

        }
    }
    //把传递进来的activity对象释放掉
    @Override
    public void onDetach() {
        super.onDetach();
        listterner = null;
    }
}

