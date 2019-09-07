package com.example.demobook.history.infra;

import com.example.demobook.history.domain.KeywordStatistics;
import com.example.demobook.history.domain.SearchHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dummyHistoryRepository")
public class DummyHistoryRepository implements HistoryRepository {

    @Override
    public List<SearchHistory> findByUserName(String userName) {
        return DummyHistoryData.get(userName);
    }

    @Override
    public List<KeywordStatistics> selectSearchKeywordStatistics() {
        return DummyKeywordStatisticsData.getAll();
    }
}
