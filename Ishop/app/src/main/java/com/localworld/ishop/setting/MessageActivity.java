package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.localworld.ishop.R;

public class MessageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_setting_message);
        initNav();
        initView();
    }

    private void initNav() {
        ImageView mBack = findViewById(R.id.iv_setting_messagebacktomian);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        LinearLayout mSend = findViewById(R.id.layout_setting_setting_message_send);
        final LinearLayout mVoice = findViewById(R.id.layout_setting_setting_message_voice);
        final ImageView mSendYes = findViewById(R.id.iv_setting_setting_message_sendyes);
        final ImageView mSendNo = findViewById(R.id.iv_setting_setting_message_sendno);
        final ImageView mVoiceYes = findViewById(R.id.iv_setting_setting_message_voiceyes);
        final ImageView mVoiceNo = findViewById(R.id.iv_setting_setting_message_voiceno);

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mSendYes.getVisibility()==View.VISIBLE && mSendNo.getVisibility()==View.GONE){
                    mSendYes.setVisibility(View.GONE);
                    mSendNo.setVisibility(View.VISIBLE);
                }else {
                    mSendYes.setVisibility(View.VISIBLE);
                    mSendNo.setVisibility(View.GONE);
                }
            }
        });

        mVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mVoiceYes.getVisibility()==View.VISIBLE && mVoiceNo.getVisibility()==View.GONE){
                    mVoiceYes.setVisibility(View.GONE);
                    mVoiceNo.setVisibility(View.VISIBLE);
                }else {
                    mVoiceYes.setVisibility(View.VISIBLE);
                    mVoiceNo.setVisibility(View.GONE);
                }
            }
        });
    }
}
