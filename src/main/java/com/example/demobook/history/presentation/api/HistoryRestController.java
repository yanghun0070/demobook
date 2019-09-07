package com.example.demobook.history.presentation.api;


import com.example.demobook.history.application.HistoryService;
import com.example.demobook.history.domain.KeywordStatistics;
import com.example.demobook.history.domain.SearchHistory;
import com.example.demobook.history.presentation.vo.SearchHistoryVo;
import com.example.demobook.security.application.LoginUserDetails;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class HistoryRestController {

    @Autowired
    private HistoryService historyService;

    /**
     * 검색한 나의 히스토리  히스토리(키워드, 검색 일시)를 최신 순으로 조회한다.
     * @param userDetails
     * @return 검색한 나의 히스토리 목록
     * @throws Exception
     */
    @GetMapping("history/me")
    public List<SearchHistoryVo> getMyHistory(@AuthenticationPrincipal LoginUserDetails userDetails) throws Exception {

        return new ModelMapper().map(
            historyService.findHistoryByUserName(
                userDetails.getUsername()),
                new TypeToken<List<SearchHistory>>(){}.getType());
    }

    /**
     * 사용자들이 많이 검색한 순서대로, 최대 10개의 검색 키워드를 조회
     * @return 최대 10개의 검색 키워드
     * @throws Exception
     */
    @GetMapping("statistic/keyword/top10")
    public List<KeywordStatistics> getTop10KeywordStatistics() throws Exception {
        return historyService.findTop10KeywordStatistics();
    }
}
