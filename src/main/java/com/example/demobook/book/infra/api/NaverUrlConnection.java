package com.example.demobook.book.infra.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NaverUrlConnection implements CustomUrlConnection {

    private HttpURLConnection con;
    private URL url;
    private final int MAX_API_PAGEROWNUM = 50;
    private final String CLIENT_ID = "ggg60QT5N8yOHQAWSu2d";
    private final String CLIENT_SECRET = "n38XuD6cWW";

    public NaverUrlConnection() {}

    @Override
    public HttpURLConnection connect(String keyword, Integer currentPage) {
        try {
            URLBuilder urlBuilder = new URLBuilder
                    .Builder("https://openapi.naver.com/v1/search/book.json")
                    .searchQuery("?query=" + URLEncoder.encode(keyword, "UTF-8"))
                    .displayQuery("&display=" + MAX_API_PAGEROWNUM)
                    .startQuery("&start=" + currentPage)
                    .sortQuery("&sort=date")
                    .build();

            url = new URL(urlBuilder.toString());
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
            con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
            con.setRequestProperty("Content-Type", "application/json");
        } catch (IOException e) {
            System.out.println(e);
        }
        return con;
    }
}
