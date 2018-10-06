package com.localworld.ishop.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.message.ChatObj;
import com.localworld.ishop.message.adapter.ChatObjAdapter;
//<<<<<<< HEAD
//import com.localworld.ipole.message.util.PopupWindowUtil;
////import com.localworld.ipole.order.CheckOrder;
//=======
//>>>>>>> 4ce19a8181df06d4b047cae1790a7178ef39826a

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 主界面 消息列表
 */
public class MessageFragment extends BaseSupportFragment {

    private List<ChatObj> chatObjList = new ArrayList<>();
    private HashSet<Integer> positionSet;
    LinearLayout layoutBottom;
    public boolean isShow = false;
    private boolean isSelectAll;
    LinearLayout selectAll;
    LinearLayout del;
    ChatObjAdapter adapter;
    CheckBox select;
    Boolean mChecked = false;
    Button backBtn;

    public static MessageFragment newInstance() {
        Bundle args = new Bundle();
        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home_message, container, false);
        initChatObj();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_message);
        backBtn = rootView.findViewById(R.id.btn_toolbar_message_back);
        layoutBottom = (LinearLayout) rootView.findViewById(R.id.layout_message_bottom);
        selectAll = rootView.findViewById(R.id.tv_message_selectAll);
        del = rootView.findViewById(R.id.btn_message_del);
        select = rootView.findViewById(R.id.check_message_all);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChatObjAdapter(getContext(), chatObjList);
        setListener();
        recyclerView.setAdapter(adapter);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ((HomeActivity) getActivity()).hideToolbar();
        super.onViewCreated(view, savedInstanceState);
    }

    private void setListener() {

        adapter.setOnPopItemListener(new ChatObjAdapter.OnPopItemListener() {

            @Override
            public void checkBoxClick(int position) {
                //已经有Item被选择,执行添加或删除操作
                addOrRemove(position);
            }

            @Override
            public void onItemClick(View view, int position) {
                //触发Item的单击事件
                //    Toast.makeText(this,String.format(getString(R.string.app_name),position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPopItemClick(View view, int position) {
                if (!isShow) {
                    isShow = true;
                    ((HomeActivity) getActivity()).hideBottomBar();
                    backBtn.animate().alpha(1.0f).setDuration(500).start();
                    layoutBottom.animate()
                            .alpha(1.0f)
                            .translationY(0)
                            .setDuration(500).start();
                    ((CheckBox) view.findViewById(R.id.check_message)).setChecked(true);
                    chatObjList.get(position).isSelect = true;
                    positionSet.add(position);
                }
                else {
                    isShow = false;
                    layoutBottom.animate()
                            .alpha(0.0f)
                            .translationY(0)
                            .setDuration(500).start();
                }
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectAll();
                select.setChecked(!mChecked);
                mChecked =!mChecked;
            }
        });
        selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectAll();
                select.setChecked(!mChecked);
                mChecked = !mChecked;
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isShow)
                    clearAll();
            }
        });

    }
    private void addOrRemove(int position) {
        if(positionSet.contains(position)) {
            // 如果包含，则撤销选择
            positionSet.remove(position);
        } else {
            // 如果不包含，则添加
            positionSet.add(position);
        }
    }
    /**
     * 删除
     */
    void delete() {
        HashSet<ChatObj> valueSet = new HashSet<>();
        for (Integer integer : positionSet) {
            valueSet.add(adapter.getItem(integer));
        }
        for (ChatObj itemModel : valueSet) {
            adapter.remove(itemModel);
        }
        adapter.notifyDataSetChanged();
        positionSet.clear();
    }

    /**
     * 全选
     */

    void selectAll() {
        if(!isSelectAll) {
            isSelectAll = true;
            for (int i = 0; i < chatObjList.size(); i++) {
                chatObjList.get(i).isSelect = true;
                positionSet.add(i);
            }
            adapter.notifyDataSetChanged();
        } else {
            isSelectAll = false;
            for (int i = 0; i < chatObjList.size(); i++) {
                chatObjList.get(i).isSelect = false;
                positionSet.remove(i);
            }
            adapter.notifyDataSetChanged();
        }
    }

    /*
    * 返回时清空
    */
    void clearAll(){
        //初始化判断数据
        ((HomeActivity) getActivity()).showBottomBar();
        mChecked = false ;
        isSelectAll = false ;
        isShow = false;
        adapter.isShow = false;
        select.setChecked(false);
        for (int i = 0; i < chatObjList.size(); i++) {
            chatObjList.get(i).isSelect = false;
            positionSet.remove(i);
        }
        positionSet.clear();
        layoutBottom.animate()
                .alpha(0.0f)
                .translationYBy(0)
                .start();
        backBtn.animate().alpha(0.0f).start();
        adapter.notifyDataSetChanged();

    }




    private void initChatObj() {
        for (int i = 0; i < 1; i++) {
            ChatObj person1 = new ChatObj("Ludwig van Beethvoen", R.drawable.ic_msg_p1, "11:46", "Hellop");
            chatObjList.add(person1);
            ChatObj person2 = new ChatObj("周树人", R.drawable.ic_msg_p2, "10:13", "呵，男人");
            chatObjList.add(person2);
            ChatObj person3 = new ChatObj("金馆长", R.drawable.ic_msg_p3, "18:11", "哈哈哈哈哈哈");
            chatObjList.add(person3);
            ChatObj person4 = new ChatObj("Billy", R.drawable.ic_msg_p4, "21:23", "哲♂学");
            chatObjList.add(person4);
            ChatObj person5 = new ChatObj("RichardMilos", R.drawable.ic_msg_p5, "10:51", "自由");
            chatObjList.add(person5);
            ChatObj person6 = new ChatObj("张学友", R.drawable.ic_msg_p6, "08:03", "嘿！");
            chatObjList.add(person6);
            ChatObj person7 = new ChatObj("D'Angelo Dinero", R.drawable.ic_msg_p7, "18:21", "Come on！");
            chatObjList.add(person7);

            positionSet =  new HashSet<>();
        }


    }
}
