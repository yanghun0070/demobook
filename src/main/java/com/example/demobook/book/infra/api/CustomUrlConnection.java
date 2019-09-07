package com.example.demobook.book.infra.api;

import java.net.HttpURLConnection;

public interface CustomUrlConnection {

    public HttpURLConnection connect(String keyword, Integer currentPage);

}
