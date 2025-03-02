package com.web.service.impl;

import com.web.dao.ArticleDao;
import com.web.domain.Article;
import com.web.domain.User;
import com.web.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public boolean save(Article article) {
        return articleDao.save(article)>0;
    }

    @Override
    public boolean update(Article article) {
        return articleDao.update(article)>0;
    }

    @Override
    public boolean addLikes(Integer id) {
        return articleDao.addLikes(id)>0;
    }

    @Override
    public boolean addViews(Integer id) {
        return articleDao.addViews(id)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return articleDao.delete(id)>0;
    }

    @Override
    public Article getById(Integer id) {
        return articleDao.getById(id);
    }

    @Override
    public List<Article> getByCategory(String category) {
        return articleDao.getByCategory(category);
    }

    @Override
    public List<Article> getAll() {
        return articleDao.getAll();
    }


    @Override
    public List<Article> orderByView() {
        return articleDao.orderByView();
    }

    @Override
    public List<Article> orderByLikes() {
        return articleDao.orderByLikes();
    }

    @Override
    public List<Article> orderByCreateTime() {
        return articleDao.orderByCreateTime();
    }

    @Override
    public User getAuthor(Integer aid) {
        return articleDao.getAuthor(aid);
    }

    @Override
    public List<Article> getByAuthor(Integer uid) {
        return articleDao.getByAuthor(uid);
    }
}
