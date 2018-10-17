package com.mpw.newslider.productpricecarousal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malith on 10/9/18.
 */

public class KohlsPriceCarousal extends FrameLayout {
    private LinearLayout rootLayout;
    private DiscreteScrollView scrollView;
    private ImageButton left, right, pdpLink;
    private TextView productType, productDesc, saleType, salePrice, regularPrice;
    private List<ProductInfo> data = new ArrayList<>();
    private KohlsCarousalCurrentItemData<ProductInfo, Integer, Integer> itemDataReceiver;

    private Float carousal_width;
    private Float carousal_height;
    private Float carousal_image_height;
    private Float carousal_image_width;
    private int kohls_carousal_background_color;
    private int rowPosition;
    private Context context;
    private ProductInfo currentItem;

    public KohlsPriceCarousal(@NonNull Context context) {
        super(context);
    }

    public KohlsPriceCarousal(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        this.context = context;
    }

    public void setData(List<ProductInfo> data, int rowPosition) {
        this.data = data;
        this.rowPosition = rowPosition;
        show();
    }

    /**
     * Set back button click listener
     *
     * @param listener
     */
    public void setLeftButtonClickListener(OnClickListener listener) {
        left.setOnClickListener(listener);
    }

    /**
     * Set home button click listener
     *
     * @param listener
     */
    public void setRightButtonClickListener(OnClickListener listener) {
        right.setOnClickListener(listener);
    }

    public void addScrollListener(DiscreteScrollView.ScrollListener<CarousalAdapter.ViewHolder> scrollListener) {
        scrollView.addScrollListener(scrollListener);
    }

    public void addOnItemChangedListener(DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder> itemChangedListener) {
        scrollView.addOnItemChangedListener(itemChangedListener);
    }

    public void setKohlsCurrentItemDataReceiver(KohlsCarousalCurrentItemData<ProductInfo, Integer, Integer> itemDataReceiver) {
        this.itemDataReceiver = itemDataReceiver;
    }

    public void smoothScrollToPosition(int position) {
        scrollView.smoothScrollToPosition(position);
    }

    public void pdpLinkOnClickListner(OnClickListener onClickListener) {
        pdpLink.setOnClickListener(onClickListener);
    }


    public void smoothScrollToNextPosition() {
        if (scrollView.getCurrentItem() + 1 < data.size()) {
            scrollView.smoothScrollToPosition(scrollView.getCurrentItem() + 1);
        }
    }

    public void smoothScrollToPreviousPosition() {
        if ((scrollView.getCurrentItem()) - 1 >= 0) {
            scrollView.smoothScrollToPosition(scrollView.getCurrentItem() - 1);
        }
    }

    public void addScrollStateChangeListener(DiscreteScrollView.ScrollStateChangeListener<RecyclerView.ViewHolder> scrollStateChangeListener) {
        scrollView.addScrollStateChangeListener(scrollStateChangeListener);
    }

    public ProductInfo getCurrentItemData() {
        return this.currentItem;
    }

    public int getCurrentItemPosition() {
        return scrollView.getCurrentItem();
    }

    private void show() {

        scrollView.setClipChildren(false);
        CarousalAdapter carousalAdapter = new CarousalAdapter(this.context, this.data, Math.round(carousal_image_width), Math.round(carousal_image_height));
        scrollView.setAdapter(carousalAdapter);
        scrollView.scrollToPosition(PositionHolder.getInstance().getViewPosition(this.rowPosition));
        scrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        scrollView.addOnItemChangedListener(new DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder>() {
            @Override
            public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {
                ProductInfo p = data.get(adapterPosition);
                currentItem = p;
                productType.setText(p.getProductType());
                productDesc.setText(p.getProductDescription());
                saleType.setText(p.getSalePriceType());
                salePrice.setText(p.getSalePriceAmount());
                regularPrice.setText(p.getRegularPrice());
                if (itemDataReceiver != null) {
                    itemDataReceiver.currentPositionData(p, rowPosition, adapterPosition);
                }
            }
        });

        scrollView.addScrollStateChangeListener(new DiscreteScrollView.ScrollStateChangeListener<RecyclerView.ViewHolder>() {
            @Override
            public void onScrollStart(@NonNull RecyclerView.ViewHolder currentItemHolder, int adapterPosition) {

            }

            @Override
            public void onScrollEnd(@NonNull RecyclerView.ViewHolder currentItemHolder, int adapterPosition) {
                PositionHolder.getInstance().addPosition(rowPosition, getCurrentItemPosition());
            }

            @Override
            public void onScroll(float scrollPosition, int currentPosition, int newPosition, @Nullable RecyclerView.ViewHolder currentHolder, @Nullable RecyclerView.ViewHolder newCurrent) {

            }
        });
    }


    private void init(final Context context) {
        View rootView = inflate(context, R.layout.kohls_price_carousal_layout, this);
        rootLayout = rootView.findViewById(R.id.kohsl_carousal_wrapper);
        scrollView = rootView.findViewById(R.id.item_picker);
        left = rootView.findViewById(R.id.carousal_left_button);
        right = rootView.findViewById(R.id.carousal_right_button);
        pdpLink = rootView.findViewById(R.id.goto_pdp_ib);
        productType = rootView.findViewById(R.id.sub_product_type_text);
        productDesc = rootView.findViewById(R.id.sub_product_name_text);
        saleType = rootView.findViewById(R.id.sub_sale_price_name_text);
        salePrice = rootView.findViewById(R.id.sub_sale_price_amount_text);
        regularPrice = rootView.findViewById(R.id.sub_regular_price_text);
    }

    private void init(Context context, AttributeSet attrs) {
        init(context);
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.KohlsPriceCarousal, 0, 0);
            carousal_height = typedArray.getDimension(R.styleable.KohlsPriceCarousal_carousal_height, 360.0f);
            carousal_width = typedArray.getDimension(R.styleable.KohlsPriceCarousal_carousal_width, 600.0f);
            carousal_image_height = typedArray.getDimension(R.styleable.KohlsPriceCarousal_carousal_image_height, 350.0f);
            carousal_image_width = typedArray.getDimension(R.styleable.KohlsPriceCarousal_carousal_image_width, 350.0f);
            String bgColor = typedArray.getString(R.styleable.KohlsPriceCarousal_carousal_background_color);
            kohls_carousal_background_color = bgColor == null ? Color.parseColor("#000000") : Color.parseColor(bgColor);
            typedArray.recycle();
        }
        rootLayout.setBackgroundColor(kohls_carousal_background_color);
        if (carousal_image_height > carousal_height) {
            scrollView.getLayoutParams().height = Math.round(carousal_image_height + 16);
        } else {
            scrollView.getLayoutParams().height = Math.round(carousal_height);
        }
        if (carousal_image_width > carousal_width) {
            scrollView.getLayoutParams().width = Math.round(carousal_image_width + 50);
        } else {
            scrollView.getLayoutParams().width = Math.round(carousal_width);
        }
    }


}
