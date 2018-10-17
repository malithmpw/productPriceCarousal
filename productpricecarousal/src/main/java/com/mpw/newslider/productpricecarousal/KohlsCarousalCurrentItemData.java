package com.mpw.newslider.productpricecarousal;

/**
 * Created by malith on 10/10/18.
 */

public interface KohlsCarousalCurrentItemData<D, R, P> {
    void currentPositionData(D data, R rowPosition, P carousalPosition);
}
