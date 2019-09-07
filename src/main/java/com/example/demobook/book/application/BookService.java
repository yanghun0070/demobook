package com.example.demobook.book.application;

import com.example.demobook.book.domain.BookDetail;
import com.example.demobook.book.infra.dto.BookHttpApiClient;
import com.example.demobook.common.PagedResult;
import com.example.demobook.history.application.HistoryService;
import com.example.demobook.history.domain.SearchHistory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService {

    private BookHttpApiClient bookHttpApiClient;
    private HistoryService historyService;

    public BookService(BookHttpApiClient bookHttpApiClient,
                       HistoryService historyService) {
        this.bookHttpApiClient = bookHttpApiClient;
        this.historyService = historyService;
    }

    /**
     * 키워드를 통해 책을 Pagination 형태로 검색한다.
     * @param keyword 키워드
     * @param userName 유저명
     * @param currentPage 현재 페이지
     * @return 책 상세 정보
     * @throws Exception
     */
    @Transactional
    public PagedResult<BookDetail> searchByKeyword(String keyword, String userName, Integer currentPage) throws Exception {

        PagedResult<BookDetail> bookDetails =
            bookHttpApiClient.findByKeyword(keyword, currentPage);

        historyService.addHistory(new SearchHistory(
                userName, keyword, LocalDateTime.now()));

        return bookDetails;
    }
}
