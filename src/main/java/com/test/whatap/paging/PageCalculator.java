package com.test.whatap.paging;

public class PageCalculator {
    private final int length;
    private final int offset;
    private final int limit;

    public PageCalculator(int length, int offset, int limit) {
        this.length = length;
        this.offset = offset;
        this.limit = limit;
    }
    public int getTotalPages() {
        return length / limit + 1; // 전체 페이지 계산
    }
    public int getAscCurrentPage() {
        return offset*limit; // 현재 페이지 계산
    }
    public int getDescCurrentPage() {
        return length - offset*limit - 1; // 현재 페이지 계산
    }
    public int getLimit() {
        if(length / limit + 1 == offset + 1) {
            return length % limit; // 인덱스를 초과하는 것을 방지
        }
        else {
            return limit;
        }
    }
}
