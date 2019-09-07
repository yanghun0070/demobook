package com.example.demobook.book.infra.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class KaKaoUrlConnection implements CustomUrlConnection {

    private HttpURLConnection con;
    private URL url;
    private final int MAX_API_PAGEROWNUM = 50;
    private final String APP_KEY = "a68150df7e87675a6583ba92d2fe9af2";

    public KaKaoUrlConnection() {}

    @Override
    public HttpURLConnection connect(String keyword, Integer currentPage) {
        try {
            URLBuilder urlBuilder = new URLBuilder
                    .Builder("https://dapi.kakao.com/v3/search/book")
                    .searchQuery("?query=" + URLEncoder.encode(keyword, "UTF-8"))
                    .displayQuery("&size=" + MAX_API_PAGEROWNUM)
                    .startQuery("&page=" + currentPage)
                    .sortQuery("&sort=latest")
                    .build();

            url = new URL(urlBuilder.toString());
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "KakaoAK " + APP_KEY);
            con.setRequestProperty("Content-Type", "application/json");

        } catch (IOException e) {
            System.out.println(e);
        }
        return con;
    }
}

