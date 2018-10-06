package com.localworld.ishop.common.heimdall;

import com.igerm.android.lib.net.core.BaseResponse;
import com.localworld.ishop.common.manager.account.UserInfo;
import com.localworld.ishop.common.manager.account.UserInfoLoginResp;
import com.localworld.ishop.home.bean.DiscoveryPopularityBean;
import com.localworld.ishop.home.bean.DiscoverySpecialBean;
import com.localworld.ishop.model.AddCart;
import com.localworld.ishop.model.AddCartDetail;
import com.localworld.ishop.model.Author;
import com.localworld.ishop.model.DefaultResponse;
import com.localworld.ishop.model.Order;
import com.localworld.ishop.model.goods.GoodsDetailModel;
import com.localworld.ishop.model.home.CategoryIndexResponse;
import com.localworld.ishop.model.home.MainIndexResponse;
import com.localworld.ishop.model.login.FollowListBean;
import com.localworld.ishop.request.LoginRequest;
import com.localworld.ishop.request.UserInfoRequest;
import com.localworld.ishop.setting.bean.FollowFollowedUserBean;
import com.localworld.ishop.setting.bean.MyHomePageBean;
import com.localworld.ishop.setting.bean.OtherAddressBean;
import com.localworld.ishop.shop.bean.AuthorData;
import com.localworld.ishop.shop.bean.ShopAuthor;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


public interface ISNetService {

    @POST("user/login")
    Call<BaseResponse<UserInfoLoginResp>> login(@Body LoginRequest request);

    @POST("user")
    Call<BaseResponse<UserInfoLoginResp>> register(@Body UserInfoRequest request);

    @POST("user/update")
    Call<BaseResponse<UserInfo>> updateUserInfo(@Body UserInfoRequest userInfoRequest);

    @DELETE("user/login")
    Call<BaseResponse<String>> logout(@QueryMap Map<String, String> map);

    @POST("user/password/reset/message")
    Call<BaseResponse<Boolean>> restPwdPhoneCode(@QueryMap Map<String, String> map);

    @GET("user/password/reset/token")
    Call<BaseResponse<String>> restPwdGetToken(@QueryMap Map<String, String> map);

    @POST("user/password/reset")
    Call<Boolean> restPwd(@QueryMap Map<String, String> map);

    @GET("goods/home")
    Call<BaseResponse<MainIndexResponse>> getHomeIndex(@QueryMap Map<String, String> map);

    /**
     * 手工艺分类id = 9
     *
     * @param map
     * @return
     */
    @GET("goods/list/9")
    Call<BaseResponse<CategoryIndexResponse>> getLeftIndex(@QueryMap Map<String, String> map);

    /**
     * 饰品分类id = 8
     *
     * @param map
     * @return
     */
    @GET("goods/list/8")
    Call<BaseResponse<CategoryIndexResponse>> getRightIndex(@QueryMap Map<String, String> map);

    /**
     * 商详
     *
     * @param goodsId
     * @return
     */
    @GET("goods/{goodsId}")
    Call<BaseResponse<GoodsDetailModel>> getGoodsDetail(@Path("goodsId") String goodsId);

    /**
     * @param map
     * @return
     */
    @GET("goods/list/ByAuthor")
    Call<BaseResponse<Author>> getAuthorDetail(@QueryMap Map<String, String> map);

    /**
     * 店详
     */
    @GET("author/{authorId}")
    Call<BaseResponse<List<AuthorData>>> getAuthorDataDetail(@Path("authorId") long authorId);


    /**
     * @param authorId
     * @return
     */
    @GET("goods/list/ByAuthor/{authorId}")
    Call<BaseResponse<List<ShopAuthor>>> getShopAuthor(@Path("authorId") long authorId);


    /**
     *
     * @param goodsId
     * @return
     */
    @POST("goods/{goodsId}/collect")
    Call<BaseResponse<DefaultResponse>> postCollection(@Path("goodsId") String goodsId);
    /**
     *
     * @param
     * @return
     */
    @GET("goods/collect")
    Call<BaseResponse<DefaultResponse>> getCollection();
    /**
     *
     * @param goodsId
     * @return
     */
    @DELETE("goods/{goodsId}/collect")
    Call<BaseResponse<DefaultResponse>> deleteCollection(@Path("goodsId") String goodsId);


    /**
     * 粉丝列表
     * @param map
     * @return
     */
    @GET("follow/search")
    Call<BaseResponse<FollowListBean>> getFansList(@QueryMap Map<String, String> map);

    /**
     * 我的关注
     * @param map
     * @return
     */
    @GET("follow/search")
    Call<BaseResponse<FollowListBean>> getMyFollowList(@QueryMap Map<String, String> map);

    @GET("follow/search")
    Call<BaseResponse<List<FollowFollowedUserBean>>> getFollowFollowedList(@QueryMap Map<String, String> map);
    /**
     * 获取板块的接口
     * 比如发现中的流行 keyword:popular
     *
     * @param map
     * @return
     */
    @GET("goods/boards")
    Call<BaseResponse<DiscoverySpecialBean>> getBoards(@QueryMap Map<String, String> map);

    /**
     * 搜索的特色，好物
     *
     * @param map
     * @return
     */
    @GET("goods/search")
    Call<BaseResponse<List<Object>>> getSearchList(@QueryMap Map<String, String> map);

    /**
     * 发现中的流行
     */
    @GET("goods/search?boardCode=popular")
    Call<BaseResponse<DiscoveryPopularityBean>> getPopularList();

    /**
     * 购物车列表
     */
    @GET("cart")
    Call<BaseResponse<List<Order>>> getCartList();

    /**
     * 添加到购物车
     */
    @POST("cart")
    Call<BaseResponse<AddCart>>AddCart(@Body AddCartDetail request);

    /*
<<<<<<< HEAD
    删除购物车
     */
    @DELETE("cart/{id}")
    Call<BaseResponse<String>>DeleteCart(@Path("id")long id);


    //todo 获取的数据有点问题
    @GET("receiveAddress/list")
    Call<BaseResponse<List<OtherAddressBean>>> getMyAddressList();

    /*
    * 发帖*/
    @POST("pics")
    Call<BaseResponse<MyHomePageBean>> getPics(@Body String pics);

}
