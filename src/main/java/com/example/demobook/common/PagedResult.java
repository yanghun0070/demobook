package com.example.demobook.common;

import java.util.List;

public class PagedResult<T> {
    private int totalCount; //총 건수
    private int currentPage; //현재 페이지

    private List<T> elements;

    public PagedResult(List<T> elements, int currentPage, int totalCount) {
        this.elements = elements;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
    }


    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<T> getElements() {
        return elements;
    }
}