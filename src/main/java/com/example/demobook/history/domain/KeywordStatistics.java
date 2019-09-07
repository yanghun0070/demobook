package com.example.demobook.history.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KeywordStatistics {
    @Id
    private String keyword;
    private Long count;

    public KeywordStatistics(String keyword, Long count) {
        this.keyword = keyword;
        this.count = count;
    }

    public String getKeyword() {
        return keyword;
    }

    public Long getCount() {
        return count;
    }
}
