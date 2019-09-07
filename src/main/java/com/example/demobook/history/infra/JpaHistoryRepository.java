package com.example.demobook.history.infra;

import com.example.demobook.history.domain.KeywordStatistics;
import com.example.demobook.history.domain.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface JpaHistoryRepository extends JpaRepository<SearchHistory, Long> {

    /**
     *
     * 유저 검색 히스토리(키워드, 검색 일시)를 최신 순으로 조회한다.
     * @param userName 유저명
     * @return 검색 히스토리
     */
    public List<SearchHistory> findByUserNameOrderByKeywordDescSearchDateDesc(String userName);


    /**
     * 사용자들이 많이 검색한 검색 키워드 조회한다.
     * @return 사용자들이 많이 검색한 검색 키워드 건수
     */
    @Query("select " +
            "new com.example.demobook.history.domain.KeywordStatistics(s.keyword, count(s)) " +
            "from SearchHistory s " +
            "group by s.keyword " +
            "order by count(s)")
    public List<KeywordStatistics> selectSearchKeywordStatistics();
}
