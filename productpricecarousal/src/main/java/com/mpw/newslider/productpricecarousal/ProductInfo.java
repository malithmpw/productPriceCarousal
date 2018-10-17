package com.mpw.newslider.productpricecarousal;

/**
 * Created by malith on 10/9/18.
 */

public class ProductInfo {

    private String imageUrl;
    private String productType;
    private String productDescription;
    private String salePriceType;
    private String salePriceAmount;
    private String regularPrice;
    private String pdpUrl;
    private String sku;
    private String upc;


    public ProductInfo(String imageUrl, String productType, String productDescription, String salePriceType, String salePriceAmount, String regularPrice) {
        this.imageUrl = imageUrl;
        this.productType = productType;
        this.productDescription = productDescription;
        this.salePriceType = salePriceType;
        this.salePriceAmount = salePriceAmount;
        this.regularPrice = regularPrice;
    }

    public ProductInfo(String imageUrl, String productType, String productDescription, String salePriceType, String salePriceAmount, String regularPrice, String pdpUrl) {
        this.imageUrl = imageUrl;
        this.productType = productType;
        this.productDescription = productDescription;
        this.salePriceType = salePriceType;
        this.salePriceAmount = salePriceAmount;
        this.regularPrice = regularPrice;
        this.pdpUrl = pdpUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getSalePriceType() {
        return salePriceType;
    }

    public void setSalePriceType(String salePriceType) {
        this.salePriceType = salePriceType;
    }

    public String getSalePriceAmount() {
        return salePriceAmount;
    }

    public void setSalePriceAmount(String salePriceAmount) {
        this.salePriceAmount = salePriceAmount;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getPdpUrl() {
        return pdpUrl;
    }

    public void setPdpUrl(String pdpUrl) {
        this.pdpUrl = pdpUrl;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }
}
