package com.vogella.mockito.inject;

public class ArticleDatabase {

    @SuppressWarnings("unused") // stored for tutorial completeness
    private ArticleListener articleListener;

    @SuppressWarnings("unused") // stored for tutorial completeness
    private User user;

    public void addListener(ArticleListener articleListener) {
        this.articleListener = articleListener;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
