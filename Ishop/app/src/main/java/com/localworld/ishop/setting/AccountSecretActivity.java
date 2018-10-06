package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.localworld.ishop.R;

public class AccountSecretActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_setting_accountsecret);
        initView();
    }

    private void initView() {
        LinearLayout mNoFind = findViewById(R.id.layout_setting_setting_accountsecret_nofind);
        LinearLayout mNoVisit = findViewById(R.id.layout_setting_setting_accountsecret_novisit);
        final ImageView mNoFindYes = findViewById(R.id.iv_setting_setting_accountsecret_nofindyes);
        final ImageView mNoFindNo = findViewById(R.id.iv_setting_setting_accountsecret_nofindno);
        final ImageView mNoVisitYes = findViewById(R.id.iv_setting_setting_accountsecret_novisityes);
        final ImageView mNoVisitNo = findViewById(R.id.iv_setting_setting_accountsecret_novisitno);

        mNoFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mNoFindYes.getVisibility()==View.VISIBLE && mNoFindNo.getVisibility()==View.GONE){
                    mNoFindYes.setVisibility(View.GONE);
                    mNoFindNo.setVisibility(View.VISIBLE);
                }else {
                    mNoFindYes.setVisibility(View.VISIBLE);
                    mNoFindNo.setVisibility(View.GONE);
                }
            }
        });

        mNoVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mNoVisitYes.getVisibility()==View.VISIBLE && mNoVisitNo.getVisibility()==View.GONE){
                    mNoVisitYes.setVisibility(View.GONE);
                    mNoVisitNo.setVisibility(View.VISIBLE);
                }else {
                    mNoVisitYes.setVisibility(View.VISIBLE);
                    mNoVisitNo.setVisibility(View.GONE);
                }
            }
        });

        ImageView mBack = findViewById(R.id.iv_setting_setting_accountsecret_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
