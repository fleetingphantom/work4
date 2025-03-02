package com.web.service;


import com.web.domain.Article;
import com.web.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface ArticleService {

    boolean save(Article article);

    boolean update(Article article);

    boolean addLikes(Integer id);

    boolean addViews(Integer id);

    boolean delete(Integer id);

    Article getById(Integer id);

    List<Article> getByCategory(String category);

    List<Article> getAll();

    List<Article> orderByView();

    List<Article> orderByLikes();

    List<Article> orderByCreateTime();

    User getAuthor(Integer aid);

    List<Article> getByAuthor(Integer uid);
}
