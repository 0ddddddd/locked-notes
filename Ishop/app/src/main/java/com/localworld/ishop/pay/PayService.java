package com.localworld.ishop.pay;

import com.igerm.android.lib.net.core.BaseResponse;
import com.localworld.ishop.pay.bean.CreateOrderResultBean;
import com.localworld.ishop.pay.request.CreateOrderRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface PayService {

    @POST("trade")
    Call<BaseResponse<CreateOrderResultBean>> createOrder(@Body CreateOrderRequest request);

    @GET("trade/prePay/{id}")
    Call<BaseResponse<String>> getPayCharge(@Path("id") String orderId);

    @GET("cart")
    Call<BaseResponse<String>> cart();
}
