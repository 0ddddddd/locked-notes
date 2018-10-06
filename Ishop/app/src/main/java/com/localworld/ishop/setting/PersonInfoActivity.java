package com.localworld.ishop.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.adapter.NewSettingMockUtils;
import com.localworld.ishop.setting.bean.PersonInfoBean;

public class PersonInfoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_personinfo_set);
        initPersonInfo();
    }

    private void initPersonInfo(){

        PersonInfoBean mPersonInfoBean;
        ImageView mBack;
        ISImageView mHeadPic;
        EditText mNickName;
        EditText mAccountNum;
        EditText mSex;
        EditText mPersonIntroduce;
        EditText mPlace;
        EditText mEmail;
        EditText mPhoneNum;
        LinearLayout mMyAddress;

        mPersonInfoBean = NewSettingMockUtils.getPersonInfoBean();

        mBack = findViewById(R.id.iv_setting_personinfo_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mHeadPic = findViewById(R.id.iv_setting_exchangeheadpic);
        mHeadPic.showImage(mPersonInfoBean.accountNum);

        mNickName = findViewById(R.id.tv_setting_nickname);
        mPersonInfoBean.nickName = mNickName.getText().toString();
        mNickName.setText(mPersonInfoBean.nickName);

        mAccountNum = findViewById(R.id.tv_setting_accountnumber);
        mPersonInfoBean.accountNum = mAccountNum.getText().toString();
        mAccountNum.setText(mPersonInfoBean.accountNum);

        mSex = findViewById(R.id.tv_setting_sex);
        mPersonInfoBean.sex = mSex.getText().toString();
        mSex.setText(mPersonInfoBean.sex);

        mPersonIntroduce = findViewById(R.id.tv_setting_personintroduce);
        mPersonInfoBean.personIntroduce = mPersonIntroduce.getText().toString();
        mPersonIntroduce.setText(mPersonInfoBean.personIntroduce);

        mPlace = findViewById(R.id.tv_setting_place);
        mPersonInfoBean.place = mPlace.getText().toString();
        mPlace.setText(mPersonInfoBean.place);

        mEmail = findViewById(R.id.tv_setting_email);
        mPersonInfoBean.email = mEmail.getText().toString();
        mEmail.setText(mPersonInfoBean.email);

        mPhoneNum = findViewById(R.id.tv_setting_phonenumber);
        mPersonInfoBean.phoneNum = mPhoneNum.getText().toString();
        mPhoneNum.setText(mPersonInfoBean.phoneNum);

        mMyAddress = findViewById(R.id.layout_setting_myaddress);
        mMyAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonInfoActivity.this,MyAddressActivity.class);
                startActivity(intent);
            }
        });
    }
}
