package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Dynamic;

/**
 *
 * @Version: 1.0
 * @Author: jiabin.zhang
 * @Email: jiabin.zhang@rograndec.com
 *
 */
public class TbItem implements Serializable {

    /**
     * 商品id，同时也是商品编号
     */
    @Field
    private Integer             id;

    /**
     * 商品标题
     */
    @Field("item_title")
    private String              title;

    /**
     * 商品卖点
     */
    private String              sellPoint;

    /**
     * 商品价格，单位为：元
     */
    @Field("item_price")
    private Double              price;

    /**
     * null
     */
    private Integer             stockCount;

    /**
     * 库存数量
     */
    private Integer             num;

    /**
     * 商品条形码
     */
    private String              barcode;

    /**
     * 商品图片
     */
    @Field("item_image")
    private String              image;

    /**
     * 所属类目，叶子类目
     */
    private Integer             categoryId;

    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    private String              status;

    /**
     * 创建时间
     */
    private Date                createTime;

    /**
     * 更新时间
     */
    private Date                updateTime;

    /**
     * null
     */
    private String              itemSn;

    /**
     * null
     */
    private Double              costPirce;

    /**
     * null
     */
    private Double              marketPrice;

    /**
     * null
     */
    private String              isDefault;

    /**
     * null
     */
    @Field("item_goodsid")
    private Integer             goodsId;

    /**
     * null
     */
    private String              sellerId;

    /**
     * null
     */
    private String              cartThumbnail;

    /**
     * null
     */
    @Field("item_category")
    private String              category;
    /**
     * null
     */
    @Field("item_brand")
    private String              brand;

    /**
     * null
     */
    private String              spec;

    /**
     * null
     */
    @Field("item_seller")
    private String              seller;

    @Dynamic
    @Field("item_spec_*")
    private Map<String, String> specMap;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getItemSn() {
        return itemSn;
    }

    public void setItemSn(String itemSn) {
        this.itemSn = itemSn;
    }

    public Double getCostPirce() {
        return costPirce;
    }

    public void setCostPirce(Double costPirce) {
        this.costPirce = costPirce;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCartThumbnail() {
        return cartThumbnail;
    }

    public void setCartThumbnail(String cartThumbnail) {
        this.cartThumbnail = cartThumbnail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Map<String, String> getSpecMap() {
        return specMap;
    }

    public void setSpecMap(Map<String, String> specMap) {
        this.specMap = specMap;
    }
}
