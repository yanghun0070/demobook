package com.example.demobook.history.infra;

import com.example.demobook.history.domain.KeywordStatistics;
import com.example.demobook.history.domain.SearchHistory;

import java.util.List;

public interface HistoryRepository {


    /**
     *
     * 검색 히스토리(키워드, 검색 일시)를 최신 순으로 조회한다.
     * @param userName 유저명
     * @return 검색 히스토리
     */
    public List<SearchHistory> findByUserName(String userName);


    /**
     * 사용자들이 많이 검색한 검색 키워드 조회한다.
     * @return 키워드 통계
     */
    public List<KeywordStatistics> selectSearchKeywordStatistics();
}
