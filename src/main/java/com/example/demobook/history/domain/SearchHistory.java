package com.example.demobook.history.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class SearchHistory {

    @GeneratedValue
    @Id
    private Long id;
    private String userName; //유저명
    private String keyword; //키워드
    private LocalDateTime searchDate; // 검색 일시

    private SearchHistory() {
    }

    public SearchHistory(String userName, String keyword, LocalDateTime searchDate) {
        this.userName = userName;
        this.keyword = keyword;
        this.searchDate = searchDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getKeyword() {
        return keyword;
    }

    @Override
    public String toString() {
        return "SearchHistory{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", keyword='" + keyword + '\'' +
                ", searchDate=" + searchDate +
                '}';
    }
}
