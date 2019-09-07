package com.example.demobook.book.infra.dto;

import java.util.List;

public class KakaoBookResponse {

    private List<KakaoDocumentResponse> documents;
    private KakaoMetaResponse meta;

    public KakaoMetaResponse getMeta() {
        return meta;
    }

    public void setMeta(KakaoMetaResponse meta) {
        this.meta = meta;
    }

    public List<KakaoDocumentResponse> getDocuments() {
        return documents;
    }

    public void setDocuments(List<KakaoDocumentResponse> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "KakaoBookResponse{" +
                "meta=" + meta +
                ", documents=" + documents +
                '}';
    }
}
