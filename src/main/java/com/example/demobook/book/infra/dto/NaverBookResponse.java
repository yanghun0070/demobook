package com.example.demobook.book.infra.dto;

import java.util.List;

public class NaverBookResponse {
    private String lastBuildDate; //검색 결과를 생성한 시간
    private Integer total; //총 건수
    private Integer start; //문서의 시작 점
    private Integer display; //검색된 검색 결과의 개수
    private List<NaverItemResponse> items;

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public List<NaverItemResponse> getItems() {
        return items;
    }

    public void setItems(List<NaverItemResponse> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "NaverBookResponse{" +
                "lastBuildDate=" + lastBuildDate +
                ", total=" + total +
                ", start=" + start +
                ", display=" + display +
                ", items=" + items +
                '}';
    }
}
