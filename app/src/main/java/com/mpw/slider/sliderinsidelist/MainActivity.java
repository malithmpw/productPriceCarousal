package com.mpw.slider.sliderinsidelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mpw.newslider.productpricecarousal.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ProductsOfProducts> products;
    private RecyclerView recyclerView;
    private ProductsOfProductsAdapter productsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    /**
     * Initialize all required variables
     */
    private void init() {
        products = getProductsOfProducts();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        productsAdapter = new ProductsOfProductsAdapter(MainActivity.this, products);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(productsAdapter);
    }

    private List<ProductInfo> getProductInfo() {
        List<ProductInfo> data = new ArrayList<>();

        data.add(new ProductInfo("https://media.kohlsimg.com/is/image/kohls/1695762_ALT?wid=500&hei=500&op_sharpen=1", "JEWLARY JEWLARY JEWLARY JEWLARY", "Desc23423ription Description Description", "JEWLARY JEWLARY JEWLARY JEWLARY", "$99439.9766767776769", "$195399.99"));
        data.add(new ProductInfo("https://media.kohlsimg.com/is/image/kohls/3243851_Teal_Marl?wid=500&hei=500&op_sharpen=1", "JEWLARY JEWLARY JEWLARY JEWLARY", "Descriprewrtion  Description", "JEWLARY JEWLARY JEWLARY JEWLARY", "$99.4399", "$12399.99"));
        data.add(new ProductInfo("https://media.kohlsimg.com/is/image/kohls/c2386950?wid=500&hei=500&op_sharpen=1", "CLOTHES", "Description Descrrweriprtion Description", "SALE", "$99943.99", "$94329.99"));
        data.add(new ProductInfo("https://media.kohlsimg.com/is/image/kohls/c2362959?wid=500&hei=500&op_sharpen=1", "CLOTHES", "Descriptewrewrion  Description", "SALE", "$9234.99", "$199.99"));
        data.add(new ProductInfo("https://media.kohlsimg.com/is/image/kohls/c2362960?wid=500&hei=500&op_sharpen=1", "CLOTHES", "Descriptionrwerewr Description Description", "CLEARANCE", "$999.99", "$1943599.99"));
        data.add(new ProductInfo("https://media.kohlsimg.com/is/image/kohls/3523128_Penley_Plumb?wid=500&hei=500&op_sharpen=1", "SHOES", "Description Descfrgreription Description", "CLEARANCE", "$9459.99", "$19659.99"));
        data.add(new ProductInfo("https://media.kohlsimg.com/is/image/kohls/3296643_Light_Gray_Floral?wid=500&hei=500&op_sharpen=1", "SHOES", "Description fre Description", "SALE", "$9.4399", "$9.9769"));
        data.add(new ProductInfo("https://media.kohlsimg.com/is/image/kohls/3438582_Navy?wid=500&hei=500&op_sharpen=1", "SHOES", "Descriptiontert Description Description", "SALE", "$99934.99", "$99.99"));
        data.add(new ProductInfo("https://media.kohlsimg.com/is/image/kohls/3385900_Purple_Plaid?wid=500&hei=500&op_sharpen=1", "JEWLARY", "Description tert  Description", "CLEARANCE", "$9679.99", "$199439.99"));
        data.add(new ProductInfo("https://media.kohlsimg.com/is/image/kohls/3348410_Floral_Teal?wid=500&hei=500&op_sharpen=1", "JEWLCLOTHESARY", "Descriptiontret Description Description", "SALE", "$99r49.99", "$19.499"));

        return data;
    }

    private List<ProductsOfProducts> getProductsOfProducts() {
        List<ProductsOfProducts> data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add(new ProductsOfProducts(getProductInfo()));
        }
        return data;
    }


}