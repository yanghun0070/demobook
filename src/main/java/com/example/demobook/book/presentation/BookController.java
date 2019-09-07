package com.example.demobook.book.presentation;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    /**
     * 책 검색 페이지
     * @return
     */
    @GetMapping("/book/search")
    public String bookSearch() {
        return "book/search/list";
    }

}
