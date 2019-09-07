package com.example.demobook.book.infra;

import com.example.demobook.book.domain.BookDetail;
import com.example.demobook.common.PagedResult;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository("dummyBookRepository")
public class DummyBookRepository implements BookRepository {

    @Override
    public PagedResult<BookDetail> findByKeyword(String keyword, Integer currentPage) throws IOException {
        return null;
    }
}
