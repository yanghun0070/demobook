package com.example.demobook.history.presentation.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchHistoryVo {
    private String userName; //유저명
    private String keyword; //키워드
    private String searchDate; // 검색 일시

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(LocalDateTime searchDate) {
        this.searchDate = searchDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));;
    }

    @Override
    public String toString() {
        return "SearchHistoryVo{" +
                "userName='" + userName + '\'' +
                ", keyword='" + keyword + '\'' +
                ", searchDate='" + searchDate + '\'' +
                '}';
    }
}
