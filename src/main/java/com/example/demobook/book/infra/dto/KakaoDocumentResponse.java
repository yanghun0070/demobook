package com.example.demobook.book.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class KakaoDocumentResponse {
    private String title; //도서 제목
    private String contents; //도서 소개
    private String url; //도서 상세 URL
    private String isbn; // 국제 표준 도서번호(ISBN10 ISBN13) (ISBN10,ISBN13 중 하나 이상 존재하며, ' '(공백)을 구분자로 출력)
    private String datetime; //도서 출판날짜. ISO 8601. [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]
    private List<String> authors; //도서 저자 리스트
    private String publisher; //도서 출판사
    private List<String> translators; //도서 번역자 리스트
    private Integer price; //도서 정가
    @JsonProperty("sale_price")
    private Integer salePrice; //도서 판매가
    private String thumbnail; //도서 표지 썸네일 URL
    private String status; //도서 판매 상태 정보(정상, 품절, 절판 등)*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<String> getTranslators() {
        return translators;
    }

    public void setTranslators(List<String> translators) {
        this.translators = translators;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "KakaoDocumentResponse{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", url='" + url + '\'' +
                ", isbn='" + isbn + '\'' +
                ", datetime='" + datetime + '\'' +
                ", authors=" + authors +
                ", publisher='" + publisher + '\'' +
                ", translators=" + translators +
                ", price=" + price +
                ", salePrice=" + salePrice +
                ", thumbnail='" + thumbnail + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
