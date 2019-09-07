package com.example.demobook.book.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KakaoMetaResponse {

    @JsonProperty("total_count")
    private Integer totalCount; //전체 검색된 문서수
    @JsonProperty("pageable_count")
    private Integer pageableCount;//검색결과로 제공 가능한 문서수
    @JsonProperty("is_end")
    private Boolean isEnd; //현재 페이지가 마지막 페이지인지 여부

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageableCount() {
        return pageableCount;
    }

    public void setPageableCount(Integer pageableCount) {
        this.pageableCount = pageableCount;
    }

    public Boolean getEnd() {
        return isEnd;
    }

    public void setEnd(Boolean end) {
        isEnd = end;
    }

    @Override
    public String toString() {
        return "KakaoMetaResponse{" +
                "totalCount=" + totalCount +
                ", pageableCount=" + pageableCount +
                ", isEnd=" + isEnd +
                '}';
    }
}
