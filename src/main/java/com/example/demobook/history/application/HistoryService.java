package com.example.demobook.history.application;

import com.example.demobook.history.domain.KeywordStatistics;
import com.example.demobook.history.domain.SearchHistory;
import com.example.demobook.history.infra.HistoryRepository;
import com.example.demobook.history.infra.JpaHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HistoryService {

    private JpaHistoryRepository jpaHistoryRepository;
    private HistoryRepository historyRepository;

    public HistoryService(JpaHistoryRepository jpaHistoryRepository,
                          HistoryRepository historyRepository) {
        this.jpaHistoryRepository = jpaHistoryRepository;
        this.historyRepository = historyRepository;
    }

    /**
     * 검색한 히스토리를 저장한다.
     * @param searchHistory
     * @throws Exception
     */
    public void addHistory(SearchHistory searchHistory) throws Exception {
        jpaHistoryRepository.save(searchHistory);
    }


    /**
     * 검색 히스토리(키워드, 검색 일시)를 최신 순으로 조회한다.
     * @param userName 유저명

     * @return 검색 히스토리 목록
     * @throws Exception
     */
    public List<SearchHistory> findHistoryByUserName(String userName) throws Exception {
        return jpaHistoryRepository.findByUserNameOrderByKeywordDescSearchDateDesc(userName);
    }

    /**
     * 사용자들이 많이 검색한 순서대로, 최대 10개의 검색 키워드를 조회한다.
     * @return 키워드 통계
     * @throws Exception
     */
    public List<KeywordStatistics> findTop10KeywordStatistics() throws Exception {

        List<KeywordStatistics> keywordStatistics = jpaHistoryRepository.selectSearchKeywordStatistics();
        if(keywordStatistics.isEmpty()) {
            return Collections.EMPTY_LIST;
        } else {
            if(keywordStatistics.size() < 10) {
                return keywordStatistics.subList(0, keywordStatistics.size());
            } else {
                return keywordStatistics.subList(0, 10);
            }
        }
    }
}
