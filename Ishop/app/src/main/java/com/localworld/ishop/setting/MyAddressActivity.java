package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.setting.adapter.OtherAddressAdapter;
import com.localworld.ishop.setting.bean.OtherAddressBean;

import java.util.List;

public class MyAddressActivity extends AppCompatActivity {

    private OtherAddressAdapter otherAddressAdapter;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_myaddress);
        RecyclerView recyclerView = findViewById(R.id.recycler_setting_otheraddress);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        otherAddressAdapter = new OtherAddressAdapter();
        recyclerView.setAdapter(otherAddressAdapter);

       // initOtherAddress();

        requestData();
    }

    private void initDefaultAddress(OtherAddressBean bean) {
        TextView defaultName = findViewById(R.id.tv_setting_defaultnickname);
        defaultName.setText(bean.receiver);
        TextView defaultAddress = findViewById(R.id.tv_setting_defaultaddress);
        defaultAddress.setText(bean.address);
        TextView defaultPhone  =findViewById(R.id.tv_setting_defaultphonenumber);
        defaultPhone.setText(bean.mobile);
        ImageView back = findViewById(R.id.iv_setting_myaddress_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void requestData() {
        service.getMyAddressList().enqueue(new HdlRawCallback<List<OtherAddressBean>>() {

            @Override
            protected void onSuccess(List<OtherAddressBean> otherAddressBeans) {
                if(otherAddressBeans.size()==0){
                    return;
                }else{
                   /* if(otherAddressBean.addressBean.isDefault){
                        initDefaultAddress(otherAddressBean.addressBean);
                    }else{
                        initOtherAddress(otherAddressBean);
                    }*/
                    initOtherAddress(otherAddressBeans);
                }
            }

            @Override
            protected void onFailed(String msg, int status) {
                String toastString;
                if (TextUtils.isEmpty(msg)) {
                    toastString = "网络似乎有点问题！";
                } else {
                    toastString = msg;
                }
                Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initOtherAddress(List<OtherAddressBean> list){
/*        List<OtherAddressBean> data = OtherAddressTest.getTestOtherAddressList();
        otherAddressAdapter.setmOtherAddressBeanList(data);
        otherAddressAdapter.notifyDataSetChanged();*/
        List<OtherAddressBean> otherAddressList = list;
        otherAddressAdapter.setmOtherAddressBeanList(otherAddressList);
        otherAddressAdapter.notifyDataSetChanged();

    }
}
