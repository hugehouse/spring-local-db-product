package com.test.whatap.paging;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PagingExceptionHandler {
    public static int normalizationLimit(int limit) {
        switch(limit) {
            case 10: case 20: case 30: case 50:
                return limit;
            default:
                return 10;
        }
    }
}
