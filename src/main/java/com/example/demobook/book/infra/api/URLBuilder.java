package com.example.demobook.book.infra.api;

public class URLBuilder {
    private String defaultUrl;
    private String searchQuery;
    private String displayQuery;
    private String startQuery;
    private String sortQuery;

    public URLBuilder() {}

    public static class Builder {
        private String defaultUrl;
        private String searchQuery;
        private String displayQuery;
        private String startQuery;
        private String sortQuery;

        public Builder(String defaultUrl) {
            this.defaultUrl = defaultUrl;
        }

        public Builder searchQuery(String searchQuery) {
            this.searchQuery = searchQuery;
            return this;
        }

        public Builder displayQuery(String displayQuery) {
            this.displayQuery = displayQuery;
            return this;
        }

        public Builder startQuery(String startQuery) {
            this.startQuery = startQuery;
            return this;
        }

        public Builder sortQuery(String sortQuery) {
            this.sortQuery = sortQuery;
            return this;
        }

        public URLBuilder build() {
            return new URLBuilder(this);
        }

    }

    private URLBuilder(Builder builder) {
        this.defaultUrl = builder.defaultUrl;
        this.searchQuery = builder.searchQuery;
        this.displayQuery = builder.displayQuery;
        this.startQuery = builder.startQuery;
        this.sortQuery = builder.sortQuery;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(defaultUrl)
            .append(searchQuery)
            .append(displayQuery)
            .append(startQuery)
            .append(sortQuery);
        return sb.toString();
    }

}
