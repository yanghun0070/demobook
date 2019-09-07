package com.example.demobook.book.infra.dto;

import com.example.demobook.book.domain.BookDetail;
import com.example.demobook.book.infra.BookRepository;
import com.example.demobook.book.infra.api.CustomUrlConnection;
import com.example.demobook.book.infra.api.KaKaoUrlConnection;
import com.example.demobook.book.infra.api.NaverUrlConnection;
import com.example.demobook.common.PagedResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository("bookApiRepository")
public class BookHttpApiClient implements BookRepository {

    private BookTranslator bookTranslator;

    public BookHttpApiClient() {
        this.bookTranslator = new BookTranslator();
    }

    /**
     * title (제목에서 검색) or isbn (ISBN에서 검색) or publisher (출판사에서 검색) or person(인명에서 검색)
     *
     * @param keyword
     * @return
     * @throws IOException
     */
    @Override
    public PagedResult<BookDetail> findByKeyword(String keyword, Integer currentPage) throws IOException {
        URL url = null;
        HttpURLConnection con = null;
        try {
            CustomUrlConnection kakaoUrlConn = new KaKaoUrlConnection();
            con = kakaoUrlConn.connect(keyword, currentPage);

            int responseCode = con.getResponseCode();
            if(responseCode != HttpStatus.OK.value()) { // 에러 발생
                con.disconnect();

                CustomUrlConnection naverUrlConn = new NaverUrlConnection();
                con = naverUrlConn.connect(keyword, currentPage);

                try ( BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = br.readLine()) != null) {
                        response.append(inputLine);
                    }
                    ObjectMapper mapper = new ObjectMapper();
                    NaverBookResponse naverBookResponse = mapper.readValue(response.toString(), NaverBookResponse.class);
                    return bookTranslator.translate(naverBookResponse);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try ( BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8")) ) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }

                System.out.println(response.toString());
                ObjectMapper mapper = new ObjectMapper();

                KakaoBookResponse kakaoBookResponse = mapper.readValue(response.toString(), KakaoBookResponse.class);
                return bookTranslator.translate(kakaoBookResponse, currentPage);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            System.out.println(e);
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
//        new BookHttpApiClient().findFromKakaoApi("자존심", 1);
        new BookHttpApiClient().findByKeyword("자존심", 1);
    }
}
