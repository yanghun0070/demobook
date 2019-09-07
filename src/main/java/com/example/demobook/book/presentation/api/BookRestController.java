package com.example.demobook.book.presentation.api;


import com.example.demobook.book.application.BookService;
import com.example.demobook.book.domain.BookDetail;
import com.example.demobook.common.PagedResult;
import com.example.demobook.security.application.LoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    private BookService bookService;


    /**
     * 키워드를 통해 책을 Pagination 형태로 검색한다.
     * @param keyword 키워드
     * @param currentPage 현재 페이지
     * @param userDetails
     * @throws Exception
     */
    @GetMapping("search/books")
    public PagedResult<BookDetail> searchBooks(@RequestParam String keyword,
                                   @RequestParam Integer currentPage,
                                   @AuthenticationPrincipal LoginUserDetails userDetails
    ) throws Exception {
        return bookService.searchByKeyword(keyword, userDetails.getUsername(), currentPage);
    }


}
