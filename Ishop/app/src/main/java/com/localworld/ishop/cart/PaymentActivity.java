package com.localworld.ishop.cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.cart.adapter.PaymentAdapter;
import com.localworld.ishop.cart.bean.PaymentBean;
import com.localworld.ishop.cart.bean.PaymentItemBean;
import com.localworld.ishop.model.goods.GoodsDetailModel;
import com.localworld.ishop.pay.PayService;
import com.localworld.ishop.pay.bean.CreateOrderResultBean;
import com.localworld.ishop.pay.request.CreateOrderRequest;
import com.pingplusplus.android.Pingpp;

import java.util.ArrayList;
import java.util.List;


public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {
    private List<PaymentItemBean> paymentBeanList = new ArrayList<>();
    private PaymentAdapter adapter;
    private PaymentBean paymentBean;
    private PaymentItemBean paymentItemBean;
    private LinearLayout discount;
    private ImageView discountYes;
    private ImageView discountNo;
    private FrameLayout pPoint;
    private FrameLayout aliPay;
    private FrameLayout weChat;
    private FrameLayout creditCard;
    private ImageView pPointCheck;
    private ImageView aliPayCheck;
    private ImageView weChatCheck;
    private ImageView creditCardCheck;
    PayService service = HdlCore.getInstance().getService(PayService.class);
    private GoodsDetailModel.GoodsBean mGoodsBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_payment);
        parseParams();
        loadData();
        RecyclerView recyclerView = findViewById(R.id.recycler_cart_payment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PaymentAdapter(paymentBeanList);
        recyclerView.setAdapter(adapter);
        initView();
    }

    private void parseParams() {
        mGoodsBean = (GoodsDetailModel.GoodsBean) getIntent().getSerializableExtra("data");
    }

    private void initView() {
        ImageView back = findViewById(R.id.iv_cart_payment_back);
        back.setOnClickListener(this);
        TextView address = findViewById(R.id.tv_cart_payment_address);
        address.setText(paymentBean.address);
        TextView mail = findViewById(R.id.tv_cart_payment_mail);
        mail.setText(paymentBean.mail);
        TextView man = findViewById(R.id.tv_cart_payment_man);
        man.setText(paymentBean.man);
        TextView phoneNumber = findViewById(R.id.tv_cart_payment_phonenumber);
        phoneNumber.setText(paymentBean.phoneNumber);
        TextView discountPrice = findViewById(R.id.tv_cart_payment_discountprice);
        discountPrice.setText(paymentBean.discountPrice);
        TextView finalPrice = findViewById(R.id.tv_cart_payment_finalprice);
        finalPrice.setText(paymentBean.finalPrice);
        TextView commitPay = findViewById(R.id.tv_cart_payment_commit);
        commitPay.setOnClickListener(this);
        discount = findViewById(R.id.layout_cart_payment_discount);
        discount.setOnClickListener(this);
        discountYes = findViewById(R.id.iv_cart_payment_discountyes);
        discountNo = findViewById(R.id.iv_cart_payment_discountno);

        pPoint = findViewById(R.id.frame_cart_payment_ppoint);
        pPoint.setOnClickListener(this);
        pPointCheck = findViewById(R.id.iv_cart_payment_ppoint);
        aliPay = findViewById(R.id.frame_cart_payment_alipay);
        aliPay.setOnClickListener(this);
        aliPayCheck = findViewById(R.id.iv_cart_payment_alipay);
        weChat = findViewById(R.id.frame_cart_payment_wechat);
        weChat.setOnClickListener(this);
        weChatCheck = findViewById(R.id.iv_cart_payment_wechat);
        creditCard = findViewById(R.id.frame_cart_payment_creditcard);
        creditCard.setOnClickListener(this);
        creditCardCheck = findViewById(R.id.iv_cart_payment_creditcard);

    }

    private void doAlipay() {
        if (mGoodsBean == null || TextUtils.isEmpty(mGoodsBean.id)) {
            return;
        }
        CreateOrderRequest request = new CreateOrderRequest();
        request.deliveryWayCode = "SF";
        request.receiveAddressId = 5;
        CreateOrderRequest.Order order = new CreateOrderRequest.Order();
        order.goodsId = Long.parseLong(mGoodsBean.id);
        order.num = 1;
        List<CreateOrderRequest.Order> list = new ArrayList<>();
        list.add(order);
        request.orders = list;
        service.createOrder(request).enqueue(new HdlRawCallback<CreateOrderResultBean>() {
            @Override
            protected void onSuccess(CreateOrderResultBean createOrderResultBean) {
                long orderId = createOrderResultBean.id;

                service.getPayCharge(String.valueOf(orderId)).enqueue(new HdlRawCallback<String>() {
                    @Override
                    protected void onSuccess(String s) {
                        Toast.makeText(PaymentActivity.this, s, Toast.LENGTH_LONG).show();
                        Pingpp.createPayment(PaymentActivity.this, s);
                    }

                    @Override
                    protected void onFailed(String msg, int status) {
                        Toast.makeText(PaymentActivity.this, "failed:" + msg, Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(PaymentActivity.this, "failed:" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //支付页面返回处理
        if (requestCode == Pingpp.REQUEST_CODE_PAYMENT) {
            String result = data.getExtras().getString("pay_result");
            /* 处理返回值
             * "success" - 支付成功
             * "fail"    - 支付失败
             * "cancel"  - 取消支付
             * "invalid" - 支付插件未安装（一般是微信客户端未安装的情况）
             * "unknown" - app进程异常被杀死(一般是低内存状态下,app进程被杀死)
             */
            String errorMsg = data.getExtras().getString("error_msg"); // 错误信息
            String extraMsg = data.getExtras().getString("extra_msg"); // 错误信息

            handleResult(result);
        }
    }

    private void handleResult(String result) {
        switch (result) {
            case "success":
                startActivity(new Intent(PaymentActivity.this, PaymentSuccessActivity.class));
                break;
            case "fail":
                startActivity(new Intent(PaymentActivity.this, PaymentFailActivity.class));
                break;
            default:
                break;
        }
    }

    private void loadData() {
        paymentBean = new PaymentBean();
        paymentBean.address = "lalaal";
        paymentBean.mail = "110";
        paymentBean.man = "Rose";
        paymentBean.phoneNumber = "120";
        paymentBean.discountPrice = "88888";
        paymentBean.finalPrice = "99999";

        for (int i = 0; i < 3; i++) {
            paymentItemBean = new PaymentItemBean();
            paymentItemBean.goodImg = "https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=29bbd61c3687e9505d17f56c203a531b/95eef01f3a292df57f4575cab0315c6035a8736f.jpg";
            paymentItemBean.goodName = "msms";
            paymentItemBean.goodNum = "2";
            paymentItemBean.goodInfo = "黄色";
            paymentItemBean.goodPrice = "20";
            paymentBeanList.add(paymentItemBean);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_cart_payment_commit:
                doAlipay();
                break;
            case R.id.iv_cart_payment_back:
                finish();
                break;
            case R.id.layout_cart_payment_discount:
                if (discountYes.getVisibility() == View.VISIBLE) {
                    discountYes.setVisibility(View.GONE);
                    discountNo.setVisibility(View.VISIBLE);
                    //todo 将优惠价格变为原始价格
                } else {
                    discountYes.setVisibility(View.VISIBLE);
                    discountNo.setVisibility(View.GONE);
                    //todo 将原始价格变为优惠价格
                }
                break;
            case R.id.frame_cart_payment_ppoint:
                if (pPointCheck.getVisibility() == View.INVISIBLE) {
                    pPointCheck.setVisibility(View.VISIBLE);
                    aliPayCheck.setVisibility(View.INVISIBLE);
                    weChatCheck.setVisibility(View.INVISIBLE);
                    creditCardCheck.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.frame_cart_payment_alipay:
                if (aliPayCheck.getVisibility() == View.INVISIBLE) {
                    aliPayCheck.setVisibility(View.VISIBLE);
                    pPointCheck.setVisibility(View.INVISIBLE);
                    weChatCheck.setVisibility(View.INVISIBLE);
                    creditCardCheck.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.frame_cart_payment_wechat:
                if (weChatCheck.getVisibility() == View.INVISIBLE) {
                    weChatCheck.setVisibility(View.VISIBLE);
                    aliPayCheck.setVisibility(View.INVISIBLE);
                    pPointCheck.setVisibility(View.INVISIBLE);
                    creditCardCheck.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.frame_cart_payment_creditcard:
                if (creditCardCheck.getVisibility() == View.INVISIBLE) {
                    creditCardCheck.setVisibility(View.VISIBLE);
                    aliPayCheck.setVisibility(View.INVISIBLE);
                    weChatCheck.setVisibility(View.INVISIBLE);
                    pPointCheck.setVisibility(View.INVISIBLE);
                }
                break;
            default:
                break;
        }
    }
}
