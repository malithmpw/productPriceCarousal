# Product Price Carousal

Display list of products in a carousal and available listners for getting data of the current position

![Screenshot](https://github.com/malithmpw/productPriceCarousal/blob/master/Screen%20Shot%202018-10-13%20at%2013.37.41.png)

by Adding KohlsCarousalCurrentItemData listner to carousal instance, current position data can be received automatically.


## Usage

Eg: 
```
KohlsPriceCarousal carousal = findViewById(R.id.productsOfProduct_carousal);
ProductsOfProducts productInfo = products.get(position);
carousal.setData(productInfo.getProductInfos(), position); //position set to 0 if carousal is not used in a recycleview or list
carousal.setKohlsCurrentItemDataReceiver(new KohlsCarousalCurrentItemData<ProductInfo, Integer, Integer>() {
       @Override
       public void currentPositionData(ProductInfo data, Integer rowPosition, Integer carousalPosition) {

       }
});

carousal.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carousal.smoothScrollToPreviousPosition();
            }
});
carousal.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carousal.smoothScrollToNextPosition();
            }
 });

```
