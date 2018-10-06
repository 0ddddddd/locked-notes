package com.localworld.ishop.model;

import java.io.Serializable;



public class Order implements Serializable{

        private Long goodsId;
        private String goodsPic;
        private String goodsTitle;
        private Long id;
        private int num;
        private Long updated;
        private Long userid;

        private Long tradeId;

        private String authorTitle;

        private int price;

        private Double postFee;

        private String status;

        private String refundStatus;

        private String remark;

        private int viewType;
        /**
         * 当从购物车选择时
         */
        private Long cartId;

        private boolean showShop;  //商店栏是否显示

        private boolean selectGoods;  //物品是否被选中

        private boolean selectShop;   //商店是否选中

        public Order() {

        }

    /**
         * lxy
         */
        public Order(String authorTitle, String goodsPic, String goodsTitle, int price, Integer num) {
            this.authorTitle = authorTitle;
            this.goodsPic = goodsPic;
            this.goodsTitle = goodsTitle;
            this.price = price;
            this.num = num;
        }

        public Order(String authorTitle, String goodsPic, String goodsTitle, int price, Integer num, int type, boolean showShop, boolean selectShop, boolean selectGoods) {
            this.authorTitle = authorTitle;
            this.goodsPic = goodsPic;
            this.goodsTitle = goodsTitle;
            this.price = price;
            this.num = num;
            this.viewType = type;
            this.showShop = showShop;
            this.selectGoods = selectGoods;
            this.selectShop = selectShop;
        }

        public Order(String goodsPic, Integer num) {
            this.goodsPic = goodsPic;
            this.num = num;
        }


        public boolean isShowShop() {
            return showShop;
        }

        public void setShowShop(boolean showShop) {
            this.showShop = showShop;
        }

        public boolean isSelectGoods() {
            return selectGoods;
        }

        public void setSelectGoods(boolean selectGoods) {
            this.selectGoods = selectGoods;
        }

        public boolean isSelectShop() {
            return selectShop;
        }

        public void setSelectShop(boolean selectShop) {
            this.selectShop = selectShop;
        }

        public String getGoodsPic() { return goodsPic; }

        public void setGoodsPic(String goodsPic) {
            this.goodsPic = goodsPic;
        }

        public Long getCartId() {
            return cartId;
        }

        public void setCartId(Long cartId) {
            this.cartId = cartId;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getTradeId() {
            return tradeId;
        }

        public void setTradeId(Long tradeId) {
            this.tradeId = tradeId;
        }

        public Long getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Long goodsId) {
            this.goodsId = goodsId;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Double getPostFee() {
            return postFee;
        }

        public void setPostFee(Double postFee) {
            this.postFee = postFee;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRefundStatus() {
            return refundStatus;
        }

        public void setRefundStatus(String refundStatus) {
            this.refundStatus = refundStatus;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getGoodsTitle() {
            return goodsTitle;
        }

        public void setGoodsTitle(String goodsTitle) {
            this.goodsTitle = goodsTitle;
        }

        public String getAuthorTitle() {
            return authorTitle;
        }

        public void setAuthorTitle(String authorTitle) {
            this.authorTitle = authorTitle;
        }

        public int getViewType() {
            return viewType;
        }

        public void setViewType(int viewType) {
            this.viewType = viewType;
        }
}
