package com.example.demobook.book.infra;

import com.example.demobook.book.domain.BookDetail;
import com.example.demobook.common.PagedResult;

import java.io.IOException;
import java.util.List;

public interface BookRepository {

    /**
     * 키워드를 통해 책을 검색할 수 있어야 한다.
     * @param keyword 키워드
     * @param currentPage 현재 페이지
     * @return 책 상세 목록
     * @throws IOException
     */
    PagedResult<BookDetail> findByKeyword(String keyword, Integer currentPage) throws IOException;
}
