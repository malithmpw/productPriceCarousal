package com.mpw.slider.sliderinsidelist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mpw.newslider.productpricecarousal.KohlsCarousalCurrentItemData;
import com.mpw.newslider.productpricecarousal.KohlsPriceCarousal;
import com.mpw.newslider.productpricecarousal.ProductInfo;

import java.util.List;

/**
 * Created by malith on 10/10/18.
 */

public class ProductsOfProductsAdapter extends RecyclerView.Adapter<ProductsOfProductsAdapter.ViewHolder> {
    private Context context;
    private List<ProductsOfProducts> products;

    public ProductsOfProductsAdapter(Context context, List<ProductsOfProducts> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.products_row, parent, false);
        return new ProductsOfProductsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        ProductsOfProducts productInfo = products.get(position);
        holder.carousal.setData(productInfo.getProductInfos(), position);
        holder.carousal.setNestedScrollingEnabled(false);
        holder.carousal.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.carousal.smoothScrollToPreviousPosition();
            }
        });
        holder.carousal.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.carousal.smoothScrollToNextPosition();
            }
        });

        holder.carousal.setKohlsCurrentItemDataReceiver(new KohlsCarousalCurrentItemData<ProductInfo, Integer, Integer>() {
            @Override
            public void currentPositionData(ProductInfo data, Integer rowPosition, Integer carousalPosition) {

            }
        });
        holder.carousal.pdpLinkOnClickListner(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.carousal.getCurrentItemData().getSalePriceAmount(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private KohlsPriceCarousal carousal;

        public ViewHolder(View itemView) {
            super(itemView);
            carousal = itemView.findViewById(R.id.productsOfProduct_carousal);
        }
    }
}
