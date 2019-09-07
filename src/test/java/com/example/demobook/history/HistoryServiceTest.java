package com.example.demobook.history;

import com.example.demobook.history.application.HistoryService;
import com.example.demobook.history.domain.KeywordStatistics;
import com.example.demobook.history.domain.SearchHistory;
import com.example.demobook.history.infra.DummyHistoryData;
import com.example.demobook.history.infra.DummyKeywordStatisticsData;
import com.example.demobook.history.infra.HistoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class HistoryServiceTest {

    @Mock
    private HistoryRepository historyRepository;

    @InjectMocks
    private HistoryService historyService;

    @Test
    public void findTop10KeywordStatistics_lessThanOrEqualTo10_True() throws Exception {

        given(historyRepository.selectSearchKeywordStatistics())
                .willReturn(DummyKeywordStatisticsData.getAll());

        final List<KeywordStatistics> results = historyService
                .findTop10KeywordStatistics();

        assertThat(results.size(), lessThanOrEqualTo(10));
    }

}
