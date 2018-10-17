package com.mpw.slider.sliderinsidelist;

import com.mpw.newslider.productpricecarousal.ProductInfo;

import java.util.List;

/**
 * Created by malith on 10/10/18.
 */

public class ProductsOfProducts {
    private List<ProductInfo> productInfos;

    public ProductsOfProducts(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }

    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }
}
