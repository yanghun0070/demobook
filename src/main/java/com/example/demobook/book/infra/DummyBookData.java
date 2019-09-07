package com.example.demobook.book.infra;

import com.example.demobook.book.domain.BookDetail;
import com.example.demobook.common.PagedResult;

import java.time.LocalDateTime;
import java.util.*;

public class DummyBookData {


    private static Map<String, PagedResult<BookDetail>> keywordToPagedResult = new HashMap<>();
    private static Map<String, List<BookDetail>> keywordToBookDetails = new HashMap<>();

    static {
        //items": [","lprice": "794640000","hprice": "0","mallName": "한서기프트","productId": "19299480585","productType": "2"},{"title": "백색디너 네프킨(2겹) (4겹 문의요망) [4,000개부터 구매 가능(소량구매전화)]","link": "https://search.shopping.naver.com/gate.nhn?id=19298722956","image": "https://shopping-phinf.pstatic.net/main_1929872/19298722956.jpg","lprice": "794640000","hprice": "0","mallName": "GK기프트","productId": "19298722956","productType": "2"},{"title": "백색디너 네프킨(2겹) (4겹 문의요망) [4,000개부터 구매 가능(소량구매전화)]","link": "https://search.shopping.naver.com/gate.nhn?id=19299946791","image": "https://shopping-phinf.pstatic.net/main_1929994/19299946791.2.jpg","lprice": "794640000","hprice": "0","mallName": "피알기프트","productId": "19299946791","productType": "2"},{"title": "백색디너 네프킨(2겹) (4겹 문의요망) [4,000개부터 구매 가능(소량구매전화)]","link": "https://search.shopping.naver.com/gate.nhn?id=19307713868","image": "https://shopping-phinf.pstatic.net/main_1930771/19307713868.jpg","lprice": "794640000","hprice": "0","mallName": "샘물기프트","productId": "19307713868","productType": "2"},{"title": "백색디너 네프킨(2겹) (4겹 문의요망) [4,000개부터 구매 가능(소량구매전화)]","link": "https://search.shopping.naver.com/gate.nhn?id=19305890160","image": "https://shopping-phinf.pstatic.net/main_1930589/19305890160.jpg","lprice": "794640000","hprice": "0","mallName": "알라딘마켓","prod
//        put("휴지", "백색디너 네프킨(2겹) (4겹 문의요망) [4,000개부터 구매 가능(소량구매전화)]",
//                "https://shopping-phinf.pstatic.net/main_1929948/19299480585.3.jpg",
//                "",
//                )
    }


//    "lastBuildDate": "Sat, 20 Jul 2019 21:34:38 +0900","total": 1476080,"start": 1,"display": 10,"items": [{"title": "백색디너 네프킨(2겹) (4겹 문의요망) [4,000개부터 구매 가능(소량구매전화)]","link": "https://search.shopping.naver.com/gate.nhn?id=19299480585","image": "https://shopping-phinf.pstatic.net/main_1929948/19299480585.3.jpg","lprice": "794640000","hprice": "0","mallName": "한서기프트","productId": "19299480585","productType": "2"},{"title": "백색디너 네프킨(2겹) (4겹 문의요망) [4,000개부터 구매 가능(소량구매전화)]","link": "https://search.shopping.naver.com/gate.nhn?id=19298722956","image": "https://shopping-phinf.pstatic.net/main_1929872/19298722956.jpg","lprice": "794640000","hprice": "0","mallName": "GK기프트","productId": "19298722956","productType": "2"},{"title": "백색디너 네프킨(2겹) (4겹 문의요망) [4,000개부터 구매 가능(소량구매전화)]","link": "https://search.shopping.naver.com/gate.nhn?id=19299946791","image": "https://shopping-phinf.pstatic.net/main_1929994/19299946791.2.jpg","lprice": "794640000","hprice": "0","mallName": "피알기프트","productId": "19299946791","productType": "2"},{"title": "백색디너 네프킨(2겹) (4겹 문의요망) [4,000개부터 구매 가능(소량구매전화)]","link": "https://search.shopping.naver.com/gate.nhn?id=19307713868","image": "https://shopping-phinf.pstatic.net/main_1930771/19307713868.jpg","lprice": "794640000","hprice": "0","mallName": "샘물기프트","productId": "19307713868","productType": "2"},{"title": "백색디너 네프킨(2겹) (4겹 문의요망) [4,000개부터 구매 가능(소량구매전화)]","link": "https://search.shopping.naver.com/gate.nhn?id=19305890160","image": "https://shopping-phinf.pstatic.net/main_1930589/19305890160.jpg","lprice": "794640000","hprice": "0","mallName": "알라딘마켓","prod

    public static PagedResult<BookDetail> get(final String keyword) {
        return keywordToPagedResult.get(keyword);
    }



    public static void put(final String keyword,
                                 final String title,
                                 final String thumbnail,
                                 final String introduce,
                                 final String isbn,
                                 final String author,
                                 final String publisher,
                                 final LocalDateTime publisherDate,
                                 final Integer listPrice,
                                 final Integer salePrice){
        if(keywordToBookDetails.isEmpty()) {

            List<BookDetail> bookDetails = Arrays.asList(new BookDetail(title, thumbnail, introduce,
                    isbn, author, publisher,
                    publisherDate, listPrice, salePrice));

            keywordToBookDetails.put(keyword, bookDetails);
            keywordToPagedResult.put(keyword, new PagedResult<>(
                    bookDetails,
                    1, //현재 페이지
                    bookDetails.size() // 전체 건수
            ));

        } else {
            List<BookDetail> bookDetails = new ArrayList<>(keywordToBookDetails.get(keyword));
            bookDetails.add(new BookDetail(title, thumbnail, introduce,
                    isbn, author, publisher,
                    publisherDate, listPrice, salePrice));
            keywordToBookDetails.put(keyword, bookDetails);
            keywordToPagedResult.put(keyword, new PagedResult<>(
                    bookDetails,
                    1, //현재 페이지
                    bookDetails.size() // 전체 건수
            ));
        }

    }
}
