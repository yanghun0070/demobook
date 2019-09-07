package com.example.demobook.book.infra.dto;

import com.example.demobook.book.domain.BookDetail;
import com.example.demobook.common.PagedResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class BookTranslator {


    public PagedResult<BookDetail> translate(final KakaoBookResponse bookResponse,
                                 final Integer currentPage) {

        List<BookDetail> bookDetails = bookResponse.getDocuments()
                .stream().map(kakaoDocument ->
            {
                //2016-06-08T00:00:00.000+09:00
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

                Date publisherDate = null;
                try {
                    publisherDate = sdf.parse(kakaoDocument.getDatetime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                // [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]
                // 2014-11-17T00:00:00.000+09:00
                LocalDateTime publisherDateTime =
                        publisherDate.toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDateTime();

                BookDetail bookDetail = new BookDetail(
                        kakaoDocument.getTitle(),
                        kakaoDocument.getThumbnail(),
                        kakaoDocument.getContents(),
                        kakaoDocument.getIsbn(),
                        kakaoDocument.getAuthors()
                                .stream()
                                .map(String::toUpperCase)
                                .collect(Collectors.joining(",")),
                        kakaoDocument.getPublisher(),
                        publisherDateTime,
                        kakaoDocument.getPrice(),
                        kakaoDocument.getSalePrice()
                );
                return bookDetail;
            }).collect(Collectors.toList());
        return new PagedResult<>(bookDetails,
                currentPage, bookResponse.getMeta().getTotalCount());
    }

    public PagedResult<BookDetail> translate(final NaverBookResponse bookResponse) {
        List<BookDetail> bookDetails = bookResponse.getItems().stream()
                .map(item ->
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    Date publisherDate = null;
                    try {
                        publisherDate = sdf.parse(item.getPubdate());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    LocalDateTime publisherDateTime =
                            publisherDate.toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDateTime();

                    return new BookDetail(
                        item.getTitle(),
                        item.getImage(),
                        item.getDescription(),
                        item.getIsbn(),
                        item.getAuthor(),
                        item.getPublisher(),
                        publisherDateTime,
                        item.getPrice(),
                        item.getDiscount());
                }).collect(Collectors.toList());

        return new PagedResult<>(bookDetails,
                bookResponse.getStart(),
                bookResponse.getTotal());
    }


}
