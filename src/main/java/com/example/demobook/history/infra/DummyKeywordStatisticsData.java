package com.example.demobook.history.infra;

import com.example.demobook.history.domain.KeywordStatistics;

import java.util.*;

public class DummyKeywordStatisticsData {


    private static List<KeywordStatistics> keywordStatistics = new ArrayList<>();

    static {
        put("가", 10000L);
        put("나", 9999L);
        put("다", 9999L);
        put("라", 8000L);
        put("마", 7007L);
        put("바", 6007L);
        put("사", 5454L);
        put("아", 5000L);
        put("자", 4443L);
        put("차", 2222L);
        put("카", 2000L);
        put("가나", 290L);
        put("다라", 200L);
        put("황진이", 180L);
    }

    public static List<KeywordStatistics> getAll(){
        return keywordStatistics;
    }


    public static void put(String keyword, Long count){
        keywordStatistics.add(new KeywordStatistics(
                keyword, count));
    }
}
