package com.example.demobook.history.infra;

import com.example.demobook.history.domain.SearchHistory;

import java.time.LocalDateTime;
import java.util.*;

public class DummyHistoryData {

    private static Map<String, List<SearchHistory>> userNameToHistorys = new HashMap<>();

    static {
        put("yanghun007", "자신감", LocalDateTime.now());
        put("yanghun007", "원피스", LocalDateTime.now());
        put("yanghun007", "원피스", LocalDateTime.now());
        put( "yanghun007", "원피스", LocalDateTime.now());
        put( "yanghun007", "지진", LocalDateTime.now());
        put( "yanghun007", "지진", LocalDateTime.now());
        put( "yanghun007", "영어", LocalDateTime.now());
        put( "yangjeehun", "영어", LocalDateTime.now());
        put( "yangjeehun", "영어", LocalDateTime.now());
        put("yangjeehun", "영어", LocalDateTime.now());
        put( "yangjeehun", "영어", LocalDateTime.now());
        put("yangjeehun", "영어", LocalDateTime.now());
        put("seek", "영어", LocalDateTime.now());
        put( "utopia", "영어", LocalDateTime.now());
        put( "sg워너비", "영어", LocalDateTime.now());
    }

    public static List<SearchHistory> get(String userName){
        return userNameToHistorys.get(userName);
    }


    public static void put( String userName, String keyword,
                                     LocalDateTime searchDate){
        if(userNameToHistorys.containsKey(userName)) {
            List<SearchHistory> searchHistories = new ArrayList<>(userNameToHistorys.get(userName));
            searchHistories.add(new SearchHistory(userName, keyword, searchDate));
            userNameToHistorys.put(userName, searchHistories);
        } else {
            userNameToHistorys.put( userName,
                    Arrays.asList(new SearchHistory(userName, keyword, searchDate)));
        }

    }
}
