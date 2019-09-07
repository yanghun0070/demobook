package com.example.demobook.book.domain;

import java.time.LocalDateTime;

public class BookDetail {
    private Long id; //책 ID
    private String title; //제목
    private String thumbnail; //썸네일
    private String introduce; //소개
    private String isbn;//ISBN(International Standard Book Number)
    private String author; //저자
    private String publisher; //출판사
    private LocalDateTime publisherDate; //출판일
    private Integer listPrice; //정가
    private Integer salePrice; //판매가

    public BookDetail(String title, String thumbnail, String introduce,
                      String isbn, String author, String publisher,
                      LocalDateTime publisherDate, Integer listPrice, Integer salePrice) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.introduce = introduce;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.publisherDate = publisherDate;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getPublisherDate() {
        return publisherDate;
    }

    public void setPublisherDate(LocalDateTime publisherDate) {
        this.publisherDate = publisherDate;
    }

    public Integer getListPrice() {
        return listPrice;
    }

    public void setListPrice(Integer listPrice) {
        this.listPrice = listPrice;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "BookDetail{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", introduce='" + introduce + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publisherDate=" + publisherDate +
                ", listPrice=" + listPrice +
                ", salePrice=" + salePrice +
                '}';
    }
}
