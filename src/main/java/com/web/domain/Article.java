package com.web.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Article {
    Integer id;
    String title;
    String content;
    Integer view = 0;
    Integer likes = 0;
    String category = "闲聊杂谈";
    LocalDateTime createTime = LocalDateTime.now();

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", view=" + view +
                ", likes=" + likes +
                ", category='" + category + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Article() {
    }

    public Article(Integer id, String title, String content, Integer view, Integer likes, String category, LocalDateTime createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.view = view;
        this.likes = likes;
        this.category = category;
        this.createTime = createTime;
    }

    public Article(String title, String content, Integer view, Integer likes, String category, LocalDateTime createTime) {
        this.title = title;
        this.content = content;
        this.view = view;
        this.likes = likes;
        this.category = category;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
