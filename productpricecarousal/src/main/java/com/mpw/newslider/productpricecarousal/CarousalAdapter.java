package com.mpw.newslider.productpricecarousal;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by malith on 10/9/18.
 */

public class CarousalAdapter extends RecyclerView.Adapter<CarousalAdapter.ViewHolder> {

    private Context context;
    private List<ProductInfo> listItems;
    private int width, height;

    public CarousalAdapter(Context context, List<ProductInfo> listItems, int width, int height) {
        this.context = context;
        this.listItems = listItems;
        this.width = width;
        this.height = height;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.slider_image, parent, false);
        return new CarousalAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductInfo productInfo = listItems.get(position);
        holder.cardView.getLayoutParams().height = height;
        holder.cardView.getLayoutParams().width = width;
        try {
            Glide
                    .with(context)
                    .load(new URL(productInfo.getImageUrl()))
                    .apply(new RequestOptions()
                            .timeout(10000)
                            .dontAnimate()
                            .placeholder(R.drawable.loading_tile_4)
                            .override(350, 350)
                            .skipMemoryCache(true)
                            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC))
                    .error(Glide.with(context)
                            .load(R.drawable.error_image))
                    .into(holder.image);
        } catch (MalformedURLException e) {
            Glide.with(context)
                    .load(R.drawable.error_image)
                    .into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.slider_image_card);
        }
    }
}