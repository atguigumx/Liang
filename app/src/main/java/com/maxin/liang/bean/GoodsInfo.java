package com.maxin.liang.bean;


public class GoodsInfo {
    private String goosId;
    private String goodsShopId;
    private String goodsUrl;
    private String goodsLogo;
    private String goodsType;
    private String goodsDiscountPrice;

    public String getGoodsDiscountPrice() {
        return goodsDiscountPrice;
    }

    public void setGoodsDiscountPrice(String goodsDiscountPrice) {
        this.goodsDiscountPrice = goodsDiscountPrice;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    private int goodsNumber;
    private String goodsName;

    private boolean isSelected;
    private String goodsPrice;

    public GoodsInfo() {
    }

    public String getGoosId() {
        return goosId;
    }

    public void setGoosId(String goosId) {
        this.goosId = goosId;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsLogo() {
        return goodsLogo;
    }

    public void setGoodsLogo(String goodsLogo) {
        this.goodsLogo = goodsLogo;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getGoodsShopId() {
        return goodsShopId;
    }

    public void setGoodsShopId(String goodsShopId) {
        this.goodsShopId = goodsShopId;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "goosId='" + goosId + '\'' +
                ", goodsShopId='" + goodsShopId + '\'' +
                ", goodsUrl='" + goodsUrl + '\'' +
                ", goodsLogo='" + goodsLogo + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", goodsName='" + goodsName + '\'' +
                ", isSelected=" + isSelected +
                ", goodsPrice=" + goodsPrice +
                '}';
    }
}
