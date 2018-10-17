package com.mpw.newslider.productpricecarousal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by malith on 10/11/18.
 */

public class PositionHolder {
    private static PositionHolder instance;
    private final Map<Integer, Integer> positions;

    private PositionHolder() {
        this.positions = new HashMap<>();
    }

    public static PositionHolder getInstance() {
        if (instance == null) {
            instance = new PositionHolder();
        }
        return instance;
    }

    public int getViewPosition(int position) {
        return this.positions.get(position) == null ? 0 : this.positions.get(position);
    }

    public void addPosition(int position, int viewPosition) {
        this.positions.put(position, viewPosition);
    }

    public Map getMap() {
        return this.positions;
    }
}
