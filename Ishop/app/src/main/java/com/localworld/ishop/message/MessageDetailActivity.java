package com.localworld.ishop.message;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.localworld.ishop.R;
import com.localworld.ishop.message.adapter.ChatDetailAdapter;
import com.localworld.ishop.message.adapter.TipsView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RequiresApi(api = Build.VERSION_CODES.O)
public class MessageDetailActivity extends AppCompatActivity {
    private Button camera;
    private EditText inputText;
    private ImageButton send;
    private Button back;
    private Button reportBtn;
    private RecyclerView mRecyclerView;
    private ChatDetailAdapter adapter;
    private List<ChatMessage> mChatMessages = new ArrayList<>();
    private PopupWindow mPopupWindow;
    private TipsView mTipsView;
    private TextView title;
    private ImageView chatObj;
    private ImageView leftImg;
    int resource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        initMsgs();
        initViews();
        Intent intent = getIntent();
        String mchatObjName = intent.getStringExtra("chatObjName");
        title.setText(mchatObjName);
        resource =intent.getIntExtra("chatObjImg",R.drawable.ic_msg_p1);
        chatObj.setImageResource(resource);

    }
    private void initViews(){
        chatObj = findViewById(R.id.iv_message_title);
        title = findViewById(R.id.tv_message_chatobj_name);
        inputText = (EditText) findViewById(R.id.edit_message_edittext);
        send = (ImageButton) findViewById(R.id.btn_message_send);
        back = (Button) findViewById(R.id.btn_message_back);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_message_detail);
        reportBtn = findViewById(R.id.btn_message_report);
        // camera = findViewById(R.id.btn_message_camera);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new ChatDetailAdapter(mChatMessages);
        mRecyclerView.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    ChatMessage chatMessage;
                    chatMessage = new ChatMessage(content, ChatMessage.TYPE_SENT, getSysTime(),resource);
                    mChatMessages.add(chatMessage);
                    adapter.notifyItemInserted(mChatMessages.size() - 1);
                    mRecyclerView.scrollToPosition(mChatMessages.size() - 1);
                    inputText.setText("");
                }
            }
        });
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTips();

            }
        });



    }

    private void initMsgs() {

        Date date1 = new Date(getSysTime());
        Date date = new Date(date1.getTime() - 24 * 60 * 60 * 1000);
        Intent intent = getIntent();
        resource =intent.getIntExtra("chatObjImg",R.drawable.ic_msg_p1);
        String lastMsg = intent.getStringExtra("chatObjMsg");

        ChatMessage message1 = new ChatMessage(lastMsg, ChatMessage.TYPE_RECEIVED, getSysTime(),resource);

        ChatMessage message2 = new ChatMessage("How are u", ChatMessage.TYPE_SENT, date.getTime(),resource);

        ChatMessage message3 = new ChatMessage("Let's take a meal", ChatMessage.TYPE_RECEIVED, 88345677888L,resource);
        mChatMessages.add(message3);
        mChatMessages.add(message2);
        mChatMessages.add(message1);
    }

    private void showTips() {

        if (mTipsView == null) {
            mTipsView = new TipsView(this);
            mPopupWindow = new PopupWindow(mTipsView, RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT, true);
            // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
            mPopupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color
                    .transparent));
            mPopupWindow.setFocusable(true);
            mPopupWindow.setOutsideTouchable(true);

        }


        if (mPopupWindow.isShowing()) {
            return;
        }
        //设置背景颜色变暗
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().setAttributes(lp);

        // 设置好参数之后再show
        int local[] = new int[2];
        //弹出控件的位置，坐标存在local数组
        reportBtn.getLocationOnScreen(local);

        int width = mTipsView.getWidth();
        int height = mTipsView.getHeight();
        if (width == 0 || height == 0) {
            // 获取测量后的宽度
            int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            mTipsView.measure(w, h);
            //   width = mTipsView.getMeasuredWidth();
            //   height = mTipsView.getMeasuredHeight();
        }

        // x坐标计算方式：控件的x坐标加上他的长度一半（相当于控件的横向居中位置）
        // ，再减少弹出气泡宽度的一半（相当于向左移动气泡一半的宽度，就居中显示在控件下了）
        // int x = local[0] + (reportBtn.getWidth() / 2) - width / 2;
        // y坐标计算方式：控件的y坐标减去气泡的高度
        // int y = local[1] - height;
        // 通过绝对位置显示
        /* @param parent a parent view to get the {@link android.view.View#getWindowToken()} token from
         * @param gravity the gravity which controls the placement of the popup window
         * @param x the popup's x location offset
         * @param y the popup's y location offset
         */
        // public void showAtLocation(View parent, int gravity, int x, int y)
        //mPopupWindow.showAtLocation(reportBtn, Gravity.NO_GRAVITY, x, y);
        mPopupWindow.showAsDropDown(reportBtn);
        //监听pop的dismiss，设置背景颜色变亮

        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
    }


    private Long getSysTime() {
        return System.currentTimeMillis();
    }


}
