package com.test.whatap.util;

import java.text.DecimalFormat;

public class PriceFormat {
    private static final DecimalFormat df = new DecimalFormat("###,###");

    public static String formatPrice(int price) {
        return df.format(price);
    }
}
